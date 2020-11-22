class Pathogene extends Cellule{
    private int ressourceAvale;
    public static final int RESSOURCE_AVANT_CLONE = 15;

    public Pathogene(String type, Terrain t){
        super(type, 20, t);
        ressourceAvale = 0;
    }

    public Pathogene(String type, int x, int y) {
        super(type,20,x,y);
    }

    public Pathogene clone(){
        return new Pathogene(type, x, y);
    }


    public void update(Simulation sim) {
        super.update(sim);
        if (estMort()) return;

        int new_x = x + (int)(Math.random() * 3) - 1;
        int new_y = y + (int)(Math.random() * 3) - 1;
        while (!sim.getTerrain().sontValides(new_y,new_x)) {
            new_x = x + (int)(Math.random() * 3) - 1;
            new_y = y + (int)(Math.random() * 3) - 1;
        }
        super.seDeplacer(new_x,new_y); //FIXME: vérifier qu'on déborde pas


        Ressource res =  sim.getTerrain().getCase(y,x);
        if (res != null && res.type == "O2") {
            Ressource tmp = new Ressource("CO2",res.getQuantite());
            sim.remove(res);
            sim.add(tmp);
            ressourceAvale += tmp.getQuantite();
            if (ressourceAvale >= RESSOURCE_AVANT_CLONE) {
                Pathogene new_pat = this.clone();
                new_pat.ressourceAvale /= 2;
                ressourceAvale = ressourceAvale - new_pat.ressourceAvale;
                sim.add(new_pat);
            }
        }
    }
}