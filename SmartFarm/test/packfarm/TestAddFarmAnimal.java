package packfarm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import packsimulator.FarmSimulator;;
class TestAddFarmAnimal {
	private static Farm farm;
	@BeforeEach
	void setUp() throws Exception {
		farm=Farm.getInstance();
		FarmSimulator.loadSensors();
	}

	@AfterEach
	void tearDown() throws Exception {
		farm.reset();
	}
	
	@Test
	void testAddFarmAnimalNoAnimal() {
		assertEquals(0,farm.howManyAnimals());
	}
	
	@Test
	void testAddFarmAnimalOneAnimal() {
		farm.addSensor(new Sensor("TEST"));
		farm.addFarmAnimal("A", 1, 2);
		assertEquals(1,farm.howManyAnimals());
	}
	
	@Test
	void testAddFarmAnimalManyAnimal() {
		FarmSimulator.loadSensors();
		FarmSimulator.loadFarmAnimals();
		System.out.println("ANIMALES"+farm.howManyAnimals());
		System.out.println("SENSORES"+farm.howManySensors());
		assertThrows(IndexOutOfBoundsException.class,()-> {for(int i=0;i<1000000;i++)farm.addFarmAnimal("A", 1, 2);});
	}
}
