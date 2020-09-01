package crew;
import java.util.ArrayList;
import java.util.Scanner;

public class Joueur {
	private int numero;
	private String name;
	private ArrayList<Vaisseau> flotte;
	private int ressources;
	private PlaneteJoueur planete;

	public Joueur(int n, String nom,PlaneteJoueur e) {
		this.numero = n;
		this.name = nom;
		this.ressources = 0;
		this.planete=e;
		this.flotte = createFlotte();
		System.out.println(this.flotte.get(3).getPosition());

	}



	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Vaisseau> getFlotte() {
		return flotte;
	}

	public void setFlotte(ArrayList<Vaisseau> flotte) {
		this.flotte = flotte;

	}

	public int getRessources() {
		return ressources;
	}

	public void setRessources(int ressources) {
		this.ressources = ressources;
	}

	public PlaneteJoueur getPlanete() {
		return planete;
	}

	public void setPlanete(PlaneteJoueur equipe) {
		this.planete = equipe;
	}


	public String toString() {
		return "Joueur [name=" + name + ", flotte=" + flotte + ", ressources=" + ressources + ", equipe=" + planete
				+ "]";
	}

	public ArrayList<Vaisseau> createFlotte(){
		ArrayList<Vaisseau> flotte = new ArrayList<Vaisseau>();
		int xCroiseur, yCroiseur, xChasseur, yChasseur, xDestroyer, yDestroyer, xEclaireur, yEclaireur;
		System.out.println(this.numero);
		switch(this.numero) {
		case 1: xCroiseur = 0; yCroiseur = 1;
		xChasseur = 1; yChasseur = 0; 
		xDestroyer = 1; yDestroyer = 1; 
		xEclaireur = 1; yEclaireur = 2;
		break;
		case 2: xCroiseur = Map.getLength() - 1; yCroiseur = Map.getLength() - 2;
		xChasseur = Map.getLength() - 2; yChasseur = Map.getLength() - 1; 
		xDestroyer = Map.getLength() - 2; yDestroyer = Map.getLength() - 2; 
		xEclaireur = Map.getLength() - 1; yEclaireur = Map.getLength() - 3;
		break;
		case 3: xCroiseur = 0; yCroiseur = Map.getLength() - 2;
		xChasseur = 1; yChasseur = Map.getLength() - 2; 
		xDestroyer = 1; yDestroyer = Map.getLength() - 1; 
		xEclaireur = 2; yEclaireur = Map.getLength() - 1;
		break;
		case 4: xCroiseur = Map.getLength() - 2; yCroiseur = 0;
		xChasseur = Map.getLength() - 2; yChasseur = 1; 
		xDestroyer = Map.getLength() - 1; yDestroyer = 1; 
		xEclaireur = Map.getLength() - 1; yEclaireur = 2;
		break;
		default : System.out.println("default");
		xCroiseur = 0; yCroiseur = 0;
		xChasseur = 0; yChasseur = 0; 
		xDestroyer = 0; yDestroyer = 0; 
		xEclaireur = 0; yEclaireur = 0;
		break;
		}
		flotte.add((new Vaisseau(VaisseauType.CROISEUR,xCroiseur,yCroiseur)));
		flotte.add((new Vaisseau(VaisseauType.CHASSEUR,xChasseur,yChasseur)));
		flotte.add((new Vaisseau(VaisseauType.DESTROYER,xDestroyer,yDestroyer)));
		flotte.add((new Vaisseau(VaisseauType.ECLAIREUR,xEclaireur,yEclaireur)));
		return flotte;
	}
}
