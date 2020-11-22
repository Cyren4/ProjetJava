import java.util.*; //need Random and Scanner and ArrayList

class Simulation{
    public final int NBRESSOURCESMAX; //nb max de ressources sur le terrain
    private Terrain map;
    public ArrayList<Cellules> cel;
    private Organe[] org;
    private ArrayList<Ressource> ress;
    private int nbRessource;

    //lance les methode d'initialisation de 
    //  Terrain
    //  Agent=Cellule(Globine,Leucocyte,Pathogene)
    //  Organe = Coeur et Poumon  
    public Simulation(Scanner sc){
        Random rnd = new Random();
        System.out.printf("You picked : La vie ~ ");
        map = initTerrain(sc, rnd);
        NBRESSOURCESMAX = map.nbColonnes * map.nbLignes <= 0 ? 1 : map.nbColonnes * map.nbLignes;
        initRessource(rnd, map); // position le coeur et les poumons
        initOrgane(map); // position le coeur et les poumons

        map.affiche(); 
        System.out.printf(map.toString());
        System.out.println("\n" + org[0].toString() + "\n" + org[1].toString());

    }

    public Terrain initTerrain(Scanner sc, Random rnd){
        System.out.printf("Do you want to choose the field size ?\n");
        System.out.printf("\t1. Yes ~\n");
        System.out.printf("\t2. No - random \n");
        System.out.printf("\t3. No - max \n");

        // try-catch affiche un message d'erreur si un int n'est pas rentré dans ligne de commande
        try{
            int pickSize = sc.nextInt();

            System.out.printf("\nStarting field : \n");
            if (pickSize == 1)
                return new Terrain(sc.nextInt(), sc.nextInt());
            else if (pickSize == 2)
                return new Terrain( rnd.nextInt(Terrain.NBLIGNESMAX) ,rnd.nextInt(Terrain.NBCOLONNESMAX));
            else
                return new Terrain();
        } catch(Exception e){
            throw new RuntimeException("Error.\nYou need to Enter a number");
        }
    }

    public void initRessource(Random rnd, Terrain t){
        int ressourceStart = (int)((rnd.nextInt(NBRESSOURCESMAX) + 1)/2);
        ress = new ArrayList<Ressource>();
        boolean success;
        Ressource tmpR;
        int x, y;
        System.out.println("nb ressource start : " + ressourceStart);
        for (int i = 0; i < ressourceStart; i++){
            y = rnd.nextInt(t.nbLignes);
            x = rnd.nextInt(t.nbColonnes);
            tmpR =new Ressource("O2", rnd.nextInt(3) + 1); 
            ress.add(tmpR);
            success = t.setCase(y, x, tmpR);
        // System.out.println(t.setCase(rnd.nextInt(t.nbLignes), rnd.nextInt(t.nbColonnes), ress[i]));
        }   
        // } catch(Exception e){
            // new RuntimeException(e);
        // }
    }

    private void initCellule(Random rnd) {
        cel = new ArrayList<Cellules>();
    }

    public void initOrgane(Terrain t){
        org = new Organe[2];
        org[0] = new Coeur(t);
        org[1] = new Poumon(t);
    }

    public boolean pasFini() {
        return true;
    }

    public void simulate() {
        while (pasFini()) {
            for (Cellules cellule :cel) {
                cellule.update(this);
            }
            for (Organe org_:org) {
                //org_.update(this);
            }
        }
    }

    public int[] getCoeurCoord() {
        return org[0].getCoord();
    }

    public int[] getPoumonCoord() {
        return org[1].getCoord();
    }

    public Terrain getTerrain() {
        return map;
    }



    public void add(Ressource newRessource){
        if (map.caseEstVide(newRessource.getX(), newRessource.getY())){
            ress.add(newRessource);
            map.setCase(newRessource.getX(), newRessource.getY(), newRessource); 
        }else{
            Ressource tmp = map.getCase(newRessource.getX(), newRessource.getY());
            tmp.setQuantite(tmp.getQuantite() + newRessource.getQuantite());
        }
    }
     
    public void remove(Ressource oldRess){
        ress.remove(map.videCase(oldRess.getX(), oldRess.getY()));
    }

    public void remove(Cellules oldCel){
        cel.remove(oldCel);
    }
        
}