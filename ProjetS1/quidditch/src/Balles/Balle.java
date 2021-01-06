package Balles;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import quidditch.*;

/**
 * Toutes les balles rebondissent sur les parois de la map
 * et ont une forme ronde avec une couleur differente et des actions differentes
 * @author cyrena
 *
 */
public abstract class Balle extends GameObject {
	protected int count;
	
	
	public Balle(int x, int y , int id, int size) {
		super(x, y, id, size);
		count = 0;
	}
	
	public void tick() {
		inside();
	}

	/**
	 * permet aux balles de ne pas sortir du terrain et de rebondir sur la parfois (vecteur vitesse opposee)
	 */
	public void inside() {
		if(x <= 0 || x >= Jeu.WIDTH - this.size)
			velX *= -1;
		if(y <= 0 || y >= Jeu.HEIGHT - this.size - 25)
			velY *= -1;
	}
	/**
	 * affiche un cercle de rayon size et de couleur c
	 * @param g
	 * @param c
	 */
	protected void render(Graphics g, Color c) {
			g.setColor(c);
			g.fillOval(x, y, size, size);
	}
}