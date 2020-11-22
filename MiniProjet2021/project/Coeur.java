class Coeur extends Organe{
    public final int capacite;
    private int nbO2;

    public Coeur(Terrain t){
        super("Coeur", t);
        capacite = 10;
        nbO2 = 0;
    }

    public void update(Simulation sim){
        if (capacite == nbO2){ 
            super.production("CO2", sim, 5);
            sim.cel.add(new Globine(sim.getTerrain(), super.x, super.y));
        }
    }

}