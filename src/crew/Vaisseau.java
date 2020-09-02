package crew;

public class Vaisseau extends Entities {

	private VaisseauType type;
	private char name;
	private int hp;
	private int attaque;
	private int movementPoint;
	private int capacity;
	private int movementPointLeft;
	private int joueur;
	private int ressources;



	public Vaisseau(VaisseauType t,int x,int y, int joueur) {
		super(x,y);
		this.type=t;
		this.name = t.getIcone();
		this.hp= type.getVie();
		this.attaque = t.getAttaque();
		this.capacity = t.getCapacity();
		this.movementPointLeft = t.getMovementPoint();
		this.movementPoint = this.movementPointLeft;
		this.joueur= joueur;
		this.ressources=0;
	}
	

	public void Combat(Vaisseau attaquant) {
		if(this.joueur == attaquant.getJoueur()) {
			System.out.println("Vous ne pouvez pas attaquer votre propre flotte");
		}else {
		this.hp=this.hp-attaquant.getType().getAttaque();
		System.out.println("Le vaisseau défenseur a subi "+attaquant.getType().getAttaque()+" il lui reste : "+this.hp+" points de vie.");
		if(this.hp<=0) {
			Map.mort(this);
			}else {
			attaquant.hp=attaquant.hp-this.getType().getAttaque();
			System.out.println("Le vaisseau attaquant a subi "+this.getType().getAttaque()+" il lui reste "+attaquant.hp+" points de vie");
			if(attaquant.hp<=0) {
				Map.mort(attaquant);
				}
			}	
		}
	}


	public int getVie() {
		return hp;
	}


	public void setVie(int vie) {
		this.hp = vie;
	}

	public void setMovementPointLeft(int movementPointLeft) {
		this.movementPointLeft = movementPointLeft;
	}


	public int getMovementPointLeft() {
		return movementPointLeft;
	}

	public Coordinates getPosition() {
		return super.getPosition();
	}


	public void setPosition(Coordinates c) {
		super.setPosition(c);
	}


	public VaisseauType getType() {
		return type;
	}

	public int getRessources() {
		return ressources;
	}



	public void setRessources(int ressources) {
		this.ressources = ressources;
	}



	public int getHp() {
		return hp;
	}



	public void setHp(int hp) {
		this.hp = hp;
	}



	public int getJoueur() {
		return joueur;
	}



	public void setJoueur(int joueur) {
		this.joueur = joueur;
	}



	public char getName() {
		return name;
	}



	public void setName(char icone) {
		this.name = icone;
	}



	public int getAttaque() {
		return attaque;
	}



	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}



	public int getMovementPoint() {
		return movementPoint;
	}



	public void setMovementPoint(int movementPoint) {
		this.movementPoint = movementPoint;
	}



	public int getCapacity() {
		return capacity;
	}



	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}



	public void setType(VaisseauType type) {
		this.type = type;
	}


	public boolean move(Direction d) {
		if(		this.getPosition().update(d).getX() >= 0 &&
				this.getPosition().update(d).getX() < Map.getLength()  && 
				this.getPosition().update(d).getY() > -1 &&
				this.getPosition().update(d).getY() < Map.getLength()  &&
				this.movementPointLeft > 0) {
			if(Map.getCase(this.getPosition().update(d)) == null ) {
				Map.deleteEntities(this);
				this.setPosition(this.getPosition().update(d));
				Map.addEntities(this);
				this.movementPointLeft --;
				return true;
			}

			else if(Map.getCase(this.getPosition().update(d)) instanceof PlaneteRandom) {
				this.aterissagePlaneteRandom((PlaneteRandom)Map.getCase(this.getPosition().update(d)));
			}

			else if(Map.getCase(this.getPosition().update(d)) instanceof PlaneteJoueur) {
				deposDebris((PlaneteJoueur) Map.getCase(this.getPosition().update(d)));
			}
			else if (Map.getCase(this.getPosition().update(d)) instanceof Vaisseau){
				Combat((Vaisseau)Map.getCase(this.getPosition().update(d)));
			}
		}
		return false;
	}



	public void deposDebris(PlaneteJoueur p) {
		if(p.getJoueur() != this.joueur) {
			System.out.println("Ce n'est pas votre planète");
		}
		else {
			System.out.println("Vous déposez " + this.getRessources() + " débris sur votre planète");
			p.setRessources(p.getRessources() + this.getRessources());
			this.setRessources(0);
		}
		try{System.in.read();}
		catch(Exception e){}

	}

	public void aterissagePlaneteRandom(PlaneteRandom p) {
		System.out.println("Vous atterissez sur " + p.getName());
		if(p.getRecharge() < 5) {
			System.out.println("Malheureusement la plan�te est vide, vous repartez");
			try{System.in.read();}
			catch(Exception e){}
		}
		else {
			System.out.println("Vous trouvez " + p.getRessources() + " d�bris");
			if(p.getRessources() > this.getCapacity() - this.ressources) {
				System.out.println("Malheureusement vous ne pouvez en prendre que " + (this.getCapacity() - this.ressources) + " car vous n'avez pas assez de place dans votre soute" );
				this.ressources = this.getCapacity();
				p.setRessources(p.getRessources() - this.getCapacity() - this.ressources);
			}
			else {
				this.ressources = this.ressources + p.getRessources();
				p.setRecharge(0);
			}
			try{System.in.read();}
			catch(Exception e){}
		}
		this.movementPointLeft --;

	}




	public String toString() {
		return this.getName() + "";
	}
}
