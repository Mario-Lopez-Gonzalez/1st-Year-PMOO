package packstock;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import packproduct.NegativeNumberException;
import packproduct.Product;
import packstock.StockSingleton.UnknownCodeException;

class StockSingletonTestObtainProduct {
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
	void testObtainProductExists() {
		p1= new Product(1);
		ins.addProduct(p1);
		try {
			assertEquals(p1,ins.obtainProduct(1));
		} catch (UnknownCodeException e) {
			fail("Exception unexpected");
		}
	}

	@Test
	void testObtainProductNotExists() {
		assertThrows(UnknownCodeException.class,()->{ins.obtainProduct(-123);});
	}
}
