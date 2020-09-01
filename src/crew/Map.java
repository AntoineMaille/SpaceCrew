package crew;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Map {
	private ArrayList<Joueur> joueursList;
	private ArrayList<Planets> planetesRandom;
	private static Random ran;
	private static final int length = 20;
	public static Entities [][] map = new Entities[length][length];
	private int compteurPlanete = -1;


	public static Entities[][] getMap() {
		return map;
	}


	public static int getLength() {
		return length;
	}

	public Map(ArrayList<Joueur> joueurs) {
		this.joueursList = new ArrayList<Joueur>();
		planetesRandom = new ArrayList<Planets>();
		for (Joueur joueur : joueurs) {
			this.joueursList.add(joueur);
			this.addPlanet(joueur.getPlanete());
		}
		for (int i = 0; i < (Map.length); i++) {
			for (int j = 0; j < (Map.length); j++) {
				if((((int) (Math.random() * 15))  >= 14) && (!((i > -1 && i < 4)&& (j > -1 && j < 4))) && (!((i > Map.length - 5 && i < Map.length) && ( j > Map.length - 5 && j < Map.length))) && (!((i > (Map.length/2 - 3) && i < (Map.length/2 + 2)) && ( j > (Map.length/2 - 3) && j < (Map.length/2 + 2))))) {
					this.planetesRandom.add(new PlaneteRandom());
					compteurPlanete++;
					//planetesRandom.add(new PlaneteRandom());					
					map[i][j] = planetesRandom.get(compteurPlanete);
				}
			}
		}
	}

	public void addPlanet(Planets p) {
		Map.map [p.getPosition().getX()][p.getPosition().getY()] = p;
	}

	public String toString() {
		StringBuilder res = new StringBuilder();
		for (int ligne = 0; ligne < Map.length ; ligne++) {
			res.append('\n');
			for (int separation = 0; separation < map.length; separation++) {
				res.append(" ---");
			}
			res.append('\n');
			for (int colonne = 0; colonne < Map.length; colonne++) {
				if( map[ligne] [colonne] instanceof Planets || map[ligne][colonne] instanceof Vaisseau)
					res.append("| " + map[ligne][colonne].toString() + " ");
				else {
					res.append("|   ");
				}
				//
			}
			res.append("|");
		}
		return res.toString();
	}

	public static Entities getCase(Coordinates c) {
			return Map.map [c.getX()][c.getY()];
	}

	public static void setVaisseau(Coordinates c, Vaisseau v) {
		Map.getMap() [c.getX()][c.getY()] = v;
	}

	public static ArrayList<Joueur> creationJoueur() {
		ArrayList<Joueur> joueurs = new ArrayList<>();
		int nbEquipe;
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Combien voulez-vous d'équipes ? : ");
			while(!scanner.hasNextInt()) {		
				System.out.println("Vous devez entrer un int");
			}
			nbEquipe = scanner.nextInt();
		}
		for (int nbJoueurs = 0; nbJoueurs < nbEquipe; nbJoueurs++) {
			joueurs.add(new Joueur(nbJoueurs + 1, "toto", new PlaneteJoueur(PlaneteInitEnum.values() [nbJoueurs])));
		}
		return joueurs;
	}

	public static void main(String[] args) {
		Map map = new Map(creationJoueur());
		System.out.println(map);
	}
}
