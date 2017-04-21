package fr.ul.miage.exemple;

import java.util.HashMap;

public class Arbre_abstrait {
	
	private HashMap<Integer,String> listInstructions;
	
	private int nb_instructions;
	
	public Arbre_abstrait() {
		nb_instructions = 0;
	}
	
	public void construireArbre() {
		
	}
	
	public void ajouterInstruction(String instruction) {
		listInstructions.put(nb_instructions, instruction);
		nb_instructions = nb_instructions + 1;
	}

}
