package crew;

public enum VaisseauType {
	CROISEUR("C",500,20,2,250),DESTROYER("D",300,60,2,225),CHASSEUR("H",200,35,3,275),ECLAIREUR("E",100,25,5,200);
		private String l;
    	private int vie;
		private int attaque;
		private int movementPoint;
		private int capacity;
	
		private VaisseauType(String l, int vie, int attaque, int movementPoint, int capacity) {
			this.l= l;
			this.vie = vie;
			this.attaque = attaque;
			this.movementPoint = movementPoint;
			this.capacity=capacity;
		}

		public String getL() {
			return l;
		}
		public void setL(String s){
			this.l=s;
		}

		public int getVie() {
			return vie;
		}

		public int getAttaque() {
			return attaque;
		}

		public int getMovementPoint() {
			return movementPoint;
		}

		public int getCapacity() {
			return capacity;
		}

		public void setCapacity(int capacity) {
			this.capacity = capacity;
		}

		public void setVie(int vie) {
			this.vie = vie;
		}

		public void setAttaque(int attaque) {
			this.attaque = attaque;
		}

		public void setMovementPoint(int movementPoint) {
			this.movementPoint = movementPoint;
		}




		
		
	
}
