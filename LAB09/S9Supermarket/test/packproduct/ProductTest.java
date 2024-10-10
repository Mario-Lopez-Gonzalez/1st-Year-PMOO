package packproduct;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ProductTest {
	Product p1;
	@BeforeEach
	void setUp() throws Exception {
		p1=new Product(1);
	}

	@Test
	void testSetAmountNegative() {
		assertThrows(NegativeNumberException.class,()->{p1.setAmount(-5);});
	}
	
	@Test
	void testSetAmountPositive(){
		try {
			p1.setAmount(5);
		} catch (NegativeNumberException e) {
			fail("Exception unexpected");
		}
		assertEquals(5,p1.getAmount());
	}
	
	@Test
	void testSetAmountZero() {
		try {
			p1.setAmount(0);
		} catch (NegativeNumberException e) {
			fail("Exception unexpected");
		}
		assertEquals(0,p1.getAmount());
	}

}
