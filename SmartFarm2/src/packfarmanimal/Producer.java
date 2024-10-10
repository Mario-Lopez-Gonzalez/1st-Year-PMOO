package packfarmanimal;

import packfarm.FarmAnimal;

/**
 * Subclass of FarmAnimal, Producer
 * @author Mario
 *
 */
public abstract class Producer extends FarmAnimal{

	private String produce;
	private boolean ecological;
	
	public Producer(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor for the Producer parent class
	 * @param id
	 * @param age
	 * @param weight
	 * @param ecological
	 * @param departureAge
	 * @param anualFoodPrice
	 */
	public Producer(String id, int age, double weight, boolean ecological,int departureAge,double anualFoodPrice) {
		super(id, age, weight, departureAge,anualFoodPrice);
		this.ecological=ecological;
	}

	/**
	 * The cost of Producer animals is increased if it is ecological or not
	 */
	public double calculateAnualCost()
	{
		double price=getAnualFoodPrice();
		if(isEcological())
			price*=1.20;
		return price;
	}
	
	/**
	 * Setter for the produce param
	 * @param produce the produce
	 */
	public void setProduce(String produce)
	{
		this.produce=produce;
	}
	
	/**
	 * Method to know the inheritancePath of the class
	 * @return String the path
	 */
	public String inheritancePath()
	{
		return "Producer < FarmAnimal";
	}

	/**
	 * @return the ecological
	 */
	public boolean isEcological() {
		return ecological;
	}
}
