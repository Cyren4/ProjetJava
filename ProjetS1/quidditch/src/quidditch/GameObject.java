package quidditch;

import java.awt.Graphics ;

/**
 * classe abstraite dont herite tous objets sur terrain visible avec une position
 * @author cyrena
 *
 */
public abstract class GameObject implements Affichable{
	protected int x, y;//position
	protected int velX, velY;//vitesse
	public final int id;
	public final int size;

	public GameObject(int x, int y, int id, int size) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.size = size;
	}
	
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public int getId() {
		return id;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int newx) {
		x = newx;
	}
	
	public void setY(int newy) {
		y = newy;
	} 
	
	public void setVelX(int vx) {
		velX = vx;
	} 
	
	public void setVelY(int vy) {
		velY = vy;
	} 
	
	public int getVelX() {
		return velX;
	}
	
	public int getVelY() {
		return velY;
	}
}
