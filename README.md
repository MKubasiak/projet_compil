# projet_compil
Projet de compilation


Introduire les constantes (� la place des nombres), les identificateurs (� la place des STRINGS).

Coh�rence, commencer par main()
Au d�but, juste les variables globales, et la premi�re fonction (main).
Optimiser(factorisation) pour �viter les redondances.

On peut mettre un commentaire partout dans le programme.
Si il y a un commentaire, on ne fait rien, comme pour l'id�e du s�parateur : return(;)
Idem pour la doc !

Il faut le non terminal instruction, contenant toutes les instructions possibles (alternative, affectation, boucle, return, appel...)
Instruction fini par un point virgule ! 

Dans un if, mettre condition, � la place de STRING, et y r�fl�chir par rapport � la pr�sence des parenth�ses.
Mettre un bloc, � la place de fichier, (bloc = suite d'instructions)..


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
	atomique --> IDF | CONST | appel | parenth�se 

If faut hi�archiser les priorit�s.
Du moins vers le plus prioritaires.
Parenth�se est la plus prioritaire.



A chaque identificateur, doit �tre une r�f�rence dans la table des symboles, soit on est en train de le d�finir et le mettre
dans la table des symboles.
fonction ::= type IDF:s PO param PF corps
					{: contexte = s :} (entre IDF, et PO)
			;
definition ::= type IDF:s PV {: rangerTDS(s,contexte);:}
			;
affectation ::= IDF FG expr {: x=rechercherTDS(s,contexte) }
s : string si IDF:s
o� trouver la variable contexte ? D�s que je rentre dans une fonction, on ins�re une op�ration d�finissant le contexte*			
;

Cr�ation d'un noeud pour idf.
Il faut qu'il a une variable contexte, pas une pile, (+ simple)..

--------------------------------------------------------------------------------------------
A faire apr�s modification : 

- Grammaire pour le "pour"