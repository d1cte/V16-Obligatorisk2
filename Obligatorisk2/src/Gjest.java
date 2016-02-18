
public class Gjest extends Kort {

	public Gjest(String navn) {
		super(navn, 9999);
	}

	@Override
	public boolean sjekkPIN(int pin) {
		return false;
	}

}
