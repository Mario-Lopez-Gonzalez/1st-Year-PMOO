package packfarm;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import packfarm.Sensor.CollectErrorException;

/**
 * Superclass FarmAnimal
 * @author Mario
 *
 */
public abstract class FarmAnimal implements Comparable<FarmAnimal>{
	private final String id;
	private int age;
	private double weight;
	private Sensor mySensor;
	private PhysiologicalValues[] myValues;
	private final int MAX=7;
	private int nmbValues=0;
	private double usualTemperature;
	private int departureAge;
	private double anualFoodPrice;
	/**
	 * Constructor for the FarmAnimal class
	 * @param id the id
	 */
	public FarmAnimal(String id)
	{
		this.id=id;
		myValues= new PhysiologicalValues[MAX];
	}
	
	/**
	 * @param id the id
	 * @param age the age
	 * @param weight the weight
	 * @param ecological if it is ecological or not
	 * @param departureAge the departure age
	 * @param anualFoodPrice the anual food price
	 */
	public FarmAnimal(String id, int age, double weight,int departureAge,double anualFoodPrice) {
		this(id);
		this.age = age;
		this.weight = weight;
		this.departureAge=departureAge;
		this.anualFoodPrice=anualFoodPrice;
		usualTemperature=39;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * Returns the Physiological values of the requested day of the week, STARTING FROM 0
	 * @param day int day of the week requested
	 * @return PhysiologicalValues values registered the requested day
	 */
	public PhysiologicalValues getMyValues(int day){
		return myValues[day];
	}
	
	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return Sensor the Sensor
	 */
	public Sensor getMySensor() {
		return mySensor;
	}
	
	/**
	 * @return nbmValues the nbmValues
	 */
	public int getNmbValues()
	{
		return nmbValues;
	}
	/**
	 * @param mySensor the mySensor to set
	 */
	public void setMySensor(Sensor mySensor) {
		this.mySensor = mySensor;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("id=");
		builder.append(id);
		builder.append(" age=");
		builder.append(age);
		builder.append(" weight=");
		builder.append(weight);
		builder.append(" mySensor=");
		builder.append(mySensor);
		builder.append(" myValues=");
		builder.append(Arrays.toString(myValues));
		builder.append(" usualTemperature=");
		builder.append(usualTemperature);
		builder.append(" departureAge=");
		builder.append(departureAge);
		builder.append(" anualFoodPrice=");
		builder.append(anualFoodPrice);
		builder.append("\n");
		return builder.toString();
	}

	/**
	 * Method to try to get one set of values for myValues, if reached MAX, myValues will be reset and its info stored in a txt file
	 * @return PhysiologicalValues the values added to myValues
	 */
	public PhysiologicalValues register()
	{
		if(nmbValues>=MAX)
		{
			this.storeValuesInFile();
			this.initWeek();
		}
		int i=0;
		while(i<1)
		{
			try {
				myValues[nmbValues]=mySensor.collectValues(usualTemperature);
				i++;
				nmbValues++;
			} catch (CollectErrorException e) {
			}
		}
		return myValues[nmbValues-1];
		}
	
	/**
	 * Private Method to store in a text file the previous values of myValues before overwriting it
	 */
	private void storeValuesInFile() {
		FileWriter fw;
		try
		{
			fw= new FileWriter("./data/historicalValues.txt",true);
			fw.write(this.getId().toString()+" "+this.getAge()+" "+this.getWeight()+":"+"\n"+"\n");
			for(int i=0;i<MAX;i++)
			fw.write(myValues[i].toString()+"\n");
			fw.write("\n");
			fw.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Method to initialize myValues
	 */
	private void initWeek()
	{
		nmbValues=0;
	}
	
	/**
	 * Method to get the average temperature of the FarmAnimal
	 * @return double the average temperature
	 */
	public double avgTemperature()
	{
		int sum=0;
		int i;
		double avg=0;
		for(i=0;i<nmbValues;i++)
		{
			sum+=myValues[i].getTemperature();
		}
		if(i!=0)
			avg=sum/i;
		return avg;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		FarmAnimal alt= (FarmAnimal)obj;
		return (this.id.equals(alt.getId()));
	}

	/**
	 * @return the usualTemperature
	 */
	public double getUsualTemperature() {
		return usualTemperature;
	}

	/**
	 * @return the departureAge
	 */
	public int getDepartureAge() {
		return departureAge;
	}

	/**
	 * @return the anualFoodPrice
	 */
	public double getAnualFoodPrice() {
		return anualFoodPrice;
	}
	
	/**
	 * Method to know if an animal is sick
	 * @return boolean true if animal's avgTemperature is 1.5ºC lower or higher that its usualTemperature
	 */
	public boolean possiblySick()
	{
		return (avgTemperature()<=usualTemperature-1.5||avgTemperature()>=usualTemperature+1.5);
	}
	
	/**
	 * Method to know if an animal can get out of the Farm
	 * @return boolean true if age of animal is greater or equal to its departureAge, exception for Horse and Pig
	 */
	public boolean departure()
	{
		return (age >= departureAge);
	}
	
	/**
	 * Method to know how much does it cost to keep the animal anually
	 * @return double the maintenance cost of the animal = anualFoodPrice + extras
	 */
	public double calculateAnualCost()
	{
		return anualFoodPrice;
	}

	/**
	 * @param usualTemperature the usualTemperature to set
	 */
	public void setUsualTemperature(double usualTemperature) {
		this.usualTemperature = usualTemperature;
	}
	
	public int compareTo(FarmAnimal a)
	{
		return id.compareToIgnoreCase(a.getId());
	}
	
	public abstract String inheritancePath();
	
	/**
	 * @return the ecological
	 */
	public abstract boolean isEcological();
}
