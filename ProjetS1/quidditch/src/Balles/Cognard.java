package Balles;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import quidditch.*;

/**
 *
 * Les cognards sont toujours mobile et apparaissent aleatoirement sur le terrain au debut
 * leur vitesse est constante
 * On peut avoir 0,1 ou 2 Cognards au depart.
 * Ils bougent si un joueur entre en collision avec eux il sera immobilise pendant un certain temps 
 * @author cyrena
 *
 */
public class Cognard extends Balle{
	public static final int STUN_DURATION = 60;
	public int timer;
	
	public Cognard(int x, int y) {
		super(x, y, 3, 25);
		velX = 2;
		velY = 2;
		timer = 0;
	}
	
	/**
	 * apparait au hasard dans la map avec une vitesse constante 
	 * on peut augmenter la difficulter du jeu en changeant la vitesse
	 */
	public Cognard() {
		this((int)(Math.random()*(Jeu.WIDTH - 50) + 30), (int)(Math.random()*(Jeu.HEIGHT-50)) + 30);
	}
	
	
	public Cognard clone() {
		return new Cognard(x, y);
	}

	/**
	 * //Quand deux cognard se cognent, un d'entre eux se dédouble
	 * @param c
	 * @return
	 */
	public Cognard duplicate(Cognard c) {
		Cognard new_cognard = null;
		if (this.canDuplicate() && c.canDuplicate()) {
			new_cognard = clone();
			new_cognard.velX = - velX;
			new_cognard.velY = - velY;
			this.timer = 60;
			c.timer = 60;	
		}
		return new_cognard;


	}
	
	/**
	 * 0.8% de chance que le cognard change de direction pour donner un comportement incertain au cognard
	 */
	@Override
	public void tick() {
		if (timer != 0) timer--;
		if (Math.random() < 0.008) { 
			if (Math.random() > 0.5)
				velX = 2;
			else 
				velX = -2;
			if (Math.random() > 0.5)
				velY = 2;
			else
				velY = -2;
		}
		x += velX;
		y += velY;
		super.tick();//keep balls inside
	}

	/**
	 * cercle couleur noir
	 */
	public void render(Graphics g) {
		super.render(g, Color.black);
	}

	/**
	 * peut se dupliquer apres un certain temps suit a la collision
	 * @return
	 */
	public boolean canDuplicate() { 
		return timer == 0;
	}

}
