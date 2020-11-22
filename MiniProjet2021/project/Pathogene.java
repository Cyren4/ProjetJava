class Pathogene extends Cellule{
    private int ressourceAvale;
    public static final int RESSOURCE_AVANT_CLONE = 15;

    public Pathogene(String type, Terrain t){
        super(type, 20, t);
        ressourceAvale = 0;
    }

    public Pathogene clone(){
        return new Pathogene(type, t);
    }


    public void update(Simulation sim) {
        super.update(sim);
        if (estMort()) return;
        super.seDeplacer(x + (int)(Math.random() * 3) - 1, y + (int)(Math.random() * 3) - 1); //FIXME: vérifier qu'on déborde pas
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