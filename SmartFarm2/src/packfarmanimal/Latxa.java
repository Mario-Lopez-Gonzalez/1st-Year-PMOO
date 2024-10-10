package packfarmanimal;

/**
 * Subclass of Sheep, Latxa
 * @author Mario
 *
 */
public class Latxa extends Sheep {

	public Latxa(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public Latxa(String id, int age, double weight, boolean ecological) {
		super(id, age, weight,ecological,"milk");
		// TODO Auto-generated constructor stub
	}

	/**
	 * Method to know the inheritancePath of the class
	 * @return String the path
	 */
	public String inheritancePath()
	{
		return "Latxa < Sheep < Producer < FarmAnimal";
	}
}
