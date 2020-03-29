import java.util.LinkedList;
/** 
 *  <b>Noeud est la classe representant les Noeuds de l'arbre</b>
 * <p>
 * Un Noeud est caract�ris� par les informations suivantes :
 * <ul>
 * <li>int: freq qui est la fr�quence du caract�re</li>
 * <li>char : caract carat�re associer � la frequence</li>
 * <li>Noeud : fd fils droit du noeud</li>
 * <li>Noeud : fg fils gauche du noeud</li>
 * <li>String : codebin associ� au caract�re</li>
 * </p>
 */

public class Noeud {
	private int freq;
	private char caract='�';
	private Noeud fd= null;
	private Noeud fg=null ;
	private String codebin = "";
	

	public Noeud(int freq, char caract, Noeud fd, Noeud fg, String codebin) {
		super();
		this.freq = freq;
		this.caract = caract;
		this.fd = fd;
		this.fg = fg;
		this.codebin = codebin;
	}


	@Override
	public String toString() {
		return "[freq=" + freq + ", caract=" + caract +  ", codebin=" + codebin
				+ "]";
	}


	public int getFreq() {
		return freq;
	}


	public void setFreq(int freq) {
		this.freq = freq;
	}


	public char getCaract() {
		return caract;
	}


	public void setCaract(char caract) {
		this.caract = caract;
	}


	public Noeud getFd() {
		return fd;
	}
	

	public void setFd(Noeud fd) {
		this.fd = fd;
	}


	public Noeud getFg() {
		return fg;
	}


	public void setFg(Noeud fg) {
		this.fg = fg;
	}


	public String getCodebin() {
		return codebin;
	}


	public void setCodebin(String codebin) {
		this.codebin = codebin;
	}


	public boolean estFeuille() {
			return  ((this.fg == null) && (this.fd == null));
		}


}