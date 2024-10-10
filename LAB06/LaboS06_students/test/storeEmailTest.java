import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mailSystem.Email;
import mailSystem.MailServer;

class storeEmailTest {
	private MailServer mServer;
	private Email email1;
	private Email email2;
	private ArrayList<Email> list;
	@BeforeEach
	void setUp() throws Exception {
		email1=new Email("Ainhoa", "Yeray","Weekend plan");
		email2=new Email("Yaiza", "Yeray","Meeting Schedule");
		mServer= new MailServer();
		list= new ArrayList<Email>();
	}

	@Test
	void testStoreEmail() {
		mServer.storeEmail(email1);
		assertEquals(mServer.getNumEmails(),1,"Email amount after adding should be 1");
		mServer.storeEmail(email2);
		assertEquals(mServer.getNumEmails(),2,"Email amount after adding should be 2");
	}
	

}
