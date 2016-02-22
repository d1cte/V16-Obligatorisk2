import java.util.ArrayList;
import java.util.*;

public abstract class Card implements Comparable<Card>{
	private String fullName;
	private String firstName;
	private String surname;
	private int pinCode;
	private int cardNumber;
	private boolean blockedCard;
	private static ArrayList<Integer> allCardNumbers = new ArrayList<>();
	private Calendar dateCreated;
	
	Card(String fullName, int pinCode) {
		setFullName(fullName);
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
	
	public void setBlockedCard(boolean blockedCard) {
		this.blockedCard = blockedCard;
	}
	
	public void setFullName(String fullName) {
		String[] allNames = fullName.split(" ");
		
		// In case given name (firstName) is made up of several names, like "Tor Even"
		String firstName = "";
		for(int i = 0; i < allNames.length - 1; i++)
			firstName += allNames[i] + " ";
		
		setFirstName(firstName.trim());
		setSurname(allNames[allNames.length - 1]);
		this.fullName = this.firstName + " " + surname;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public boolean isBlocked() {
		return blockedCard;
	}
	
	public boolean isCorrectPIN(int pinCode) {
		return((pinCode == this.pinCode) ? true : false);
	}
	
	public Calendar getDateCreated() {
		return dateCreated;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getSurname() {
		return surname;
	}

	public String getFullName() {
		return fullName;
	}
	
	public int getCardNumber() {
		return cardNumber;
	}
	
	public int getPinCode() {
		return pinCode;
	}
	
	@Override
	public String toString() {
		String header = String.format("%-20s %-20s %-20s %-20s\n", "Navn", "Kortnummer", "PIN-kode", "Status");
		String information = String.format("%-20s %-20d %-20d %-20s", fullName, cardNumber, pinCode, ((blockedCard) ? "Sperret": "Aktiv"));
		return header + information;
	}
	
	public abstract boolean checkPIN(int pin);
	
	@Override
	public int compareTo(Card c) {
		if(getSurname().compareTo(c.getSurname()) != 0)
			return getSurname().compareTo(c.getSurname());
		else
			return getFirstName().compareTo(c.getFirstName());
	}
}
