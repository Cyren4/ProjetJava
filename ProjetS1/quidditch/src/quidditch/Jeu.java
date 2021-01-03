package quidditch;

import Balles.*;
import java.util.*; //need Random and Scanner and ArrayList
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.*;

/**
 * class Jeu : suit le fil du jeu et affiche les logs
 * @author cyrena
 * Initialise : 
 * - 2 Joueurs
 * - Les balles 
 */
public class Jeu extends Canvas implements Runnable {
	public static final int WIDTH = 1000; 
	public static final int HEIGHT = 640;
	public final int startSouffle;
	
	private Thread thread;
	private boolean running = false;
	private UseGameO handler;

	public static int NBSOUFFLE = 0;
	private int nbCognard;
	private boolean vifOr = true;
//	private Terrain t;
//	private ArrayList<Balle> bal;
//	private Joueur[] j;
//	private int nbBalles;
	
	
	
	public Jeu(Joueur[] j, int[] nbBall){
		handler  = new UseGameO();
		this.addKeyListener(new KeyInput(handler));
		new Window(WIDTH, HEIGHT, "Quidditch Tournament!", this);
		
		startSouffle = nbBall[0];
		nbCognard = nbBall[1];
		vifOr = nbBall[2] == 1;
//		handler.addObject(new Joueur("Harry", 0, Color.red));
//		handler.addObject(new Joueur("Drago", 1, Color.green));
		handler.addObject(j[0]);
		handler.addObject(j[1]);
		
		for(int i = 0; i < startSouffle; i++)
			handler.addObject(new Souffle(handler, NBSOUFFLE++));
		for(int i = 0; i < nbCognard; i++)
			handler.addObject(new Cognard());
		if (vifOr)	handler.addObject(new VifOr());
	}

	public int getNbStartSouffle() {
		return startSouffle;
	}
	
	public int getNbSouffle() {
		return NBSOUFFLE;
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
		int frames = 0; //nb d'affichage par seconde
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime)/ ns;
			lastTime = now;
			while (delta >= 1) {//si jeu en cours on update
				tick();
				delta--;
			}
			if (running) //si jeu en cours on affiche
				render();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer+= 1000;
				System.out.println("FPS :" + frames);
				frames = 0;
			}
		}
		stop();
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
