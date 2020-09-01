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
	
	
}
