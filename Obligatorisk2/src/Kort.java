
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
	
	String getNavn() {
		return fornavn + " " + etternavn;
	}
	
	boolean isSperret() {
		return sperretKort;
	}
	
	@Override
	public String toString() {
		String header = String.format("%-20s %-20s %-20s %-20s %-20s\n", "Fornavn", "Etternavn", "Kortnummer", "PIN-kode", "Status");
		String information = String.format("%-20s %-20s %-20d %-20d %-20s\n", fornavn, etternavn, kortnummer, pinkode, ((sperretKort) ? "Sperret": "Aktiv"));
		return header + information;
	}
	
	public abstract boolean sjekkPIN(int pin);
	
	

}
