package packfarm;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRegister {
	FarmAnimal a1;
	@BeforeEach
	void setUp() throws Exception {
		a1=new FarmAnimal("A",1,1,new Sensor("TEST"));
	}

	@Test
	void testRegisterNoRegister() {
	  assertEquals(0,a1.getNmbValues()); 
	}
	
	@Test
	void testRegisterFirstRegister() {
		assertEquals(a1.register(),a1.getMyValues(0));
	}
	
	@Test
	void testRegisterFourthRegister() {
		for(int i=0;i<3;i++)
		a1.register();
		assertEquals(a1.register(),a1.getMyValues(3));
	}
	
	@Test
	void testRegisterSeventhRegister() {
		for(int i=0;i<6;i++)
		a1.register();
		assertEquals(a1.register(),a1.getMyValues(6));
	}
	
	@Test
	void testRegisterFullWeek() {
		for(int i=0;i<7;i++)
		a1.register();
		assertEquals(a1.register(),a1.getMyValues(0));
	}
}
