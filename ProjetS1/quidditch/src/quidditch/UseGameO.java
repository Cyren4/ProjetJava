package quidditch;

import java.awt.Graphics;
import java.util.ArrayList;
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
	ArrayList<GameObject> object = new ArrayList<GameObject>();
	
	public void tick() { //update tous les gameObject
		for (int i = 0; i < object.size(); i++) {
			GameObject tmpObject = object.get(i);
			tmpObject.tick();
		}
	}
	
	public void render(Graphics g) {  //affiche tous les gameObject
		for (int i = 0; i < object.size(); i++) {
			GameObject tmpObject = object.get(i);
			
			tmpObject.render(g);
		}
	}
	
	public Joueur getPlayer(int p) {
		int i = 0;
		assert(i == 0 || i == 1);//id 0 and 1 are the only player
		
		while (i < object.size()) {
			if (object.get(i).getId() == p)
				return (Joueur)object.get(i);
			i++;
		} 
		return null;
	}
	
	public void addObject(GameObject newObject) {
		object.add(newObject);
	}
	
	public void removeObject(GameObject supObject) {
		object.remove(supObject);
	}
}
