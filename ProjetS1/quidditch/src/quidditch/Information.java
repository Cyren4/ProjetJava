package quidditch;

public class Information {
	   private Information(){}

	    public static void Jeu(){
	       System.out.println("Welcome in our game \"Quidditch Tournament\"! "); 
	       
	       System.out.println("Tired of being a simple muggle? Take your chance and enter our Quidditch Tournament.\n" + 
	    		   "It's your turn to ride your flying broomsticks and show your talent as the best witch or wizard.\n" +
	       			"Be a part of your favorite House in Hogwarts and bring honour to them.");
	       
	       System.out.println("A new way of playing this dangerous sport invented by author J.K. Rowling for her fantasy book series Harry Potter."); 
	     
	       System.out.println("\nHow to play :"+
	    		   "1. Choose between solo and multiplayer mode.\n"+
	    		   "2. Choose your house and name your wizard.\n"+
	    		   "3. Pick how many Quaffles you want\n"+
	    		   "4. Choose to play with or without Bludgers and the Golden Snitch.\n" +
	    		   "5. Have fun !");
	    }

	    public static void Teams(){
	    	 System.out.println("\nHogwarts is divided into four houses, each bearing the last name of its founder:\n"+
		    		   "Red: Gryffindor values courage, bravery, nerve, and chivalry."
		    		   + " Gryffindor's mascot is the lion, and its colours are scarlet red and gold\n"+
		    		   "Yellow: Hufflepuff values hard work, patience, justice, and loyalty."
		    		   + " The house mascot is the badger, and canary yellow and black \n"+
		    		   "Blue: Ravenclaw values intelligence, learning, wisdom and wit."
		    		   + " The house mascot is an eagle and the house colours are blue and bronze \n"+
		    		   "Green: Slytherin values ambition, cunning, leadership, and resourcefulness. "
		    		   + "The house mascot of Slytherin is the serpent, and the house colours are green and silver. \n" +
		    		   " Pick your values and color!");
	    }
	    
	    public static void Field(){
	    	 System.out.println("\nThe field is pretty wide"+ Jeu.WIDTH + " x " + Jeu.HEIGHT + "sq feet"+
	    			 "Both teams Hoops to score are highlighted.");
	    }
	    public static void Quaffles(){
	       System.out.println("\nYou can choose to play with 3 or 5 Quaffles\n"+
	    		   "Your goal is to bring all of them to the opponents' hoop it scores 10 points and defend yours as well.\n"+
	    		   "The game finish once all the Quaffles got scored.\n");
	    }
	    public static void Bludgers(){
	       System.out.println("If you choose to play with Bludgers\n"+
	    		   "Both teams are attacked indiscriminately by the two Bludgers\n"+
	    		   "If you get hit by one of them your player while be shortly disoriented.\n"); 
	    }

	    public static void GoldenSnitch(){
	    	System.out.println("If you choose to play with the Golden Snitch\n"+
	    			"Catching the Snitch ends the game and scores 150 points.\n" +
	    			"However catching it is pretty hard and it can get tricky if the other team score all the Quaffles\n");
	    }
}
