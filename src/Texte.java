import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class Texte {
	String txt;
	ArrayList<Tuple> setTuple = new ArrayList<Tuple>();
	Set<Character> setcaract = new TreeSet<Character>();
	private ArrayList<Noeud> listeNoeuds = new ArrayList<Noeud>();
	HashMap<Character, String> dict = new HashMap<Character, String>();
	
	public void codageHuffman(String doctxt, String docbin,String docfreq) {
		this.alphaFreq();
		this.tri();
		this.creation_noeud();
		Noeud n1 = this.creation_arbre();
		this.parcourArbre(n1,"");
		this.writeFreqCode(docfreq);
		this.codeBintexte(docbin);
		System.out.println("Compression terminée !");
		System.out.println("taux de compression " + this.compression(doctxt, docbin) +" nombre de bits moyen "+ this.nbBitMoy());
		 
	}
	

	public ArrayList<Noeud> getListeNoeuds() {
		return listeNoeuds;
	}
	

	public HashMap<Character, String> getDict() {
		return dict;
	}


	public void setDict(HashMap<Character, String> dict) {
		this.dict = dict;
	}


	public void setListeNoeuds(ArrayList<Noeud> listeNoeuds) {
		this.listeNoeuds = listeNoeuds;
	}

	public Texte(String fichier) {
		this.txt=this.open(fichier);
	}
	
	public Set<Character> getSetcaract() {
		return setcaract;
	}

	public String getTxt() {
		return txt;
	}

	public ArrayList<Tuple> getSetTuple() {
		return setTuple;
	}

	public String open(String adresse) {
		String texte = " ";
		  try{
			   InputStream ips=new FileInputStream(adresse); 
			   InputStreamReader ipsr=new InputStreamReader(ips);
			   BufferedReader br=new BufferedReader(ipsr);
			   String ligne;
			   
			   while ((ligne=br.readLine())!=null){
				   texte += ligne;
			   }
			   br.close(); 
			   
			  }  
			  catch (Exception e){
			   System.out.println(e.toString());
			  }
		  return texte;
		  
	}
	
	public Tuple getTupleBycaract(char caract) {
		for(Tuple i: this.setTuple ) {
			if(caract == i.getCaract()) {
				return i;
			}
			
		}
		return null;}
		
	public void alphaFreq() {
		for (int i = 0; i< this.txt.length();i++) {
			//System.out.println(i);
			if(setcaract.contains(this.txt.charAt(i)) == false) {
				
				setcaract.add(this.txt.charAt(i));
				
				Tuple a = new Tuple(this.txt.charAt(i),1);
				this.setTuple.add(a);
				
			}
			else
			{
				int s = (this.getTupleBycaract(this.txt.charAt(i)).getFreq() + 1);
				this.getTupleBycaract(this.txt.charAt(i)).setFreq(s);
			}
		}
	}
	public void tri() 
	{
		for(int i = 1;i< this.setTuple.size();i++) 
		{
			
			int freq_en_cours = this.setTuple.get(i).freq;
			char caract_en = this.setTuple.get(i).caract;
			int j = i;
			while(j>0 && this.setTuple.get(j-1).freq > freq_en_cours ) 
			{
				this.setTuple.get(j).setFreq(this.setTuple.get(j-1).freq);
				this.setTuple.get(j).setCaract(this.setTuple.get(j-1).caract);
				j = j-1;
			}
			this.setTuple.get(j).setFreq(freq_en_cours);
			this.setTuple.get(j).setCaract(caract_en);
		}
	}
	public void affichageTuple() 
	{
		for(int i = 0; i< this.setTuple.size();i++) 
		{
			System.out.println(this.setTuple.get(i).freq +" "+ this.setTuple.get(i).caract );
		}
	}
	//je créer la liste des noeuds (feuilles) trié par ordre croissant de mon futur arbre 
	public ArrayList<Noeud> creation_noeud() {
		for(int i = 0; i< this.setTuple.size();i++) {
			int a =this.setTuple.get(i).freq;
			char b =this.setTuple.get(i).caract;
			this.listeNoeuds.add(new Noeud(a,b,null,null,""));	
		}
		return this.listeNoeuds;
		
		
	}
	public Noeud creation_arbre() {
		ArrayList<Noeud> noeuds2 = (ArrayList<Noeud>) listeNoeuds.clone();
		while(noeuds2.size()>1) {
			//System.out.println(noeuds2.get(0) + " "+ noeuds2.get(1));
			Noeud n1 = noeuds2.get(0);
			noeuds2.remove(0);
			Noeud n2 = noeuds2.get(0);
			noeuds2.remove(0);
			
			noeuds2.add(new Noeud(n1.getFreq() +n2.getFreq(),'¤',n1,n2,""));
			noeuds2=this.triNoeuds(noeuds2);
			
		}
		return noeuds2.get(0);
	}
	public ArrayList<Noeud> triNoeuds(ArrayList<Noeud> list) 
	{
		for(int i = 1;i< list.size();i++) 
		{
			
			int freq_en_cours = list.get(i).getFreq();
			char caract_en = list.get(i).getCaract();
			Noeud fd_courant= list.get(i).getFd();
			Noeud fg_courant =list.get(i).getFg() ;
			String codebin = list.get(i).getCodebin();
			
			int j = i;
			while(j>0 && list.get(j-1).getFreq() > freq_en_cours ) 
			{
				list.get(j).setFreq(list.get(j-1).getFreq());
				list.get(j).setCaract(list.get(j-1).getCaract());
				list.get(j).setFd(list.get(j-1).getFd());
				list.get(j).setFg(list.get(j-1).getFg());
				list.get(j).setCodebin(list.get(j-1).getCodebin());
				j = j-1;
			}
			list.get(j).setFreq(freq_en_cours);
			list.get(j).setFd(fd_courant);
			list.get(j).setCaract(caract_en);
			list.get(j).setFg(fg_courant);
			list.get(j).setCodebin(codebin);
		}
		return list;
	}
	//parcour recursif de l'arbre
	

	public void parcourArbre(Noeud racine,String codeBin) {
		
		if(racine.estFeuille()==true) {
			racine.setCodebin(codeBin);
			//System.out.println(racine.getCaract() + " " + racine.getCodebin());
			this.dict.put(racine.getCaract(), racine.getCodebin());
			
		}
		
		else {
			parcourArbre(racine.getFg(), codeBin + "0");
			parcourArbre(racine.getFd(), codeBin + "1");	
		}
	}
	
	public void writeFreqCode(String chemin) {
		try{
			File ff=new File(chemin); // définir l'arborescence
			ff.createNewFile();
			FileWriter ffw=new FileWriter(ff);
			 ffw.write("\n");
			 ffw.write("Fréquence");
			 ffw.write("\n");
			 for (Tuple i: this.getSetTuple()) {
				 ffw.write(i.toString());  // écrire une ligne dans le fichier resultat.txt
				 ffw.write("\n"); // forcer le passage à la ligne
		    	  
		    	}
			 ffw.write("\n");
			 ffw.write("dictionnaire");
			 ffw.write("\n");
			 for (char i : this.getDict().keySet()) {
				 ffw.write(i + "-->" + this.getDict().get(i));  // écrire une ligne dans le fichier resultat.txt
				 ffw.write("\n"); // forcer le passage à la ligne
		    	  
		    	}
			
			ffw.close(); // fermer le fichier à la fin des traitements
			} catch (Exception e) {}
			}
	     
	  
	
	public void codeBintexte(String chemin) {
		String texte ="";
		for (int i = 0; i< this.txt.length();i++) {
			texte = texte + this.getDict().get(this.txt.charAt(i));
			
		
	}
		while(texte.length()%8 != 0) {
			texte= texte +'0';
			
		}
		ArrayList<String> octet = new ArrayList<String>();
		for(int i = 8;i<=texte.length();i=i+8) {
			
			octet.add(texte.substring(i-8, i));
			
		}
		
		try {
			
			File fff=new File(chemin); // définir l'arborescence
			fff.createNewFile();
			FileWriter fffw=new FileWriter(fff);
			
			for(String i: octet) {
				int s = Integer.parseInt(i, 2);
				fffw.write((byte)s);
			}
			
			
			fffw.close();
			
			
		}
		
		catch (Exception e) {}
	}
	
	public float compression(String doctxt, String docbin) {
		File txt = new File(doctxt);
		File bin = new File(docbin);
		double txtbytes = txt.length();
		double txtbits = txtbytes *8;
		double binbytes = bin.length();
		double binbits = binbytes *8;
		double txtkb = txtbits/1024;
		double binkb = binbits/1024;
		return (float)(1-(binkb/txtkb));
		
	}
	public float nbBitMoy() {
		int tot = 0;
		int freq =0;
		for(Tuple tuple : this.getSetTuple()) {
			tot = tot + tuple.getFreq()* this.getDict().get(tuple.getCaract()).length();
			freq = freq + tuple.getFreq();
		}
		return tot/freq;
	}
		
			
			

	

	}