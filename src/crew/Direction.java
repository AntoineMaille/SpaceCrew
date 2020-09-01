package crew;

public enum Direction {
	NORD(-1, 0), SUD(1 , 0), EST(0,1), OUEST(0, -1);
	private int x;
	private int y;

	private Direction(int x, int y) {
		
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
}

	
