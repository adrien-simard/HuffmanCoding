import java.awt.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Texte {
	String txt;
	ArrayList<Tuple> setTuple = new ArrayList<Tuple>();
	Set<Character> setcaract = new TreeSet<Character>();
	private ArrayList<Noeud> listeNoeuds = new ArrayList<Noeud>();
	

	public ArrayList<Noeud> getListeNoeuds() {
		return listeNoeuds;
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
			Noeud n1 = noeuds2.get(0);
			Noeud n2 = noeuds2.get(1);
			noeuds2.add(new Noeud(n1.getFreq() +n2.getFreq(),'¤',n1,n2,""));
			noeuds2.remove(0);
			noeuds2.remove(1);
			this.triNoeuds(noeuds2);	
		}
		return noeuds2.get(0);
	}
	public void triNoeuds(ArrayList<Noeud> list) 
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
	}
	//parcour recursif de l'arbre
	
int i =0;
	public void parcourArbre(Noeud racine,String codeBin) {
		
		System.out.println(i);
		++i;
		
		if(racine.estFeuille()==true) {
			racine.setCodebin(codeBin);
			System.out.println(racine.getCaract() + " " + racine.getCodebin());
			
		}
		
		else {
			parcourArbre(racine.getFg(), codeBin + "0");
			parcourArbre(racine.getFd(), codeBin + "1");	
		}
	}
		
			
			

	

	}
	
	
	
	
	
	
	
