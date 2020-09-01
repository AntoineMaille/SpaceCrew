package crew;

public enum VaisseauType {
	CROISEUR("Croiseur",'C', 500,20,2, 1000),DESTROYER("Destroyer", 'D',300,60,2, 1000),CHASSEUR("Chasseur",'H',200,35,3,500),ECLAIREUR("Eclaireur",'E', 100,25,5,200);
		private String name;
    	private int vie;
		private int attaque;
		private int movementPoint;
		private int capacity;
		private char icone;
	
		private VaisseauType(String l,char icone, int vie, int attaque, int movementPoint, int capacity) {
			this.icone = icone;
			this.name= l;
			this.vie = vie;
			this.attaque = attaque;
			this.movementPoint = movementPoint;
			this.capacity = capacity;
		}

		public String getName() {
			return name;
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

		public char getIcone() {
			return icone;
			
		}





		
		
	
}
