package crew;

public enum VaisseauType {
	CROISEUR("C",500,20,2),DESTROYER("D",300,60,2),CHASSEUR("H",200,35,3),ECLAIREUR("E",100,25,5);
		private String l;
    	private int vie;
		private int attaque;
		private int movementPoint;
		private int ressources;
		
		private VaisseauType(String l, int vie, int attaque, int movementPoint) {
			this.l= l;
			this.vie = vie;
			this.attaque = attaque;
			this.movementPoint = movementPoint;
			this.ressources=0;
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

		public int getRessources() {
			return ressources;
		}


		
		
	
}
