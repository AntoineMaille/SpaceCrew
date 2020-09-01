package crew;

public class Vaisseau extends Entities {
	
	private VaisseauType type;
	private int hp;
	private int x;
	private int y;
	
	
	public Vaisseau(VaisseauType t,int v,int x,int y) {
		this.type=t;
		this.hp=v;
		this.x=x;
		this.y=y;
	}


	public int getVie() {
		return hp;
	}


	public void setVie(int vie) {
		this.hp = vie;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public VaisseauType getType() {
		return type;
	}
}