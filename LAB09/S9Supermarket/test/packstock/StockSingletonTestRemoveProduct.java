package packstock;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import packproduct.Product;
import packstock.StockSingleton.UnknownCodeException;

class StockSingletonTestRemoveProduct {
	StockSingleton ins;
	Product p1;
	
	@BeforeEach
	void setUp() throws Exception {
		ins=StockSingleton.getInstance();
	}

	@AfterEach
	void tearDown() throws Exception {
		ins.reset();
	}

	@Test
	void testRemoveProductIntExists() {
		p1=new Product(1);
		ins.addProduct(p1);
		try {
			ins.removeProduct(p1);
		} catch (UnknownCodeException e) {
			fail("Unexpected Exception");
		}
		assertFalse(ins.containsProduct(p1));
	}

	@Test
	void testRemoveProductIntNotExists() {
		assertThrows(UnknownCodeException.class,()->{ins.removeProduct(-123);});
	}
}
