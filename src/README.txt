Fahirah Diarra, p1104084
Hamdi Ghannem,  p1225567

Par rapport au design que nous avons précédement voici les quelques changements que nous avons apporter,
pour mener à bien le projet.


- Classe Surface, attribut  Forme[] listeForme

l'attribut liste est de type Forme [], nous l'avons changer pour un ArrayList<Forme> car, cette
structure permettait d'ajouter plus facilement les formes, nous évitant ainsi de recréer
nouveau tableau à chaque fois que nous voulons insérer une forme

- Classe Surface, méthode  resetCanevas ()

Cette méthode efface tout ce qui été inscrit dans le canevas, elle est utile, car elle permet,la
de réecrire nos forme après avoir entre brasser ou renverser

- Classe Surface, méthode setPixel(char car , int i , int j)

Cette méthode à été ajouter pour permettre de mettre dans le canevas les pixels de l'objet que nous essayons de dessiner
à l'interieur de la matrice.


- Classe Surface, méthode afficherCanevas()

Cette méthode a été ajouter simplement pour permettre d'afficher le contenu du canevas


Classe Forme, méthode abstraite renverse

Cette méthode abstraite permet à chacune des classe qui le concept de étende forme de pouvoir définir la procédure permettant
de renverser une forme.



- Classe Cercle, méthode ajouterPixel(Surface sur, int x , int y)

C'est une méthode est utilisé lors de la création du dessin de cercle pour faciliter
l'ajout au canevas.


- Classe Cercle, méthode renverser(Surface sur)

Cette méthode à été ajouter pour permetttre de renverser le cercle en tenant compte du positionnement et des dimension de la surface



- Classe Rectangle, méthode renverser(Surface sur)

Cette méthode à été ajouter pour permetttre de renverser le rectangle en tenant compte du positionnement et des dimension de la surface


- Classe Ligne, méthode renverser(Surface sur)

Cette méthode à été ajouter pour permetttre de renverser la ligne en tenant compte du positionnement et des dimension de la surface


-  Classe Lettre attribut char lettre

Cette attribut à été enlever, car nous utilisons maintenant la paramètre passant la lettre pour créer
directement le tableau d'octet contenant l'information nécessaire pour construire le caractère.

- Class Lettre attribut byte [] carImage

Cette attribut sert à contenir l'information par rapport à la facon de dessiner une lettre.

- Classe Lettre méthode renverser(Surface sur)

Cette méthode permet changer l'arrangement des bytes en tenant compte du positionnement et des dimension de la surface
pour obternir un dessin renverser.


- Classe Ligne, méthode renverser(Surface sur)

Cette méthode à été ajouter pour permetttre de renverser la ligne en tenant compte du positionnement et des dimension de la surface


- Classe Lettre, méthode renverser(Surface sur)

Cette méthode à été ajouter pour permetttre de renverser la texte en renversant individuellement chacune des lettres qui forme le texte


Pour la detection des entrées nous séparer le concept en deux étapes:
1- la detection de la validité de l'entrée
2. l'execution de l'entrée

Pour la detection de la validité de l'entrée,nous nous sommes intéressé dabord à l'existence de la commande.
ensuite nous avons découper les arguments de la commande pour voir si le nombre de paramètre était adéquat et s'ils étaient du bon type.

Ensuite, il ne restait qu'à faire l'exécution en étant s'assurant que la surface ait été initialisé avant de pour executer.

Ce Travail pratique fut une bon exercise pour exercer les concepts d'orienter objet. Nous avions quelques fonctions manquantse au niveau de notre design, mais sinon le squelette de départ
à été une bonne inspiration pour la complétion du tp.

 Merci!