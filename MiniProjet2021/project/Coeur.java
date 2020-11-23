class Coeur extends Organe{
    public final int capacite;
    private int nbO2;

    public Coeur(Terrain t){
        super("Coeur", t);
        capacite = 10;
        nbO2 = 0;
    }

    public void update(Simulation sim){
        while (capacite <= nbO2){
            System.out.println("Production");
            super.production("CO2", sim, 5);
            sim.add(new Globine(super.x, super.y));
            nbO2 -= capacite;
        }
    }

    public void oxygenate(int nb) {
        System.out.println("        Coeur" + nb);
        nbO2 += nb;
    }

    public String toString() {
        return super.toString() + "(" + nbO2 +")";
    }

}