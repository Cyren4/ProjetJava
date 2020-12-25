package Balles;

import java.util.Random;
import quidditch.*;

public class Souffle extends Balle{
	
	public Souffle() {
		super((int)(Terrain.HAUTEUR/2),(int)(Math.random()*Terrain.HAUTEUR));
	}
	
	public void move() {
		//if joueur a droite -> bouge a gauche else blabla 
	}

}