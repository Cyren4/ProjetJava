import java.util.*;

//Le poumon est un organe qui rejette le CO2 
//et injecte de l'O2 dans l'organisme 
class Poumon extends Organe{
    public static final double pourcentageMap = 0.2;//poucentage de map a ajouter O2
    public static final int concO2;//concentration O2 = quantite d'O2 ajouter par ressource
    public int debit;

    public Poumon(Terrain map){
        super("Poumon", map);
        debit = map.nbColonnes * map.nbLignes <= 0 ? 1 : (int)(map.nbColonnes * map.nbLignes * pourcentageMap);
    }

    public void fumer(){
        if (debit > 0)
            debit--;
    }

    public void courir(){
        debit += 10*pourcentageMap;
    }

    public void update(Simulation sim){
        Random rnd = new Random();
        int ajoutO2 = rnd.nextInt(debit);
        for (int i = 0; i < ajoutO2; i++){
            sim.ress.add(new Ressource("O2", rnd.nextInt(concO2)));
        }
    }

    public String toString(){
        return super.toString() + " a un debit de " + debit + " O2/tour.";
    }
}