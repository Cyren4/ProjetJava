package Balles;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import quidditch.*;

public class Cognard extends Balle{
	
	public Cognard() {
		super((int)(Math.random()*(Jeu.WIDTH - 25) + 20), (int)(Math.random()*(Jeu.HEIGHT-25)) + 20, 3, 25);
		velX = 5;
		velY = 5;
	}
	

	@Override
	public void tick() {
		x += velX;
		y += velY;
		inside();
	}
	
	public void inside() {
		if(x <= 0 || x >= Jeu.WIDTH - this.size)
			velX *= -1;
		if(y <= 0 || y >= Jeu.HEIGHT - this.size - 25)
			velY *= -1;
	}

	public void render(Graphics g) {
		super.render(g, Color.black);
	}
}
