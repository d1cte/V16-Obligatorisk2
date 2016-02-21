import java.util.*;

public class CardTest {

	public static void main(String[] args) {

		ArrayList<Card> cardArray = new ArrayList<>();
		Card k1 = new Employee("Ole Olsen", 1234);
		Card k2 = new Guest("Marit Olsen", 9999);
		Card k3 = new Guest("Marit Olsen", 4444);
		
		cardArray.add(k1);
		cardArray.add(k2);
		cardArray.add(k3);		
		k3.setBlockedCard(true);
		
		for (Card card : cardArray) {
			System.out.println(card);
			System.out.println("Kode 1234 er " + (card.checkPIN(1234) ? "gyldig": "ugyldig"));
			System.out.println("Kode 9999 er " + (card.checkPIN(9999) ? "gyldig": "ugyldig"));
			System.out.println("Kode 4444 er " + (card.checkPIN(4444) ? "gyldig": "ugyldig"));
			System.out.println("--------------------------");
		}

		
	
	}

}
