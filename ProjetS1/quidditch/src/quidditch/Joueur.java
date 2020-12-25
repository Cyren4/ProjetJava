package quidditch;
	
public class Joueur {
	private double x;
	private double y;
	public final String nom;
	public final int team;
	//ajout barre vie -> si on se fait toucher trop de fois par cognard = mort
	
	public Joueur(String nom, int team) {
		this.nom = nom;
		this.team = team;
		x = team == 1 ? 175 : 250;
		y = 100;
	}
	
}
