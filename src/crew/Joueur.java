package crew;

public class Joueur {
	private int numero;
	private String name;
	private VaisseauType Croiseur;
	private VaisseauType Destroyer;
	private VaisseauType Chasseur;
	private VaisseauType Eclaireur;
	private int ressources;
	
	public int getNumero() {
		return numero;
	}
	public String getName() {
		return name;
	}
	public VaisseauType getCroiseur() {
		return Croiseur;
	}
	public VaisseauType getDestroyer() {
		return Destroyer;
	}
	public VaisseauType getChasseur() {
		return Chasseur;
	}
	public VaisseauType getEclaireur() {
		return Eclaireur;
	}
	public int getRessources() {
		return ressources;
	}
	public Joueur(int numero, String name, VaisseauType croiseur, VaisseauType destroyer, VaisseauType chasseur,
			VaisseauType eclaireur, int ressources) {
		super();
		this.numero = numero;
		this.name = name;
		Croiseur = croiseur;
		Destroyer = destroyer;
		Chasseur = chasseur;
		Eclaireur = eclaireur;
		this.ressources = ressources;
	}
}
