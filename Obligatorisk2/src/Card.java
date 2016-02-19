import java.util.ArrayList;
import java.util.*;

public abstract class Card {
	private String name;
	private int pinCode;
	private int cardNumber;
	private boolean blockedCard;
	private static ArrayList<Integer> allCardNumbers = new ArrayList<>();
	private Calendar dateCreated;
	
	Card(String name, int pinCode) {
		this.name = name;
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
	
	String getName() {
		return name;
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
		String information = String.format("%-20s %-20d %-20d %-20s", name, cardNumber, pinCode, ((blockedCard) ? "Sperret": "Aktiv"));
		return header + information;
	}
	
	public abstract boolean checkPIN(int pin);
	
	void setBlockedCard(boolean blockedCard) {
		this.blockedCard = blockedCard;
	}

}
