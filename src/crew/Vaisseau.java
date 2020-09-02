package crew;

import java.util.Scanner;

public class Vaisseau extends Entities {

	private VaisseauType type;
	private String name;
	private char icone;
	private int hp;
	private int hpcapacity;
	private int attaque;
	private int movementPoint;
	private int capacity;
	private int movementPointLeft;
	private int joueur;
	private int ressources;
	private static Scanner in = new Scanner(System.in);



	public Vaisseau(VaisseauType t,int x,int y, int joueur) {
		super(x,y);
		this.type=t;
		this.name = t.getName();
		this.icone = t.getIcone();
		this.hp= type.getVie();
		this.hpcapacity = hp;
		this.attaque = t.getAttaque();
		this.capacity = t.getCapacity();
		this.movementPointLeft = t.getMovementPoint();
		this.movementPoint = this.movementPointLeft;
		this.joueur= joueur;
		this.ressources=0;
	}


	public char getIcone() {
		return icone;
	}


	public void setIcone(char icone) {
		this.icone = icone;
	}



	public int getVie() {
		return hp;
	}


	public void setVie(int vie) {
		this.hp = vie;
	}

	public void setMovementPointLeft(int movementPointLeft) {
		this.movementPointLeft = movementPointLeft;
	}


	public int getMovementPointLeft() {
		return movementPointLeft;
	}

	public Coordinates getPosition() {
		return super.getPosition();
	}


	public void setPosition(Coordinates c) {
		super.setPosition(c);
	}


	public VaisseauType getType() {
		return type;
	}

	public int getRessources() {
		return ressources;
	}



	public void setRessources(int ressources) {
		this.ressources = ressources;
	}




	public int getJoueur() {
		return joueur;
	}



	public void setJoueur(int joueur) {
		this.joueur = joueur;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAttaque() {
		return attaque;
	}



	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}



	public int getMovementPoint() {
		return movementPoint;
	}



	public void setMovementPoint(int movementPoint) {
		this.movementPoint = movementPoint;
	}



	public int getCapacity() {
		return capacity;
	}



	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}



	public void setType(VaisseauType type) {
		this.type = type;
	}


	public int getHpcapacity() {
		return hpcapacity;
	}





	public void setHpcapacity(int hpcapacity) {
		this.hpcapacity = hpcapacity;
	}





	public boolean move(Direction d) {
		if(		this.getPosition().update(d).getX() >= 0 &&
				this.getPosition().update(d).getX() < Map.getLength()  && 
				this.getPosition().update(d).getY() > -1 &&
				this.getPosition().update(d).getY() < Map.getLength()  &&
				this.movementPointLeft > 0) {
			if(Map.getCase(this.getPosition().update(d)) == null ) {
				Map.deleteEntities(this);
				this.setPosition(this.getPosition().update(d));
				Map.addEntities(this);
				this.movementPointLeft --;
				return true;
			}

			else if(Map.getCase(this.getPosition().update(d)) instanceof PlaneteRandom) {
				this.aterissagePlaneteRandom((PlaneteRandom)Map.getCase(this.getPosition().update(d)));
			}

			else if(Map.getCase(this.getPosition().update(d)) instanceof PlaneteJoueur) {
				deposDebris((PlaneteJoueur) Map.getCase(this.getPosition().update(d)));
			}
			else if (Map.getCase(this.getPosition().update(d)) instanceof Vaisseau){
				combat((Vaisseau)Map.getCase(this.getPosition().update(d)));
			}
			else if(Map.getCase(this.getPosition().update(d)) instanceof PlaneteMarche) {
				planeteMarche();

			}
		}
		return false;
	}

	public void planeteMarche() {
		if(!isFull()) {
			System.out.println("Il faut que votre soute soit pleine pour améliorer votre vaisseau");
		}
		else {
			System.out.println("Voulez-vous améliorer votre " + this.getName() + " ?");
			System.out.println("1. oui\n 2. non\n");
			String choix1 = in.nextLine();
			while(!choix1.equals("1") && !choix1.equals("2")) {
				choix1 = in.nextLine();;
			}
			switch(choix1) {
			case "1" : 
				System.out.println("1. Réparer votre vaisseau \n 2. Améliorer vos HP \n 3. Améliorer votre soute \n 4. Ameliorer votre attaque \n 5. Ameliorer vos points de déplacements \n");
				String choix2 = in.nextLine();
				while(!choix2.equals("1") && !choix2.equals("2") && !choix2.equals("3") && !choix2.equals("4") && !choix2.equals("5")) {
					choix2 = in.nextLine();
				}
				switch(choix2) {
				case "1" : heal();
				break;
				case "2" : ameliorationPV();
				break;
				case "3" : ameliorationCapacity();
				break;
				case "4": ameliorationAttaque();
				break;
				case "5" : ameliorationMP();
				}
				break;
			case "2" :
				System.out.println("Vous décollez de la planète");
				break;
			}
			this.setRessources(0);
		}
	}


	public void  ameliorationPV() {
		System.out.println("Vous augmentez les hp de votre vaisseau de " + ( this.hpcapacity / 4) + " HP");
		this.setHpcapacity(this.getVie()+ (this.getVie() / 4));
	}

	public void heal() {
		System.out.println("Vous réparez votre vaisseau");
		this.setVie(this.getHpcapacity());
	}

	public void ameliorationAttaque() {
		System.out.println("Vous augmentez l'attaque de votre vaisseau de " +  this.attaque / 4 + " HP");
		this.setAttaque(this.getAttaque()+ (this.getAttaque() / 4));
	}

	public void ameliorationMP() {
		System.out.println("Vous augmentez les points de déplacements de votre vaisseau de 1");
		this.setMovementPoint(this.getMovementPoint() + 1);
	}

	public void ameliorationCapacity() {
		System.out.println("Vous augmentez la capacité de votre vaisseau de " + this.getCapacity() / 4 );
		this.setCapacity(this.getCapacity() + this.getCapacity() / 4);
	}

	public boolean isFull() {
		return this.getRessources() == this.getCapacity();
	}

	public boolean isFullLife() {
		return this.hp == this.hpcapacity;
	}


	public void combat(Vaisseau defenseur){
		if(this.joueur == defenseur.getJoueur()) {
			System.out.println("Vous ne pouvez pas attaquer votre propre flotte");
		}else{
			this.setMovementPointLeft(this.movementPointLeft-1);
			//defenseur subi les degats
			defenseur.setVie(defenseur.getVie()-this.getAttaque());
			System.out.println("Le vaisseau défenseur a subi "+this.getAttaque()+" il lui reste : "+defenseur.getVie()+" points de vie.");
			//defenseur meurt
			if(defenseur.getVie()<=0) {
				defenseur.setVie(0);
				//recupere ressources
				System.out.println(defenseur.getType().getName()+"du joueur"+defenseur.getJoueur()+"est détruit.");
				if((this.getRessources()+defenseur.getRessources())>this.getCapacity()) {
					System.out.println("Le vaisseau du joueur "+this.getJoueur()+"a récupéré "+(this.getCapacity()-this.getRessources())+" débris!");
					this.setRessources(this.getCapacity());				
				}else {
					System.out.println("Le vaisseau du joueur "+this.getJoueur()+"a récupéré "+defenseur.getRessources()+" débris!");
					this.setRessources(this.getRessources()+defenseur.getRessources());
				}		
				//defenseur supprimé
				defenseur.setMovementPointLeft(0);
				defenseur.setMovementPoint(0);
				defenseur.setAttaque(0);
				defenseur.setName("☠");
				Map.deleteEntities(defenseur);
			}else {
				//attaquant subi les dégats.
				this.setVie(this.getVie()-(int)(defenseur.getAttaque()/3));
				System.out.println("Le vaisseau attaquant a subi "+(int)(defenseur.getAttaque())/3+" il lui reste "+this.getVie()+" points de vie");
				//attaquant meurt
				if(this.getVie()<=0){
					this.setVie(0);
					System.out.println(this.getType().getName()+"du joueur"+this.getJoueur()+"est détruit.");
					//recupere les ressources
					if((defenseur.getRessources()+this.getRessources())>defenseur.getCapacity()) {
						System.out.println("Le vaisseau du joueur "+defenseur.getJoueur()+"a récupéré "+(defenseur.getCapacity()-defenseur.getRessources())+" débris!");
						this.setRessources(this.getCapacity());	
					}else {
						defenseur.setRessources(defenseur.getRessources()+this.getRessources());
						System.out.println("Le vaisseau du joueur "+defenseur.getJoueur()+"a récupéré "+this.getRessources()+" débris!");
						//supprime le vaisseau de l'attaquant
						this.setMovementPointLeft(0);
						this.setMovementPoint(0);
						this.setAttaque(0);
						this.setName("☠");
						Map.deleteEntities(this);
					}
				}
			}
		}
	}


	public void deposDebris(PlaneteJoueur p) {
		if(p.getJoueur() != this.joueur) {
			System.out.println("Ce n'est pas votre planète");
		}
		else {
			System.out.println("Vous déposez " + this.getRessources() + " débris sur votre planète");
			p.setRessources(p.getRessources() + this.getRessources());
			this.setRessources(0);
		}
		try{System.in.read();}
		catch(Exception e){}

	}

	public void aterissagePlaneteRandom(PlaneteRandom p) {
		System.out.println("Vous atterissez sur " + p.getName());
		if(p.getRecharge() < 5) {
			System.out.println("Malheureusement la plan�te est vide, vous repartez");
			try{System.in.read();}
			catch(Exception e){}
		}
		else {
			System.out.println("Vous trouvez " + p.getRessources() + " d�bris");
			if(this.ressources == this.capacity) {
				System.out.println("Votre soute est déjà pleine, vous redecollez...");
			}
			else if(p.getRessources() > this.getCapacity() - this.ressources) {
				System.out.println("Malheureusement vous ne pouvez en prendre que " + (this.getCapacity() - this.ressources) + " car vous n'avez pas assez de place dans votre soute" );
				this.ressources = this.getCapacity();
				p.setRessources(p.getRessources() - this.getCapacity() - this.ressources);
			}
			else {
				this.ressources = this.ressources + p.getRessources();
				p.setRecharge(0);
			}
			try{System.in.read();}
			catch(Exception e){}
		}
		this.movementPointLeft --;

	}


	public String toString() {
		return this.getIcone() + "";
	}
}
