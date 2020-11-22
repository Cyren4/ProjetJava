public final class Terrain {
  public static final int NBLIGNESMAX = 20;
  
  public static final int NBCOLONNESMAX = 20;
  
  private static final int NBCARAFFICHES = 5;
  
  public final int nbLignes;
  
  public final int nbColonnes;
  
  private Ressource[][] terrain;
  
  public Terrain() {
    this(20, 20);
  }
  
  public Terrain(int paramInt1, int paramInt2) {
    if (paramInt1 > 20) {
      this.nbLignes = 20;
    } else if (paramInt1 <= 0) {
      this.nbLignes = 1;
    } else {
      this.nbLignes = paramInt1;
    } 
    if (paramInt2 > 20) {
      this.nbColonnes = 20;
    } else if (paramInt2 <= 0) {
      this.nbColonnes = 1;
    } else {
      this.nbColonnes = paramInt2;
    } 
    this.terrain = new Ressource[this.nbLignes][this.nbColonnes];
  }
  
  public Ressource getCase(int paramInt1, int paramInt2) {
    if (sontValides(paramInt1, paramInt2))
      return this.terrain[paramInt1][paramInt2]; 
    return null;
  }
  
  public Ressource videCase(int paramInt1, int paramInt2) {
    if (sontValides(paramInt1, paramInt2) && 
      this.terrain[paramInt1][paramInt2] != null) {
      Ressource ressource = this.terrain[paramInt1][paramInt2];
      ressource.initialisePosition();
      this.terrain[paramInt1][paramInt2] = null;
      return ressource;
    } 
    return null;
  }
  
  public boolean setCase(int paramInt1, int paramInt2, Ressource paramRessource) {
    if (sontValides(paramInt1, paramInt2)) {
      if (this.terrain[paramInt1][paramInt2] != null)
        this.terrain[paramInt1][paramInt2].initialisePosition(); 
      this.terrain[paramInt1][paramInt2] = paramRessource;
      paramRessource.setPosition(paramInt1, paramInt2);
      return true;
    } 
    return false;
  }
  
  public boolean caseEstVide(int paramInt1, int paramInt2) {
    if (sontValides(paramInt1, paramInt2))
      return (this.terrain[paramInt1][paramInt2] == null); 
    return true;
  }
  
  public boolean sontValides(int paramInt1, int paramInt2) {
    return (paramInt1 >= 0 && paramInt1 < this.nbLignes && paramInt2 >= 0 && paramInt2 < this.nbColonnes);
  }
  
  public void affiche() {
    String str1 = "";
    String str2 = ":";
    String str3 = "";
    byte b;
    for (b = 0; b < 5; b++)
      str3 = str3 + "-"; 
    for (b = 0; b < this.nbColonnes; b++)
      str2 = str2 + str3 + ":"; 
    str2 = str2 + "\n";
    str1 = str2;
    for (b = 0; b < this.nbLignes; b++) {
      for (byte b1 = 0; b1 < this.nbColonnes; b1++) {
        if (this.terrain[b][b1] == null) {
          str1 = str1 + "|" + String.format("%-5s", new Object[] { " " });
        } else {
          str1 = str1 + "|" + premiersCar((this.terrain[b][b1]).type);
        } 
      } 
      str1 = str1 + "|\n" + str2;
    } 
    System.out.println(str1);
  }
  
  public String toString() {
    byte b1 = 0;
    for (byte b2 = 0; b2 < this.nbLignes; b2++) {
      for (byte b = 0; b < this.nbColonnes; b++) {
        if (this.terrain[b2][b] != null)
          b1++; 
      } 
    } 
    String str = "Terrain de " + this.nbLignes + "x" + this.nbColonnes + " cases: ";
    if (b1 == 0) {
      str = str + "toutes les cases sont libres.";
    } else if (b1 == 1) {
      str = str + "il y a une case occup;
    } else {
      str = str + "il y a " + b1 + " cases occup;
    } 
    return str;
  }
  
  private String premiersCar(String paramString) {
    String str = String.format("%-5s", new Object[] { paramString });
    return str.substring(0, 5);
  }
}
