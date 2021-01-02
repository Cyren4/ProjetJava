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
	public static final int STARTSOUFFLE = 3;
	
	private Thread thread;
	private boolean running = false;
	private UseGameO handler;

	private int nbSouffle = 3;
	private int nbCognard = 2;
	private boolean vifOr = true;
//	private Terrain t;
//	private ArrayList<Balle> bal;
//	private Joueur[] j;
//	private int nbBalles;
	
	
	
	public Jeu(){
		handler  = new UseGameO();
		this.addKeyListener(new KeyInput(handler));
		new Window(WIDTH, HEIGHT, "Quidditch Tournament!", this);
		
		
	
		handler.addObject(new Joueur("Harry", 0, Color.red));
		handler.addObject(new Joueur("Drago", 1, Color.green));
		
		for(int i = 0; i < STARTSOUFFLE; i++)
			handler.addObject(new Souffle(handler));
		for(int i = 0; i < nbCognard; i++)
			handler.addObject(new Cognard());
		if (vifOr)	handler.addObject(new VifOr());
	}

	public int getNbSouffle() {
		return nbSouffle;
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
		double ns = 1000000000/amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
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
//				System.out.println("FPS :" + frames);
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
	
	public static int limit(int x, int min, int max) {
		if (x >= max) return max;
		else if (x <= min) return min;
		else return x;
	}
	
}
