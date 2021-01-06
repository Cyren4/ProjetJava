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
	
	public Cognard() {
		super((int)(Math.random()*(Jeu.WIDTH - 50) + 30), (int)(Math.random()*(Jeu.HEIGHT-50)) + 30, 3, 25);
		velX = 2;
		velY = 2;
		timer = 0;
	}

	
	public Cognard(int x, int y) {
		super(x, y, 3, 25);
		velX = 2;
		velY = 2;
	}
	
	public Cognard clone() {
		return new Cognard(x, y);
	}

	public Cognard duplicate(Cognard c) {
		Cognard new_cognard = null;
		if (this.canDuplicate() && c.canDuplicate()) {
			new_cognard = clone();
			new_cognard.velX = - velX;
			new_cognard.velY = - velY;
			this.timer = 60;
			c.timer = 60;
			//Quand deux cognard se cognent, un d'entre eux se dédouble
		}
		return new_cognard;


	}
	
	@Override
	public void tick() {
		if (timer != 0) timer--;
		if (Math.random() < 0.008) { //0.8% de chance que le cognard change de direction
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

	public void render(Graphics g) {
		super.render(g, Color.black);
	}

	public boolean canDuplicate() {
		return timer == 0;
	}

}
