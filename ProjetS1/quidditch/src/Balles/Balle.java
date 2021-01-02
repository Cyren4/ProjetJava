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
		if ((x <= 20 || x >= Jeu.WIDTH - 20) && this.id == 3)
			if (y >= 200 && y <= 200)
				System.out.println("GOALLL");
			
	}

	
	protected void render(Graphics g, Color c) {
			g.setColor(c);
			g.fillOval(x, y, size, size);
	}
}