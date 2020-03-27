import java.util.ArrayList;
import java.util.HashMap; // import the HashMap class
import java.util.Map;
import java.util.TreeMap;

import javax.swing.text.html.HTMLDocument.Iterator;

import java.util.Collections;

public class Main {
	public static void main(String[] args) {
	    
	    
	    Texte alice = new Texte("textesimple3.txt");
	   
	    alice.alphaFreq();
	    
	    alice.writeFreq();
	    System.out.println(alice.setTuple);
	    System.out.println(alice.getSetTuple().size());
	   
	    alice.tri();
	    
	    alice.affichageTuple();
	    alice.creation_noeud();
	    System.out.println("prout");
	    System.out.println("l"+alice.getListeNoeuds());
	    Noeud n1 = alice.creation_arbre();
	    alice.parcourArbre(n1,"");
	    System.out.println(n1);
	    
	    for (char i : alice.getDict().keySet()) {
	    	  System.out.println( i + "-->" + alice.getDict().get(i));
	    	}
	    System.out.println(alice.writecodeBin());
	    
	    	
	    }
	   
	   
	   
	  
	  
	   
	}
	
	
