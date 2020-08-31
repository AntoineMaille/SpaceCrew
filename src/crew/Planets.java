package crew;

public class Planets extends Entities {
	private int ressources;
	private String name;
	
	
	public int getRessources() {
		return ressources;
	}

	public String getName() {
		return name;
	}
	
	public Planets(int ressources, String name) {
		super();
		this.ressources = ressources;
		this.name = name;
	}

	public Planets() {
		
	}

	@Override
	public String toString() {
		return "O";
	}
	
	
}
