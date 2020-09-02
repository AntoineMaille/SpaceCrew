package crew;

public class PlaneteJoueur extends Planets{
	private int joueur;
	private static int seuil = 10000;
	public PlaneteInitEnum positionInit;
	
	
	public PlaneteJoueur(PlaneteInitEnum pos, int joueur) {
		super(0, "test",pos.getX(), pos.getY());
		this.positionInit=pos;
		this.joueur = joueur;
	}

	public PlaneteInitEnum getPositionInit() {
		return positionInit;
	}


	public void setPositionInit(PlaneteInitEnum positionInit) {
		this.positionInit = positionInit;
	}


	public  static int getSeuil() {
		return seuil;
	}


	public int getJoueur() {
		return joueur;
	}

	public void setJoueur(int joueur) {
		this.joueur = joueur;
	}

	public static void setSeuil(int seuil) {
		PlaneteJoueur.seuil = seuil;
	}

	@Override
	public String toString() {
		return "○";
	}
	
	
		public boolean Pleine() {
		if (this.getRessources()==this.seuil) {
			return true;
		}
		return false;
	}
}