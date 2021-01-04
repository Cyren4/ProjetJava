package Balles;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import quidditch.*;

public class VifOr extends Balle{
//	boolean visible;
	
	public VifOr() {
		super((int)(Math.random()*Jeu.WIDTH), (int)(Math.random()*Jeu.HEIGHT), 4, 15);

	}
	
	public static boolean prob() {
		return (int)(Math.random()* 100) < 5;
	}
	@Override
	public void tick() {
		
//		if (count == (int)(Math.random()* 40 + 20){
		if(prob() && count == 30)	{
			x = (int)(Math.random() * Jeu.WIDTH);
			y =  (int)(Math.random() * Jeu.HEIGHT);
			count = 0;
		} else {
			x = -10;
			y = -10;
			count++;
		}
		
	}

	public void render(Graphics g) {
		super.render(g, Color.yellow);
	}

}
