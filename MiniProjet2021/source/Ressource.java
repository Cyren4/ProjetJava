public class Ressource {
  private static int nbRessourcesCreees = 0;
  
  public final int ident;
  
  public final String type;
  
  private int quantite;
  
  private int x;
  
  private int y;
  
  public Ressource(String paramString, int paramInt) {
    this.type = paramString;
    this.quantite = paramInt;
    this.ident = nbRessourcesCreees++;
    this.x = -1;
    this.y = -1;
  }
  
  public int getX() {
    return this.x;
  }
  
  public int getY() {
    return this.y;
  }
  
  public int getQuantite() {
    return this.quantite;
  }
  
  public void setQuantite(int paramInt) {
    this.quantite = paramInt;
  }
  
  public void setPosition(int paramInt1, int paramInt2) {
    this.x = paramInt1;
    this.y = paramInt2;
  }
  
  public void initialisePosition() {
    this.x = -1;
    this.y = -1;
  }
  
  public String toString() {
    String str = this.type + "[id:" + this.ident + " quantite: " + this.quantite + "] ";
    if (this.x == -1 || this.y == -1) {
      str = str + " n'est pas sur le terrain.";
    } else {
      str = str + " en position (" + this.x + ", " + this.y + ")";
    } 
    return str;
  }
}
