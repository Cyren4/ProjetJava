import java.util.*; //need Random and Scanner

abstract class Organe{
    public final String nom;
    public final int x;
    public final int y;
    
    public Organe(String nom, Terrain t){
        Random rnd = new Random();
        this.nom = nom;
        x = rnd.nextInt(t.nbColonnes);
        y = rnd.nextInt(t.nbLignes);
    }

    abstract public void update(Simulation sim);

    public String toString(){
        return nom + ": [" + y + ", " + x + "]";
    }

    public void production(String nom, Simulation sim, int quantite){
        Random rnd = new Random();
        Ressource newRes = new Ressource(nom, quantite);
        newRes.setPosition(rnd.nextInt(sim.getTerrain().nbLignes) , rnd.nextInt(sim.getTerrain().nbColonnes)); 
        sim.add(newRes);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int[] getCoord() {
        int[] res = {x,y};
        return res;
    }
}