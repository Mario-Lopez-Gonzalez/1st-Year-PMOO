package packfarmanimal;

/**
 * Subclass of Producer, Chicken
 * @author Mario
 *
 */
public class Chicken extends Producer {

	public Chicken(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	/**
	 * UsualTemperature for chickens is 42, departureAge is 4 and anualFoodPrice is 547.5€
	 * @param id
	 * @param age
	 * @param weight
	 * @param sensor
	 * @param ecological
	 */
	public Chicken(String id, int age, double weight, boolean ecological) {
		super(id, age, weight,ecological,4,547.5);
		setUsualTemperature(42);
		setProduce("eggs");
	}
	
	/**
	 * Method to know the inheritancePath of the class
	 * @return String the path
	 */
	public String inheritancePath()
	{
		return "Chicken < Producer < FarmAnimal";
	}
}
