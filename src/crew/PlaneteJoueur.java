package crew;

public class PlaneteJoueur extends Planets{
	
	private static int seuil = 1500;
	public int ressources;
	public PlaneteInitEnum positionInit;
	
	
	public PlaneteJoueur(PlaneteInitEnum pos) {
		this.ressources=0;
		this.positionInit=pos;
	}
		public boolean Pleine() {
		if (this.ressources==this.seuil) {
			return true;
		}
		return false;
	}
}