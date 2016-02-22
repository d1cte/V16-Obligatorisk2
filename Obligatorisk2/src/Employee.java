import java.util.Calendar;
import java.util.GregorianCalendar;

public class Employee extends Card implements Constants {
	private double hourlyWage;
	private double seniority;
	
	Employee(String fullName, int pinCode) {
		super(fullName, pinCode);
		setSeniority(1);
		setHourlyWage(200);
	}

	public void setHourlyWage(double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

	public void setSeniority(double seniority) {
		this.seniority = seniority;
	}
	
	@Override
	public boolean checkPIN(int pinCode) {
		/* Usikker på om denne metoden skal returnere true HVIS pin skal sjekkes, 
		eller true om pin er sjekket og iorden. 
		Jeg går utfra det siste. */ 
		if(this.isBlocked())
			return false;
		
		if(this.officeHours()) {
			// Ifølge min tolkning av oppgaveteksten så skal den returnere true i hele kontortiden uavhengig av pin
			return true;
		}
		
		if(this.isCorrectPIN(pinCode))
			return true;
		
		return false;
	}
	
	public boolean officeHours() {
		GregorianCalendar currentTime = new GregorianCalendar();
		int dayOfWeek = currentTime.get(Calendar.DAY_OF_WEEK);
		int hourOfDay = currentTime.get(Calendar.HOUR_OF_DAY);
		if((dayOfWeek > 1 && dayOfWeek < 7) && (hourOfDay > 6 && hourOfDay < 17))
			return true;
		
		return false;
	}

	@Override
	public double calculateCredit() {
		return CREDIT * hourlyWage;
	}

	@Override
	public double calculateBonus() {
		return BONUS * seniority;
	}

	public double getHourlyWage() {
		return hourlyWage;
	}
	
	public double getSeniority() {
		return seniority;
	}

	@Override
	public String toString() {
		String header = String.format("%-20s %-20s %-20s %-20s %-20s %-20s\n", "Navn", "Kortnummer", "PIN-kode", "Status", "Timelønn", "Ansenitet");
		String information = String.format("%-20s %-20d %-20d %-20s %-20.2f %-20.2f", getFullName(), getCardNumber(), getPinCode(), ((isBlocked()) ? "Sperret": "Aktiv"), hourlyWage, seniority);
		return header + information;
	}



}

