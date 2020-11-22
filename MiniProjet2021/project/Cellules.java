import java.util.*;

class Cellules{
    private final String type;
    private static int cpt;
    private int dureeVie;
    private int y;//ligne
    private int x;//colonne

    public Cellules(String type, int dureeVie, Terrain t){
        Random rnd = new Random();
        this.type = type; 
        this.dureeVie = dureeVie;
        y = rnd.nextInt(t.nbLignes);
        x = rnd.nextInt(t.nbColonnes);
        cpt++;
    }

    public boolean estMort(){
        return dureeVie <= 0;
    }


    public double distance(int lig, int col){
        return Math.sqrt(Math.pow(lig - y, 2) + Math.pow(col - x, 2));
    }

    //xnew:nouvelle colonne
    //ynew:nouvelle ligne 
    /*public void seDeplacer(int xnew, int ynew){
        if (!freeze){
            x = xnew;
            y = ynew;
        }
    }*/

    public void update(Simulation sim) {
        dureeVie--;
        if (estMort()) {
            sim.cel.remove(this);
        }
    }
}