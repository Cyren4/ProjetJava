class Globine extends Cellules{
    private int capaciteTransp;

    public Globine(Terrain t){
        super("Globule rouge", 3, t);
        Random rnd = new Random();
        capaciteTransp = rnd.nextInt(5) + 1;
    }

    public Glonbine clone(){
        return new Globine(t);
    }
}