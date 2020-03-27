import java.util.LinkedList;

public class Noeud {
	private int freq;
	private char caract='¤';
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
		if(this.fd==null && this.fg==null) {
			return true;
		}
		else {
			return false;
		}
	}

}