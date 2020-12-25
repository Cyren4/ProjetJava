package Balles;

import java.util.Random;
import quidditch.*;

public class Cognard extends Balle{
	public static int cpt = 0;
	public final int id;
	
	public Cognard() {
		super((int)(Math.random()*Terrain.LARGEUR), (int)(Math.random()*Terrain.HAUTEUR));
		cpt++;
		id = cpt;
	}
	
	public void move() {
		//bouge au hasard
	}
}
