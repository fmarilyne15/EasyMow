# EasyMow
Projet r�alis� pour le cours de scala.

## Compiler et executer 

* Le projet a �t� construit avec SBT. Pour compiler, il faut lancer sbt compile. 
* Pour lancer le programme il faut utiliser sbt run file, o� file est le nom du fichier � utiliser. Les fichiers doivent obligatoirement �tre placer dans le dossier src/main/ressources. Si aucun argument n'est fourni, c'est le fichier movers.txt qui est pris 
* Pour lancer les tests, tapez sbt test

## Impl�mentation 

### Dans cette partie, je vais vous d�tailler mes choix d'impl�mentations

Les repr�sentations des commandes et des directions sont similaires. J'ai opt� pour un sealed case et un object. La fonction stringToCommand prend un char car j'ai estim� qu'une commande n'�tait qu'une seule lettre. Alors que pour direction, on pouvait avoir plus lettres (ex "NW") d'o� le String dans la fonction stringToDirection. Dans direction, j'ai chang� en cours de d�veloppement car ma solution �tait d'avoir deux fonctions dans chaque case object qui renvoyaient les directions droites et gauches. Si on voulait ajouter des points cardinaux, il fallait changer toutes les fonctions. Maintenant j'ai qu'une fonction � modifier.

Pour le terrain, j'ai fait un trait pour un terrain g�n�rique. Puis une case class pour mod�liser un terrain rectangulaire qui impl�mente la fonction inside. Si la taille est n�gative, une exception du constructeur est lev�e.

Une tondeuse est repr�sent�e par la case class car le programme effectue un nombre important de match sur les positions et direction de la tondeuse.

J'ai mod�lis� une position par une case class avec deux entiers et une fonction changePosition qui renvoie une nouvelle position en ajoutant les deltas pris en param�tres. Je n'ai pas mis de restrictions au moment de l'instanciation car les coordonn�es pourront �tre n�gatives pour l'�volution du projet.

Pour essayer de programmer un maximum de fonctionnalit�s scala, j'ai fait un typeclass Print pour afficher les �l�ments.

Enfin le Parseur est la partie qui va g�rer la lecture du fichier contenant la configuration du plateau ainsi que les instructions de l�utilisateur. Dans une premi�re version du projet, il n'y avait pas le type MowersWithCommands. Le Main n'�tait pas vraiment lisible (cf commit 31 d�cembre). 

## Conclusion 

De mani�re objective, le regard que je porte sur l'�tat final du projet est satisfaisant. La totalit� des fonctionnalit�s ont �t� impl�ment�s avec succ�s, Certaines parties du code ont �t� particuli�rement soign�s. 

