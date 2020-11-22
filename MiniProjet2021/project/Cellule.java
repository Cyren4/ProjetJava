import java.util.*;

class Cellule{
    protected final String type;
    private static int cpt;
    protected int dureeVie;
    protected int y;//ligne
    protected int x;//colonne

    public Cellule(String type, int dureeVie, Terrain t){
        Random rnd = new Random();
        this.type = type; 
        this.dureeVie = dureeVie;
        y = rnd.nextInt(t.nbLignes);
        x = rnd.nextInt(t.nbColonnes);
        cpt++;
    }

    public Cellule(String type, int dureeVie , int y, int x){
        this.type = type;
        this.dureeVie = dureeVie;
        this.y = y;
        this.x = x;
    }


    public boolean estMort(){
        return dureeVie <= 0;
    }


    public double distance(int lig, int col){
        return Math.sqrt(Math.pow(lig - y, 2) + Math.pow(col - x, 2));
    }

    //xnew:nouvelle colonne
    //ynew:nouvelle ligne 
    public void seDeplacer(int xnew, int ynew){
        x = xnew;
        y = ynew;

    }

    public void update(Simulation sim) {
        dureeVie--;
        if (estMort()) {
            sim.remove(this);
        }
    }
}