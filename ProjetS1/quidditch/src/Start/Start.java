package Start;

import java.awt.Color;
import java.util.*;


import quidditch.*;


/**
 * class Start permet d'afficher le menu d'accueil et avoir des informations sur le jeu et l'univers
 * 
 * @author cyrena
 *
 */
public final class Start {
	
	private Start(){}
	
	/**
	 * si l'utilisateur decide de quitter le programme s'arrete sinon le jeu commence
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		if(start(sc) == 1)
			Jeu.GetInstance();
		else
			System.out.println("You chose to quit the game.\nSee you soon!");
	}

	/**
	* Cette fonction sert pour les menus : elle fait choisir l'utilisateur entre les différentes valeurs donné en argument.
	* En cas d'erreur, elle renvoie l'exception TropDErreurException.
	*/
	private static int choixVal(Scanner sc, int[] vals) throws TropDErreurException {
		int nbErreur = 0;
		int choice = 0;
		boolean ok = false;

        while (!ok) {
			choice = sc.nextInt();
			for (int val:vals) {
				if (choice == val) {
					ok = true;
					break;
				}
			}
			if (!ok) {
				nbErreur++;
					if (nbErreur > 4) throw new TropDErreurException("Nombre non valide");
				System.out.printf("Not valid number, try again.\n");
			}
		}
		return choice;
	}
	
	/**
	 * Donne le choix au joueur du nombre de souaffle, Cognard et Vif d'Or
	 * @param sc
	 * @return
	 * @throws TropDErreurException
	 */
	public static int[] initBalls(Scanner sc) throws TropDErreurException {
		int[] nbBalls = new int[3];
		int choice;
		int nbErreur = 0;
		
		try{
			 	System.out.printf("How many Quaffles do you want?\n"+
					 "\t 3 or 5 ? \n");
	            int[] nb_souaffle = {3,5};
	            nbBalls[0] = choixVal(sc,nb_souaffle);
	            
	            System.out.printf("How many Bludgers do you want?\n"+
	   				 "\t 0, 1 or 2 ? \n");
	            int[] nb_cognards = {0,1,2};
	            nbBalls[1] = choixVal(sc,nb_cognards);
	            
	            System.out.printf("How many goldenSnitch do you want?\n"+
		   				 "\t 0 or 1 ? \n");
	            int[] nb_vif = {0,1};
	            nbBalls[2] = choixVal(sc,nb_vif);
	           
	} catch(Exception e){
		throw new TropDErreurException("You need to Enter a number");
	}
		 return nbBalls;
	}
	
	/**
	 * Interprete le choix des joueur et cree le joueur
	 * @param sc
	 * @return
	 * @throws TropDErreurException
	 */
	public static Joueur[] initPlayer(Scanner sc) throws TropDErreurException {
		Joueur[] player = new Joueur[2];
		int otherTeam = 0;
		String name;
		int team;
		int nbErreur = 0; 
		try{
			for (int i = 0 ; i < 2; i++) {
				System.out.println("Player " + (i+1) + " : \nEnter your Name : \n");
				name = sc.nextLine();
				System.out.println("Player "+ (i+1) + " : " + name + "\n");
				team = chooseTeam(sc, otherTeam);
				sc.nextLine(); //this line consume the \n, otherwise the 2nd name can't have an input
				otherTeam = team;
				
				if (team == 1)
					player[i] = new Joueur(name, i, Color.red);
				else if (team == 2)
					player[i] = new Joueur(name, i, Color.blue);
				else if (team == 3)
					player[i] = new Joueur(name, i, Color.yellow);
				else if (team == 4)
					player[i] = new Joueur(name, i, Color.green);
				else
					throw new TropDErreurException("Team not valid");
			}
		
	   	} catch(Exception e){
	   		throw new TropDErreurException("You need to Enter a string");
	    }
		
		return player;
	}
	
	/**
	 * Donne le choix au joueur de sa couleur(equipe) entre Gryffondor / Poufsouffle / Serdaigle / Serpentard
	 * si trop d'erreur sont fait l'exception TropDErreurException est lancee
	 * Au bout de 4 erreurs tout les paramètres seront choisis aléatoirement
	 * @param sc
	 * @return
	 * @throws TropDErreurException
	 */
	public static int chooseTeam(Scanner sc, int otherTeam) throws TropDErreurException{
		System.out.printf("Which team do you want to join? \n"+
				 "\t1. Gryffindor (red)\n"+
	    		 "\t2. Hufflepuff (blue)\n"+
	    		 "\t3. Ravenclaw (yellow)\n"+
	    		 "\t4. Slytherin (green)\n");
		
		int[] teams = {1,2,3,4};
		if (otherTeam != 0) { 	//Si une équipe a déjà été choisie, on enlève du tableau.
								//Comme on utilise un tableau statique, au lieu d'enlever on remplace par une autre valeur du tableau.
			if (otherTeam == 1) {
				teams[0] = teams[1];
			} else {
				teams[otherTeam-1] = teams[otherTeam-2];
			}
		} 

 		return choixVal(sc,teams);
	}
	

	/**
	 * menu de depart 
	 * @param sc
	 * @return
	 */
	public static int start(Scanner sc){
        System.out.printf("What do you want to do ? \n"+
        		"\t1. Start Quiddich Tournament !\n"+
        		"\t2. Information\n"+
        		"\t3. Quit\n");
      //try/catch affiche un message d'erreur si un int n'est pas rentré dans ligne de commande
        try{
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 2){
                info(sc);
                start(new Scanner(System.in));
            }
            return choice;
        } catch(Exception e){
            throw new RuntimeException("Error.\nYou need to Enter a number");
        }
    }
	
	/**
	 * menu d'informations
	 * @param sc
	 */
	public static void info(Scanner sc){
        System.out.printf("Which information do you want?\n"+
        		"\t1. Game\n"+
        		"\t2. Teams\n" +
        		"\t3. Balls\n"+
        		"\t4. Quit\n");
        //try/catch affiche un message d'erreur si un int n'est pas rentré dans ligne de commande
        try{
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                Information.jeu();
            	Information.field();
            } else if (choice == 2)
            	detailTeams(sc);
            else if (choice == 3)
                detailBalls(sc);
            else
            	return;
            info(sc);
        } catch(Exception e){
            throw new RuntimeException("Error.\nYou need to Enter a number");
        }
    }

	/**
	 * menu detail des balles
	 * @param sc
	 */
	private static void detailBalls(Scanner sc) {
		 Information.balls();
	     System.out.printf("Which Ball information do you want?\n"+
	    		 "\t1. Quaffles\n"+
	    		 "\t2. Bludgers\n"+
	    		 "\t3. GoldenSnitch\n"+
	    		 "\t4. Quit\n");
	        //try/catch affiche un message d'erreur si un int n'est pas rentré dans ligne de commande
	     try{
	    	 int choice = sc.nextInt();
	    	 sc.nextLine();
	    	 if (choice == 1)
	    		 Information.quaffles();
	         else if (choice == 2)
	         	Information.bludgers();
	         else if (choice == 3)
	        	 Information.goldenSnitch();
	         else
	        	 return;
	    	 detailBalls(sc);
	        } catch(Exception e){
	            throw new RuntimeException("Error.\nYou need to Enter a number");
	        }
	}
	/**
	 * menu detail des equipes
	 * @param sc
	 */
	private static void detailTeams(Scanner sc) {
		 Information.teams();
	     System.out.printf("Which Team information do you want?\n"+
	    		 "\t1. Gryffindor\n"+
	    		 "\t2. Hufflepuff\n"+
	    		 "\t3. Ravenclaw\n"+
	    		 "\t4. Slytherin\n"+
	    		 "\t5. Quit\n");
	        //try/catch affiche un message d'erreur si un int n'est pas rentré dans ligne de commande
	     try{
	    	 int choice = sc.nextInt();
	    	 sc.nextLine();
	    	 if (choice == 1)
	    		 Information.gryffindor();
	         else if (choice == 2)
	         	Information.hufflepuff();
	         else if (choice == 3)
	        	 Information.ravenclaw();
	         else if (choice == 4)
	        	 Information.slytherin();
	         else
	        	 return;
	    	 detailTeams(sc);
	        } catch(Exception e){
	            throw new RuntimeException("Error.\nYou need to Enter a number");
	        }
		
	}
}