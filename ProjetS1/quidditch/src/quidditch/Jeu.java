package quidditch;

import Balles.*;
import Start.*;

import java.util.*; //need Random and Scanner and ArrayList
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.awt.Dimension;
import javax.swing.JFrame;
import java.io.*;


/**
 * class Jeu : suit le fil du jeu et affiche les logs
 * Il s'agit d'un singleton car une partie est unique 
 * @author cyrena
 * Initialise : 
 * - 2 Joueurs
 * - Les balles 
 */

public class Jeu extends Canvas implements Runnable, Saveable{
	
	private static Jeu instance;
	
	public static final int WIDTH = 1000; 
	public static final int HEIGHT = 640;
	public final int startSouaffle;
	
	private JFrame frame;
	private Thread thread;
	private boolean running = false;
	private UseGameO handler;

	private static int nbSouaffle = 0;
	private int nbCognard;
	private boolean vifOr = true;
	private static int[] score = {0, 0};
	private static Joueur[] player;
	
	
	public static Jeu GetInstance(){
		Scanner sc = new Scanner(System.in);
		if (instance == null)
			instance = pickRandom(sc);
		return instance;
	}
	
	private  Jeu(Joueur[] j, int[] nbBall){
		handler  = new UseGameO();
		this.addKeyListener(new KeyInput(handler));
		createWindow(WIDTH, HEIGHT, "Quidditch Tournament!");
		this.requestFocusInWindow();

		startSouaffle = nbBall[0];
		nbCognard = nbBall[1];
		vifOr = nbBall[2] == 1;
		
		handler.addObject(j[0]);
		handler.addObject(j[1]);
		player = j;
//		player = new Joueur[2];
//		player[0] = j[0];
//		player[1] = j[1];
		
		for(int i = 0; i < startSouaffle; i++) {
			handler.addObject(new Souaffle(handler, startSouaffle));
			nbSouaffle++;
		}
		for(int i = 0; i < nbCognard; i++)
			handler.addObject(new Cognard());
		if (vifOr)	handler.addObject(new VifOr());

		this.start();

		
	}

	private void createWindow(int width, int height, String title) {
		//Créé et configure la fenêtre
		frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(this);
		frame.setVisible(true);
	}

	//choose random (code pas tres elabore mais nous permet d'effectuer nos test plus rapidement)
	private static Jeu pickRandom(Scanner sc){
        System.out.printf("What do you want to do ? \n"+
        		"\t1. Choose your own settings!\n"+
        		"\t2. Random settings\n");
        Random rd = new Random();
        //try/catch affiche un message d'erreur si un int n'est pas rentré dans ligne de commande
        int choice = sc.nextInt();
        sc.nextLine(); //this line consume the \n, otherwise the 2nd name can't have an input
        if (choice == 1){
        	try {
        		return new Jeu(Start.initPlayer(sc), Start.initBalls(sc));
        	} catch(TropDErreurException e) {
        		System.out.println("You have made too many mistakes, so your settings will be random.\nDo better next time !");
        		//Pas de return, on sélectionne donc au hasard
        	}
        }
    	int[] b =  {rd.nextBoolean() ? 3 : 5,rd.nextInt(2), rd.nextInt(1)};
    	return new Jeu(randomPlayer(), b);
    }
	
	private static Joueur[] randomPlayer(){
		Joueur j[] = new Joueur[2];
		j[0] = new Joueur("Player 1", 0,Color.red);
		j[1] = new Joueur("Player 2", 1,Color.green);
		return j;
	}
	
	public int getNbStartSouaffle() {
		return startSouaffle;
	}
	
	public static int getNbSouaffle() {
		return nbSouaffle;
	}

	public static void goal(int team) {
		score[team]++;
		System.out.println("Current score : " + score[0] +"\t-\t"+ score[1] + "\n");
		if (score[0] == score[1])
			System.out.println("The battle is fierce both player are ex aequo!\n");
		else
			System.out.println(player[score[0] > score[1]? 0 : 1].getName() + " takes the lead!\n");
		nbSouaffle--;
		if (nbSouaffle == 0)
			System.out.println(player[score[0] > score[1]? 0 : 1].getName() + " won the tournament!\n");
	}
	
	// start thread of game
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();	
		running = true;
	}
	
	private void reset() {
		instance = null;
		score[0] = 0;
		score[1] = 0;
		GetInstance();
	}
	
	// stop thread of game
	public synchronized void stop() {
		try {
//			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//D'après un code trouvé sur internet (https://gamedev.net/forums/topic/687454-understanding-game-loops/5337108/)
	//puis modifié pour qu'il nous convienne.
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0; //Nombre de tick pas seconde
		double ns = 1000000000/amountOfTicks;//nb de ns par tick
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		int ticks = 0;
		boolean new_tick = true;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime)/ ns; //Nombre de tick à effectuer
			lastTime = now;
			while (delta >= 1) {//si jeu en cours on update
				tick();
				ticks++;
				delta--;
				new_tick = true;
			}
			if (running && new_tick) {//si jeu en cours et qu'il y a eu un tick, on affiche
				render();
				frames++;
				new_tick = false;
			}
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer+= 1000;
//				System.out.println("FPS :" + frames);//si on veut les fps
//				System.out.println("TPS :" + ticks);//si on veut le nb de tick par seconde
				frames = 0;
				ticks = 0;
			}
			if (nbSouaffle == 0) {
				
				if (playAgain() == 1)
					reset();
				else {
					save("save.quidditch");
					frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
					break;
				}
			}
		}
		stop();
	}
	
	private int playAgain() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("Do you want to play again? \n"+
	        		"\t1. Yes\n"+
	        		"\t2. No\n");
	        //try/catch affiche un message d'erreur si un int n'est pas rentré dans ligne de commande
	        try{
	            int choice = sc.nextInt();
	            sc.nextLine(); //this line consume the \n, otherwise the 2nd name can't have an input
	            return choice;
	        } catch(Exception e){
	            throw new RuntimeException("Error.\nYou need to Enter a number");
	        }
	}
	
	//update all game object
	private void tick() {
		handler.tick();
	}
	
	
	private void render() {
		/**
		 * can create buffers at the launch of the game(bc null at beginning)
		 * fill the window with one color and the goals
		 */
	
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);//nb of buffer recommended
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		
		g.setColor(Color.lightGray);
		g.fillRect(0, 0, WIDTH, HEIGHT-25);
		
		g.setColor(Color.darkGray);
		g.fillRect(0, 225, 10, 150);
		g.fillRect(WIDTH - 10, 225, 10, 150);
		
		handler.render(g);
		
		g.dispose();
		bs.show();
	}
	
	/**
	 * //empeche les joueurs de sortir du terrain
	 * @param x
	 * @param min
	 * @param max
	 * @return
	 */
	public static int limit(int x, int min, int max) {
		if (x >= max) return max;
		else if (x <= min) return min;
		else return x;
	}

	public static void win(int team) {
		nbSouaffle = 0;
	}

	@Override
	public void save(String file) {
		handler.save(file);
		String output = player[0].name + "(team " + player[0].team+") : " + score[0] + "pts\n";
		output += player[1].name + "(team " + player[1].team+") : " + score[1] + "pts\n";
		Saveable.write_to_file(file,output);
	}
	
}
