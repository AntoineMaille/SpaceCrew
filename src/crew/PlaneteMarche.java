package crew;

import java.util.ArrayList;
import java.util.Scanner;

public class PlaneteMarche extends Planets {
	
	private String name;
	private Coordinates p1;
	private Coordinates p2;
	private Coordinates p3;
	private Coordinates p4;
	private ArrayList<Coordinates> coordonees;
	

	public PlaneteMarche() {
		super(0, "Marché" ,Map.getLength()/2-1, Map.getLength()/2-1);
		this.name="Marché";
		this.coordonees = new ArrayList<Coordinates>();
		this.p1=new Coordinates(Map.getLength()/2-1, Map.getLength()/2-1);
		coordonees.add(p1);
		this.p2=new Coordinates(Map.getLength()/2-1, Map.getLength()/2);
		coordonees.add(p2);
		this.p3=new Coordinates(Map.getLength()/2, Map.getLength()/2-1);
		coordonees.add(p3);
		this.p4=new Coordinates(Map.getLength()/2, Map.getLength()/2);
		coordonees.add(p4);
		for (Coordinates coordinates : coordonees) {
			Map.map [coordinates.getX()][coordinates.getY()]= this;
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Coordinates getP1() {
		return p1;
	}
	public void setP1(Coordinates p1) {
		this.p1 = p1;
	}
	public Coordinates getP2() {
		return p2;
	}
	public void setP2(Coordinates p2) {
		this.p2 = p2;
	}
	public Coordinates getP3() {
		return p3;
	}
	public void setP3(Coordinates p3) {
		this.p3 = p3;
	}
	public Coordinates getP4() {
		return p4;
	}
	public void setP4(Coordinates p4) {
		this.p4 = p4;
	}
	@Override
	public String toString() {
		return "$";
	}

	
	
	
}
