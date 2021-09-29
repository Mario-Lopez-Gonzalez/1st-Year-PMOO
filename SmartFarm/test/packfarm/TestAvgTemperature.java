package packfarm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestAvgTemperature {
	static FarmAnimal a1;
	@BeforeEach
	void setUp() throws Exception {
		a1=new FarmAnimal("A",1,1,new Sensor("TEST"));
	}

	@Test
	void testAvgTemperatureNoRegister() {
		assertEquals(0,a1.avgTemperature());
	}

	@Test
	void testAvgTemperatureOneRegister() {
		a1.register();
		assertEquals(avg(1),a1.avgTemperature());
	}
	
	@Test
	void testAvgTemperatureFourRegister() {
		for(int i=0;i<4;i++)
			a1.register();
		assertEquals(avg(4),a1.avgTemperature());
	}
	
	@Test
	void testAvgTemperatureSevenRegister() {
		for(int i=0;i<7;i++)
			a1.register();
		assertEquals(avg(7),a1.avgTemperature());
	}
	
	@Test
	void testAvgTemperatureFullWeek() {
		for(int i=0;i<8;i++)
			a1.register();
		assertEquals(avg(1),a1.avgTemperature());
	}
	
	/**
	 * Private auxiliar method to get an average of temperatures manually
	 * @param x int number of elements, DO NOT ENTER 0
	 * @return the average of temperatures
	 */
	private static int avg(int x) {
		int sum=0;
		for(int i=0;i<x;i++)
			sum+=a1.getMyValues(i).getTemperature();
		return sum/x;
	}
}
