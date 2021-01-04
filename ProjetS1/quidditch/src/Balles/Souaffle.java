package Balles;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import quidditch.*;

public class Souaffle extends Balle{
	private UseGameO handler;
	private int count;
	
	public Souaffle(UseGameO handler, int nbStart) {
		super((int)(Jeu.WIDTH/2), calculPlace(nbStart), 2, 35);
		this.handler = handler;
		count = 0;
		
	}
	
	private static int calculPlace(int nbStart) {
		int implement = nbStart == 3 ? 200 : 125;
		return nbStart == 3 ? 100 + Jeu.getNbSouaffle() * implement : 50 + Jeu.getNbSouaffle() * implement;
	}
	//faire interraction avec joueur
	public void tick() {
		if (count == 60){
			if (velX > 0) velX--;
			if (velX < 0) velX++;
			if (velY > 0) velY--;
			if (velY < 0) velY++;
			count = 0;
		} else {
			count++;
		}
		// comment faire une vitesse decroissante ? aka force de frottement 
		x += velX;//to sup
		y += velY;//to sup
		if ( y >= 180 && y <= 360) { //check y
			if (x <= 5) {
				System.out.println("Team 2 Scored!\n"); // ajouter le score a l'equipe 1
				handler.removeObject(this);
				Jeu.goal(1);
			}
			else if ( x >= Jeu.WIDTH - 35){
				System.out.println("Team 1 Scored!\n");// ajouter le score a l'equipe 0
				handler.removeObject(this);
				Jeu.goal(0);
			}
		}
		super.tick();//keep balls inside
	}

	public void pousse(Joueur j) {
		velX += j.getVelX();
		velY += j.getVelY();
	}

	public void render(Graphics g) {
		super.render(g, Color.magenta);
	}
}