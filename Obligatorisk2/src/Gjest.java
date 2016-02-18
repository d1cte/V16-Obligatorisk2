import java.util.GregorianCalendar;

public class Gjest extends Kort {

	public Gjest(String navn, int pinkode) {
		super(navn, pinkode);
	}

	@Override
	public boolean sjekkPIN(int pin) {
		// Usikker på om denne metoden skal returnere true HVIS pin skal sjekkes, 
		// eller true om pin er sjekket og iorden. går utfra det siste.
		this.isUtgaatt();
		
		if(this.isRiktigPIN(pin) && !this.isSperret())
			return true;

		return false;
	}
	
	void isUtgaatt() {
		// Sjekker om kortet er utgått, og sperrer kortet om nødvendig
		GregorianCalendar currentTime = new GregorianCalendar();
		// 1 uke = 604800000 millisekunder.
		if(currentTime.getTimeInMillis() - this.getDatoOpprettet().getTimeInMillis() > 604800000) 
			this.setSperretKort(true);
	}

}
