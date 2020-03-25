import java.awt.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Texte {
	String txt;
	ArrayList<Tuple> setTuple = new ArrayList<Tuple>();
	Set<Character> setcaract = new TreeSet<Character>();
	

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
				System.out.println(a.freq);
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
	public void affichage() 
	{
		for(int i = 0; i< this.setTuple.size();i++) 
		{
			System.out.println(this.setTuple.get(i).freq +" "+ this.setTuple.get(i).caract );
		}
	}

	}
	
	
	
	
	
	
	
