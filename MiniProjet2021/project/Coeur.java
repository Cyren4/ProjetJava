class Coeur extends Organe{
    public final int capacite;
    private int nbO2;

    public Coeur(Terrain t){
        super("Coeur", t);
        capacite = 10;
        oxygenation = 0;
    }

    public void update(Simulation sim){
        if (capacite == nbO2){ 
            super.production("CO2", sim, 5);
            sim.cel.add(new Globine(sim.map, super.x, super.y));
        }
    }

}