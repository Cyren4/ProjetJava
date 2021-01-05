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
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		if(start(sc) == 1)
			Jeu.GetInstance();
		else
			System.out.println("You chose to quit the game.\nSee you soon!");
	}
	
	//Donne le choix au joueur du nombre de souaffle, Cognard et Vif d'Or
	public static int[] initBalls(Scanner sc) throws TropDErreurException {
		int[] nbBalls = new int[3];
		int choice;
		int nbErreur = 0;
		
		try{
			 	System.out.printf("How many Quaffles do you want?\n"+
					 "\t 3 or 5 ? \n");
	            do  {
            		choice = sc.nextInt();
	            	if(choice !=  3 && choice != 5) {
	            		nbErreur++;
	            		if (nbErreur > 4) 
	            			if (nbErreur > 4) throw new TropDErreurException("Erreur dans le choix du nombre de Souaffle");
	            			System.out.printf("Not valid number, try again.\n");
	            	}

	            }while (choice !=  3 && choice != 5);
	            nbBalls[0] = choice;
	            
	            System.out.printf("How many Bludgers do you want?\n"+
	   				 "\t 0, 1 or 2 ? \n");
	            do  {
	            	choice = sc.nextInt();
	            	if(choice < 0 || choice > 2){
	            		nbErreur++;
	            		if (nbErreur > 4) throw new TropDErreurException("Erreur dans le choix du nombre de Cognard");
	            		System.out.printf("Not valid number, try again.\n");
	            	}
	            }while (choice < 0 || choice > 2);
	            nbBalls[1] = choice;
	            
	            System.out.printf("How many goldenSnitch do you want?\n"+
		   				 "\t 0 or 1 ? \n");
	            do  {
	            	choice = sc.nextInt();
	            	if(choice < 0 || choice > 1){
	            		nbErreur++;
	            		if (nbErreur > 4) throw new TropDErreurException("Erreur dans le choix du nombre de Vif d'or");

	            		System.out.printf("Not valid number, try again.\n");
	            	}
	            }while (choice < 0 || choice > 1);
	            nbBalls[2] = choice;
	           
	} catch(Exception e){
		throw new TropDErreurException("You need to Enter a number");
	}
		 return nbBalls;
	}
	
	private static int tooManyError(String error, int nbErreur)throws TropDErreurException{
		nbErreur++;
		if (nbErreur > 4) throw new TropDErreurException("Erreur dans le choix du nombre de" + error);
		System.out.printf("Not valid number, try again.\n");
		return nbErreur;
	}
	
	//Donne le choix au joueur de sa couleur(equipe) entre Gryffondor / Poufsouffle / Serdaigle / Serpentard
	public static Joueur[] initPlayer(Scanner sc) throws TropDErreurException {
		Joueur[] player = new Joueur[2];
		int otherTeam = 0;
		String name;
		int team;
		int nbErreur = 0; //Au bout de 4 erreurs tout les paramètres seront choisis aléatoirement
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
	
	public static int chooseTeam(Scanner sc, int otherTeam) throws TropDErreurException{
		System.out.printf("Which team do you want to join? \n"+
				 "\t1. Gryffindor (red)\n"+
	    		 "\t2. Hufflepuff (blue)\n"+
	    		 "\t3. Ravenclaw (yellow)\n"+
	    		 "\t4. Slytherin (green)\n");
		 try{
	            int choice = sc.nextInt();
	            if (choice <  1 || choice > 4) {
	            	System.out.printf("Not valid number, try again.\n");
	            	return chooseTeam(sc, otherTeam);
	            }else if (choice == otherTeam) {
	            	System.out.printf("You can't pick the same color , pick another one.\n");
	            	return chooseTeam(sc, otherTeam);
	            }
	            else
	            	return choice;
	        } catch(Exception e){
	            throw new TropDErreurException("You need to Enter a number");
	        }
	}
	

	//menu de depart 
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
	
	//menu d'information
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
//	public static void showWindow() {
//		   JFrame frame = new JFrame("Quidditch Tournament");  
//	       JPanel panel = new JPanel();  
//	       panel.setLayout(new FlowLayout());  
//	       JLabel label = new JLabel("Do you want to play Quidditch?");  
//	       JButton button = new JButton();
//	       ImageIcon test = new ImageIcon("Image/start.jpg");
////	       JLabel image = new JLabel(test);
//	       button.setText("Start");  
//	       panel.add(label);  
//	       panel.add(button);  
//	       frame.add(panel); 
//	     //  frame.add(test);
//	       frame.setSize(1000, 500);  
//	       frame.setLocationRelativeTo(null);  
//	       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
//	       frame.setVisible(true);  
//	   
//	}
}
