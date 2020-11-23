import java.util.*;

//Le poumon est un organe qui rejette le CO2 
//et injecte de l'O2 dans l'organisme 
class Poumon extends Organe{
    public static final double POURCENTAGE_MAP = 0.2;//poucentage de map a ajouter O2
    public final int concO2;//concentration O2 = quantite d'O2 ajouter par ressource
    private int debit;

    public Poumon(Terrain map){
        super("Poumon", map);
        debit = map.nbColonnes * map.nbLignes <= 0 ? 1 : (int)(map.nbColonnes * map.nbLignes * POURCENTAGE_MAP);
        concO2 = 4;
    }


    public void update(Simulation sim){
        Random rnd = new Random();
        int ajoutO2 = rnd.nextInt(debit+1);//quantite O2 ajouté aleatoirement
        
        for (int i = 0; i < ajoutO2; i++){
            super.production("O2", sim, concO2);
        }
    }

    public String toString(){
        return super.toString() + " a un debit de " + debit + " O2/tour.";
    }
}