package crew;
import java.util.ArrayList;
import java.util.Scanner;

public class Joueur {
	private int numero;
	private String name;
	private ArrayList<Vaisseau> flotte;
	private int ressources;
	private PlaneteJoueur equipe;
	
	public Joueur(int n, String nom,PlaneteJoueur e) {
		this.numero = n;
		this.name = nom;
		this.ressources = 0;
		this.equipe=e;
	}


	public void CreationJoueur() {
		System.out.println("Nommez les deux équipes ?");
		Scanner in = new Scanner(System.in);
		PlaneteJoueur[] planeteDepart= new PlaneteJoueur[2];
		planeteDepart[0]=new PlaneteJoueur(PlaneteInitEnum.PlanNO);
		planeteDepart[1]=new PlaneteJoueur(PlaneteInitEnum.PlanSE);
		Joueur j1=new Joueur(1,in.nextLine(),planeteDepart[0]);
		Joueur j2=new Joueur(2,in.nextLine(),planeteDepart[1]);
		System.out.println(j1+" Démarre sur la planète du haut.");
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

	public PlaneteJoueur getEquipe() {
		return equipe;
	}

	public void setEquipe(PlaneteJoueur equipe) {
		this.equipe = equipe;
	}


	public String toString() {
		return "Joueur [name=" + name + ", flotte=" + flotte + ", ressources=" + ressources + ", equipe=" + equipe
				+ "]";
	}
	
	
}
