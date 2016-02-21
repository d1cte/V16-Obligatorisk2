import java.util.Calendar;
import java.util.GregorianCalendar;

public class Employee extends Card implements Constants {
	private double hourlyWage;
	private double seniority;
	
	Employee(String fullName, int pinCode, double hourlyWage, double seniority) {
		super(fullName, pinCode);
		setSeniority(seniority);
		setHourlyWage(hourlyWage);
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
		if((dayOfWeek > 1 && dayOfWeek < 7) && (hourOfDay > 6 && hourOfDay < 18))
			return true;
		
		return false;
	}

	@Override
	public double calculateCredit() {
		return credit * hourlyWage;
	}

	@Override
	public double calculateBonus() {
		return bonus * seniority;
	}

	public double getHourlyWage() {
		return hourlyWage;
	}
	
	public double getSeniority() {
		return seniority;
	}
}

