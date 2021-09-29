package packfarm;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class to manage a SmartFarm with its FarmAnimals and Sensors included
 * @author Mario
 */
public class Farm {
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
	  * Method to add a FarmAnimal to Farm
	  * @param id id of FarmAnimal
	  * @param age age of FarmAnimal
	  * @param weight weight of FarmAnimal
	  * @throws IndexOutOfBoundsException if there are no more sensors left
	  */
	 public void addFarmAnimal(String id, int age, double weight) throws IndexOutOfBoundsException
	 {
		 FarmAnimal animal;
		 Sensor sensor=sensorList.remove(0);
		 animal= new FarmAnimal(id,age,weight,sensor);
		 farmAnimalSet.add(animal);
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
	  * Method to obtain a list of FarmAnimals whose average temperature is above the given threshold
	  * @param max double , the threshold to compare the average temperature with
	  * @return FarmAnimal[] a list of sick FarmAnimals
	  */
	 public ArrayList<FarmAnimal> obtainPosibblySick(double max)
	 {
		 ArrayList<FarmAnimal> list= new ArrayList<FarmAnimal>();
		 for(int i=0;i<farmAnimalSet.size();i++)
		 {
			 if(farmAnimalSet.get(i).avgTemperature()>max)
				 list.add(farmAnimalSet.get(i));
		 }
		 return list;
	 }
	 
	 /**
	  * Method to obtain the FarmAnimal with the specified id
	  * @param id String, id to search for
	  * @return FarmAnimal the FarmAnimal
	  */
	 public FarmAnimal obtainFarmAnimal(String id)
	 {
		 FarmAnimal x=new FarmAnimal("TEMPORAL HANDLER");
		 int i=0;
		 boolean found=false;
		 while(i<farmAnimalSet.size()&&!found)
		 {
			 if(farmAnimalSet.get(i).getId()==id)
				 found=true;
			 	 x=farmAnimalSet.get(i);
		 }
		 return x;
	 }
	 
	 /**
	  * Method to remove a FarmAnimal by id and add its Sensor the the sensorList
	  * @param id String id to search for
	  * @return FarmAnimal removed FarmAnimal
	  */
	 public FarmAnimal removeFarmAnimal(String id)
	 {
		 FarmAnimal x=new FarmAnimal(id);
		 int i=0;
		 boolean found=false;
		 while(i<farmAnimalSet.size()-1&&!found)
		 {
			 if(farmAnimalSet.get(i).equals(x)) {
				 found=true;
			 	 i--;
			 	 }
			 i++;
		 }
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
	  * Method to release all animals whose weight is above and average temperature is below given numbers, and adds their Sensors back
	  * @param weight double given weight threshold
	  * @param temp double given average temperature threshold
	  * @return String[] list of the released animals' ids
	  */
	 public ArrayList<String> farmAnimalsDeparture(double weight,double temp)
	 {
		 ArrayList<String> list= new ArrayList<String>();
		 for(int i=0;i<farmAnimalSet.size();i++)
		 {
			 if(farmAnimalSet.get(i).avgTemperature()<temp&&farmAnimalSet.get(i).getWeight()>weight)
				 list.add(farmAnimalSet.get(i).getId()+"\n");
			 	 sensorList.add(farmAnimalSet.get(i).getMySensor());
			 	 farmAnimalSet.remove(i);
		 }
		 return list;
	 }
	 
	 /**
	  * Method to reset the current instance of Farm
	  */
	 public void reset() {
		 instance=null;
	 }
}
