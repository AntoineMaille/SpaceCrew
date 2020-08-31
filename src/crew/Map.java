package crew;

import java.util.ArrayList;
import java.util.Random;

public class Map {
	private ArrayList<Planets> planetesJoueurs;
	private ArrayList<Planets> planetesRandom;
	private static Random ran;
	private Entities [][] map;
	private static int length = 20;

	public Map() {
		planetesJoueurs = new ArrayList<Planets>();
		planetesJoueurs.add(new PlaneteJoueur());
		planetesJoueurs.add(new PlaneteJoueur());
		map = new Entities[Map.length][Map.length];
		map [0] [0] = new PlaneteJoueur();
		map [Map.length - 1][Map.length - 1] = new PlaneteJoueur();
	}

	public String toString() {
		StringBuilder res = new StringBuilder();
		for (int bordure = 0; bordure < map.length * 3; bordure++) {
			res.append("_");
		}
		for (int ligne = 0; ligne < Map.length ; ligne++) {
			res.append('\n');
			for (int colonne = 0; colonne < Map.length; colonne++) {
				if(ligne % 2 ==  0 ) {
					if(colonne % 2 == 1)
						res.append("__");
					else
						res.append(" ");
				}
				else if(ligne % 2 == 1) {
					if(colonne % 2 == 1	)
						res.append('|');
					else
						res.append(' ');
				}
			}
		}
		return res.toString();
	}
	
	public static void main(String[] args) {
		Map map = new Map();
		System.out.println(map);
	}
}
