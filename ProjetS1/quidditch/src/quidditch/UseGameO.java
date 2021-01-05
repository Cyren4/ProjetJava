package quidditch;

import java.awt.Graphics;
import java.util.ArrayList;
import Balles.*;
import Start.Saveable;
//import java.util.LinkedList;

/**
 * 	UseGameO est une classe qui permet de gerer les gameObject
 * 	
 * @author cyrena
 *
 *	@summary
 *	Pour les ajouter , enlever ou juste update les GO
 *	garde aussi une liste des objets en collision a un instant t
 *	
 */

public class UseGameO implements Saveable {
	ArrayList<GameObject> objects = new ArrayList<GameObject>();
	

	/**
	* Cette méthode est appelé régulièrement, elle est responsable de faire évoluer l'état du jeu.
	* Elle va donc appeler la méthode tick de chaque objet, et gérer les collisions.
	*/
	public void tick() {
		for (int i = 0; i < objects.size(); i++) {
			GameObject tmpObject = objects.get(i);
			tmpObject.tick();
		}

		for (GameObject[] coll: collisions()) {//pour chaque couple en collision
			GameObject o1 = coll[0];
			GameObject o2 = coll[1];
//			System.out.println(o1 + " " + o2);//log les 2 objets en collision

			if (o1 instanceof Joueur) {
				if (o2 instanceof Souaffle)
					((Souaffle) o2).pousse((Joueur)o1);
				else if (o2 instanceof Cognard) 
					((Joueur)o1).getKnocked();
				else if (o2 instanceof VifOr) 
					((Joueur)o1).win();
			}		
			if (o1 instanceof Souaffle)
				if (o2 instanceof Joueur)
					((Souaffle) o1).pousse((Joueur) o2);
			
			if (o1 instanceof Cognard) {
				if (o2 instanceof Joueur)
					((Joueur) o2).getKnocked();
				if (o2 instanceof Cognard) {
					Cognard n = ((Cognard) o2).duplicate((Cognard) o1);
					if (n != null) {
						objects.add(n);
					}
				}
			}
			if (o1 instanceof VifOr)
				if (o2 instanceof Joueur)
					((Joueur) o2).win();
		}
	}

	/**
	* Cette méthode va afficher tout les objets. Elle est appelé régulièrement pour raffraichir l'écran.
	*/
	public void render(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			GameObject tmpObject = objects.get(i);
			tmpObject.render(g);
		}
	}

	/**
	* Retourne une liste de tout les couple d'objects qui sont en collision.
	* (on considère que tout les objets sont des carrés pour plus de simplicité)
	*/
	public ArrayList<GameObject[]> collisions() {
		ArrayList<GameObject[]> lst = new ArrayList<GameObject[]>();
		for (int i=0; i < objects.size();i++) {
			GameObject object = objects.get(i);
			for (int j=i+1; j < objects.size(); j++) { //On ne teste que les objets derrières pour ne pas avoir deux fois les couples.
				GameObject other_object = objects.get(j);
				int diff_x_1 = Integer.signum(object.getX() - other_object.getX() - other_object.size);
				int diff_x_2 = Integer.signum(object.getX() + object.size - other_object.getX());
				int diff_y_1 = Integer.signum(object.getY() - other_object.getY() - other_object.size);
				int diff_y_2 = Integer.signum(object.getY() + object.size - other_object.getY());
				if ((diff_x_1 != diff_x_2 || diff_x_1 == 0) && (diff_y_1 != diff_y_2 || diff_y_1 == 0)) {
					GameObject[] temp = {object,other_object};
					lst.add(temp); //On ne teste pas si object == other_object car la manière dont on fait la boucle garantie de ne pas avoir ce cas
				}
			}
		}
		return lst;
	}

	
	public Joueur getPlayer(int p) { //get which player according to id
		int i = 0;
		assert(i == 0 || i == 1);//id 0 and 1 are the only player
		
		while (i < objects.size()) {
			if (objects.get(i).getId() == p)
				return (Joueur)objects.get(i);
			i++;
		} 
		return null;
	}
	
	public void addObject(GameObject newObject) {
		objects.add(newObject);
	}
	
	public void removeObject(GameObject supObject) {
		objects.remove(supObject);
	}

	public void save(String file) {
		for (GameObject ob: objects) {
			ob.save(file);
		}
	}
}
