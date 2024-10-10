package packfarm;

/**
 * Class to simulate PhysiologicalValues of FarmAnimal
 * @author Mario
 */
public class PhysiologicalValues {
	private int heartRate;
	private double temperature;
	private int activity;
	
	

	/**
	 * Constructor for the PhysiologicalValues class
	 * @param heartRate int heart rate of the FarmAnimal
	 * @param temperature double temperature of the FarmAnimal
	 * @param activity int activity value (between 1-5) of the FarmAnimal
	 */
	public PhysiologicalValues(int heartRate, double temperature, int activity) {
		this.heartRate = heartRate;
		this.temperature = temperature;
		this.activity = activity;
	}

	/**
	 * @return the heartRate
	 */
	public int getHeartRate() {
		return heartRate;
	}

	/**
	 * @return the temperature
	 */
	public double getTemperature() {
		return temperature;
	}

	/**
	 * @return the activity
	 */
	public int getActivity() {
		return activity;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(heartRate);
		builder.append(" ");
		builder.append(temperature);
		builder.append(" ");
		builder.append(activity);
		return builder.toString();
	}



	
}
