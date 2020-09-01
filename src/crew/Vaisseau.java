package crew;

public class Vaisseau extends Entities {

	private VaisseauType type;
	private int hp;
	private int movementPointLeft;
	private int ressources;
	private int attaque;
	private int capacity;



	public Vaisseau(VaisseauType t,int x,int y) {
		super(x,y);
		this.type=t;
		this.hp= type.getVie();
		this.movementPointLeft = t.getMovementPoint();
		this.ressources=0;
		this.attaque=type.getAttaque();
		this.capacity=type.getCapacity();
	}
	


	public void Combat(Vaisseau attaquant) {
		if (this.getType().getVie()-attaquant.getType().getAttaque()>=0){
			this.setMovementPointLeft(0);
			this.getType().setL("☠");
		}
		this.setVie(this.getType().getVie()-attaquant.getType().getAttaque());
		//system.out.println("Le Vaisseau s'est fait bombardé et a subi :"+ this.getType().getVie()-attaquant.getType().getAttaque() +"Point de dégâts, il lui en reste :"+this.getVie());
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


	public int getAttaque() {
		return attaque;
	}


	public void setAttaque(int attaque) {
		this.attaque = attaque;
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
				Map.getCase(this.getPosition().update(d)) == null &&
				this.movementPointLeft > 0) {
			if(Map.getCase(this.getPosition().update(d)) == null ) {
				Map.deleteEntities(this);
				this.setPosition(this.getPosition().update(d));
				Map.addEntities(this);
				this.movementPointLeft --;
				return true;
			}

			else if(Map.getCase(this.getPosition().update(d)) instanceof PlaneteRandom) {
				//if((PlaneteRandom)Map.getCase(this.getPosition().update(d).).get
			}
			else {
			}
		}
		System.out.println(this.getPosition());
		System.out.println(Map.getCase(this.getPosition().update(d)).getPosition());
		System.out.println("ca passe pas");
		return false;
	}



	
	public String toString() {
		return ""+this.getType().getL();
	}
}
