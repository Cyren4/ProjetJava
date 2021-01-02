package Balles;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import quidditch.*;

public class VifOr extends Balle{

	public VifOr() {
		super((int)(Math.random()*Jeu.WIDTH), (int)(Math.random()*Jeu.HEIGHT), 4, 15);
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	public void render(Graphics g) {
		super.render(g, Color.yellow);
	}

}
