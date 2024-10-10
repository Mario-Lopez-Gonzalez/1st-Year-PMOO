package packsupermarket;

import packproduct.*;
import packstock.*;
import packstock.Stock.UnknownCodeException;
import packproduct.*;
/**
 * Demo class to test the implementation of Product and Stock
 * @author PMOO teachers
 * @version v1
 */
public class SuperOnline {
	/**
	 * Test
	 * @param args void
	 */
	public static void main(String[] args) {
		Stock ins = new Stock();
		Product p1 = new Product(ins.getNextCode(), "banana", 2.3, 1, 0.04);
		ins.addProduct(p1);
		
		try
		{ins.updateAmount(1, -10);}
		catch (NegativeNumberException e)
		{System.out.println("ERROR:Trying to add a negative amount");}	
		catch (Stock.UnknownCodeException e)
		{System.out.println("ERROR:Trying to access nonexistent code");}
		
        try
        {ins.updateAmount(-12, 10);}
        catch (NegativeNumberException e)
		{System.out.println("ERROR:Trying to add a negative amount");}
		catch (Stock.UnknownCodeException e)
		{System.out.println("ERROR:Trying to access nonexistent code");}
        
		p1 = new Product(ins.getNextCode(), "milk", 1, 3, 0.04);
		System.out.println(ins.toString());
			
		try{ins.removeProduct(1);}
		catch (Stock.UnknownCodeException e)
		{System.out.println("ERROR:Trying to access nonexistent code");}
		
		Product p2 = new Product(ins.getNextCode(), "gel_ducha", 1.58, 100, 0.21);
		Product p3 = new Product(ins.getNextCode(), "alitas_de_pollo", 2.13, 40, 0.1);
		Product p4 = new Product(ins.getNextCode(), "oro", 1489.99, 2, 0.45);
		ins.addProduct(p2);
		ins.addProduct(p3);
		ins.addProduct(p4);
		System.out.println(ins.toString());
		
		try{ins.removeProduct(p4);}
		catch (Stock.UnknownCodeException e)
		{System.out.println("ERROR:Trying to access nonexistent code");}
		System.out.println(ins.toString());
		ins.storeStockInFile();

		try {
			Product get= ins.obtainProduct(p3.getCode()-1);
			System.out.println(get.toString());
		} catch (UnknownCodeException e) {
			System.out.println(e);
		}
		
		try {
			Product get= ins.obtainProduct(-1);
			System.out.println(get.toString());
		} catch (UnknownCodeException e) {
			System.out.println(e);
		}
;
	}

}
