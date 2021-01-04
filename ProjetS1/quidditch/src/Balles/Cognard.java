package Balles;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import quidditch.*;

public class Cognard extends Balle{
	public static final int STUN_DURATION = 60;
	public Cognard() {
		super((int)(Math.random()*(Jeu.WIDTH - 50) + 30), (int)(Math.random()*(Jeu.HEIGHT-50)) + 30, 3, 25);
		velX = 2;
		velY = 2;
	}
	

	@Override
	public void tick() {
		if (Math.random() < 0.008) { //0.8% de chance que le cognard change de direction
			System.out.println("X");
			if (Math.random() > 0.5) {
				velX = 2;
			} else {
				velX = -2;
			}
			if (Math.random() > 0.5) {
				velY = 2;
			} else {
				velY = -2;
			}
		}
		x += velX;
		y += velY;
		super.tick();//keep balls inside
	}

	public void render(Graphics g) {
		super.render(g, Color.black);
	}
}
