import java.util.GregorianCalendar;

public class Guest extends Card {

	public Guest(String fullName, int pinCode) {
		super(fullName, pinCode);
	}

	@Override
	public boolean checkPIN(int pinCode) {
		// Usikker på om denne metoden skal returnere true HVIS pin skal sjekkes, 
		// eller true om pin er sjekket og iorden. går utfra det siste.
		this.isExpired();
		
		if(this.isCorrectPIN(pinCode) && !this.isBlocked())
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
