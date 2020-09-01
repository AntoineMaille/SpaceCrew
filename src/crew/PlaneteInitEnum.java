package crew;

public enum PlaneteInitEnum {
	PlanNO(0,0),PlanSE(19,19);
	private int x;
	private int y;
	
	private PlaneteInitEnum(int i,int j) {
		this.x=i;
		this.y=j;
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	
}
