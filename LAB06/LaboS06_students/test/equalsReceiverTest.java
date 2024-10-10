import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mailSystem.Email;

class equalsReceiverTest {
	private Email email1;
	private Email email2;
	private Email email3;
	@BeforeEach
	void setUp() throws Exception {
		email1=new Email("sender","receiver","subject","text");
		email2=new Email("sender","receiver","subject","text");
		email3=new Email("other","other","other","other");
	}
	
	@DisplayName("Verificacion testEqualsReceiver")
	@Test
	void testEqualsReceiver() {
		assertTrue(email1.equalsReceiver(email2),"should have same receiver String");
		assertFalse(email1.equalsReceiver(email3),"should not have same receiver String");
	}

}
