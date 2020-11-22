class Information{
    private static float TEMPERATURE = 37.2;

    private Information(){}

    public fievre(){
        TEMPERATURE = 40.3;
    }

    public mort(){
        TEMPERATURE = 10.1;
    }
    public static simulation(){
       System.out.println("Bienvenue dans la simulation \"Il etait une fois... la Vie\"! "); 
       System.out.println("Inspiré de la serie televise \"La fabuleuse histoire du corps humain\"."); 
       System.out.println("Vous allez pouvoir apprecier les interactions entre les divers organes du corps humains avec leurs resources.");
       System.out.println("Le tout sans oublier les organismes externes qui nous pourrissent bien la vie (cf année 2020~).")
       System.out.println("\nCommencer la Simulation va proceder par plusieur etape :")
       System.out.println("1. Creer un terrain et vous avez le choix de sa taille")
       System.out.println("2. Pose aleatoirement les ressources")
       System.out.println("3. Creation d'Organes (Coeur, Poumons) et Cellules (Globines, Pathogene)");
       System.out.println("4. La simulation commence et on peut suivre les mouvements des Cellules graces aux log.");
       System.out.println("5. La situation se termine uniquement si le nombre de tour atteint 200 ou si le nombre de CO2 excede celui de l'O2")
    }

    public static organe(){
       System.out.println("Le Organes composent le corps. On s'interesse ici uniquement au Coeur et au Poumon.");

    }
    public static coeur(){
       System.out.println("Le Coeur assure la circulation sanguine. Il recoit de l'O2 grace aux globines."); 
       System.out.println("Une fois un certain nombre d'O2 recut il produit de nouvelles globines et du CO2."); 
    }

    public static poumon(){
       System.out.println("Le Pumon assure l'approvisionnement d'O2 dans le corps."); 
       System.out.println("Il produit de l'O2 avec un certain debit et permet aux globines de les debarasser du CO2."); 
    }

    public static cellule(){
       System.out.println("Les cellules sont des micro-organismes qui assure se déplace dans le corps humain. Ils peuvent etre benefique pour le corps."); 
    }

    public static globine(){
       System.out.println("Les globines sont des agents qui assurent l'acheminement des ressources entre les divers organes du corps humain."); 
        
    }

    public static pathogene(){
       System.out.println("Les pathogenes sont des agents qui se nourissent des ressources et se multiplient. Ils transforment l'O2 en CO2"); 
    }
}