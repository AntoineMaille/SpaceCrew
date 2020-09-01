package crew;

import java.util.ArrayList;
import java.util.Random;

public class Map {
	private ArrayList<Planets> planetesJoueurs;
	private ArrayList<Planets> planetesRandom;
	private Entities [][] map;
	private static int length = 20;
	private int compteurPlanete = -1;

	public Map() {
		planetesJoueurs = new ArrayList<Planets>();
		planetesRandom = new ArrayList<Planets>();
		planetesJoueurs.add(new PlaneteJoueur(PlanNO));
		planetesJoueurs.add(new PlaneteJoueur(PlanSE));
		map = new Entities[Map.length][Map.length];
		map [0] [0] = planetesJoueurs.get(0);
		map [Map.length - 1][Map.length - 1] = planetesJoueurs.get(1);
		for (int i = 0; i < (Map.length); i++) {
			for (int j = 0; j < (Map.length); j++) {
				if((((int) (Math.random() * 15))  >= 14) && (!((i > -1 && i < 4)&& (j > -1 && j < 4))) && (!((i > Map.length - 5 && i < Map.length) && ( j > Map.length - 5 && j < Map.length))) && (!((i > (Map.length/2 - 3) && i < (Map.length/2 + 2)) && ( j > (Map.length/2 - 3) && j < (Map.length/2 + 2))))) {
					this.planetesRandom.add(new PlaneteRandom());
					compteurPlanete++;
					planetesRandom.add(new PlaneteRandom());					
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
				//
			}
			res.append("|");
		}
		return res.toString();
	}
	
	
	public static void main(String[] args) {
		Map map = new Map();
		System.out.println(map);
	}
}
