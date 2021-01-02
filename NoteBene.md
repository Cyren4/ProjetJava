

# JFrame

class Window -> cree JFrame

## What 
cadre de notre fenetre -> dans une lib java
constructeur : donne nom de la fenetre

### set DefaultCloseOperation : 
Permet de fermer la fenetre avec la croix

### setResizable
On empeche de redimensionner la fenetre (moins de probleme a gerer)

### setLocation
null -> permet d'afficher la fenetre au milieu de l'ecran

### add(jeu)
Permet d'afficher le jeu dans notre cadre
 
### setvisible()
rendre visible


# Jeu

## Thread
Fil conducteur qui permet de faire le jeu

coupler avec l'utilisation de methode synchronized : 
oblige a avoir une thread passant dans la methode a la fois

## BufferStrategy 

check why 3 is recommended
ca commence avec null donc avec la methode render on en cree 3 au depart

constructeur : cree une instance de jeu -> qui cree un fenetre
