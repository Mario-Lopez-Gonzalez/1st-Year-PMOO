package packsimulator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import packfarm.Farm;
import packfarm.FarmAnimal;
import packfarm.Sensor;
import packfarmanimal.Chicken;
import packfarmanimal.Cow;
import packfarmanimal.Horse;
import packfarmanimal.Latxa;
import packfarmanimal.Pig;
import packfarmanimal.WoolSheep;

/**
 * Class to test the second part of the project
 * @author Mario
 *
 */
public class farmSimulatorHierarchy {

	private static Farm farm=Farm.getInstance();
	
	/**
	 * Main program
	 * @param args ignore this
	 */
	public static void main(String[] args) {
		loadSensors();
		initializeFarmAnimals();
		farm.whoIsInFarm();
		for(int i=0;i<7;i++)
			farm.register();
		System.out.println("Sick Animals:");
		ArrayList<FarmAnimal>sickAnimals=farm.obtainPosibblySick();
		for(int i=0;i<sickAnimals.size();i++)
		{
			System.out.println(sickAnimals.get(i));
			System.out.println(sickAnimals.get(i).inheritancePath());
		}
		farm.sort();
		farm.whoIsInFarm();
		System.out.println("Anual cost of the farm:");
		System.out.println(farm.calculateAnualCost());
		System.out.println("Number of sensors:");
		System.out.println(farm.howManySensors());
		System.out.println("Animals which are leaving the farm:");
		System.out.println(farm.farmAnimalsDeparture());
		System.out.println("Number of sensors:");
		System.out.println(farm.howManySensors());
	}

	/**
	 * Method to load all Sensors from the availableSensors.txt stored in the data folder into the current Farm instance
	 */
	public static void loadSensors()
	{
			int count=0;
			Scanner sc;
			try {
				sc = new Scanner(new FileReader("./data/availableSensors.txt"));
				while(sc.hasNext())
				{
					String id;
					id=sc.nextLine();
					Sensor temp= new Sensor(id);
					farm.addSensor(temp);
					count++;
				}
				sc.close();
				System.out.println("Amount of Sensors loaded: "+count);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * Method to initialize test FarmAnimals
	 */
	public static void initializeFarmAnimals() {
		// 5 chickens (3 ecological and two not ecological. In general of 1 year old but 1 of 4
		farm.addFarmAnimal(new Chicken("CHI34", 1, 1.5, true));
		farm.addFarmAnimal(new Chicken("CHI35", 1, 1.5, true));
		farm.addFarmAnimal(new Chicken("CHI36", 1, 1.5, true));
		farm.addFarmAnimal(new Chicken("CHI37", 4, 1.5, false));
		farm.addFarmAnimal(new Chicken("CHI38", 1, 1.5, false));

		// 2 ecological Latxa sheep and 2 non-ecological WoolSheep, about 45 kilos and 3-5 years old. One of them of 12 years old
		farm.addFarmAnimal(new Latxa("SHE80", 5, 48, true));
		farm.addFarmAnimal(new Latxa("SHE81", 3, 46, true));
		farm.addFarmAnimal(new WoolSheep("SHE82", 12, 45, false));
		farm.addFarmAnimal(new WoolSheep("SHE83", 4, 44, false));

		// 5 cows of about 450-600 kilos and of about 15 years (one of 20 years), 3 ecological and 2 not ecological
		farm.addFarmAnimal(new Cow("COW51", 18, 446, true));
		farm.addFarmAnimal(new Cow("COW52", 16, 500, true));
		farm.addFarmAnimal(new Cow("COW53", 15, 470, true));
		farm.addFarmAnimal(new Cow("COW54", 11, 550, false));
		farm.addFarmAnimal(new Cow("COW55", 10, 600, false));

		// 3 pigs with id "PIG"+n of all between 80 and 200 kilos, all of them of 1 year old, two of them ecological
		farm.addFarmAnimal(new Pig("PIG91", 1, 80, true));
		farm.addFarmAnimal(new Pig("PIG92", 1, 150, true));
		farm.addFarmAnimal(new Pig("PIG93", 1, 200, false));
		// 3 horses, one of each type, with identifiers "HOR"+n, 7 years old the ones of ride and show types,
		//  and the work type of 10 years old. Approximate weight 300-400 kilos
		farm.addFarmAnimal(new Horse("HOR41", 7, 340, "show"));
		farm.addFarmAnimal(new Horse("HOR42", 7, 380, "ride"));
		farm.addFarmAnimal(new Horse("HOR43", 10, 400, "work"));
	}
}
