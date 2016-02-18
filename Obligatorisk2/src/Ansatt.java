import java.util.GregorianCalendar;

public class Ansatt extends Kort {

	public Ansatt(String navn, int pinkode) {
		super(navn, pinkode);
	}

	@Override
	public boolean sjekkPIN(int pin) {
		// Usikker på om denne metoden skal returnere true HVIS pin skal sjekkes, 
		// eller true om pin er sjekket og iorden. går utfra det siste.
		if(this.isSperret())
			return false;
		
		GregorianCalendar currentTime = new GregorianCalendar();
		int dayOfWeek = currentTime.get(currentTime.DAY_OF_WEEK);
		int hourOfDay = currentTime.get(currentTime.HOUR_OF_DAY);
		if((dayOfWeek > 1 && dayOfWeek < 7) && (hourOfDay > 6 && hourOfDay < 18))
			return true;
	
		if(this.isRiktigPIN(pin))
			return true;
		
		return false;
	}

}

