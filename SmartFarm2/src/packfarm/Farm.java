package packfarm;

import java.util.ArrayList;
import java.util.Collections;

import packfarmanimal.Chicken;

/**
 * Class to manage a SmartFarm with its FarmAnimals and Sensors included
 * @author Mario
 */
public class Farm {
	private final Sensor sensor=new Sensor("ID00");
	private ArrayList<FarmAnimal> farmAnimalSet;
	private ArrayList<Sensor> sensorList;
	private static Farm instance;
	
	/**
	 * Constructor for the Farm class
	 */
	private Farm()
	{
		farmAnimalSet=new ArrayList<FarmAnimal>();
		sensorList=new ArrayList<Sensor>();
	}
	
	/**
	 * Method to create a instance of Farm if there is not already one running
	 * @return Farm the instance created
	 */
	 public static Farm getInstance()
	 {
		 if(instance==null)
			 instance=new Farm();
			 return instance;
	 }
	
	 /**
	  * Method to add a FarmAnimal to Farm, if it is a Chicken it will get a default sensor
	  * @param a the FarmAnimal to be added
	  * @throws IndexOutOfBoundsException if there are no more sensors left
	  */
	 public void addFarmAnimal(FarmAnimal a) throws IndexOutOfBoundsException
	 {
		 if(a instanceof Chicken)
		 {
		 a.setMySensor(this.sensor);
		 farmAnimalSet.add(a);
		 }
		 else
		 {
		 Sensor sensor=sensorList.remove(0);
		 a.setMySensor(sensor);
		 farmAnimalSet.add(a);
		 }
	 }
	 
	 /**
	  * Method to get the amount of FarmAnimals
	  * @return int the amount of FarmAnimals
	  */
	 public int howManyAnimals()
	 {
		 return farmAnimalSet.size();
	 }
	 
	 /**
	  * Method to add a sensor to sensorList
	  * @param sensor Sensor to be added
	  */
	 public void addSensor(Sensor sensor)
	 {
		 sensorList.add(sensor);
	 }
	 
	 /**
	  * Method to get the amount of Sensors
	  * @return int the amount of Sensors
	  */
	 public int howManySensors()
	 {
		 return sensorList.size();
	 }
	 
	 /**
	  * Method to activate FarmAnimal.register in all FarmAnimals
	  */
	 public void register()
	 {
		 for(int i=0;i<this.howManyAnimals();i++)
			 farmAnimalSet.get(i).register();
	 }
	 
	 /**
	  * Method to obtain a list of FarmAnimals who can possibly be sick
	  * @return FarmAnimal[] a list of sick FarmAnimals
	  */
	 public ArrayList<FarmAnimal> obtainPosibblySick()
	 {
		 ArrayList<FarmAnimal> list= new ArrayList<FarmAnimal>();
		 for(int i=0;i<farmAnimalSet.size();i++)
		 {
			 if(farmAnimalSet.get(i).possiblySick())
				 list.add(farmAnimalSet.get(i));
		 }
		 return list;
	 }
	 
	 /**
	  * Method to obtain the FarmAnimal requested
	  * @param FarmAnimal the FarmAnimal requested
	  * @return FarmAnimal the FarmAnimal found
	  */
	 public FarmAnimal obtainFarmAnimal(FarmAnimal farmAnimal)
	 {
		 int i=0;
		 boolean found=false;
		 while(i<farmAnimalSet.size()&&!found)
		 {
			 if(farmAnimalSet.get(i).equals(farmAnimal))
				 found=true;
		 }
		 return farmAnimal;
	 }
	 
	 /**
	  * Method to remove a FarmAnimal 
	  * @param farmAnimal FarmAnimal to be removed
	  * @return FarmAnimal removed FarmAnimal
	  */
	 public FarmAnimal removeFarmAnimal(FarmAnimal farmAnimal)
	 {
		 int i=0;
		 boolean found=false;
		 while(i<farmAnimalSet.size()-1&&!found)
		 {
			 if(farmAnimalSet.get(i).equals(farmAnimal)) {
				 found=true;
			 	 i--;
			 	 }
			 i++;
		 }
		 if(!(farmAnimal instanceof Chicken))
		 sensorList.add(farmAnimalSet.get(i).getMySensor());
		 return farmAnimalSet.remove(i);
	 }
	 
	 /**
	  * Method to return a list of FarmAnimals whose age is strictly older than the given age
	  * @param age int the given age
	  * @return ArrayList<FarmAnimal> list of FarmAnimals older than the given age
	  */
	 public ArrayList<FarmAnimal> obtainFarmAnimalOlder(int age)
	 {
		 ArrayList<FarmAnimal> list=new ArrayList<FarmAnimal>();
		 for(int i=0;i<farmAnimalSet.size();i++)
		 {
			 if(farmAnimalSet.get(i).getAge()>age)
			 {
				 list.add(farmAnimalSet.get(i));
			 }
		 }
		 return list;
	 }
	 
	 /**
	  * Method to release all animals whose departure requirements are met and adds their Sensors back if they are not a Chicken
	  * @return String[] list of the released animals' ids (including the Chickens')
	  */
	 public ArrayList<String> farmAnimalsDeparture()
	 {
		 ArrayList<String> list= new ArrayList<String>();
		 for(int i=0;i<farmAnimalSet.size();i++)
		 {
			 if(farmAnimalSet.get(i).departure())
			 {
				 list.add(farmAnimalSet.get(i).getId()+"\n");
			     if(!(farmAnimalSet.get(i) instanceof Chicken))
			 	 sensorList.add(farmAnimalSet.get(i).getMySensor());
			 	 farmAnimalSet.remove(i);
			 }
		 }
		 return list;
	 }
	 
	 /**
	  * Method to reset the current instance of Farm
	  */
	 public void reset() {
		 instance=null;
	 }
	 
 	/**
	 * Method to sort FarmAnimals by id
	 */
	public void sort()
	{
		Collections.sort(farmAnimalSet);
	}
	
	/**
	 * Method to print by console all the FarmAnimals in the Farm
	 */
	public void whoIsInFarm()
	{
		System.out.println("Animals in the farm:");
		System.out.println(farmAnimalSet);
		//TODO arreglar el toString de lo que quede raro
	}
	
	/**
	 * Method to calculate the anual cost of all the Farm
	 * @return double, the anual cost of the Farm
	 */
	public double calculateAnualCost()
	{
		double sum=0;
		for(int i=0;i<farmAnimalSet.size();i++)
			sum+=farmAnimalSet.get(i).calculateAnualCost();
		return sum;
	}
	
	/**
	 * Method to know the amount of animals which are ecological
	 * @return int, the amount
	 */
	public int farmEcologicalAnimalAccount()
	{
		int sum=0;
		for(int i=0;i<farmAnimalSet.size();i++)
			if(farmAnimalSet.get(i).isEcological())
			sum++;
		return sum;
	}
}
