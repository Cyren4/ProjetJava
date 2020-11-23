import java.util.*;

abstract class Cellule{
    protected final String type;
    private static int cpt=0;
    protected int dureeVie;
    protected int y;//ligne
    protected int x;//colonne
    private int id;

    public Cellule(String type, int dureeVie , int y, int x){
        this.type = type;
        this.dureeVie = dureeVie;
        this.y = y;
        this.x = x;
        id = cpt++;
    }



    public Cellule(String type, int dureeVie, Terrain t){
        this(type,dureeVie,(int)(Math.random()*t.nbLignes),(int)(Math.random() * t.nbColonnes));
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
        //System.out.println(""+this+" "+xnew+","+ynew);
        x = xnew;
        y = ynew;

    }

    public void update(Simulation sim) {
        dureeVie--;
        if (estMort()) {
            sim.remove(this);
        }
    }

    public String toString() {
        return type + "("+id+") : [" + y + "," + x + "]";
    }
}