package quidditch;

import java.awt.Graphics;
import java.util.ArrayList;
import Balles.*;
//import java.util.LinkedList;

/**
 * 	UseGameO est une classe qui permet de gerer les gameObject
 * 	
 * @author cyrena
 *
 *	@summary
 *	Pour les ajouter , enlever ou juste update les GO
 *	
 */

public class UseGameO {
	ArrayList<GameObject> objects = new ArrayList<GameObject>();
	
	public void tick() { //update tous les gameObject
		for (int i = 0; i < objects.size(); i++) {
			GameObject tmpObject = objects.get(i);
			tmpObject.tick();
		}

		for (GameObject[] coll: collisions()) {
			GameObject o1 = coll[0];
			GameObject o2 = coll[1];
			System.out.println(o1 + " " + o2);

			if (o1 instanceof Joueur) {
				if (o2 instanceof Souffle) {
					//((Souffle) o2).pousse();
				}
			}
			if (o1 instanceof Souffle) {
				if (o2 instanceof Joueur) {
					//((Souffle) o1).pousse();
				}
			}
		}
	}

	public void render(Graphics g) {  //affiche tous les gameObject
		for (int i = 0; i < objects.size(); i++) {
			GameObject tmpObject = objects.get(i);
			tmpObject.render(g);
		}
	}

	public ArrayList<GameObject[]> collisions() {
		/**
		* Retourne une liste de couple d'objects qui sont en collision.
		*/
		ArrayList<GameObject[]> lst = new ArrayList<GameObject[]>();
		for (int i=0; i < objects.size();i++) {
			GameObject object = objects.get(i);
			for (int j=i+1; j < objects.size(); j++) {
				GameObject other_object = objects.get(j);
				int diff_x_1 = Integer.signum(object.getX() - other_object.getX() - other_object.size);
				int diff_x_2 = Integer.signum(object.getX() + object.size - other_object.getX());
				int diff_y_1 = Integer.signum(object.getY() - other_object.getY() - other_object.size);
				int diff_y_2 = Integer.signum(object.getY() + object.size - other_object.getY());
				if ((diff_x_1 != diff_x_2 || diff_x_1 == 0) && (diff_y_1 != diff_y_2 || diff_y_1 == 0)) {
					GameObject[] temp = {object,other_object};
					lst.add(temp);
				}
			}
		}
		return lst;
	}

	public void addObject(GameObject newObject) {
		objects.add(newObject);
	}
	
	public void removeObject(GameObject supObject) {
		objects.remove(supObject);
	}
}
