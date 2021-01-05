package Balles;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import quidditch.*;

/**
 * /**
 * Les cognards sont toujours mobile et apparaissent aleatoirement sur le terrain au debut
 * leur vitesse est constante
 * On peut avoir 0,1 ou 2 Cognards au depart.
 * Ils bougent si un joueur entre en collision avec eux il sera immobilise pendant un certain temps 
 * @author cyrena
 *
 */
public class Cognard extends Balle{
	public static final int STUN_DURATION = 60;
	
	public Cognard() {
		super((int)(Math.random()*(Jeu.WIDTH - 50) + 30), (int)(Math.random()*(Jeu.HEIGHT-50)) + 30, 3, 25);
		velX = 2;
		velY = 2;
	}
	
	public Cognard(int x, int y) {
		super(x, y, 3, 25);
		velX = 2;
		velY = 2;
	}
	
	public Cognard clone() {
		return new Cognard(x, y);
	}
	
	@Override
	public void tick() {
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
}
