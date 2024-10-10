package mailsystem;

public class MailClient {
	private MailServer server;
	private String userAddress;
	/**
	 * Constructor for the MailClient class
	 * @param pServer
	 * @param pUserAddress
	 */
	public MailClient(MailServer pServer,String pUserAddress)
	{
		server=pServer;
		userAddress=pUserAddress;
	}
	
	/**
	 * Method to get the value of userAddress
	 * @return String of userAddress
	 */
	public String getUserAddress()
	{
		return (userAddress);
	}
	
	/**
	 * Method to create and Email (sender is userAddress, other parameters are specified) and save it on MailServer
	 * @param pTo
	 * @param pSubject
	 * @param pText
	 */
	public void sendEmail(String pTo, String pSubject, String pText)
	{
		Email newEmail=new Email(userAddress,pTo,pSubject,pText);
		server.storeEmail(newEmail);
	}
	
	/**
	 * Method to show by console all Emails which sender is userAddress
	 */
	public void showMyInbox()
	{
		server.showInbox(userAddress);
	}
	
	/**
	 * Method to show by console all Emails which receiver is userAddress
	 */
	public void showMySent()
	{
		server.showSentEmails(userAddress);
	}
	
	/**
	 * Method to remove the first email which sender is userAddress and return it
	 * @return Email, first Email which sender is userAddress
	 */
	public Email obtainRemoveEmailFromInbox()
	{
		return server.obtainRemoveEmail(userAddress);
	}
}
