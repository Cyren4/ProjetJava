package quidditch;

import java.awt.Graphics;
import Start.Saveable;


/**
 * classe abstraite dont heritent tous objets sur terrain visible avec une position,une taille et une vitesse
 * @author cyrena
 *
 */
public abstract class GameObject implements Saveable{
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

	public void save(String file) {
		Saveable.write_to_file(this.getClass() + "[x:"+x+", y:",+y+", velX:"+velX+", velY:"+velY+"]\n");
	}
}
