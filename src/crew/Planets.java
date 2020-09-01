package crew;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Planets extends Entities {
	private int ressources;
	private String name;
	
	public void setRessources(int ressources) {
		this.ressources = ressources;
	}


   /** public String nomPlanete() {
=======
    /*public String nomPlanete() {
>>>>>>> branch 'master' of https://gitlab.univ-lille.fr/2020-S3-projet/groupe-23.git
        String csvFile = "~/groupe-23/ressources/name_planets.csv";
        BufferedReader reader = null;
        List<String> lines = new ArrayList<>();
        String line = null;
        try {
            reader = new BufferedReader(new FileReader(csvFile));
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        return lines.get((int) (Math.random() * (40) ));

    }**/

    public int getRessources() {
        return ressources;
    }

    public String getName() {
        return name;
    }

    public Planets(int ressources, String name, int x, int y) {
    	super(x, y);
    }
    /**public Planets(int ressources,String name) {
        super();
        this.ressources = ressources;
        this.setName("toto");
    }**/


    @Override
    public String toString() {
        return "O";
    }

    public void setName(String name) {
        this.name = name;
    }


	
	
}
