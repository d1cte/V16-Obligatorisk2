import java.util.GregorianCalendar;

public class Gjest extends Kort {

	public Gjest(String navn) {
		super(navn, 9999);
	}

	@Override
	public boolean sjekkPIN(int pin) {
		// Usikker på om denne metoden skal returnere true HVIS pin skal sjekkes, 
		// eller true om pin er sjekket og iorden. går utfra det siste.
		GregorianCalendar currentTime = new GregorianCalendar();
		
		// Sjekker om utløpstiden på en uke er gått ut. 1 uke = 604800000 millisekunder. 
		if((currentTime.getTimeInMillis() - this.getDatoOpprettet().getTimeInMillis()) < 604800000 && this.isRiktigPIN(pin))
			return true;
		return false;
	}

}
