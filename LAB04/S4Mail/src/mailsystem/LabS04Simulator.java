package mailsystem;

/**
 * Class for simulating MailServer activity
 * @author PMOO teachers
 *
 */
public class LabS04Simulator {

	/**
	 * Main method
	 * @param args - No parameters required
	 */
	public static void main(String[] args) {
		testEmail();
		testMailServer();
		testMailClient();
	}

	/**
	 * Method to test the Email class
	 */
	public static void testEmail() {
		
		//Create an Email instance using the Constructor with all fields
		Email email1 = new Email("user1", "user2", "Mail subject 1", "Mail text 1");
	
		//Create an email instance using the Constructor with all fields but "text"
		Email email2 = new Email("name2", "name1", "Mail subject 2");
	
		//Use all different getters on email1 and email2
		System.out.println("email1 attributes (by getters):\n");
		System.out.println("Sender: " + email1.getSender());
		System.out.println("Receiver: " + email1.getReceiver());
		System.out.println("Subject: " + email1.getSubject());
		System.out.println("Text: " + email1.getText());
	
		System.out.println("\nemail2 attributes (by getters):");
		System.out.println("Sender: " + email2.getSender());
		System.out.println("Receiver: " + email2.getReceiver());
		System.out.println("Subject: " + email2.getSubject());
		System.out.println("Text: " + email2.getText());

		//Use setter to set text in email2
		email2.setText("Mail text 2 - by setter");
	
		//Check whether the value of the text attribute has changed (by its corresponding setter)
		System.out.println("\nText: " + email2.getText());
		
		//checking equalsReceiver method
		System.out.println("Should be true:"+email1.equalsReceiver(email1));
		System.out.println("Should be false:"+email1.equalsReceiver(email2));
		//Create divide
		System.out.println("---------------------------------------------------------------");
		System.out.println("");
	}
	
	/**
	 * Method to test the MailServer class
	 */
	public static void testMailServer()
	{	
		//Constructors
		MailServer insServer=new MailServer();
		Email email1=new Email("user1","user2","1st Mail","1st Mail's body");
		Email email2=new Email("user1","user2","2nd Mail","2nd Mail's body");
		Email email3=new Email("user1","user2","3rd Mail","3rd Mail's body");
		Email email4=new Email("user2","user1","RE: 1st Mail","RE: 1st Mail's body");
		//Email storing...
		insServer.storeEmail(email1);
		insServer.storeEmail(email2);
		insServer.storeEmail(email3);
		insServer.storeEmail(email4);
		//General tests
		System.out.println("Showing all emails: \n\n");
		insServer.showAllEmails();
		System.out.println("Showing emails sent by user1: \n");
		insServer.showSentEmails("user1");
		System.out.println("Showing emails received by user1: \n");
		insServer.showInbox("user1");
		//Create divide
		System.out.println("---------------------------------------------------------------");
		System.out.println("");
	}
	
	public static void testMailClient()
	{
		//Constructors
		MailServer insServer=new MailServer();
		MailClient mailClient1= new MailClient(insServer,"Pepe");
		MailClient mailClient2= new MailClient(insServer,"Paca");
		//Sending Emails...
		mailClient1.sendEmail("Paca","Que tal el dia?", "Hoy me han cambiado el turno de tarde, podré ir pronto a casa. Tengo ganas de verte ;)");
		mailClient1.sendEmail("Paca","Postdata", "Creo que no quedaba pan. Compro pan a la vuelta?");
		mailClient1.sendEmail("Paca","Postpostdata", "Olvida el mensaje anterior, se me ha olvidado la cartera en casa. Te quiero");
		mailClient2.sendEmail("Pepe","Cabezachorlito", "Tranquilo hay pan, pero ten más cuidado con la cartera. Vuelve pronto, tabién te quiero.");
		//Showing Emails...
		System.out.println("Showing inbox of Pepe:\n");
		mailClient1.showMyInbox();
		System.out.println("Showing emails sent by Pepe:\n");
		mailClient1.showMySent();
		//Testing for complementary tasks...
		System.out.println("Showing inbox of Paca:\n");
		mailClient2.showMyInbox();
		System.out.println("Showing Email to be deleted:\n");
		mailClient1.obtainRemoveEmailFromInbox().showEmail();
		System.out.println("Showing inbox of Paca:\n");
		mailClient2.showMyInbox();
		System.out.println("Showing Email to be deleted:\n");
		insServer.obtainRemoveEmail("Pepe").showEmail();
		System.out.println("Showing inbox of Paca:\n");
		mailClient2.showMyInbox();
	}
}
