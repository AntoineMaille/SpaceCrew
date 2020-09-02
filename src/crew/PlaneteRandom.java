package crew;

import java.util.Random;

public class PlaneteRandom extends Planets{
	private Vaisseau currentVessel;
	private int recharge;
	private static final int tempsRecharge = 3;
	private static Random ran = new Random();
	
	public PlaneteRandom(int x, int y) {
		super((ran.nextInt(1000 - 300) + 1) + 300, "toto", x, y);
		this.currentVessel = null;
		this.recharge = 5;
	}

	public Vaisseau getCurrentVessel() {
		return currentVessel;
	}

	public void setCurrentVessel(Vaisseau currentVessel) {
		this.currentVessel = currentVessel;
	}

	public int getRecharge() {
		return recharge;
	}

	public void setRecharge(int recharge) {
		this.recharge = recharge;
	}

	public static int getTempsrecharge() {
		return tempsRecharge;
	}
	
	
}
