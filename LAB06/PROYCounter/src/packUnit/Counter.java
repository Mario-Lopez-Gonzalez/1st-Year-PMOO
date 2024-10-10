package packUnit;


public class Counter {
	private int count;
	
	/**
	 * Constructs the initial counter with 0 value
	 */
	public Counter() {
		count=10;
	}
	
	/**
	 * Increments the counter in 1 and returns the new value
	 * @return counter's new value
	 */
	public int increment() {
        count=count+1;
        return count;	
    }
	
	/**
	 * Decrements the counter in 1 and returns the new value
	 * @return counter's new value
	 */
	public int decrement() {	
		count=count-1; 
		return count;	
    }
	
	/**
	 * Returns the counter value
	 * @return the counter value
	 */
	public int getCount() {   
		return count;       
	}
}
