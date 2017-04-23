package fr.ul.miage.exemple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Table_symboles {

	private HashMap<Integer,ArrayList<String>> listSymboles;
	private ArrayList<String> contexte;
	private int nbSymboles;
	
	public Table_symboles() {
		this.listSymboles = new HashMap<Integer,ArrayList<String>>();
		this.contexte = new ArrayList<String>();
		this.contexte.add("main");
		this.nbSymboles = 1;
	}
	
	// Dans le cas d'une nouvelle fonction
	public void setContexte(String nomFonction, String categorie, String type, int nbbloc, int nbp) {
		if(!this.contexte.get(this.contexte.size()-1).equals(nomFonction)) {
			this.contexte.add(nomFonction);
		}
		ArrayList<String> param = new ArrayList<String>();
		String contexte = "Contexte : " + this.contexte.get(this.contexte.size()-1);
		String nomF = "NomFonction : " + nomFonction;
		String cat = "Catégorie : " + categorie;
		String t = "Type : " + type;
		String nbloc = "Nombre bloc : " + nbbloc;
		String nbparam ="Nombre de parametre : " + nbp;
		param.add(contexte);
		param.add(nomF);
		param.add(cat);
		param.add(t);
		param.add(nbloc);
		param.add(nbparam);
		this.listSymboles.put(this.nbSymboles, param);
		this.nbSymboles = this.nbSymboles + 1;
	}
	
	// Dans le cas d'une definition
	public void rangerTDS(String typeVariable, String nomVariable) {
		ArrayList<String> param = new ArrayList<String>();
		String contexte = "Contexte : " + this.contexte.get(this.contexte.size()-1);
		String nomV = "Nom de variable : ";
		String nomVar = nomVariable;
		String cat = "Categorie : " + null;
		if(typeVariable.equals("int")) {
			cat = "Categorie :" + " variable";
		}
		String type = "Type : " + typeVariable;
		String val = "Valeur : " + null;
		param.add(contexte);
		param.add(nomV);
		param.add(nomVar);
		param.add(cat);
		param.add(type);
		param.add(val);
		this.listSymboles.put(this.nbSymboles, param);
		this.nbSymboles = this.nbSymboles + 1;
	}
	
	// Dans le cas d'une affectation
	public String rechercherTDS(String nomVariable, ArrayList<String> listVal) {
		for(Entry<Integer, ArrayList<String>> entry : listSymboles.entrySet()) {
		    Integer cle = entry.getKey();
		    ArrayList<String> valeur = entry.getValue();
		    System.out.println(valeur.get(2));
		    //valeur.get(1) == Nom variable, donc si il est bien dans la table (logique, si affectation)
		    if (valeur.get(2).equals(nomVariable)) {
		    	String contexte = valeur.get(0);
		    	String nomV = valeur.get(1);
		    	String nomVar = valeur.get(2);
		    	String cat = valeur.get(3);
		    	String type = valeur.get(4);
		    	String val = "Valeur : ";
		    	for(int i = 0; i<listVal.size();i++) {
		    		val = val + listVal.get(i);
		    	}
		    	ArrayList<String> param = new ArrayList<String>();
		    	param.add(contexte);
		    	param.add(nomV);
		    	param.add(nomVar);
		    	param.add(cat);
		    	param.add(type);
		    	param.add(val);
		    	this.listSymboles.put(cle, param);
		    	return "ok";
		    }
		}
		System.out.println("pas dans la table des symboles");
		return "pas ok";
	}
	
	public void afficherTDS() {
		for(Entry<Integer, ArrayList<String>> entry : listSymboles.entrySet()) {
		    Integer cle = entry.getKey();
		    ArrayList<String> valeur = entry.getValue();
		    System.out.println("---------------------------");
		    System.out.println("Symbole : " + cle);
		    for(int i = 0; i<valeur.size();i++) {
		    	 System.out.println(valeur.get(i));
		    }
		}
	}
	
}
