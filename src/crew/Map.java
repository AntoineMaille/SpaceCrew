package crew;

import java.util.ArrayList;
import java.util.Scanner;

public class Map {
	private ArrayList<Joueur> winners=new ArrayList<Joueur>();
	private static ArrayList<Joueur> joueursList;
	private ArrayList<PlaneteRandom> planetesRandom;
	private static final int length = 10;
	public static Entities [][] map = new Entities[length][length];
	private int compteurPlanete = -1;
	private static Scanner scanner = new Scanner(System.in);
	private PlaneteMarche marche;


	public static Entities[][] getMap() {
		return map;
	}


	public static int getLength() {
		return length;
	}


	public Map(ArrayList<Joueur> joueurs) {
		joueursList = new ArrayList<Joueur>();
		planetesRandom = new ArrayList<PlaneteRandom>();
		new PlaneteMarche();
		for (Joueur joueur : joueurs) {
			joueursList.add(joueur);
			Map.addEntities(joueur.getPlanete());
			for (Vaisseau vaisseau : joueur.getFlotte()) {
				Map.addEntities(vaisseau);
			}
		}
		for (int i = 0; i < (Map.length); i++) {
			for (int j = 0; j < (Map.length); j++) {
				if((((int) (Math.random() * 15))  >= 13) 
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
		marche = new PlaneteMarche();
		Map.addEntities(marche);
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
		String choix1 = scanner.nextLine();
		while(!choix1.equals("2") && !choix1.equals("3") && !choix1.equals("4")) {
			System.out.println("Choisissez un chiffre entre 2 et 4");
			choix1 = scanner.nextLine();;
		}
		nbEquipe = Integer.parseInt(choix1);
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


	public static void mort(Vaisseau v) {
		for (Joueur j : joueursList) {
			for (Vaisseau cible : j.getFlotte()) {
				if (v.equals(cible)) {
					Map.deleteEntities(v);
					j.getFlotte().remove(v);
				}
			}
		}
	}
	public boolean win() {
		this.winners.clear();
		for (Joueur j : joueursList) {
			if(j.getPlanete().getRessources()>=PlaneteJoueur.getSeuil()) {
				winners.add(j);
			}
		}
		if(this.winners.size()> 0) {
			return true;
		}
		else {
			for (Joueur joueur : joueursList) {
				for (Vaisseau v : joueur.getFlotte()) {
					if(v.getVie() > 0 && !winners.contains(joueur)) {
						winners.add(joueur);
					}
				}
			}
			System.out.println(winners.size());
			if(winners.size() == 1) {
				return true;
			}
		}
		return false;
}


	public static void main(String[] args) {
		System.out.println("Règles de base :\n" + 
				"\n" + 
				"-Le but final est de détruire l'univers de 2 manières possibles:\n" + 
				"    -Détruire la flotte adverse\n" + 
				"    -Construire une étoile de la mort\n" + 
				"\n" + 
				"Votre flotte peut atterir sur les diverses planètes de l'univers pour collecter des matériaux qui vous serviront à améliorer vos vaisseaux OU les déposer dans votre camp pour vous rapprocher de la construction de votre étoile.\n" + 
				"\n" + 
				"Au centre de l'univers se trouve le marché où vous pourrez améliorer les vaisseaux débordant de matériaux.\n" + 
				"\n" + 
				"Vous pouvez également attaquer les vaisseaux adverses pour potentiellement les détruire et piller leurs ressources !\n" + 
				"\n" + 
				"Bonne chance et bon jeu dans l'univers impitoyable de SpaceCrew !");
		try{System.in.read();}
		catch(Exception e){}
		Map map = new Map(creationJoueur());
		while(!map.win()) {
			for (PlaneteRandom planete : map.planetesRandom) {
				if(planete.getRecharge() != PlaneteRandom.getTempsrecharge())
					planete.setRecharge(planete.getRecharge() + 1);
			}
			for (Joueur joueur : joueursList) {
				for (Vaisseau vaisseau : joueur.getFlotte()) {
					vaisseau.setMovementPointLeft(vaisseau.getMovementPoint());
				}
				for (Vaisseau vaisseau : joueur.getFlotte()) {
					System.out.println(map);
					while(vaisseau.getMovementPointLeft() > 0) {
						System.out.println("\n               Joueur " + joueur.getNumero() + " 🌕 :  " + joueur.getPlanete().getRessources() + "/" + PlaneteJoueur.getSeuil() + "\n");
						for (Vaisseau vaisseauMenu : joueur.getFlotte()) {
							if(vaisseau == vaisseauMenu)
								System.out.println("-> " +  vaisseauMenu.getName() + ":  ❤️  " + vaisseauMenu.getVie() + "/" + vaisseauMenu.getHpcapacity() +"         🗡   " + vaisseauMenu.getAttaque() + "         🛢️  " + vaisseauMenu.getRessources() + "/" + vaisseauMenu.getCapacity() + "        ►  " + vaisseauMenu.getMovementPointLeft());
							else {
								System.out.println("   " + vaisseauMenu.getName() + ":  ❤️  " + vaisseauMenu.getVie() + "/" + vaisseauMenu.getHpcapacity() + "         🗡   " + vaisseauMenu.getAttaque() + "         🛢️  " + vaisseauMenu.getRessources() + "/" + vaisseauMenu.getCapacity() + "        ►  " + vaisseauMenu.getMovementPointLeft());
							}
						}
						String deplacement = scanner.nextLine();
						while(!deplacement.equals("z") && !deplacement.equals("s") && !deplacement.equals("q") && !deplacement.equals("d")) {
							deplacement = scanner.nextLine();
						}
						if (deplacement.equalsIgnoreCase("z")) {
							vaisseau.move(Direction.NORD);
						}else if (deplacement.equalsIgnoreCase("s")) {
							vaisseau.move(Direction.SUD);
						}else if (deplacement.equalsIgnoreCase("d")) {
							vaisseau.move(Direction.EST);
						}else if (deplacement.equalsIgnoreCase("q")) {
							vaisseau.move(Direction.OUEST);
						}
						System.out.println(map.toString());
					}
				}
			}
		}
		System.out.println("le(s) vainqeurs sont :");
		for (Joueur winners : map.winners) {
			System.out.println(winners.getNumero() +  " ");
		}
	}
}
