package crew;

import java.util.ArrayList;
import java.util.Random;

public class Map {
	private ArrayList<Planets> planetesJoueurs;
	private ArrayList<Planets> planetesRandom;
	private static Random ran;
	public static Entities [][] map;
	private static final int length = 20;

	public static Entities[][] getMap() {
		return map;
	}

	public static void setMap(Entities[][] map) {
		Map.map = map;
	}

	public static int getLength() {
		return length;
	}

	public Map() {
		planetesJoueurs = new ArrayList<Planets>();
		planetesJoueurs.add(new PlaneteJoueur());
		planetesJoueurs.add(new PlaneteJoueur());
		map = new Entities[Map.length][Map.length];
		map [0] [0] = planetesJoueurs.get(0);
		map [Map.length - 1][Map.length - 1] = planetesJoueurs.get(1);
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
	
	public static Vaisseau getVaisseau(Coordinates c) {
		if(Map.map [c.getX()][c.getY()] instanceof Vaisseau) {
			return (Vaisseau) Map.map [c.getX()][c.getY()];
		}
		return null;
	}
	
	public static void setVaisseau(Coordinates c, Vaisseau v) {
		Map.getMap() [c.getX()][c.getY()] = v;
	}

	public static void main(String[] args) {
		Map map = new Map();
		System.out.println(map);
	}
}
