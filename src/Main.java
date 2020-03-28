import java.util.ArrayList;
import java.util.HashMap; // import the HashMap class
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.text.html.HTMLDocument.Iterator;

import java.util.Collections;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir le chemin vers votre fichier texte à compresser :");
		String str1 = sc.nextLine();
		System.out.println("Veuillez saisir l'emplacement de votre fichier texte qui affichera la liste des fréquences :");
		String str2 = sc.nextLine();
		System.out.println("Veuillez saisir l'emplacement de votre fichier texte qui affichera la liste des fréquences :");
		String str3 = sc.nextLine();
		Texte alice = new Texte(str1);
	    alice.codageHuffman(str1,str2,str3);
	   
	   
	  
	  
	   
	}
}
	
	
