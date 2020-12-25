package Balles;

import java.util.Random;
import quidditch.*;

public class VifOr extends Balle{

	public VifOr() {
		super((int)(Math.random()*Terrain.LARGEUR), (int)(Math.random()*Terrain.HAUTEUR));
	}
	
	public void move() {
		//apparait au hasard
	}

}
