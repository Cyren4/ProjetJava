import java.util.*; //need Random and Scanner

class Organe{
    public final String nom;
    public final int x;
    public final int y;
    
    public Organe(String nom, Terrain t){
        Random rnd = new Random();
        this.nom = nom;
        x = rnd.nextInt(t.nbColonnes);
        y = rnd.nextInt(t.nbLignes);
    }

    public String toString(){
        return nom + "[" + y + ", " + x + "]";
    }

}