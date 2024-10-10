package mailSystem;

import java.util.ArrayList;

/**
 * Class for managing mail servers
 * @author teacher
 *
 */
public class MailServer {
	
	//Attribute for storing emails
	private ArrayList<Email> emailList;

	/**
	 * Mail Server Constructor
	 */
	public MailServer() {
		emailList =new ArrayList<Email>();
	}
	
	/**
	 * Method that stores an email at the end of the list
	 * @param pMail Email to be stored
	 */
	public void storeEmail(Email pMail) {
		emailList.add( pMail) ; 
	}
	/**
	 * Method that resets the email list
	 */
	public void reset() {
		emailList =new ArrayList<Email>();
	}

	/**
	 * Method that returns the Email list
	 * @return the emailList
	 */
	public ArrayList<Email> getEmailList() {
		return emailList;
	}
	/**
	 * Returns the Email at the given position, or null if the i value is not in the range
	 * @param i position
	 * @return the Email at the given position
	 */
	public Email getEmailPos(int i) {
		if (i>=0&&i<emailList.size())
			return emailList.get(i);
		else
			return null;
		
	}
	/**
	 * Method that returns the number of emails in the server
	 * @return the number of emails
	 */
	public int getNumEmails() {
		return emailList.size();
	}
	/**
	 * Method that obtains whether the list contains the given email or not 
	 * @param e the email to search for
	 * @return true if the list contains the email and false otherwise
	 */
	public boolean containsEmail(Email e) {
		return emailList.contains(e);
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
}
