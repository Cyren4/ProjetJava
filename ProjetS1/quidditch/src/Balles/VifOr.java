package Balles;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import quidditch.*;

public class VifOr extends Balle{
	boolean visible;
	
	public VifOr() {
		super((int)(Math.random()*Jeu.WIDTH), (int)(Math.random()*Jeu.HEIGHT), 4, 15);
		visible = true;
	}
	
	public static boolean prob() {
		return (int)(Math.random()* 100) < 5;
	}
	@Override
	public void tick() {
		if ( 0 > count)	{
			x = visible ? (int)(Math.random() * Jeu.WIDTH) : -10;
			y = visible ? (int)(Math.random() * Jeu.HEIGHT) : - 10;
			count = (int)(Math.random()* 100) + 50;
			visible = !visible;
		} else
			count--;
	}

	public void render(Graphics g) {
		super.render(g, Color.yellow);
	}

}
