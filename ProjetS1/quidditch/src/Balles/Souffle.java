package Balles;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import quidditch.*;

public class Souffle extends Balle{
	private static int start = Jeu.STARTSOUFFLE == 3 ? 100 : 50 ;
	private UseGameO handler;
	
	public Souffle(UseGameO handler) {
		super((int)(Jeu.WIDTH/2), start, 2, 35);
	
		start += Jeu.STARTSOUFFLE == 3 ? 200 : 125;
		this.handler = handler;
		
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