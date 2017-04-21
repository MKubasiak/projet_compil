package fr.ul.miage.exemple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Arbre_abstrait {
	
	private HashMap<Integer,ArrayList<String>> listInstructions;
	
	private int nb_instructions;
	
	public Arbre_abstrait() {
		this.listInstructions = new HashMap<Integer,ArrayList<String>>();
		this.nb_instructions = 0;
	}
	
	public void construireArbre() {
	}
	
	public void ajouterInstruction(ArrayList<String> instruction) {
		listInstructions.put(nb_instructions, instruction);
		nb_instructions = nb_instructions + 1;
	}
	
	public void afficherListe() {
		for(Entry<Integer, ArrayList<String>> entry : listInstructions.entrySet()) {
		    Integer cle = entry.getKey();
		    ArrayList<String> valeur = entry.getValue();
		    System.out.println("---------------------------");
		    System.out.println("Instruction : " + cle);
		    for(int i = 0; i<valeur.size();i++) {
		    	 System.out.println("  Valeurs : " + valeur.get(i));
		    }
		}
	}

}
