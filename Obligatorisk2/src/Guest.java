import java.util.*;

public class Guest extends Card {

	public Guest(String fullName, int pinCode) {
		super(fullName, pinCode);
	}

	public void isExpired() {
		// Checks if card is expired and blocks the card if needed
		Calendar currentTime = new GregorianCalendar();
		// 1 week = 604800000 millisec.
		if (currentTime.getTimeInMillis() - getDateCreated().getTimeInMillis() > 604800000)
			setBlockedCard(true);
	}

	@Override
	public boolean checkPIN(int pinCode) {
		/* Usikker på om denne metoden skal returnere true HVIS pin skal sjekkes, 
		eller true om pin er sjekket og iorden. 
		Jeg går utfra det siste. */ 
		isExpired();

		if (isCorrectPIN(pinCode) && !isBlocked())
			return true;

		return false;
	}

}
