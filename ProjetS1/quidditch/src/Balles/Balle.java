package Balles;

import java.util.Random;
import quidditch.*;

public abstract class Balle implements Affichable {
	private static int nbBalles;
	private int x;
	private int y;
	private boolean visible;
	
	
	public Balle(int x, int y) {
		this.x = x;
		this.y = y;
		nbBalles++;
		visible = true;
	}
	
	public abstract void move();
	
	public int[] getPosition() {
		int[] res = {x,y};
		return res;
	}
	
	public void switchVisible() {
		visible = !visible;
	}
	
}