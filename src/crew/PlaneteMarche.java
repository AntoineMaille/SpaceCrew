package crew;

import java.util.Scanner;

public class PlaneteMarche extends Planets {
	private String name;
	private Coordinates p1;
	private Coordinates p2;
	private Coordinates p3;
	private Coordinates p4;
	private Vaisseau estPresent;
	
	/**Manque les boucles, et les entrées au clavier**/
	public PlaneteMarche() {
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
		if(estPresent.getRessources()!=0) {
			Amelioration();
		}else {
			System.out.println("Vous n'avez aucune ressources, revenez plus tard.");
			this.estPresent=null;
		}
		
	}
	public void Amelioration() {
		System.out.println("Voulez vous améliorer votre vaisseau ?");
		
	}
	public void AmeliorationPV() {
		if(estPresent.getType()==VaisseauType.CHASSEUR) {
			System.out.println("Pour améliorer votre vaisseau de 10 PV, cela vous coutera 15 débrits ");
			System.out.println("Voulez vous l'améliorer ?");
			try (Scanner scanner = new Scanner(System.in)) {
				
			}
			this.estPresent.setVie(this.estPresent.getVie()+10);
			this.estPresent.setRessources(this.getRessources()-20);
			
			
		}else if(estPresent.getType()==VaisseauType.CROISEUR) {
			System.out.println("Pour améliorer votre vaisseau de 10 PV, cela vous coutera 25 débrits ");
			System.out.println("Voulez vous l'améliorer ?");
			try (Scanner scanner = new Scanner(System.in)) {
				
			}
			this.estPresent.setVie(this.estPresent.getVie()+10);
			this.estPresent.setRessources(this.getRessources()-15);
			
		}else if(estPresent.getType()==VaisseauType.DESTROYER) {
			System.out.println("Pour améliorer votre vaisseau de 10 PV, cela vous coutera 20 débrits ");
			System.out.println("Voulez vous l'améliorer ?");
			try (Scanner scanner = new Scanner(System.in)) {
				
			}
			this.estPresent.setVie(this.estPresent.getVie()+10);
			this.estPresent.setRessources(this.getRessources()-20);
			
		}else if(estPresent.getType()==VaisseauType.ECLAIREUR) {
			System.out.println("Pour améliorer votre vaisseau de 10 PV, cela vous coutera 10 débrits ");
			System.out.println("Voulez vous l'améliorer ?");
			try (Scanner scanner = new Scanner(System.in)) {
				
			}
			this.estPresent.setVie(this.estPresent.getVie()+10);
			this.estPresent.setRessources(this.getRessources()-25);
			
		}
		
		
	}
	public void AmeliorationDMG() {
		if(estPresent.getType()==VaisseauType.CHASSEUR) {
			System.out.println("Pour améliorer votre vaisseau de 10 point d'attaque, cela vous coutera 15 débrits ");
			System.out.println("Voulez vous l'améliorer ?");
			try (Scanner scanner = new Scanner(System.in)) {
				
			}
			this.estPresent.setAttaque(this.estPresent.getAttaque()+10);
			this.estPresent.setRessources(this.getRessources()-20);
			
			
		}else if(estPresent.getType()==VaisseauType.CROISEUR) {
			System.out.println("Pour améliorer votre vaisseau de 10 point d'attaque, cela vous coutera 25 débrits ");
			System.out.println("Voulez vous l'améliorer ?");
			try (Scanner scanner = new Scanner(System.in)) {
				
			}
			this.estPresent.setAttaque(this.estPresent.getAttaque()+10);
			this.estPresent.setRessources(this.getRessources()-15);
			
		}else if(estPresent.getType()==VaisseauType.DESTROYER) {
			System.out.println("Pour améliorer votre vaisseau de 10 point d'attaque, cela vous coutera 20 débrits ");
			System.out.println("Voulez vous l'améliorer ?");
			try (Scanner scanner = new Scanner(System.in)) {
				
			}
			this.estPresent.setAttaque(this.estPresent.getAttaque()+10);
			this.estPresent.setRessources(this.getRessources()-20);
			
		}else if(estPresent.getType()==VaisseauType.ECLAIREUR) {
			System.out.println("Pour améliorer votre vaisseau de 10 point d'attaque, cela vous coutera 10 débrits ");
			System.out.println("Voulez vous l'améliorer ?");
			try (Scanner scanner = new Scanner(System.in)) {
				
			}
			this.estPresent.setAttaque(this.estPresent.getAttaque()+10);
			this.estPresent.setRessources(this.getRessources()-25);
			
		}
	}
	public void AmeliorationMVT() {
		if(estPresent.getType()==VaisseauType.CHASSEUR) {
			System.out.println("Pour améliorer votre vaisseau pour qu'il se déplace d'une case suplémentaire, cela vous coutera 10 débrits ");
			System.out.println("Voulez vous l'améliorer ?");
			try (Scanner scanner = new Scanner(System.in)) {
				
			}
			this.estPresent.setMovementPointLeft(this.estPresent.getMovementPointLeft()+1);
			this.estPresent.setRessources(this.getRessources()-10);
			
			
		}else if(estPresent.getType()==VaisseauType.CROISEUR) {
			System.out.println("Pour améliorer votre vaisseau pour qu'il se déplace d'une case suplémentaire, cela vous coutera 15 débrits ");
			System.out.println("Voulez vous l'améliorer ?");
			try (Scanner scanner = new Scanner(System.in)) {
				
			}
			this.estPresent.setMovementPointLeft(this.estPresent.getMovementPointLeft()+1);
			this.estPresent.setRessources(this.getRessources()-15);
			
		}else if(estPresent.getType()==VaisseauType.DESTROYER) {
			System.out.println("Pour améliorer votre vaisseau pour qu'il se déplace d'une case suplémentaire, cela vous coutera 20 débrits ");
			System.out.println("Voulez vous l'améliorer ?");
			try (Scanner scanner = new Scanner(System.in)) {
				
			}
			this.estPresent.setMovementPointLeft(this.estPresent.getMovementPointLeft()+1);
			this.estPresent.setRessources(this.getRessources()-20);
			
		}else if(estPresent.getType()==VaisseauType.ECLAIREUR) {
			System.out.println("Pour améliorer votre vaisseau pour qu'il se déplace d'une case suplémentaire, cela vous coutera 25 débrits ");
			System.out.println("Voulez vous l'améliorer ?");
			try (Scanner scanner = new Scanner(System.in)) {
				
			}
			this.estPresent.setMovementPointLeft(this.estPresent.getMovementPointLeft()+1);
			this.estPresent.setRessources(this.getRessources()-25);
			
		}
	}
	public void AmeliorationCapacity() {
		if(estPresent.getType()==VaisseauType.CHASSEUR) {
			System.out.println("Pour améliorer la capacité de stockage de 50, cela vous coutera 20 débrits ");
			System.out.println("Voulez vous l'améliorer ?");
			try (Scanner scanner = new Scanner(System.in)) {
				
			}

			this.estPresent.setRessources(this.getRessources()-20);
			
			
		}else if(estPresent.getType()==VaisseauType.CROISEUR) {
			System.out.println("Pour améliorer la capacité de stockage de 50, cela vous coutera 10 débrits ");
			System.out.println("Voulez vous l'améliorer ?");
			try (Scanner scanner = new Scanner(System.in)) {
				
			}
			this.estPresent.setCapacity(this.estPresent.getCapacity()+50);
			this.estPresent.setRessources(this.getRessources()-15);
			
		}else if(estPresent.getType()==VaisseauType.DESTROYER) {
			System.out.println("Pour améliorer la capacité de stockage de 50, cela vous coutera 15 débrits ");
			System.out.println("Voulez vous l'améliorer ?");
			try (Scanner scanner = new Scanner(System.in)) {
				
			}
			this.estPresent.setCapacity(this.estPresent.getCapacity()+50);
			this.estPresent.setRessources(this.getRessources()-20);
			
		}else if(estPresent.getType()==VaisseauType.ECLAIREUR) {
			System.out.println("Pour améliorer la capacité de stockage de 50, cela vous coutera 25 débrits ");
			System.out.println("Voulez vous l'améliorer ?");
			try (Scanner scanner = new Scanner(System.in)) {
				
			}
			this.estPresent.setCapacity(this.estPresent.getCapacity()+50);
			this.estPresent.setRessources(this.getRessources()-25);
			
		}
	}	

	
	
	
	
}
