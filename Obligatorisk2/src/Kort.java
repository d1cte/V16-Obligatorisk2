import java.util.ArrayList;

public abstract class Kort {
	private String fornavn;
	private String etternavn;
	private int pinkode;
	private int kortnummer;
	private boolean sperretKort;
	private static ArrayList<Integer> alleKortnummer = new ArrayList<>();
	
	Kort(String fornavn, String etternavn, int pinkode) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.pinkode = pinkode;
		sperretKort = false;
		setKortnummer();
	}
	
	private void setKortnummer() {
		// Genererer kortnummer med 8 siffer
		int kortnummer = (int)(Math.random() * (100000000 - 10000000) + 10000000);
		
		// Sjekker at kortnummeret ikke allerede eksisterer. 
		while(alleKortnummer.contains(kortnummer)) {
			kortnummer = (int)(Math.random() * (100000000 - 10000000) + 10000000);
		}
		alleKortnummer.add(kortnummer);
		this.kortnummer = kortnummer;
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
