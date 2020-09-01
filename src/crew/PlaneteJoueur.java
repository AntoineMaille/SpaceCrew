package crew;

public class PlaneteJoueur extends Planets{
	private int seuil = 1500;
	public PlaneteInitEnum positionInit;
	
	
	public PlaneteJoueur(PlaneteInitEnum pos) {
		super(0, "test",pos.getX(), pos.getY());
		this.positionInit=pos;
	}

	public PlaneteInitEnum getPositionInit() {
		return positionInit;
	}


	public void setPositionInit(PlaneteInitEnum positionInit) {
		this.positionInit = positionInit;
	}


	public  int getSeuil() {
		return seuil;
	}




	@Override
	public String toString() {
		return "O";
	}
	
	
		public boolean Pleine() {
		if (this.getRessources()==this.seuil) {
			return true;
		}
		return false;
	}
}