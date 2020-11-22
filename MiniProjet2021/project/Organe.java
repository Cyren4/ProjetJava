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

    public void update(){}

    public String toString(){
        return nom + ": [" + y + ", " + x + "]";
    }
<<<<<<< Updated upstream

    public int[] getCoord() {
        int[] res = {x,y};
        return res;
    }

=======
>>>>>>> Stashed changes
}