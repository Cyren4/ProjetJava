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
http://www.plantuml.com/plantuml/uml/bLPHRnev47w-_HLM-x9LGEMaqxrmLvLIaf1M90gaRLHL9xCx2qwClRMz91pAVp-FlHX379qgn89dlXb__dR6zdjjg3BDYcSrBUxf0iYhALfURRE2Kws96sspawq56bOy4IRCzn_soSm7ohdEfmKL0jIRVeIva0qqgeLTSRe1bS9XBb8ifTGm0xhQGJfeVuPpH9DPrfAL5bB9bxqb6Chu4U4q29d4eASi6pebPahM7qTAGQD6ZmNKXab1uD60A3K9bkqJHWGnVpQiB9afbbRGDiy5D25iICMQQi9MDOSL2AF9TIC4dNCWswnB0Z-C6K-ciy5aE8fvLqnGxkJvEluuEoT_azzxlLwV927de_7P-SnY_loZPvC4XvTsAXjQLHpwsMzPz-9KqHMGoZwjeJjRAg0bCUx7ZkTISg22A4kMYOLDML6k4NcZuSp6N98b5IK7rS-oxeuAJZNvCBsy6PoUVXxPe9uDGAEO3-L2K1MdNhFgKbcCKGtcFIg_wV3o6ZDiUntIUmh-kFHgLtOulnKl3-QxJfj2pB4SN1N4Af-16Gjh40NarjbrbL4ee0Q-Cb7AXzo6T_0xDSgklME347UGf6R5_JMrw53J2CazvCsUetAOja6GIdvGa0j9UUvx8JlH6r4ibHJiNoYzstU4TIPzidOkDrADs2z6WGOCyzgZJ8C5PHxWWusb7-D5YVIE6vAp5JD13Vjztb4FJ230Tr56vzeeMXZYTnPN9_Cxi8PjzjgbVEoGJR_zlmR-hOFFs_xRjsjcG6l8Jg9oPcN_OApjwb6eaDUJ8_73SzmHUOgMctAqApzJj5woGfC5Wd2gXIsICez6t-B1xLvuZIvhZWstnuOlTgK9My3vj1uMZn4IRr2-hCBU4kiRXF95IuHS7OfdW4QMeUHIaQ8j4MqQ8Q14RVqKkS_Ythk38glMvN_2KYpFJq8Mz-3b2bKHhMFcf_OvqJ2nnFDzIb9mARpXy7Mbtv5Nn9VO9zYCHTsOe8ar34fQ6r2ulIOsgvDTIBvpXfdkONEbi0hBt896Qn0czbq31nexFP6MIPXgcmsKeflFJ9k_zc_e7P7k5ndy_oBHdiho_SSxKaZEcMPIw7quBSks8VROAFTAhY7b3pAEHINLYhe3RtlSutVGvCyx7-j99-mBjQagt4TLmhbiy02gxJFXLDIAQlay97oQRymI51C9NyM0bmdxd7AUOlZJ7uCw5SARSW4gkIx9In1JWKUzQqhxYQu1UDI0VhKztWETFTsnhztbI3R25OK3nfijVbze2IOqAm77hrFLq_7j7R_WzkmFJ3olbrfaXmujqdBf7jxhA2yQViLf0VdBN6lPQ0tHhf5Y75DjRmf7J9FtdUdiPlBFnvlhmMnyES5hJm_Pxp8u3hl_GT1W-gLT9oRu1IykH_JYQurcSmv8n05_OGBxUM-jpOh_1m00

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
}

package "quidditch"{

Class Jeu extends Canvas implements Runnable {
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
}

abstract class GameObject {
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

Old Version : 

[diagramme UML](http://www.plantuml.com/plantuml/uml/dP2nJW91441hvokcX91hh8q1YGN4n09ZOopcxkPmpDmkcPr52E7VHHQYHcsiBfUtRz_CZfEJUUuL93XRHmtZfEkaUQ5Q6NTmCLf7QR4rUXiyi1b9G1_27W0QfPHmpda7rJncplPq-OolK4tCQ7idoQzkI9MliORgv7w8qwDN39H-fTnpyFIzMqbmt9JF5ieGTSnBji4GHdMCoXImYQgI98R1iOJry3DmksbuvGUsYER2v-5vunpQBtYtFmcpi2QLTXPMsNyz1bGdDseSo-gb-QyDzkVdMyHCNQTy3fPB3x62ft4PoDe_wADqz_Q3mVZmctjz1m00)
