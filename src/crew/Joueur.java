package crew;

public class Joueur {
	private int numero;
	private String name;
	private VaisseauType v1;
	private DESTROYER v2;
	private CHASSEUR v3;
	private ECLAIREUR v4;
	private int ressources;
	
	public int getNumero() {
		return numero;
	}
	public String getName() {
		return name;
	}
	public CROISEUR getV1() {
		return v1;
	}
	public DESTROYER getV2() {
		return v2;
	}
	public CHASSEUR getV3() {
		return v3;
	}
	public ECLAIREUR getV4() {
		return v4;
	}
	public int getRessources() {
		return ressources;
	}

	public Joueur(int numero, String name, CROISEUR v1, DESTROYER v2, CHASSEUR v3, ECLAIREUR v4,) {
		super();
		this.numero = numero;
		this.name = name;
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
		this.v4 = v4;
	}
	
	
}
