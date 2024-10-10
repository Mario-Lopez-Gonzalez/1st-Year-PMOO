package packstock;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StockSingletonTest {
	StockSingleton ins;
	@BeforeEach
	void setUp() throws Exception {
		ins=StockSingleton.getInstance();
	}
	@AfterEach
	void tearDown()
	{
		ins.reset();
	}

	@Test
	void testGetNextCode1() {
		assertEquals(1,ins.getNextCode());
	}

	@Test
	void testGetNextCode2() {
		ins.getNextCode();
		assertEquals(2,ins.getNextCode());
	}
}
