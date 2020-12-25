package quidditch;
	
public class Joueur {
	private float x;
	private float y;
	public final String nom;
	public final int team;
	
	public Joueur(String nom, int team) {
		this.nom = nom;
		this.team = team;
		x = team == 1 ? 175 : 250;
		y = 100;
		}
	
}
