package Balles;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import quidditch.*;

public class Souffle extends Balle{
//	private static int start = nbSouffle == 3 ? 100 : 50 ;
	private UseGameO handler;
	
	public Souffle(UseGameO handler, int nbStart) {
		super((int)(Jeu.WIDTH/2), calculPlace(nbStart), 2, 35);

//		start += Jeu.NBSOUFFLE == 3 ? 200 : 125;
		this.handler = handler;
		
	}
	
	private static int calculPlace(int nbStart) {
		int implement = nbStart == 3 ? 200 : 125;
		return nbStart == 3 ? 100 + Jeu.NBSOUFFLE * implement : 50 + Jeu.NBSOUFFLE * implement;
	}
	//faire interraction avec joueur
	public void tick() {
		// comment faire une vitesse decroissante ? aka force de frottement 
		if ( y >= 180 && y <= 360 && this.id == 2) //check s'il s'agit d'un souffle
			if (x <= 5) {
				System.out.println("GOALLL 1"); // ajouter le score a l'equipe 1
				handler.removeObject(this);
			}
			else if ( x >= Jeu.WIDTH - 35){
				System.out.println("GOALLL 2");// ajouter le score a l'equipe 0
				handler.removeObject(this);
			}
	}

	public void render(Graphics g) {
		super.render(g, Color.magenta);
	}
}