import java.util.ArrayList;
import java.util.HashMap; // import the HashMap class
import java.util.Map;
import java.util.TreeMap;

import javax.swing.text.html.HTMLDocument.Iterator;

import java.util.Collections;
public class Main {
	public static void main(String[] args) {
	    // Create a HashMap object called capitalCities
		
		String l = "azertyuiop";
		char s = 'c';
		
	    HashMap<String, Integer> capitalCities = new HashMap<String, Integer>();
	    ArrayList<Integer> freq = new ArrayList<Integer>(); 
	    //System.out.println(capitalCities);
	    Texte alice = new Texte("alice.txt");
	    //System.out.println(alice);
	    //System.out.println( alice.txt);
	   
	    System.out.println(alice.getSetcaract());
	   alice.alphaFreq();
	    System.out.println(alice.getSetTuple());
	    System.out.println(alice.setTuple);
	    alice.tri();
	    System.out.println(alice.setTuple);
	    alice.affichage();
	    
	   
	  
	  
	   
	}

	} 
	
	

