import java.util.GregorianCalendar;

public class Employee extends Card {

	public Employee(String name, int pinCode) {
		super(name, pinCode);
	}

	@Override
	public boolean checkPIN(int pin) {
		/* Usikker på om denne metoden skal returnere true HVIS pin skal sjekkes, 
		eller true om pin er sjekket og iorden. 
		Jeg går utfra det siste. */ 
		if(this.isBlocked())
			return false;
		
		if(this.officeHours()) {
			// Ifølge min tolkning av oppgaveteksten så skal den returnere true i hele kontortiden uavhengig av pin
			return true;
		}
		
		if(this.isCorrectPIN(pin))
			return true;
		
		return false;
	}
	
	public boolean officeHours() {
		GregorianCalendar currentTime = new GregorianCalendar();
		int dayOfWeek = currentTime.get(currentTime.DAY_OF_WEEK);
		int hourOfDay = currentTime.get(currentTime.HOUR_OF_DAY);
		if((dayOfWeek > 1 && dayOfWeek < 7) && (hourOfDay > 6 && hourOfDay < 18))
			return true;
		
		return false;
	}

}

