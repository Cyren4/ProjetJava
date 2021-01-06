package Balles;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import quidditch.*;
/**
 * Le vif d'or apparait de maniere aleatoire pendant des temps aleatoire sur le terrain
 * pour simplifier les choses on le positionne juste en dehors du terrain lorsqu'il est invisible
 * si le joueur touche le vif d'or il gagne automatiquement la partie
 * @author cyrena
 *
 */
public class VifOr extends Balle{
	private boolean visible;
	
	public VifOr() {
		super((int)(Math.random()*Jeu.WIDTH), (int)(Math.random()*Jeu.HEIGHT), 4, 15);
		visible = true;
	}
	
	/**
	 * est invisible pendant count tick (nombre aleatoire entre 50 et 100)
	 * alterne entre etre visible et invisible et change de position a cette alternance
	 */
	@Override
	public void tick() {
		if ( 0 > count)	{
			x = visible ? (int)(Math.random() * Jeu.WIDTH) : -20;
			y = visible ? (int)(Math.random() * Jeu.HEIGHT) : -20;
			count = (int)(Math.random()* 100) + 50;
			visible = !visible;
		} else
			count--;
	}

	/**
	 * cercle couleur jaune
	 */
	public void render(Graphics g) {
		super.render(g, Color.yellow);
	}

}
