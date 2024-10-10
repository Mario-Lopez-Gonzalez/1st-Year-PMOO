package packfarmanimal;

/**
 * Subclass of Sheep, Latxa
 * @author Mario
 *
 */
public class WoolSheep extends Sheep {

	public WoolSheep(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public WoolSheep(String id, int age, double weight, boolean ecological) {
		super(id, age, weight, ecological,"whool");
		// TODO Auto-generated constructor stub
	}

	/**
	 * Method to know the inheritancePath of the class
	 * @return String the path
	 */
	public String inheritancePath()
	{
		return "WoolSheep < Sheep < Producer < FarmAnimal";
	}
}
