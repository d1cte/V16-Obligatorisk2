
public abstract class Kort {
	private String fornavn;
	private String etternavn;
	private int pinkode;
	private int kortnummer;
	private boolean sperretKort;
	
	Kort(String fornavn, String etternavn, int pinkode) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.pinkode = pinkode;
		sperretKort = false;
	}

}
