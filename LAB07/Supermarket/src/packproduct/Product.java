package packproduct;

/**
 * Class that represents Products
 * @author PMOO teachers
 * @version v1
 */
public class Product {
	private int code;
	private String name;
	private double price;
	private int amount;
	private final double VAT;
	
	/**
	 * Empty contructor for the Product class
	 */
	public Product()
	{
		this(0,"",0,0,0);
	}
	
	/**
	 * Constructor for the Product class with parameters
	 * @param code code of Product
	 */
	public Product(int code)
	{
		this(code,"",0,0,0);
	}
	/**
	 * Constructor for the Product class with parameters
	 * @param code code of Product
	 * @param name name of Product
	 * @param price price of Product
	 * @param amount amount of Product
	 * @param vAT VAT of Product
	 */
	public Product(int code, String name, double price, int amount, double vAT) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.amount = amount;
		VAT = vAT;
	}

	/**
	 * Getter for the Product class
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * Setter for the Product class
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * Getter for the Product class
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for the Product class
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for the Product class
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Setter for the Product class
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Getter for the Product class
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * Setter for the Product class
	 * @param amount the amount to set
	 * @throws NegativeNumberException negative amount
	 */
	public void setAmount(int amount) throws NegativeNumberException{
		if(amount<0)
		{throw new NegativeNumberException("ERROR: Negative amount");}
		this.amount = amount;
	}

	/**
	 * Getter for the Product class
	 * @return the vAT
	 */
	public double getVAT() {
		return VAT;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(code);
		builder.append(" ");
		builder.append(name);
		builder.append(" ");
		builder.append(price);
		builder.append(" ");
		builder.append(amount);
		builder.append(" ");
		builder.append(VAT);
		return builder.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		Product other = (Product) obj;
			return (code == other.code);
	}
	
}
