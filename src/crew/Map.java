package crew;

import java.util.ArrayList;
import java.util.Scanner;

public class Map {
	private ArrayList<Joueur> joueursList;
	private ArrayList<Planets> planetesRandom;
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
			Map.addEntities(joueur.getPlanete());
			for (Vaisseau vaisseau : joueur.getFlotte()) {
				Map.addEntities(vaisseau);
			}
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
			}
			res.append("|");
		}
		return res.toString();
	}

	public static Entities getCase(Coordinates c) {
		return Map.map [c.getX()][c.getY()];
	}

	public static void addEntities(Entities e) {
		Map.map [e.getPosition().getX()][e.getPosition().getY()] = e;
	}

	public static void deleteEntities(Entities e) {
		Map.map [e.getPosition().getX()][e.getPosition().getY()] = null;
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
		/**for (int i =0; i < 4; i++) {
		
		for (int i =0; i < 4; i++) {
 		branch 'master' of https://gitlab.univ-lille.fr/2020-S3-projet/groupe-23.git
			while(map.flotte1.get(i).getMovementPointLeft() > 0) {
				Scanner in = new Scanner(System.in);
				Direction d;
				String test = in.nextLine();
				if (test.equalsIgnoreCase("n")) {
					d = Direction.NORD;
					map.flotte1.get(i).move(d);
					System.out.println(map);
				}else if (test.equalsIgnoreCase("s")) {
					d = Direction.SUD;
					map.flotte1.get(i).move(d);
					System.out.println(map);
				}else if (test.equalsIgnoreCase("e")) {
					d = Direction.EST;
					map.flotte1.get(i).move(d);
					System.out.println(map);
				}else if (test.equalsIgnoreCase("o")) {
					d = Direction.OUEST;
					map.flotte1.get(i).move(d);
					System.out.println(map);
				}
			}
		}**/
	}
}
