class Coeur extends Organe{
    public final int capacite;
    public Ressource[] oxygenation;

    public Coeur(Terrain t){
        super("Coeur", t);
        capacite = 10;
        oxygenation = new Ressource[capacite];
    }

}