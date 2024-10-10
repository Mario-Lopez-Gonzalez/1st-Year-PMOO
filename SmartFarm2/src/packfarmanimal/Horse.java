package packfarmanimal;

import packfarm.FarmAnimal;

/**
 * Subclass of FarmAnimal, Horse
 * @author Mario
 *
 */
public class Horse extends FarmAnimal{

	private String type;
	
	/**
	 * Constructor for the Horse subclass
	 * @param id the id
	 */
	public Horse(String id) {
		super(id);
	}

	/**
	 * DepartureAge for horses is 5 and anualFoodPrice is 3175.5€
	 * @param id the id
	 * @param age the age
	 * @param weight the weight
	 * @param ecological if it is ecological or not
	 * @param type the type
	 */
	public Horse(String id, int age, double weight, String type) {
		super(id, age, weight,5,3175.5);
		this.type=type;
	}
	
	/**
	 * In the case of horses, they cannot be sick
	 */
	public boolean departure()
	{
		return(super.departure()&&possiblySick());
	}
	
	/**
	 * The cost of Horse is increased by its weight
	 */
	public double calculateAnualCost()
	{
		return (getAnualFoodPrice()+(getWeight()*0.01));
	}
	
	/**
	 * Method to know the inheritancePath of the class
	 * @return String the path
	 */
	public String inheritancePath()
	{
		return "Horse < FarmAnimal";
	}
	
	/**
	 * @return the ecological
	 */
	public boolean isEcological() {
		return false;
	}
}
