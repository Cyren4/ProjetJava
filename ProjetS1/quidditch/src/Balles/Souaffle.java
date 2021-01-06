package Balles;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import quidditch.*;

/**
 * Les souaffles sont immobile au depart et apparaissent sur la ligne centrales.
 * Leur ordonne de depart depend de si on commencent avec 3 ou 5 souaffles.
 * Ils bougent si un joueur entre en collision avec eux et 
 * perdent de la vitesse avec le temps si aucune nouvelle collision n'est faite
 * Si un souaffle entre dans un goal il donne un point a l'equipe adverse
 * @author cyrena
 *
 */
public class Souaffle extends Balle{
	private UseGameO handler;
	
	public Souaffle(UseGameO handler, int nbStart) {
		super((int)(Jeu.WIDTH/2), calculPlace(nbStart), 2, 35);
		this.handler = handler;
	}
	
	private static int calculPlace(int nbStart) {
		int implement = nbStart == 3 ? 200 : 125;
		return nbStart == 3 ? 100 + Jeu.getNbSouaffle() * implement : 50 + Jeu.getNbSouaffle() * implement;
	}
	
	/**
	 * interraction avec joueur
	 * une vitesse decroissante, aka force de frottement (en fonction des ticks)
	 * si le souaffle rentre dans l'un des but ca augmente le score de l'equipe adverse
	 */
	public void tick() {
		
		if (count == 70){
			if (velX > 0) velX--;
			if (velX < 0) velX++;
			if (velY > 0) velY--;
			if (velY < 0) velY++;
			count = 0;
		} else
			count++;
	
		//On verifie si le souaffle n'entre pas dans une des cages
		if ( y >= 180 && y <= 360) { 
			if (x <= 5) {//entre dans goal gauche
				System.out.println("Team 2 Scored!\n"); // ajouter le score a l'equipe 1
				handler.removeObject(this);
				Jeu.goal(1);
			}
			else if ( x >= Jeu.WIDTH - 35){//entre dans goal gauche
				System.out.println("Team 1 Scored!\n");// ajouter le score a l'equipe 0
				handler.removeObject(this);
				Jeu.goal(0);
			}
		}
		//empeche la balle de sortir
		x = Jeu.limit(x + velX, 0, Jeu.WIDTH-35);
		y = Jeu.limit(y + velY, 0, Jeu.HEIGHT-60);
		super.tick();//keep balls inside
	}

	/**
	 * gagne la vitesse du joueur avec lequel le souaffle entre en collision
	 * @param j
	 */
	public void pousse(Joueur j) {
		velX += j.getVelX();
		velY += j.getVelY();
	}

	/**
	 * cercle couleur magenta
	 */
	public void render(Graphics g) {
		super.render(g, Color.magenta);
	}
}