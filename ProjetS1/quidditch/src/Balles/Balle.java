package Balles;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import quidditch.*;

public abstract class Balle extends GameObject {
//	private static int nbBalles;
//	private boolean visible;
	
	
	public Balle(int x, int y , int id, int size) {
		super(x, y, id, size);
	}
	
	public void tick() {
		inside();
	}

	public void inside() {
		if(x <= 0 || x >= Jeu.WIDTH - this.size)
			velX *= -1;
		if(y <= 0 || y >= Jeu.HEIGHT - this.size - 25)
			velY *= -1;
	}
	
	protected void render(Graphics g, Color c) {
			g.setColor(c);
			g.fillOval(x, y, size, size);
	}
}