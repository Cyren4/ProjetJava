package quidditch;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import Balles.Cognard;


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
	public final String name;
	public final int team;
	public final Color c;
	private int stunned;
	//ajout barre vie -> si on se fait toucher trop de fois par cognard = mort ? 

	public Joueur(String nom, int team, Color c) {
		super(team == 0 ? Jeu.WIDTH / 4 : Jeu.WIDTH * 3 / 4 , Jeu.HEIGHT / 2, team, 35);
		this.name = nom;
		this.team = team;
		this.c = c;
		this.stunned = 0;
	}
	
	public Joueur(Joueur player) {
		super(player.team == 0 ? Jeu.WIDTH / 4 : Jeu.WIDTH * 3 / 4 , Jeu.HEIGHT / 2, player.team, 35);
		this.name = player.name;
		this.team = player.team;
		this.c = player.c;
		this.stunned = 0;
	}
	
	/**
	* Appelé quand un cognard cogne un joueur, le joueur reste immobile pendant Cognard.STUN_DURATION
	*/
	public void getKnocked() {
		stunned = Cognard.STUN_DURATION;
	}
	
	public void win() {
		System.out.println(name + " caught the Golden Snitch and won the Tornament!\nIncredible!\n");
		Jeu.win(team);
	}
	
	public int getTeam() {
		return team;
	}
	
	public String getName() {
		return name;
	}

	public Joueur clone() {
		return new Joueur(this);
	}
	
	@Override
	public void tick() {
		if (stunned == 0) {//si joueur pas sonne se deplace
			x = Jeu.limit(x + velX, 0, Jeu.WIDTH-35);
			y = Jeu.limit(y + velY, 0, Jeu.HEIGHT-60);
		} else
			stunned--;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(c);
		g.fillRect(x, y, size, size);
	}
	
}
