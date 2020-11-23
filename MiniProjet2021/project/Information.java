class Information{
    private static final double  TEMPERATURE = 37.2;

    private Information(){}

    public static void simulation(){
       System.out.println("Bienvenue dans la simulation \"Il etait une fois... la Vie\"! "); 
       System.out.println("Inspiré de la serie televise \"La fabuleuse histoire du corps humain\"."); 
       System.out.println("Vous allez pouvoir apprecier les interactions entre les divers organes du corps humains avec leurs resources.");
       System.out.println("Le tout sans oublier les organismes externes qui nous pourrissent bien la vie (cf année 2020~).");
       System.out.println("\nCommencer la Simulation va proceder par plusieurs etapes :");
       System.out.println("1. Creer un terrain, avec un choix de la taille");
       System.out.println("2. Pose aleatoire des ressources");
       System.out.println("3. Creation d'Organes (Coeur, Poumons) et Cellules (Globines, Pathogenes)");
       System.out.println("4. La simulation commence et on peut suivre le mouvement des Cellules grace aux logs.");
       System.out.println("5. La situation se termine uniquement si le nombre de tour atteint le max ou si le nombre de CO2 excede celui de l'O2");
    }

    public static void organe(){
       System.out.println("\nLes Organes composent le corps. On s'interesse ici uniquement au Coeur et au Poumon.\n");

    }
    public static void coeur(){
       System.out.println("Le Coeur assure la circulation sanguine. Il recoit de l'O2 grace aux globines.\n"); 
       System.out.println("Une fois un certain nombre d'O2 recut il produit de nouvelles globines et du CO2."); 
    }

    public static void poumon(){
       System.out.println("Le Poumon assure l'approvisionnement d'O2 dans le corps."); 
       System.out.println("Il produit de l'O2 avec un certain debit et permet aux globines de les debarasser du CO2."); 
    }

    public static void cellule(){
       System.out.println("Les cellules sont des micro-organismes qui assure se déplace dans le corps humain. Ils peuvent etre benefique pour le corps."); 
    }

    public static void globine(){
       System.out.println("Les globines sont des agents qui assurent l'acheminement des ressources entre les divers organes du corps humain."); 
        
    }

    public static void pathogene(){
       System.out.println("Les pathogenes sont des agents qui se nourissent des ressources et se multiplient. Ils transforment l'O2 en CO2"); 
    }
}
