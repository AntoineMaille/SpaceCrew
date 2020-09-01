package crew;

public enum PlaneteInitEnum {
	PlanNO(0,0),PlanSE(Map.getLength() - 1,Map.getLength() - 1), PlanNE(0, Map.getLength() - 1), PlanSO(Map.getLength() - 1, 0);
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
