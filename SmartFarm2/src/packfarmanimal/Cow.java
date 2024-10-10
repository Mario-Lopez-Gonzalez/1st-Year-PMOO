package packfarmanimal;

/**
 * Subclass of Producer, Cow
 * @author Mario
 *
 */
public class Cow extends Producer {

	public Cow(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	/**
	 * DepartureAge for cows is 20 and anualFoodPrice is 492.75€
	 * @param id
	 * @param age
	 * @param weight
	 * @param sensor
	 * @param ecological
	 */
	public Cow(String id, int age, double weight,boolean ecological) {
		super(id, age, weight, ecological,20,492.75);
		setProduce("milk");
	}
	
	/**
	 * Method to know the inheritancePath of the class
	 * @return String the path
	 */
	public String inheritancePath()
	{
		return "Cow < Producer < FarmAnimal";
	}
}
