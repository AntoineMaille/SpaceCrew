package crew;

public enum VaisseauType {
	CROISEUR('C','500','20','2'),DESTROYER('D','300','60','2'),CHASSEUR('H','200','35','3'),ECLAIREUR('E','100','25','5');
		private char l;
    	private int vie;
		private int attaque;
		private int movementPoint;
		
		private VaisseauType(char l, int vie, int attaque, int movementPoint) {
			this.l= l;
			this.vie = vie;
			this.attaque = attaque;
			this.movementPoint = movementPoint;
		}
	
}
