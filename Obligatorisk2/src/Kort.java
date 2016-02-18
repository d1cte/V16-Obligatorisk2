import java.util.ArrayList;
import java.util.GregorianCalendar;

public abstract class Kort {
	private String navn;
	private int pinkode;
	private int kortnummer;
	private boolean sperretKort;
	private static ArrayList<Integer> alleKortnummer = new ArrayList<>();
	private GregorianCalendar datoOpprettet;
	
	Kort(String navn, int pinkode) {
		this.navn = navn;
		this.pinkode = pinkode;
		sperretKort = false;
		datoOpprettet = new GregorianCalendar();
		setKortnummer();
	}
	
	private void setKortnummer() {
		// Kortnummer med 8 siffer
		int kortnummer = (int)(Math.random() * (100000000 - 10000000) + 10000000);
		
		while(alleKortnummer.contains(kortnummer)) {
			kortnummer = (int)(Math.random() * (100000000 - 10000000) + 10000000);
		}
		alleKortnummer.add(kortnummer);
		this.kortnummer = kortnummer;
	}
	
	String getNavn() {
		return navn;
	}
	
	boolean isSperret() {
		return sperretKort;
	}
	
	boolean isRiktigPIN(int pinkode) {
		return((pinkode == this.pinkode) ? true : false);
	}
	
	GregorianCalendar getDatoOpprettet() {
		return datoOpprettet;
	}
	
	@Override
	public String toString() {
		String header = String.format("%-20s %-20s %-20s %-20s\n", "Navn", "Kortnummer", "PIN-kode", "Status");
		String information = String.format("%-20s %-20d %-20d %-20s", navn, kortnummer, pinkode, ((sperretKort) ? "Sperret": "Aktiv"));
		return header + information;
	}
	
	public abstract boolean sjekkPIN(int pin);
	
	void setSperretKort(boolean sperret) {
		sperretKort = sperret;
	}

}
