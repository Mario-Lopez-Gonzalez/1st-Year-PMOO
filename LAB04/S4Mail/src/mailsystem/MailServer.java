package mailsystem;
import java.util.ArrayList;

/**
 * Class for managing mail servers
 * @author PMOO teachers
 *
 */
public class MailServer {
	
	//Attribute for storing emails
	private ArrayList<Email> emailList;

	//Attribute for Maximum capacity
	private final int MAXIMUM_CAPACITY = 100;

	/**
	 * MailServer Constructor
	 */
	public MailServer() {
		emailList=new ArrayList<Email>(MAXIMUM_CAPACITY);
	}
	
	/**
	 * Method that stores an Email at the end of the list
	 * @param pMail Email to be stored
	 */
	public void storeEmail(Email pMail) {
		if(emailList.size()!=MAXIMUM_CAPACITY)
		{
		emailList.add(pMail);
		}
		else
		{
			System.out.println("ERROR: The server has reached maximun capacity");
		}
	}
	
	/**
	 * Method to show all emails stored in the server
	 */
	public void showAllEmails() 
	{
		for(int i=0;i<emailList.size();i++)
		{
			emailList.get(i);
		}
	}
	
	/**
	 * Method that sets the variable emailList.size() to 0
	 */
	public void resetServer()
	{
		emailList.clear();
	}
	
	/**
	 * Method to show all emails sent to a specified receiver
	 * @param user is receiver
	 */
	public void showInbox(String user)
	{
		for(int i=0;i<emailList.size();i++)
		{
			if(emailList.get(i).getReceiver()==user)
			{
				emailList.get(i).showEmail();
			}
		}
	}
	
	/**
	 * Method to show by console all Emails sent by a specified sender
	 * @param user is the sender
	 */
	public void showSentEmails(String user)
	{
		for(int i=0;i<emailList.size();i++)
		{
			if(emailList.get(i).getSender()==user)
			{
				emailList.get(i).showEmail();
			}
		}
	}
	/**
	 * Method to eliminate the first appearance of an Email on MailServer
	 * @param email is target Email
	 */
	public void removeEmail(Email email)
	{
		boolean found=false;
		for(int i=0;i<emailList.size()&&!found;i++)
		{
			if(emailList.get(i).equals(email))
			{
				emailList.remove(i);
				found=true;
			}
		}
	}
	
	/**
	 * Private method to get the first appearance of an Email which sender is pUserAddress
	 * @param pUserAddress
	 * @return Email, first Email which sender is pUserAddress
	 */
	private Email obtainFirstEmail(String pUserAddress)
	{
		int j=0;
		boolean stop=false;
		int max= emailList.size();
		for(int i=0;i<(max-1)&&!stop;i++)
		{
			if(emailList.get(i).getSender().equalsIgnoreCase(pUserAddress))
			{
				stop=true;
			}
			else
			{
			j++;
			}
		}
		return emailList.get(j);
	}
	
	/**
	 * Method to remove the first Email which sender is pUserAddress and return the same Email
	 * @param pUserAddress
	 * @return Email, Email which is removed
	 */
	public Email obtainRemoveEmail(String pUserAddress)
	{
		Email removeEmail=obtainFirstEmail(pUserAddress);
		removeEmail(removeEmail);
		return removeEmail;
	}
}

