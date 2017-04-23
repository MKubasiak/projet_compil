package fr.ul.miage.exemple;

import java.util.LinkedList;

public class Noeud{
	
	private LinkedList<Noeud> fils;
	private String valeur;
	
	public Noeud(LinkedList<Noeud> sons, String operation){
		this.valeur = operation;
		this.fils = sons;
	}
	
	public Noeud(String operation){
		this.valeur = operation;
		this.fils = new LinkedList<Noeud>();
	}

	public LinkedList<Noeud> getFils(){
		return this.fils;
	}
	
	public String getValeur(){
		return this.valeur;
	}
	
	
	
}