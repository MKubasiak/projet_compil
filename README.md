# projet_compil
Projet de compilation


Introduire les constantes (à la place des nombres), les identificateurs (à la place des STRINGS).

Cohérence, commencer par main()
Au début, juste les variables globales, et la première fonction (main).
Optimiser(factorisation) pour éviter les redondances.

On peut mettre un commentaire partout dans le programme.
Si il y a un commentaire, on ne fait rien, comme pour l'idée du séparateur : return(;)
Idem pour la doc !

Il faut le non terminal instruction, contenant toutes les instructions possibles (alternative, affectation, boucle, return, appel...)
Instruction fini par un point virgule ! 

Dans un if, mettre condition, à la place de STRING, et y réfléchir par rapport à la présence des parenthèses.
Mettre un bloc, à la place de fichier, (bloc = suite d'instructions)..


exemple de if par le prof :
	alternative ::= IF PO condition PF
					AO bloc AF
					else;
	bloc ::= instruction bloc | ..;
	else ::= ELSE AO bloc AF | ...;


La partie expression est ambigu :
	expression --> expression + facteur |
				   expression - facteur |
				   facteur
	facteur --> facteur * atomique |
				facteur / atomique |
				facteur;
	atomique --> IDF | CONST | appel | parenthèse 

If faut hiéarchiser les priorités.
Du moins vers le plus prioritaires.
Parenthèse est la plus prioritaire.