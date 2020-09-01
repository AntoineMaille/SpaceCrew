package crew;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Planets extends Entities {
	private int ressources;
	private String name;

	public static void main(String[] args) {
		String csvFile = "../../ressources/name_planets.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] country = line.split(cvsSplitBy);

				System.out.println("Country[code= " + country[4] + " , name=" + country[5] + "]");

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}


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
