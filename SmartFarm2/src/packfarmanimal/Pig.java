package packfarmanimal;

import packfarm.FarmAnimal;

/**
 * Subclass of FarmAnimal, Pig
 * @author Mario
 *
 */
public class Pig extends FarmAnimal{

	private boolean ecological;
	/**
	 * Constructor for the Pig subclass
	 * @param id
	 */
	public Pig(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	/**
	 * DepartureAge for pigs is 1 and anualFoodPrice is 134.32€
	 * @param id
	 * @param age
	 * @param weight
	 * @param sensor
	 * @param ecological
	 */
	public Pig(String id, int age, double weight, boolean ecological) {
		super(id, age, weight, 1,134.32);
		this.ecological=ecological;
	}

	/**
	 * In the case of pigs they can leave the farm if they are over 100Kg and cannot be sick
	 */
	public boolean departure()
	{
		return((super.departure()||getWeight()>=100)&&possiblySick());
	}
	
	/**
	 * The cost of Pig is increased by its weight and if it is ecological or not
	 */
	public double calculateAnualCost()
	{
		double price;
		if(isEcological())
			price=(getAnualFoodPrice()+(getWeight()*0.035));
		else
			price=(getAnualFoodPrice()+(getWeight()*0.035))*1.15;
		return price;
	}
	/**
	 * Method to know the inheritancePath of the class
	 * @return String the path
	 */
	public String inheritancePath()
	{
		return "Pig < FarmAnimal";
	}
	
	/**
	 * @return the ecological
	 */
	public boolean isEcological() {
		return ecological;
	}
}
