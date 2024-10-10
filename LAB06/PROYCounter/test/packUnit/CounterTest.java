package packUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
@DisplayName("Verificaci�n clase Counter")
class CounterTest {
	
	private Counter counter1;
	@BeforeEach
	void setUp() {// Generate the objects to be used in all the test methods
	 counter1 = new Counter();}

	@Test
	@DisplayName("Verificaci�n m�todo testIncrement")
	void testIncrement() {
		assertEquals(1, counter1.increment(),"esperaba el valor 1");
		 assertEquals(2, counter1.increment());
	}

	@Test
	@DisplayName("Verificaci�n m�todo testDecrement")
	void testDecrement() {
		assertTrue(counter1.decrement() == -1,"esperaba el valor -1");
	}
}
