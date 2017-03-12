/**
 * 
 */
package fr.ul.miage.exemple;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

import fr.ul.miage.exemple.generated.ParserCup;
import fr.ul.miage.exemple.generated.Yylex;



/**
 * @author azim
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ParserCup parser = new ParserCup(new Yylex(new BufferedReader(new FileReader(new File(args[0])))));
			parser.parse();
			System.out.println("fin gros pd");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
