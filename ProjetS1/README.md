Projet de Java
==============

Miguel Gazquez 28600492
Cyrena Ramdani 3805942

Règles du quidditch
-------------------

### Le Terrain
Le Quidditch se joue au-dessus du sol sur des balais. Il y a une zone de but à chaque extrémité du terrain. 
- L’aire de jeu est appelée le terrain de Quidditch.

### Balles
On utilise trois types de balles différents :

1. Le Souafle sert à marquer des points.
2. Le Cognard est sans doute la balle la plus dangereuse : il vole dans les airs et des joueurs appelés Batteurs sont chargés de le frapper. De graves blessures peuvent être causées par un Cognard et certains joueurs tombent de leur balai, déséquilibrés.
3. La troisième et la plus importante des balles est le Vif d’or. C’est une petite balle pourvue d’ailes.  Si l’attrapeur réussit à se saisir du Vif d’or, son équipe gagne 150 points d’un coup et fait remporter la plupart du temps la victoire à son équipe. Ces trois balles sont ensorcelées.

### Jeu
À chaque extrémité du terrain de Quidditch se trouvent trois anneaux à travers lesquels le Souafle doit passer pour marquer des points. Au centre du terrain se trouve un cercle, c’est de là que les balles sont lancées quand le match débute. Une fois les balles lancées, les joueurs se rassemblent au sol et s’envolent au coup de sifflet de l’arbitre.



Version (Objectif par palier) : 
-------------------------------

### Version 0: 

- Terrain
- 1 joueur dans chaque équipe.
- 3-5-7  souafles sont disponibles. 
Objectif est de déplacer le plus souaffle jusqu’au but adverse, celui qui en marque le plus gagne. 
Interface graphique reprensentant le terrain, avec un point de couleur representant chaque joueur et la balle



### Version 1 : ajout de fonctionnalités à v0 
- le Cognard est disponible. 
Le Cognard se déplace de manière aléatoire et s’il rentre en interaction avec un joueur, le joueur est propulsé et ne peut pas bouger pendant le cooldown


### Version 2:  ajout de fonctionnalités à v1
- le Vif d’or est disponible 
Le Vif d’or apparaît de manière aléatoire brièvement. Si un joueur,l’attrape il gagne la partie 
- interaction avec la balle plus pousse
possibilité de tirer plus fort (autres?)

### Version 3
Ajout d’un IA contre qui jouer (possibilité de programmer son ia pour en affronter d’autre)

Classes :
---------
http://www.plantuml.com/plantuml/uml/bLRVRngv4t_-xbzXfIzR1LI-qkbUkAjA2KrfAr85qXywdIBZdGKdnjxQNX8EvNy_pthN6Ef8lGTsySp7Cn-FPsRdZR5KsteZiegoUxe2SZP7oTa-Ou8QGvhLFZlVEw3bx8bmQV_wspsvVKk5CFcSKIb1lnn6c0-gXbgtiC-2xa2dS6YBiBLI1XP0DnsaX_AVS0tHf9MjueM3bEfvRG6MSd5AE0b29Z7eASl6JIGMMbKN4wsXrfD71fNbIX9uj20BGu9ax_2EBkYICY1pkWMw5E02sBWmRftFhUPozRF_1yqjt5frMtBHeNeae9-GIhYb7pKl2cxP-cpV4Vm0TU0pfd9B3U6RIi06f3NakfOIgVGwJcIVzKbWW9kdi_bYD1jFOcObbrGq5_1rUh5uJ_ua_nyC1aEIXBoVJ2_VBnpczzy6paXG-CkRgvgMfO1Xzh-i_-6TfXiWfNiwGN-nra0BOfkNMo-L4a0bqOwrExupML9X47bZuDBjkI9hAWi1UfXb_OuAkfgzdL_TZDwz-pHncmPk0mhbSgnMakhOz9QNLzfXhAxHxac2pyTNrsXXF-YHmLEi3ybT2Rhp_btmyY2-wxKcv18Jpjzp5ELBi5Ff1991xfJzvkwP1chXAvU5UiZTzXx-sXHmcn1tPAJYxFwQEdIe6eJa7lBom54tcBO4aKf-b78hHKNkgoqxDpl9rbf9_WyKNkrhpYcJEbKrAbpXFHqEey40RlEnnp2DLfHxWDzi7VqOBmkaTrhoWc-u3T5mlqJDSEdvfmeC2oQZIsCrPPRuVjRapl8Ec8sA8whJ5utdnnxP3Tl_Mn3VUlZyFdprQiij60FPUPJrl1WUhOqB4iOpkF9d8F737wNZzXH79Q5e0tIfQRNcp90LWj3L2koqoAFLjtZnFJ_41LL7WKBrYU2BEsb25d3Uh8V5QuJ4dT9dN-X5KSZt8L3-ZeXKc-FWMQ2HPAo4qeIrcMHiBIKK65lleckI6DG6YgnQbN-5epYU7wLYz-335P8dEiV2k_OsKJ1pnFE3ISA4abvmV5tfEte-9tqcVeJTL5Qr3N5oWb51AmiQEtEYpvrtM_9E6NpSm-wpnimiSWUQR47QM7SD0cYiz4HQ9i7LFXjfJNUVkB5_76xjDL7DUvZzoi5Hdh3Y6k9hmfGGt70bpM4xBGeFo0_OoFP6RI6b3s6SobBf3Ms-nllJzd07DNewaMAEcOHyfNTbYIrO9vJh6hzTbNicb9gwe3e-3mcT4Jkx1irbGbTo44L2lgH2f1Z-y5zGazeYwc85Edak9GgGSudZGjvE4j4eWLyfC6VxqrRPoDDL_AAPt5GjcwHeW76VnjypPSAbuGNW-aKgUtg-vECBzcD3ODBoUgv4EdGeaPPB_tZef8BLuhEW3FBdkLQgDWRYJf9W75DjXumJfibHQRwucTrUt5oF5jEh6KvC0sJVMMWuTFz3G8FeFtKYb7Sp3wFoegu4PzH2x8CKGTfAucDzmKdfz53H76NuKW3IRu2_JWlpy8sJrXlnBm00

```uml
@startuml
package "Start"{
class Start{
+{static} int[] initBalls(Scanner);
+{static} Joueur[] initPlayer(Scanner);
+{static} int chooseTeam(Scanner, int);
+{static} int start(Scanner);
+{static} void info(Scanner);
+{static} void detailBalls(Scanner);
+{static} void detailTeams(Scanner);
}

Class TropDErreurException extends Exception{}

interface Saveable{
+void save(String);
+{static} void write_to_file(String, String);
}
}

package "quidditch"{

Class Jeu extends Canvas implements Runnable,Saveable {
- {static} Jeu INSTANCE;
+{static} final int WIDTH = 1000; 
+{static} final int HEIGHT = 640;
+final int startSouaffle;
	
-JFrame frame;
-Thread thread;
-boolean running = false;
-UseGameO handler;

-{static}int NBSOUAFFLE = 0;
-int nbCognard;
-boolean vifOr = true;
-{static} int[] SCORE = {0, 0};
-{static} Joueur[] player;

-Jeu(Joueur[] j, int[] nbBall);
+{static} Jeu GetInstance();
-void createWindow(int,int,String,Jeu);
-{static} Jeu pickRandom(Scanner);
-(static) Joueur[] randomPlayer();
+(static} void goal(int);

+synchronized void start();
+synchronized void stop();
+void run();
-void reset();
-int playAgain();
- void tick();
-void render();
+{static} int limit(int,int,int);
+{static} void win(int);
+void save(String);
}


abstract class GameObject implements Saveable{
# int x, y;
# int velX, velY;//vitesse
+ final int id;
+ final int size;

+GameObject(int, int, int, int);
+{abstract} void tick();
+{abstract} void render(Graphics g);
+int getId();
+int getX();
+int getY();
+void setX(int);
+void setY(int);
+void setVelX(int);
+void setVelY(int);
+int getVelX();
+int getVelY();
}

Class Joueur extends GameObject {
+ final String nom;
+ final int team;
+ final Color c;
-int stunned;

+Joueur(String,int,Color);
+Joueur(Joueur);
+void getKnocked();
+void win();
+int getTeam;
+String getName();
+Joueur clone();
+void tick();
+void render(Graphics g);
+void save(String);
}

class KeyInput extends KeyAdapter{
- UseGameO handler;

+KeyInput(UseGameO);
+void keyPressed(KeyEvent);
+void keyReleased(KeyEvent);
}


class UseGameO {
ArrayList<GameObject> object;

+void tick();
+void render(Graphics);
+ArrayList<GameObject[]> collisions();
+void addObject(GameObject);
+void removeObject(GameObject);
}

class Information {
+{static} void jeu();
+{static} void teams();
+{static} void gryffindor();
+{static} void hufflepuff();
+{static} void ravenclaw();
+{static} void slytherin();
+{static} void field();
+{static} void balls();
+{static} void quaffles();
+{static} void bludgers();
+{static} void goldenSnitch();
}
}


package "Balles"{
abstract class Balle extends GameObject {
#int count;

+Balle(int,int,int,int);
+void tick();
+void inside();
#void render(Graphics, Color);
}

class Souaffle extends Balle{
- UseGameO handler;

+Souaffle(UseGameO,int);
-{static} int calculPlace(int);
+void tick();
+void pousse(Joueur);
+void render(Graphics);
}

class Cognard extends Balle{
+{static} final int STUN_DURATION = 60;

+ Cognard();
+Cognard(int,int);
+Cognard clone();
+void tick();
+void render(Graphics);
+boolean canDuplicate();
+Cognard duplicate(Cognard);
}

class VifOr extends Balle{
-boolean visible;

+VifOr();
+void tick();
+void render(Graphics);
}
}
@enduml
```
