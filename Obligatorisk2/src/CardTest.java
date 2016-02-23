import java.util.*;

public class CardTest {

	public static void main(String[] args) {
		ArrayList<Card> cardArray = new ArrayList<>();
		
		Card k1 = new Employee("Ola Olsen", 1234);
		Card k2 = new Guest("Ole Olsen", 9999);
		Card k3 = new Guest("Arvid Hågensen", 1234);
		Card k4 = new Employee("Håkon Andersen", 9999);
		Card k5 = new Guest("Sofie Andersen", 9999);

		cardArray.add(k1);
		cardArray.add(k2);
		cardArray.add(k3);		
		cardArray.add(k4);	
		cardArray.add(k5);
		
		k3.setBlockedCard(true);
		
		for (Card card : cardArray) {
			System.out.println(card);
			System.out.println("Kode 1234 er " + (card.checkPIN(1234) ? "gyldig": "ugyldig"));
			System.out.println("Kode 9999 er " + (card.checkPIN(9999) ? "gyldig": "ugyldig"));
			
			System.out.println("-----------------------------------------------------------------------------------------------------------------------");
			
		}
		
		System.out.println("\nOBS! I arbeidstiden vil pin for ansatt alltid være gyldig da pin ikke kreves i arbeidstiden.\n\n\n");

		// Sorting
		Collections.sort(cardArray);
		System.out.println("\n-------------- Sortert ---------------");
		System.out.printf("%-20s %-20s\n", "Etternavn", "Fornavn");
		for(Card card :cardArray) 
			System.out.printf("%-20s %-20s\n", card.getSurname(), card.getFirstName());
		
		// Code to check clone
		Card clone = (Card)k1.clone();
		System.out.println("\n-------------- Clone (original først, deretter clone) --------------");
	
		System.out.println(k1);
		System.out.println(clone);
		System.out.println("\nk1.getDateCreated() == clone.getDateCreated() is: \t" + (k1.getDateCreated() == clone.getDateCreated()));
		System.out.println("k1.getDateCreated().equals(clone.getDateCreated()) is: \t" + k1.getDateCreated().equals(clone.getDateCreated()));

	}

}
