package crew;

public class Vaisseau extends Entities {

	private VaisseauType type;
	private int hp;
	private int movementPointLeft;


	public Vaisseau(VaisseauType t,int x,int y) {
		this.type=t;
		this.hp= type.getVie();
		this.setPosition(new Coordinates(x, y));
		this.movementPointLeft = t.getMovementPoint();
	}


	public int getVie() {
		return hp;
	}


	public void setVie(int vie) {
		this.hp = vie;
	}


	public Coordinates getPosition() {
		return this.getPosition();
	}


	public void setPosition(Coordinates c) {
		this.setPosition(c);
	}


	public VaisseauType getType() {
		return type;
	}

	public boolean move(Direction d) {
		if(		this.getPosition().update(d).getX() > 0 &&
				this.getPosition().update(d).getX() < Map.getLength() - 1 &&
				this.movementPointLeft != 0) {
			if(Map.getCase(this.getPosition().update(d)) == null ) {
				Map.getMap() [this.getPosition().getX()][this.getPosition().getY()] = null;
				Map.setVaisseau(this.getPosition().update(d), this);
				this.setPosition(this.getPosition().update(d));
				this.movementPointLeft --;
				return true;
			}

			else if(Map.getCase(this.getPosition().update(d)) instanceof PlaneteRandom) {
				//if((PlaneteRandom)Map.getCase(this.getPosition().update(d).).get

			}
		}
		return false;
	}


}