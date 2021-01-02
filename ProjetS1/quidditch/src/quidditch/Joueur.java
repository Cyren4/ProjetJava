package quidditch;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


/**
 * 	Joueur :  A chaque partie il y a 2 joueurs = un dans chaque equipe
 * 	
 * @author cyrena
 *
 *	@summary
 *	-	Un joueur et caracterise par:
 *	-	Son nom
 *	-  	Son equipe (0 commence a gauche et 1 a droite)
 *	- 	Sa couleur (= la maison de son choix)
 *	-	positionne joueur a meme hauteur, au centre de leur cote du terrain
 *	
 */

public class Joueur extends GameObject {
	public static final int STARTX = Jeu.WIDTH;
	public static final int STARTY = Jeu.HEIGHT / 2;
	public final String nom;
	public final int team;
	public final Color c;
	//ajout barre vie -> si on se fait toucher trop de fois par cognard = mort ? 

	public Joueur(String nom, int team, Color c) {
		super(team == 0 ? STARTX / 4 : STARTX * 3 / 4 , STARTY, team, 35);
		this.nom = nom;
		this.team = team;
		this.c = c;
	}

	public int getTeam() {
		return team;
	}
	
	@Override
	public void tick() {
		x = Jeu.limit(x + velX, 0, Jeu.WIDTH-35);
		y = Jeu.limit(y + velY, 0, Jeu.HEIGHT-60);
		if ( y >= 180 && y <= 360 && this.id <=1)
			if (x <= 10) {
				System.out.println("GOALLL 1");
			}
			else if ( x >= Jeu.WIDTH - 50)
				System.out.println("GOALLL 2");
	}

	@Override
	public void render(Graphics g) {
		g.setColor(c);
		g.fillRect(x, y, size, size);
	}
	
}
