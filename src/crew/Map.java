package crew;

import java.util.ArrayList;
import java.util.Scanner;

public class Map {
	private ArrayList<Vaisseau> flotte1;
	private ArrayList<Vaisseau> flotte2;
	private ArrayList<Joueur> Joueurs;
	private ArrayList<Planets> planetesJoueurs;
	private ArrayList<Planets> planetesRandom;
	public static Entities [][] map;
	private static int length = 20;
	private int compteurPlanete = -1;
	
	public static Entities[][] getMap() {
		return map;
	}

	public static void setMap(Entities[][] map) {
		Map.map = map;
	}

	public static int getLength() {
		return length;
	}
	
	public void CreationJoueur() {
		System.out.println("Nommez les deux équipes ?");
		Scanner in = new Scanner(System.in);
		PlaneteJoueur[] planeteDepart= new PlaneteJoueur[2];
		planeteDepart[0]=new PlaneteJoueur(PlaneteInitEnum.PlanNO);
		planeteDepart[1]=new PlaneteJoueur(PlaneteInitEnum.PlanSE);
		Joueur j1=new Joueur(1,in.nextLine(),planeteDepart[0]);
		flotte1= new ArrayList<Vaisseau>();
		flotte1.add((new Vaisseau(VaisseauType.CROISEUR,0,2)));
		flotte1.add((new Vaisseau(VaisseauType.CHASSEUR,1,2)));
		flotte1.add((new Vaisseau(VaisseauType.DESTROYER,2,0)));
		flotte1.add((new Vaisseau(VaisseauType.ECLAIREUR,2,1)));
		j1.setFlotte(flotte1);
		map[j1.getFlotte().get(0).getPosition().getY()][j1.getFlotte().get(0).getPosition().getX()]=j1.getFlotte().get(0);
		map[j1.getFlotte().get(1).getPosition().getY()][j1.getFlotte().get(1).getPosition().getX()]=j1.getFlotte().get(1);
		map[j1.getFlotte().get(2).getPosition().getY()][j1.getFlotte().get(2).getPosition().getX()]=j1.getFlotte().get(2);
		map[j1.getFlotte().get(3).getPosition().getY()][j1.getFlotte().get(3).getPosition().getX()]=j1.getFlotte().get(3);
		Joueur j2=new Joueur(2,in.nextLine(),planeteDepart[1]);
		flotte2= new ArrayList<Vaisseau>();
		flotte2.add((new Vaisseau(VaisseauType.CROISEUR,17,19)));
		flotte2.add((new Vaisseau(VaisseauType.CHASSEUR,17,18)));
		flotte2.add((new Vaisseau(VaisseauType.DESTROYER,19,17)));
		flotte2.add((new Vaisseau(VaisseauType.ECLAIREUR,18,17)));
		j2.setFlotte(flotte2);
		map[j2.getFlotte().get(0).getPosition().getY()][j1.getFlotte().get(0).getPosition().getX()]=j1.getFlotte().get(0);
		map[j2.getFlotte().get(1).getPosition().getY()][j1.getFlotte().get(1).getPosition().getX()]=j1.getFlotte().get(1);
		map[j2.getFlotte().get(2).getPosition().getY()][j1.getFlotte().get(2).getPosition().getX()]=j1.getFlotte().get(2);
		map[j2.getFlotte().get(3).getPosition().getY()][j1.getFlotte().get(3).getPosition().getX()]=j1.getFlotte().get(3);
		System.out.println(j1.getName()+" Démarre sur la planète du haut.");
	}


	public Map() {
		planetesJoueurs = new ArrayList<Planets>();
		planetesRandom = new ArrayList<Planets>();
		planetesJoueurs.add(new PlaneteJoueur());
		planetesJoueurs.add(new PlaneteJoueur());
		map = new Entities[Map.length][Map.length];
		map [0] [0] = planetesJoueurs.get(0);
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
		this.CreationJoueur();
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
		for(i=0;i<joueursList.size();i++) {
		if(joueursList.get(i).Pleine()){
		System.out.println("Le joueur "+i+" est le grand vainqueur de cette bataille spatiale, bravo!");
			}
		}
		for (int i =0; i < 4; i++) {
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
		}
	}
}
