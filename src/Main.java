
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir le chemin vers votre fichier texte � compresser :");
		String str1 = sc.nextLine();
		System.out.println("Veuillez saisir l'emplacement de votre fichier binaire compress�:");
		String str2 = sc.nextLine();
		System.out.println("Veuillez saisir l'emplacement de votre fichier texte qui affichera la liste des fr�quences :");
		String str3 = sc.nextLine();
		Texte alice = new Texte(str1);
	    alice.codageHuffman(str1,str2,str3);
	   
	   
	  
	  
	   
	}
}
	
	
