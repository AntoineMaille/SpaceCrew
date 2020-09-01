package crew;

public class PlaneteJoueur extends Planets{
	private int seuil = 1500;
	public PlaneteInitEnum positionInit;
	
	
	public PlaneteJoueur(PlaneteInitEnum pos) {
		super(0, "test");
		this.positionInit=pos;
		this.setPosition(new Coordinates(pos.getX(), pos.getY()));
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