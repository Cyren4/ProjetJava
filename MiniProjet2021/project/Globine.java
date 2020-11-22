import java.util.*;

class Globine extends Cellule{
    private int capaciteTransp;
    private int transporte_ressource;
    private int nb_transporte;

    public Globine(Terrain t){
        super("Globule rouge", 20, t);
        Random rnd = new Random();
        capaciteTransp = rnd.nextInt(5) + 1;
    }

    public Globine(int x, int y) {
        super("Globule rouge",20,x,y);
    }


    public void update(Simulation sim) {
        super.update(sim);
        if (estMort()) return;


        if (transporte_ressource == 0) { //ne transporte pas de ressources, donc bouge aléatoirement
            int new_x = x + (int)(Math.random() * 3) - 1;
            int new_y = y + (int)(Math.random() * 3) - 1;
            while (!sim.getTerrain().sontValides(new_y,new_x)) {
                new_x = x + (int)(Math.random() * 3) - 1;
                new_y = y + (int)(Math.random() * 3) - 1;
            }
            super.seDeplacer(new_x,new_y); //FIXME: vérifier qu'on déborde pas
        
        } else {

            int[] coords;
            if (transporte_ressource == 1) { // O2
                coords =  sim.getCoeurCoord();
            } else  { //CO2
                coords = sim.getPoumonCoord();
            }
            int dx = x - coords[0];
            int dy = y - coords[1];
            int mv_x,mv_y;
            if (dx > 0) 
                mv_x = 1;
            else if (dx < 0)
                mv_x = -1;
            else
                mv_x = 0;

            if (dy > 0)
                mv_y = 1;
            else if (dy < 0)
                mv_y = -1;
            else
                mv_y = 0;

            super.seDeplacer(x+mv_x, y+mv_y);

            if (x == coords[0] && y == coords[1]) { //
                if (transporte_ressource == 1) {
                    sim.getCoeur().oxygenate(nb_transporte);

                }
                transporte_ressource = 0;
                nb_transporte = 0;
            }
        }

        Ressource res =  sim.getTerrain().getCase(y,x);
        if (res != null) {
            if (transporte_ressource == 0) {
                if (res.type == "O2") transporte_ressource = 1;
                if (res.type == "CO2") transporte_ressource = 2;
                if (nb_transporte + res.getQuantite() < capaciteTransp) {
                    nb_transporte += res.getQuantite();
                    sim.remove(res);
                }

            } else if (res.type == "O2" && transporte_ressource == 1
                || res.type == "CO2" && transporte_ressource == 2) {
                
                if (nb_transporte + res.getQuantite() < capaciteTransp) {
                    nb_transporte += res.getQuantite();
                    sim.remove(res);
                } else {
                    res.setQuantite(res.getQuantite() - (capaciteTransp - nb_transporte)); //La globine se remplit au max, et laisse le reste sur place.
                    nb_transporte = capaciteTransp;
                }
            }
        }
    }

    public String toString() {
        String s;
        if (transporte_ressource == 0) {
            s = "";
        } else if (transporte_ressource == 1) {
            s = "  O2 (" + nb_transporte+")";
        } else {
            s = "  CO2 (" + nb_transporte + ")";
        }
        return super.toString() + s;
    }
}