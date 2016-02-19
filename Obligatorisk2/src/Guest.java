import java.util.GregorianCalendar;

public class Guest extends Card {

	public Guest(String name, int pinCode) {
		super(name, pinCode);
	}

	@Override
	public boolean checkPIN(int pin) {
		// Usikker på om denne metoden skal returnere true HVIS pin skal sjekkes, 
		// eller true om pin er sjekket og iorden. går utfra det siste.
		this.isExpired();
		
		if(this.isCorrectPIN(pin) && !this.isBlocked())
			return true;

		return false;
	}
	
	void isExpired() {
		// Checks if card is expired and blocks the card if needed
		GregorianCalendar currentTime = new GregorianCalendar();
		// 1 week = 604800000 millisec.
		if(currentTime.getTimeInMillis() - this.getDateCreated().getTimeInMillis() > 604800000) 
			this.setBlockedCard(true);
	}

}
