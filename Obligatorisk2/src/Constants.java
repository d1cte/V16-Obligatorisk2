
public interface Constants {
	public static final double CREDIT = 1000;
	public static final double BONUS = 1000;
	
	public abstract void setFirstName(String firstName);
	public abstract void setSurname(String surname);
	public abstract void setFullName(String fullName);
	
	public abstract String getFirstName();
	public abstract String getSurname();
	public abstract String getFullName();
	
	public abstract double calculateCredit();
	public abstract double calculateBonus();
	
}
