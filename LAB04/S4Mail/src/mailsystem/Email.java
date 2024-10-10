package mailsystem;

/**
 * Class for the creation of Emails
 */
public class Email {
	private String sender;
	private String receiver;
	private String subject;
	private String text;
	
	/**
	 * Constructor to create a new Email with given parameters and text set to ""
	 * @param se is the sender
	 * @param re is the receiver
	 * @param sub is the subject
	 */
	public Email(String se, String re, String sub)
	{
		this(se,re,sub,"");
	}
	
	/**
	 * Constructor to create a new Email with given parameters
	 * @param se is the sender
	 * @param re is the receiver
	 * @param sub is the subject
	 * @param txt is the text
	 */
	public Email(String se, String re, String sub, String txt)
	{
		sender=se;
		receiver=re;
		subject=sub;
		text=txt;
	}
	
	/**
	 * Method to return the value of sender
	 * @return sender
	 */
	public String getSender()
	{
		return sender;
	}
	
	/**
	 * Method to return the value of receiver
	 * @return receiver
	 */
	public String getReceiver()
	{
		return receiver;
	}
	
	/**
	 * Method to return the value of subject
	 * @return subject
	 */
	public String getSubject()
	{
		return subject;
	}
	
	/**
	 * Method to return the value of text
	 * @return text
	 */
	public String getText()
	{
		return text;
	}
	
	/**
	 * Method to set the value of text to given text
	 * @param txt is the given text
	 */
	public void setText(String txt)
	{
		text=txt;
	}
	
	/**
	 * Method to return by console all parameters of Email
	 */
	public void showEmail()
	{
		System.out.println("Sender: "+sender);
		System.out.println("Receiver: "+receiver);
		System.out.println("Subject: "+subject);
		System.out.println("Text: "+text);
		System.out.println("");
	}
	
	/**
	 * Method to check if current Email's receiver is same as given Email's
	 * @param mail is given Email
	 * @return boolean true if same receiver, false if not
	 */
	public boolean equalsReceiver(Email mail)
	{
		return (mail.receiver==receiver);
	}
	/**
	 * Method to overwrite the equals default method, checks if all parameters have the same value, even if they are on different memory addresses
	 * @param email
	 * @return true if all variables are the same
	 */
	public boolean equals(Object mail)
	{
		Email email=(Email) mail;
		return(sender==email.getSender()&&
			   receiver==email.getReceiver()&&
			   subject==email.getSubject()&&
			   text==email.getText());
	}
}
