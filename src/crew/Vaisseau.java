package crew;

public class Vaisseau extends Entities {
	
	private VaisseauType type;
	private int hp;
	private int movementPointLeft;
	
	
	public Vaisseau(VaisseauType t,int x,int y) {
		super(x,y);
		this.type=t;
		this.hp= type.getVie();
		this.movementPointLeft = t.getMovementPoint();
	}


	public int getVie() {
		return hp;
	}


	public void setVie(int vie) {
		this.hp = vie;
	}


	public Coordinates getPosition() {
		return super.getPosition();
	}


	public VaisseauType getType() {
		return type;
	}
	
	public boolean move(Direction d) {
		if(		this.getPosition().update(d).getX() > 0 &&
				this.getPosition().update(d).getX() < Map.getLength() - 1 &&
				Map.getVaisseau(this.getPosition().update(d)) == null &&
				this.movementPointLeft != 0) {
			Map.getMap() [this.getPosition().getX()][this.getPosition().getY()] = null;
			Map.setVaisseau(this.getPosition().update(d), this);
			this.setPosition(this.getPosition().update(d));
			this.movementPointLeft --;
			return true;
		}
		return false;
	}
	
	public String toString() {
		return ""+this.getType().getL();
	}
}
