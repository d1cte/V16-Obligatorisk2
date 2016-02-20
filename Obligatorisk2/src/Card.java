import java.util.ArrayList;
import java.util.*;

public abstract class Card {
	private String fullName;
	private String firstName;
	private String surname;
	private int pinCode;
	private int cardNumber;
	private boolean blockedCard;
	private static ArrayList<Integer> allCardNumbers = new ArrayList<>();
	private Calendar dateCreated;
	
	Card(String fullName, int pinCode) {
		setName(fullName);
		this.pinCode = pinCode;
		blockedCard = false;
		dateCreated = new GregorianCalendar();
		setCardNumber();
	}
	
	private void setCardNumber() {
		int cardNumber = (int)(Math.random() * (100000000 - 10000000) + 10000000);
		
		while(allCardNumbers.contains(cardNumber)) {
			cardNumber = (int)(Math.random() * (100000000 - 10000000) + 10000000);
		}
		allCardNumbers.add(cardNumber);
		this.cardNumber = cardNumber;
	}
	
	public String getName() {
		return fullName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getSurname() {
		return surname;
	}
	
	boolean isBlocked() {
		return blockedCard;
	}
	
	boolean isCorrectPIN(int pinCode) {
		return((pinCode == this.pinCode) ? true : false);
	}
	
	Calendar getDateCreated() {
		return dateCreated;
	}
	
	@Override
	public String toString() {
		String header = String.format("%-20s %-20s %-20s %-20s\n", "Navn", "Kortnummer", "PIN-kode", "Status");
		String information = String.format("%-20s %-20d %-20d %-20s", fullName, cardNumber, pinCode, ((blockedCard) ? "Sperret": "Aktiv"));
		return header + information;
	}
	
	public abstract boolean checkPIN(int pin);
	
	void setBlockedCard(boolean blockedCard) {
		this.blockedCard = blockedCard;
	}
	
	public void setName(String fullName) {
		String[] allNames = fullName.split(" ");
		surname = allNames[allNames.length - 1];
		
		// In case given name (firstName) is made up of several names, like "Tor Even"
		String firstName = "";
		for(int j = 0; j < allNames.length - 1; j++)
			firstName += allNames[j] + " ";
		
		this.firstName = firstName;
	}

}
