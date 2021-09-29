package packsimulator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import packfarm.*;

/**
 * Class to simulate a SmartFarm
 * @author Mario
 */
public class FarmSimulator {
	
	private static Farm farm= Farm.getInstance();
	public static void main(String[] args)
	{
		fileDeleter(); //Deletes previous attempt of HistoricalValues.txt
		loadSensors();
		loadFarmAnimals();
		System.out.println("Amount of animals older than 17: "+farm.obtainFarmAnimalOlder(17).size());
		registerOlder(17);
		for(int i=0; i<7;i++)
		{
			farm.register();
		}
		System.out.println("Amount of sensors available: "+farm.howManySensors());
		System.out.println("This animal was removed: "+farm.removeFarmAnimal("BOV128"));
		System.out.println("Amount of sensors available: "+farm.howManySensors());
		farm.addFarmAnimal("XXXX", 1, 1);
		System.out.println("Animals whose average temperature is over 102ºF: "+farm.obtainPosibblySick(102));
		System.out.println("Animals whose weight is over 500 and whose average temperature is below 102ºF"
				+ ", which are to be released: "
				+farm.farmAnimalsDeparture(500, 102));
		System.out.println("Amount of sensors available: "+farm.howManySensors());
		farm.reset();
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
	 * Method to add all FarmAnimal info available in data/smartFarm.txt (data has to be String id, int age and double weight)
	 */
	public static void loadFarmAnimals()
	{
		Scanner sc;
		try {
			sc = new Scanner(new FileReader("./data/smartFarm.txt"));
			while(sc.hasNext())
			{
				String[] string= sc.nextLine().split(" ");
				String id=string[0];
				int age=Integer.parseInt(string[1]);
				double weight=Double.parseDouble(string[2]);
				farm.addFarmAnimal(id, age, weight);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to register PhysiologicalValues of all FarmAnimals older than the given age
	 * @param age int given age
	 */
	private static void registerOlder(int age)
	{
		ArrayList<FarmAnimal> list=farm.obtainFarmAnimalOlder(age);
		for(int i=0; i<list.size();i++)
		{
			list.get(i).register();
		}
	}

	/**
	 * Method to delete a previous creation of historicalValues.txt, if it exists
	 */
	private static void fileDeleter()
	{     
		try  
		{         
		File f= new File("./data/HistoricalValues.txt"); 
		if(f.delete()) 
		System.out.println(f.getName() + " deleted"); 
		else  
		System.out.println("failed");  
		}  
		catch(Exception e)  
		{  
		e.printStackTrace();  
		}}} 
