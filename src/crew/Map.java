package crew;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Map {
	private static ArrayList<Joueur> joueursList;
	private ArrayList<PlaneteRandom> planetesRandom;
	private static final int length = 16;
	public static Entities [][] map = new Entities[length][length];
	private int compteurPlanete = -1;
	private static Scanner scanner = new Scanner(System.in);


	public static Entities[][] getMap() {
		return map;
	}


	public static int getLength() {
		return length;
	}


	public Map(ArrayList<Joueur> joueurs) {
		joueursList = new ArrayList<Joueur>();
		planetesRandom = new ArrayList<PlaneteRandom>();
		for (Joueur joueur : joueurs) {
			joueursList.add(joueur);
			Map.addEntities(joueur.getPlanete());
			for (Vaisseau vaisseau : joueur.getFlotte()) {
				Map.addEntities(vaisseau);
			}
		}
		for (int i = 0; i < (Map.length); i++) {
			for (int j = 0; j < (Map.length); j++) {
				if((((int) (Math.random() * 15))  >= 14) 
						&& (!((i > -1 && i < 4) && (j > -1 && j < 4))) 
						&& (!((i > Map.length - 5 && i < Map.length) && ( j > Map.length - 5 && j < Map.length))) 
						&& (!((i > (Map.length/2 - 3) && i < (Map.length/2 + 2)) && ( j > (Map.length/2 - 3) && j < (Map.length/2 + 2))))
						&& (!((i > -1 && i < 4) && (j > Map.length - 5 && j < Map.length)))
						&& (!((j > -1 && j < 4) && (i > Map.length - 5 && i < Map.length)))){
					this.planetesRandom.add(new PlaneteRandom(i ,j));
					compteurPlanete++;
					Map.addEntities(this.planetesRandom.get(compteurPlanete));
				}
			}
		}
	}

	@Override
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
		System.out.println("Combien voulez-vous d'équipes ? : ");
		while(!scanner.hasNextInt()) {		
			System.out.println("Vous devez entrer un int");
		}
		nbEquipe = scanner.nextInt();
		for (int nbJoueurs = 0; nbJoueurs < nbEquipe; nbJoueurs++) {
			joueurs.add(new Joueur(nbJoueurs + 1, "toto", new PlaneteJoueur(PlaneteInitEnum.values() [nbJoueurs], nbJoueurs + 1)));
		}
		return joueurs;
	}

	/**public void play() {
		boolean win = false;
		while(!win) {
			for (Joueur joueur : joueursList) {
				if(joueur.getFlotte().size() > 0)
					System.out.println("C'est au tour du joueur : " + joueur.getNumero());
				for (Vaisseau vaisseau : joueur.getFlotte()) {
					System.out.println("Vous déplacez le vaisseau : " + vaisseau);
					while(vaisseau.getMovementPointLeft() > 0) {
						System.out.println("Il vous reste " + vaisseau.getMovementPointLeft() + " d�placements avec " + vaisseau);
						String deplacement = scanner.nextLine();
						while(!deplacement.equals("n") && !deplacement.equals("s") && !deplacement.equals("e") && !deplacement.equals("o")) {
							deplacement = scanner.nextLine();
						}
						if (deplacement.equalsIgnoreCase("n")) {
							vaisseau.move(Direction.NORD);
						}else if (deplacement.equalsIgnoreCase("s")) {
							vaisseau.move(Direction.SUD);
						}else if (deplacement.equalsIgnoreCase("e")) {
							vaisseau.move(Direction.EST);
						}else if (deplacement.equalsIgnoreCase("o")) {
							vaisseau.move(Direction.OUEST);
						}
						System.out.println(map.toString());
					}
				}
			}
		}
	}**/





	public static void main(String[] args) {
		Map map = new Map(creationJoueur());
		System.out.println(map);
		boolean win = false;
		while(!win) {
			for (PlaneteRandom planete : map.planetesRandom) {
				if(planete.getRecharge() != 5)
					planete.setRecharge(planete.getRecharge() + 1);
			}
			for (Joueur joueur : joueursList) {
				for (Vaisseau vaisseau : joueur.getFlotte()) {
					vaisseau.setMovementPointLeft(vaisseau.getMovementPoint());
				}
				if(joueur.getFlotte().size() > 0)
				for (Vaisseau vaisseau : joueur.getFlotte()) {
					System.out.println(map);
					while(vaisseau.getMovementPointLeft() > 0) {
						System.out.println("\n               Joueur " + joueur.getNumero() + " 🌕 :  " + joueur.getPlanete().getRessources() + "/" + PlaneteJoueur.getSeuil() + "\n");
						for (Vaisseau vaisseauMenu : joueur.getFlotte()) {
							if(vaisseau == vaisseauMenu)
								System.out.println("-> " +  vaisseauMenu.getType().getName() + ":  ❤️  " + vaisseauMenu.getHp() + "         🔫   " + vaisseauMenu.getAttaque() + "         🛢️  " + vaisseauMenu.getRessources() + "/" + vaisseauMenu.getCapacity() + "        🏃‍♂️  " + vaisseauMenu.getMovementPointLeft());
							else {
								System.out.println("   " + vaisseauMenu.getType().getName() + ":  ❤️  " + vaisseauMenu.getHp() + "         🔫   " + vaisseauMenu.getAttaque() + "         🛢️  " + vaisseauMenu.getRessources() + "/" + vaisseauMenu.getCapacity() + "        🏃‍♂️  " + vaisseauMenu.getMovementPointLeft());
							}
						}
						String deplacement = scanner.nextLine();
						while(!deplacement.equals("n") && !deplacement.equals("s") && !deplacement.equals("e") && !deplacement.equals("o")) {
							deplacement = scanner.nextLine();
						}
						if (deplacement.equalsIgnoreCase("n")) {
							vaisseau.move(Direction.NORD);
						}else if (deplacement.equalsIgnoreCase("s")) {
							vaisseau.move(Direction.SUD);
						}else if (deplacement.equalsIgnoreCase("e")) {
							vaisseau.move(Direction.EST);
						}else if (deplacement.equalsIgnoreCase("o")) {
							vaisseau.move(Direction.OUEST);
						}
						System.out.println(map.toString());
					}
				}
			}
		}
	}
}
