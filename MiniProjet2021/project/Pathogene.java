class Pathogene extends Cellules{
    private int ressourceAvalé;

    public Pathogene(String type, Terrain t){
        super(type, 20, t);
        ressourceAvalé = 0;
    }

    public void mange(){
        if ()
    }
    public Pathogene clone(){
        return new Pathogene(type, t);
    }
}