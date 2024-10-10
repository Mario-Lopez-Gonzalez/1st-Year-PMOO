package packfarmanimal;


/**
 * Subclass of Producer, Sheep
 * @author Mario
 *
 */
public abstract class Sheep extends Producer {

	public Sheep(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	/**
	 * DepartureAge for sheep is 12 and anualFoodPrice is 133.23€
	 * @param id
	 * @param age
	 * @param weight
	 * @param sensor
	 * @param ecological
	 */
	public Sheep(String id, int age, double weight, boolean ecological, String produce) {
		super(id, age, weight, ecological,12,133.23);
		setProduce(produce);
	}

	/**
	 * Method to know the inheritancePath of the class
	 * @return String the path
	 */
	public String inheritancePath()
	{
		return "Sheep < Producer < FarmAnimal";
	}
}
