package fr.ul.miage.exemple;

import java.util.HashMap;
import java.util.Map.Entry;

public class Arbre_abstrait {
	
	private HashMap<Integer,String[]> listInstructions;
	
	private int nb_instructions;
	
	public Arbre_abstrait() {
		this.listInstructions = new HashMap<Integer,String[]>();
		this.nb_instructions = 0;
	}
	
	public void construireArbre() {
	}
	
	public void ajouterInstruction(String[] instruction) {
		listInstructions.put(nb_instructions, instruction);
		nb_instructions = nb_instructions + 1;
	}
	
	public void afficherListe() {
		for(Entry<Integer, String[]> entry : listInstructions.entrySet()) {
		    Integer cle = entry.getKey();
		    String[] valeur = entry.getValue();
		    System.out.println("Instruction : " + cle + "Valeurs : " + valeur.length);
		}
	}

}
