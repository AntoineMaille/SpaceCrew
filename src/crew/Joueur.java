package crew;

public class Joueur {
	private int numero;
	private String name;
	private Vaisseau Croiseur;
	private Vaisseau Destroyer;
	private Vaisseau Chasseur;
	private Vaisseau Eclaireur;
	private int ressources;
	private PlaneteJoueur Camp;
	
	public int getNumero() {
		return numero;
	}
	public String getName() {
		return name;
	}
	public Vaisseau getCroiseur() {
		return Croiseur;
	}
	public Vaisseau getDestroyer() {
		return Destroyer;
	}
	public Vaisseau getChasseur() {
		return Chasseur;
	}
	public Vaisseau getEclaireur() {
		return Eclaireur;
	}
	public int getRessources() {
		return ressources;
	}
	public PlaneteJoueur getCamp() {

		return Camp;
	}
	public Joueur(int numero, String name, Vaisseau croiseur, Vaisseau destroyer, Vaisseau chasseur, Vaisseau eclaireur,
			int ressources, PlaneteJoueur camp) {
		super();
		this.numero = numero;
		this.name = name;
		Croiseur = croiseur;
		Destroyer = destroyer;
		Chasseur = chasseur;
		Eclaireur = eclaireur;
		this.ressources = ressources;
		Camp = camp;
	}
	
	
}
