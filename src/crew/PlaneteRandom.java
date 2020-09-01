package crew;

import java.util.Random;

public class PlaneteRandom extends Planets{
	private Vaisseau currentVessel;
	private int recharge;
	private static Random ran = new Random();
	
	public PlaneteRandom() {
		super((ran.nextInt() * 1000 - 300) + 300, "toto");
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
	
	
}
