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
[diagramme UML]
http://www.plantuml.com/plantuml/png/bLPHRo8t47xk_WehUTbJG4UbgY-qf-C8ISYTI1J8tKLLLPdT0PmOUy_sab34Vw_7NemXZgfxO1VFV3F-_EsCxO_QK6Ng9SygMZpHEP2JCLfEDbd1gTR4ZJRPsSO23IksX0dprz_soSmdohdEnmKL0jIxReIvbZNKge7TShe6bS9XBb8ifDGm0RhSGLfeVuLpH9DPLfAL5ZAJRtjBC9Jn8y9f43A9GTiiwpib9afMvmEbe5Q3bm8gmwGWy690b9e4osQB4K7C7pKhIsQAXHMqoNCDTGZhKx6Ych1bnM49mcXoLmj1fnp89ckJm0zZXgFnf3Vg3sBUCoOeT_9y6vvFhiYVvDTEfzCbISZLO7XvDR6Ott_hs2J1uQKTovhEPXowsIzP-_f2qIMGcNrQGtkoK41BOjpBZgTISg22A4kMYRbDEQDS8_9UmwMDkI4BAaeEgfjbxHqLd6hqQNnptxku-3AmGHqRW4OnxSkve2fElMAp6sKnHjMOzwZynlsREyomwRH8PnlxG-bLjkpy_5QyF9WVMqqACSLoy5KGgNm9PYYiGHIGMsVRLKQXW1hunaGfdtCRtiBVs2YxzfODGjn1aeeLJtVKeaDD8oJta7TxZifXcWP1Alb1GSubvRdlXUnChqMnK5AmVw7qRjyHrfdqoSgvt4ZLOhyO1Hemp6kFClNcb7c03pQMVemN9T8xRaZEbinuDVplTKSzCu40tqLqgesYXI5-Ot5bCdq4QzXafoxZIukikyt_5V3lBNm-TD-_Np43MaDs5bKpAxi7OsqNZpg5l9uRYH-Uuex8Dbfjoj4i_5BHQi4AJUO8mgdcjaRAF1fzZmSFUzqrkgmvDZmS6xxQbIPi7XVIUbWyHaYyF_cg2bjBh6yGojSi4N9vA9u16bdwaaj5YgP2jAc5W1ArzLFaFelxx0wAh1gNVuMbM9wVXIoUmCiLYY9QnyHFxNEYOMI9v_kKfE1IUCFXvqf_8w-8Bx7Fi1wAgZP14slebRGoe71tJUnLPxkGVESCCpt1-bPX5PQv1GrM84pikmCED7Pw8WsJCDKcwob5rr-ODd_ilz078jqR6Vp_8j6Uo68tjG-aa9mppQJG-t1QbXwGxx5HxgLSGSeVP1oAcLHBwiwxpN6BFqATlsvyh2UTiC_LUZR3RLGbd8iQpv_AFXDEHQsebizpmgVvsYn0CP7mpHZmCc6VKivJ37_uKr2dGdXTpa4broLv2M8iyAJtJRdDebi0dZIWJpR7Uw2pfplsrDsDP2rSKJXWlDVYxusMO4Ap4d1ycggUbc_l-0CtHtzWudczrI8xT6YHXalxy5f7UL7pMquBoD_cMibQQuXsZHJZc6fpKJXcchhkZ2Vtet_Ex-zwa-7D26yz7MI_o-0uxFu7GOFfftQTcE1NlBSSqujkDPfDEI0H1_o92N2AZzPSB_b_

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
