package fr.ul.miage.exemple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

public class Arbre_abstrait {
	
	private HashMap<Integer,ArrayList<String>> listInstructions;
	
	private int nb_instructions;
	
	private Noeud racine;
	
	private Noeud dernier;
	
	public Arbre_abstrait() {
		this.listInstructions = new HashMap<Integer,ArrayList<String>>();
		this.nb_instructions = 1;
		this.racine = new Noeud("main");
		this.dernier = this.racine;
	}
	
	public void construireArbre() {
		//on parcourt la hashmap d'instruction
		for(int i=0; i<this.listInstructions.size();i++){
			//On prend les instructions niveau par niveau
			ArrayList<String> instr = this.listInstructions.get(i);
			//On les parcours
			for(int j=instr.size()-1; j>=0; j--){
				//Si c'est une affectation qu'il n'y a pas d'opération qui suit
				if(instr.get(j)=="Affectation"){
					if(instr.get(j-4) == "Condition"){
						Noeud gauche = ajouterCondition(instr);
						this.dernier.getFils().add(gauche);
						ajouterAffectation(instr.get(j-1), instr.get(j-3),this.dernier);
					}else if(instr.get(j-3) != "operation"){
						//On ajoute l'affectation a l'arbre
						ajouterAffectation(instr.get(j-1), instr.get(j-3),this.dernier);
						//on remove de la liste d'instruction du niveau les elements traités
						instr.remove(j);
						instr.remove(j-1);
						instr.remove(j-2);
						instr.remove(j-3);
						j-=3;
					}else{
						//si une operation suis l'instruction
						ajouterOperation(instr, this.dernier);
						j=0;
					}
				}
			}
		}
	}
	
	public void afficherArbre(){
		System.out.println(this.racine.getValeur());
		LinkedList<Noeud> fils = this.racine.getFils();
		this.parcourirArbre(fils);
	}
	
	public void parcourirArbre(LinkedList<Noeud> fils){
		for(int i = 0; i<fils.size();i++) {
			System.out.println(fils.get(i).getValeur());
			if(!fils.get(i).getFils().isEmpty()) {
				this.parcourirArbre(fils.get(i).getFils());
			}
		}
	}
	
	private void ajouterAffectation(String var, String val, Noeud racine_aff){
		LinkedList<Noeud> fils = new LinkedList<Noeud>();
		fils.add(new Noeud(var));
		fils.add(new Noeud(val));
		Noeud ope = new Noeud(fils, "=");
		racine_aff.getFils().add(ope);
	}
	
	public Noeud ajouterCondition(ArrayList<String> instructions){
		LinkedList<Noeud> fils = new LinkedList<Noeud>();
		fils.add(new Noeud(instructions.get(1)));
		fils.add(new Noeud(instructions.get(3)));
		Noeud gauche = new Noeud(fils, instructions.get(2));
		return gauche;
	}
	
	public void ajouterBloc(ArrayList<String> instructions){
		
	}
	
	private Noeud ajouterOperation(ArrayList<String> instructions, Noeud racine_ope){
			int i=0;
			//si il n'y a qu'une seule operation
			if(!(instructions.get(i+2) == "operation" || instructions.get(i+3) == "operation")){
				LinkedList<Noeud> fils = new LinkedList<Noeud>();
				//on cree le noeud ope qui contient le signe de l'operation et les deux noeuds fils qui contiennent les valeurs
				Noeud val1 = new Noeud(instructions.get(i));
				Noeud val2 = new Noeud(instructions.get(i+1));
				Noeud ope = new Noeud(instructions.get(i+2));
				ope.getFils().add(val1);
				ope.getFils().add(val2);
				racine_ope.getFils().add(ope);
				return racine_ope;
			}else if(instructions.get(i+3)=="operation"){
				//Cas d'operation sans sous operation meme principe qu'au dessus, sauf qu'on suit les operations qui suivent
				LinkedList<Noeud> fils = new LinkedList<Noeud>();
				Noeud val1 = new Noeud(instructions.get(i));
				Noeud val2 = new Noeud(instructions.get(i+1));
				Noeud ope = new Noeud(instructions.get(i+2));
				ope.getFils().add(val1);
				ope.getFils().add(val2);
				instructions.remove(i);
				instructions.remove(i+1);
				instructions.remove(i+2);
				instructions.remove(i+3);
				racine_ope.getFils().add(ope);
				ajouterOperation(instructions, racine_ope);
				return racine_ope;
			}else if(instructions.get(i+2)=="operation"){
				//cas ou operation avec sous operations, on calcule alors le sous arbre contenant la/les sous operations
				Noeud val1 = new Noeud(instructions.get(i));
				Noeud ope = new Noeud(instructions.get(i+1));
				instructions.remove(i);
				instructions.remove(i+1);
				instructions.remove(i+2);
				Noeud val2 = ajouterOperation(instructions, ope);
				ope.getFils().add(val1);
				ope.getFils().add(val2);
				racine_ope.getFils().add(ope);
				return racine_ope;
			}else{
				return null;
			}
	}
	
	public void ajouterInstruction(ArrayList<String> instruction) {
		listInstructions.put(nb_instructions, instruction);
		nb_instructions = nb_instructions + 1;
	}
	
	public void ajouterInstructionDebut(ArrayList<String> instruction) {
		listInstructions.put(0, instruction);
	}
	
	public void ajouterInstructionAvant(ArrayList<String> instruction, int nombre) {
		ArrayList<String> tempo = new ArrayList<String>();
		tempo = listInstructions.get(nb_instructions-nombre);
		ArrayList<String> complete = new ArrayList<String>();
		complete.addAll(instruction);
		complete.addAll(tempo);
		listInstructions.put(nb_instructions-nombre, complete);
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
