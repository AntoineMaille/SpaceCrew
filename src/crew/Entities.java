package crew;

public abstract class Entities {
	private Coordinates position;
	
		
	public Entities(Coordinates c) {
		this.position=c;
	}
	
	public Entities(int x, int y) {
		this.position=new Coordinates(x,y);
	}
	
	public Coordinates getPosition() {
		return position;
	}

	public void setPosition(Coordinates position) {
		this.position = position;
	}
	
	
}
