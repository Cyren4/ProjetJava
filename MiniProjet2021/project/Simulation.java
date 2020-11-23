import java.util.*; //need Random and Scanner and ArrayList
import java.io.*;

class Simulation{
    public final int NBRESSOURCESMAX; //nb max de ressources sur le terrain
    private Terrain map;
    private ArrayList<Cellule> cel;
    private Organe[] org;
    private ArrayList<Ressource> ress;
    private ArrayList<Cellule> temp_add;
    private ArrayList<Cellule> temp_remove;
    private int nbRessource;
    private PrintWriter file; 

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
        initCellule();

        map.affiche(); 
        System.out.printf(map.toString());
        System.out.println("\n" + org[0].toString() + "\n" + org[1].toString());

        try {
            file = new PrintWriter("simulation.log", "UTF-8");
        } catch(Exception e) {
            throw new RuntimeException("Error on log file");
        }

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
        }   
    }

    private void initCellule() {
        cel = new ArrayList<Cellule>();
        cel.add(new Pathogene("Bactérie",map));
        for (int i=0;i<100;i++) {
            cel.add(new Globine(map));
        }
    }

    public void initOrgane(Terrain t){
        org = new Organe[2];
        org[0] = new Coeur(t);
        org[1] = new Poumon(t);
    }

    public boolean pasFini() {
        int o2 = 0;
        int co2 = 0;
        for (int i=0;i<map.nbLignes;i++) {
            for (int j=0;j<map.nbColonnes;j++) {
                if (map.getCase(i,j) != null) {
                    if (map.getCase(i,j).type.equals("O2")) {
                        o2 += map.getCase(i,j).getQuantite();
                    } else {
                        co2 += map.getCase(i,j).getQuantite();
                    }
                }
            }
        }
        System.err.println("" + co2 + " " + o2);
        o2 = 0;
        co2 = 0;
        for (Ressource res: ress) {
            if (res.type.equals("O2")) {
                o2 += res.getQuantite();
            } else {
                co2 += res.getQuantite();
            }
        }
        System.err.println("" + co2 + " " + o2);
        if (co2 > o2) {
            return false;
        }
        boolean glob = false;
        for (Cellule c:cel) {
            if (c instanceof Globine) {
                glob = true;
                break;
            }
        }
        /*if (!glob) {
            return false;
        }*/
        return (cel.size() != 0);
    }

    public void simulate() {
        int n = 0;
        while (pasFini() && n < 1000) {
            temp_add = new ArrayList<Cellule>();
            temp_remove = new ArrayList<Cellule>();
            for (Cellule cellule :cel) {
                cellule.update(this);
            }
            for (Organe org_:org) {
                org_.update(this);
            }

            for (Cellule cellule:temp_remove) {
                cel.remove(cellule);
            }
            System.out.println(temp_add.size());
            for (Cellule cellule:temp_add) {
                cel.add(cellule);
            }
            //cel.addAll(temp_add);



            affiche();
            log(n);
            n++;
            System.out.println("\n\n");
        }
        file.close();
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

    public Coeur getCoeur() {
        return (Coeur) org[0];
    }

    public void add(Ressource newRessource){
        if (map.caseEstVide(newRessource.getX(), newRessource.getY())){
            ress.add(newRessource);
            map.setCase(newRessource.getX(), newRessource.getY(), newRessource);
        } else {
            Ressource tmp = map.getCase(newRessource.getX(), newRessource.getY());
            if (newRessource.type.equals(tmp.type))
                tmp.setQuantite(tmp.getQuantite() + newRessource.getQuantite());
        }
    }

    public void add(Cellule newCell) {
        temp_add.add(newCell);
    }
     
    public void remove(Ressource oldRess){
        ress.remove(map.videCase(oldRess.getX(), oldRess.getY()));
    }

    public void remove(Cellule oldCel){
        temp_remove.add(oldCel);
    }

    public void affiche() {
        map.affiche();
        System.out.println(this.getCoeur());
        System.out.println(org[1]);
        for (Cellule cel_ : cel) {
            System.out.println(cel_);
        }
    }

    public void log(int n) {
        int co2 = 0;
        int o2 = 0;
        for (Ressource res: ress) {
            if (res.type.equals("O2")) {
                o2 += res.getQuantite();
            } else {
                co2 += res.getQuantite();
            }
        }
        int glob = 0;
        int path = 0;
        for (Cellule c:cel) {
            if (c instanceof Globine) {
                glob++;
            } else {
                path++;
            }
        }

        file.println("" + n + " " + o2 + " "+co2+" "+glob+" "+path);
    }
}