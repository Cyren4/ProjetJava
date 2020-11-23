import java.util.*; //need Random and Scanner

class TestSimulation{

    private TestSimulation(){}

    public static int info(Scanner sc){
        System.out.printf("Which information do you want?\n");
        System.out.printf("\t1. All about the simulation\n");
        System.out.printf("\t2. Organes\n");
        System.out.printf("\t3. Cellules\n");
        System.out.printf("\t4. Quit\n");
        //try/catch affiche un message d'erreur si un int n'est pas rentré dans ligne de commande
        try{
            return sc.nextInt();
        } catch(Exception e){
            throw new RuntimeException("Error.\nYou need to Enter a number");
        }
    }

    //permet de choisir si on veut ou non commencer la simulation
    public static int Start(Scanner sc){
        System.out.printf("Welcome!\n\n");
        System.out.printf("Which simulation do you want?\n");
        System.out.printf("\t1. La vie ~\n");
        System.out.printf("\t2. Information\n");
        //mon projet initial mais les contraintes de production m'ont empeché de m'amuser
        // System.out.printf("\t2. Chunin Game\n");
        System.out.printf("\t3. Quit\n");
        //try/catch affiche un message d'erreur si un int n'est pas rentré dans ligne de commande
        try{
            return sc.nextInt();
        } catch(Exception e){
            throw new RuntimeException("Error.\nYou need to Enter a number");
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int jeu = Start(sc);

        if (jeu == 1 ) {
            Simulation s = new Simulation(sc);
            s.simulate();
        } else
            System.out.println("You chose to quit the Simulation.\nSee you soon!");
        
    }
}