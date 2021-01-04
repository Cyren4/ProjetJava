package quidditch;

import Balles.*;
import Start.*;

import java.util.*; //need Random and Scanner and ArrayList
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.*;

/**
 * class Jeu : suit le fil du jeu et affiche les logs
 * Il s'agit d'un singleton
 * @author cyrena
 * Initialise : 
 * - 2 Joueurs
 * - Les balles 
 */

public class Jeu extends Canvas implements Runnable{
	
	private static Jeu INSTANCE;
	
	public static final int WIDTH = 1000; 
	public static final int HEIGHT = 640;
	public final int startSouaffle;
	
	private Thread thread;
	private boolean running = false;
	private UseGameO handler;

	private static int NBSOUAFFLE = 0;
	private int nbCognard;
	private boolean vifOr = true;
	private static int[] SCORE = {0, 0};
	private static Joueur[] player;
	
	
	public static Jeu GetInstance(){
		Scanner sc = new Scanner(System.in);
		if (INSTANCE == null)
			INSTANCE = pickRandom(sc);
		return INSTANCE;
	}
	
	private  Jeu(Joueur[] j, int[] nbBall){
		handler  = new UseGameO();
		this.addKeyListener(new KeyInput(handler));
		new Window(WIDTH, HEIGHT, "Quidditch Tournament!", this);
		
		startSouaffle = nbBall[0];
		nbCognard = nbBall[1];
		vifOr = nbBall[2] == 1;
		
		handler.addObject(j[0]);
		handler.addObject(j[1]);
		player = new Joueur[2];
		player[0] = j[0];
		player[1] = j[1];
		
		for(int i = 0; i < startSouaffle; i++) {
			handler.addObject(new Souaffle(handler, startSouaffle));
			NBSOUAFFLE++;
		}
		for(int i = 0; i < nbCognard; i++)
			handler.addObject(new Cognard());
		if (vifOr)	handler.addObject(new VifOr());
		
	}

	//choose random (code pas tres elabore mais nous permet d'effectuer plus nos test plus rapidement)
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
		return NBSOUAFFLE;
	}

	public static void goal(int team) {
		SCORE[team]++;
		System.out.println("Current score : " + SCORE[0] +"\t-\t"+ SCORE[1] + "\n");
		if (SCORE[0] == SCORE[1])
			System.out.println("The battle is fierce both player are ex aequo!\n");
		else
			System.out.println(player[SCORE[0] > SCORE[1]? 0 : 1].getName() + " takes the lead!\n");
		NBSOUAFFLE--;
		if (NBSOUAFFLE == 0)
			System.out.println(player[SCORE[0] > SCORE[1]? 0 : 1].getName() + " won the tournament!\n");
	}
	// start thread of game
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();	
		running = true;
	}
	
	// stop thread of game
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//blabla du copie colle pour avoir notre boucle de jeu et avoir des log de fps du jeu
	//je trouvais ca assez cool donc je l'ai ajoute
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000/amountOfTicks;//nb de ns par tick (reduire --> augmente nb tick)
		double delta = 0;//nb de temps qui s'est passe depuis derniere boucle
		long timer = System.currentTimeMillis();
		int frames = 0;
		int ticks = 0;
		boolean new_tick = true;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime)/ ns;
			lastTime = now;
			while (delta >= 1) {//si jeu en cours on update
				tick();
				ticks++;
				delta--;
				new_tick = true;
			}
			if (running && new_tick) {//si jeu en cours on affiche
				render();
				frames++;
				new_tick = false;
			}
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer+= 1000;
//				System.out.println("FPS :" + frames);
//				System.out.println("TPS :" + ticks);
				frames = 0;
				ticks = 0;
			}
			if (NBSOUAFFLE == 0) {
				if (playAgain() == 1)
					reset();
				else
					break;
			}
		}
		stop();
	}
	
	private void reset() {}
	
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
	
	//can create buffers at the launch of the game(bc null at beginning)
	// fill the window with one color and the goals
	private void render() {
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
	
	//empeche les joueurs de sortir du terrain
	public static int limit(int x, int min, int max) {
		if (x >= max) return max;
		else if (x <= min) return min;
		else return x;
	}
	
}
