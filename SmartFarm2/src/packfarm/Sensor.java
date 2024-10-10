package packfarm;

import java.util.Random;

/**
 * Class to get PhysiologicalValues for FarmAnimal 
 * @author Mario
 */
public class Sensor {
	private String id;
		
	/**
	 * Constructor for the Sensor class
	 * @param id String id given to the Sensor
	 */
	public Sensor(String id) {
		this.id=id;
	}

	/**
	 * Simulates physiological values collection with potential failure
	 * 
	 * @return collected physiological values
	 * @throws CollectErrorException when it is not possible to return the values
	 */
	private PhysiologicalValues collect(double temp) throws CollectErrorException {
		Random r = new Random();

		int heartRate = 0;
		double temperature = 0.0;
		int activity = 0;

		heartRate = 60 + r.nextInt(20);

		temperature = temp + r.nextDouble()*2;
		temperature = Double.parseDouble(String.format("%.2f", temperature).replace(',', '.'));

		activity = r.nextInt(5) + 1;

		PhysiologicalValues phy = new PhysiologicalValues(heartRate, temperature, activity);

		if (Math.random() >= 0.9)
			throw new CollectErrorException(phy.toString());

		return phy;
	}
	
	/**
	 * Method to randomly collect physiological values of FarmAnimal
	 * @return PhysiologicalValues are values of animal (temp, heart rate, activity)
	 * @throws CollectErrorException when an error is collected
	 */
	public PhysiologicalValues collectValues(double temp) throws CollectErrorException
	{
			return this.collect(temp);
	}
	
	@SuppressWarnings("serial")
	public class CollectErrorException extends Exception {

		/**
		 * Constructor for the CollectErrorException class
		 * @param message String to be returned along with the exception
		 */
		public CollectErrorException(String message) {
			super(message);
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(id);
		return builder.toString();
	}
}

