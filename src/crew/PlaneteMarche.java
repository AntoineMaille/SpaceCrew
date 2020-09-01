package crew;

public class PlaneteMarche extends Planets {
	private String name;
	private Coordinates p1;
	private Coordinates p2;
	private Coordinates p3;
	private Coordinates p4;
	private Vaisseau estPresent;
	

	public PlaneteMarche() {
		super(0, "March�" , 0 , 0);
		this.name="Marché";
		this.p1=new Coordinates(Map.getLength()/2-1, Map.getLength()/2-1);
		this.p2=new Coordinates(Map.getLength()/2-1, Map.getLength()/2);
		this.p3=new Coordinates(Map.getLength()/2, Map.getLength()/2-1);
		this.p4=new Coordinates(Map.getLength()/2, Map.getLength()/2);
			Map.getMap()[p1.getX()][p1.getY()]=this;
			Map.getMap()[p2.getX()][p2.getY()]=this;
			Map.getMap()[p3.getX()][p3.getY()]=this;
			Map.getMap()[p4.getX()][p4.getY()]=this;
			estPresent=null;
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
	public Vaisseau getEstPresent() {
		return estPresent;
	}
	public void setEstPresent(Vaisseau estPresent) {
		this.estPresent = estPresent;
	}
	
	public void Rencontre(Vaisseau stranger) {
		this.estPresent=stranger;
		if(estPresent.getRessources() == estPresent.getType().getCapacity()) {
			Amelioration();
		}else {
			System.out.println("Vous n'avez aucune ressources, revenez plus tard.");
			this.estPresent=null;
		}
		
	}
	public void Amelioration() {
		System.out.println("Voulez vous améliorer votre vaisseau ?");
		
	}
	
	
	
}
