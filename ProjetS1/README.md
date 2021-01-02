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
http://www.plantuml.com/plantuml/png/RLDDRvj043rtVyL8FIPMt0_rGbl5TPtORIHBWJJjSO0XsMgPjNONQXVvltTP42Ok5nRclNapysQvjWwDgqebCeNMmgFaNFy1sZlYtC8IkKOBpL68PS2_KNKEodAdg2Hs5kuhPamLGICklB2J6HIIKO5a1u-RhyaQFi6R-NmUmGHXlThShXFF-F1-7atWSRAuJ-BjmytDtSgptaNYbPWbpuOm1nUEICnIhHKXW_6jI7xol0AL9OyyMBh5ahRmZ9mhCf4GirQMqrXNHQ6eq-nZI_t4Q78VUpjIhMMnDJxcJEKblIkOMcSmSz3P5mgalya76l4wTBs_X4FKlzUaVbwspr_HrLKj7LbBuc8qeioZ5zzM_ktgTFB328rO68E7EsdTnrFDpw33UKhuJeSDxoetxCm75Zdk79b6pE1_IqwBrXLLPiWR3pPq63lJMiowVDcr8nn5bbff0zb8UxNFQEUavbWR9oaXOr3oK6k0csEViE4QbSp3A9EqypryGQLeklcJENxjM1GZNiXgVUckNfWb_1yGJPerAFMNvKpesAC_mgKvntfmmuKs9RPpW8zUUqvLgdy0

```uml
@startuml
class Window extends Canvas {}

Class Jeu extends Canvas implements Runnable {
+static final int WIDTH = 1000; 
+static final int HEIGHT = 640;
+static final int STARTSOUFFLE = 3;
	
-Thread thread;
-boolean running = false;
-UseGameO handler;

-int nbSouffle = 3;
-int nbCognard = 2;
-boolean vifOr = true;
}

abstract class GameObject {
# int x, y;
# int velX, velY;//vitesse
+ final int id;
+ final int size;
}

class UseGameO {
ArrayList<GameObject> object
}

class KeyInput extends KeyAdapter{
- UseGameO handler;
}

Class Joueur extends GameObject {
+ final String nom;
+ final int team;
+ final Color c;
}

Class ExceptionSortieTerrain extends Exception{}
Class InvalidInput extends Exception{}

abstract class Balle extends GameObject {

}

class Souaffle extends Balle{
- static int start ;
- UseGameO handler;
}

class Cognard extends Balle{}
class VifOr extends Balle{}

class Information {}
@enduml
```

Old Version : 

[diagramme UML](http://www.plantuml.com/plantuml/uml/dP2nJW91441hvokcX91hh8q1YGN4n09ZOopcxkPmpDmkcPr52E7VHHQYHcsiBfUtRz_CZfEJUUuL93XRHmtZfEkaUQ5Q6NTmCLf7QR4rUXiyi1b9G1_27W0QfPHmpda7rJncplPq-OolK4tCQ7idoQzkI9MliORgv7w8qwDN39H-fTnpyFIzMqbmt9JF5ieGTSnBji4GHdMCoXImYQgI98R1iOJry3DmksbuvGUsYER2v-5vunpQBtYtFmcpi2QLTXPMsNyz1bGdDseSo-gb-QyDzkVdMyHCNQTy3fPB3x62ft4PoDe_wADqz_Q3mVZmctjz1m00)
