package packstock;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import packproduct.NegativeNumberException;
import packproduct.Product;

/**
 * Class that allows to represent a Stock composed of Products
 * 
 * @author PMOO teachers
 * @version v1
 */
public class Stock {
	private ArrayList<Product> list;
	private int lastCode;

	/**
	 * Constructor without parameters that initializes the lastCode to 0 and creates
	 * an empty ArrayList of Products
	 */
	public Stock() {
		lastCode = 0;
		list = new ArrayList<Product>();
	}

	/**
	 * Increments the value of lastCode and returns it
	 * 
	 * @return the next code value
	 */
	public int getNextCode() {
		lastCode = lastCode + 1;
		return lastCode;
	}

	/**
	 * Adds a Product to the list
	 * 
	 * @param p the product to be added
	 */
	public void addProduct(Product p) {
		list.add(p);
	}

	/**
	 * Obtains the number of Products in the list
	 * 
	 * @return int number of Products
	 */
	public int numberOfProducts() {
		return list.size();
	}

	/**
	 * Removes the given Product from the list. If the product does not exist, it shows a message
	 * 
	 * @param p Product to be removed
	 * @throws UnknownCodeException code does not exist
	 */
	public void removeProduct(Product p) throws UnknownCodeException {
		if (!(list.remove(p)))
			throw new UnknownCodeException("ERROR: Nonexistent code");
	}

	/**
	 * Removes the product with the given code from the list. If the product does not exist, it shows a message
	 * 
	 * @param code code of Product to be removed
	 * @throws UnknownCodeException code does not exist
	 */
	public void removeProduct(int code) throws UnknownCodeException{
		Product p = new Product(code);
		if (!list.remove(p))
			throw new UnknownCodeException("ERROR: Code does not exist");
	}

	/**
	 * Updates the amount of the product with the given code with the given amount
	 * 
	 * @param code   Code of the Product to be updated
	 * @param amount Amount to set
	 * @throws NegativeNumberException negative amount
	 * @throws UnknownCodeException code does not exist
	 */
	public void updateAmount(int code, int amount) throws UnknownCodeException, NegativeNumberException {
		Product p = new Product(code);
		int pos = list.indexOf(p);
		if (pos != -1) {
			list.get(pos).setAmount(amount);
		}else {
			throw new UnknownCodeException("ERROR: Code does not exist");
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i=0;i<list.size();i++)
		{
			builder.append(list.get(i));
			builder.append("\n");
		}
		return builder.toString();
	}
	
	/**
	 * Class to detect errors when trying to work with negative integers
	 * @author Mario
	 *
	 */
	public class UnknownCodeException extends Exception
	{
	/**
	 * Empty constructor for the UnknownCodeException class
	 */
	public UnknownCodeException() {
		this("");
	}

	/**
	 * Constructor for the UnknownCodeException class with parameters
	 * @param msg message to be shown
	 */
	public UnknownCodeException(String msg) {
		super(msg);
	}
	}
	/**
	 * Method to write in a file the contents of Stock
	 */
	public void storeStockInFile()
	{
		try
		{
		FileWriter fw=new FileWriter("C:\\Users\\Mario\\Desktop\\CLASE\\PMOO\\Supermarket\\data\\"+"Stock");
		for(int i=0;i<list.size();i++)
		{
		fw.write(list.get(i).toString());
		fw.write("\n");
		}
		fw.close();
		}
		catch(IOException e) {System.out.println("ERROR: File could not be written");}
	}
	
	/**
	 * Method to return a Product with a given code
	 * @param code code of Product
	 * @return Product
	 * @throws UnknownCodeException code does not exist
	 */
	public Product obtainProduct(int code) throws UnknownCodeException
	{
		int i;
		boolean found=false;
		for(i=0;i<list.size()-1&&!found;i++)
		{
			if(code==list.get(i).getCode())
				found=true;
		}
		if(!found)
			throw new UnknownCodeException("ERROR:Nonexistent code");
		return list.get(i);
	}
}
