/** 
 *  <b>Tuple est la classe representant le couple caract�re et fr�quence associ�</b>
 * <p>
 * Un Tuple est caract�ris� par les informations suivantes :
 * <ul>
 * <li>char : caract qui est le caract�re</li>
 * <li>int: freq qui est la fr�quence du caract�re</li>
 * </p>


*/
public class Tuple {
	
	char caract;
	int freq;
	
	public Tuple(Character caract, int freq) {
		super();
		this.caract = caract;
		this.freq = freq;
	}
	
	
	public char getCaract() {
		return caract;
	}


	public void setCaract(char caract) {
		this.caract = caract;
	}


	public int getFreq() {
		return freq;
	}
	public void setFreq(int freq) {
		this.freq = freq;
	}


	@Override
	public String toString() {
		return "caract=" + caract + " freq=" + freq  ;
	}
	

}