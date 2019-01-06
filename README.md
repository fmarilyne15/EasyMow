# EasyMow
Projet réalisé pour le cours de scala.

## Compiler et executer 

* Le projet a été construit avec SBT. Pour compiler, il faut lancer sbt compile. 
* Pour lancer le programme il faut utiliser sbt run file, où file est le nom du fichier à utiliser. Les fichiers doivent obligatoirement être placer dans le dossier src/main/ressources. Si aucun argument n'est fourni, c'est le fichier movers.txt qui est pris 
* Pour lancer les tests, tapez sbt test

## Implémentation 

### Dans cette partie, je vais vous détailler mes choix d'implémentations

Les représentations des commandes et des directions sont similaires. J'ai opté pour un sealed case et un object. La fonction stringToCommand prend un char car j'ai estimé qu'une commande n'était qu'une seule lettre. Alors que pour direction, on pouvait avoir plus lettres (ex "NW") d'où le String dans la fonction stringToDirection. Dans direction, j'ai changé en cours de développement car ma solution était d'avoir deux fonctions dans chaque case object qui renvoyaient les directions droites et gauches. Si on voulait ajouter des points cardinaux, il fallait changer toutes les fonctions. Maintenant j'ai qu'une fonction à modifier.

Pour le terrain, j'ai fait un trait pour un terrain générique. Puis une case class pour modéliser un terrain rectangulaire qui implémente la fonction inside. Si la taille est négative, une exception du constructeur est levée.

Une tondeuse est représentée par la case class car le programme effectue un nombre important de match sur les positions et direction de la tondeuse.

J'ai modélisé une position par une case class avec deux entiers et une fonction changePosition qui renvoie une nouvelle position en ajoutant les deltas pris en paramètres. Je n'ai pas mis de restrictions au moment de l'instanciation car les coordonnées pourront être négatives pour l'évolution du projet.

Pour essayer de programmer un maximum de fonctionnalités scala, j'ai fait un typeclass Print pour afficher les éléments.

Enfin le Parseur est la partie qui va gérer la lecture du fichier contenant la configuration du plateau ainsi que les instructions de l’utilisateur. Dans une première version du projet, il n'y avait pas le type MowersWithCommands. Le Main n'était pas vraiment lisible (cf commit 31 décembre). 

## Conclusion 

De manière objective, le regard que je porte sur l'état final du projet est satisfaisant. La totalité des fonctionnalités ont été implémentés avec succès, Certaines parties du code ont été particulièrement soignés. 

