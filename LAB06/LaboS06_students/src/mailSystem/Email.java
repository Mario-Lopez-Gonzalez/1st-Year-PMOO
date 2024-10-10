package mailSystem;

public class Email {
	private String sender;
	private String receiver;
	private String subject;
	private String text;
	

	/**
     * Create a new email with corresponding sender, receiver and subject
     * @param pFrom - Email sender
     * @param pTo - Email receiver
     * @param pSubject - Email subject
	 */
	public Email(String pFrom, String pTo, String pSubject) {
		this(pFrom,pTo,pSubject,"");
	}
	/**
     * Create a new email with corresponding sender, receiver, subject and text
     * @param pFrom - Email sender
     * @param pTo - Email receiver
     * @param pSubject - Email subject
     * @param pText - Email text
     */
	public Email(String pFrom, String pTo, String pSubject, String pText) {
		this.sender = pFrom;
		this.receiver = pTo;
		this.subject = pSubject;
		this.text = pText;
	}	

	/**
     * Method that returns the sender of the email 
     * @return email sender
     */
	public String getSender() {
		return sender;
	}

	/**
     * Method that returns the receiver of the email 
     * @return email receiver
     */
	public String getReceiver() {
		return receiver;
	}

	/**
     * Method that returns the subject of the email 
     * @return email subject
     */
	public String getSubject() {
		return subject;
	}

	/**
     * Method that returns the text of the email 
     * @return email text
     */
	public String getText() {
		return text;
	}
	
	/**
	 * Method that modifies the text of the email with the text in the parameter
	 * @param pText Text for the email
	 */
	public void setText(String pText) {
		this.text = pText;
	}
	
	/**
     * Method that shows the message in the standard output
     */
    public void showEmail() {
        System.out.println(this.toString());
    }
    /**
     *  Method to determine whether the receiver of two Email instances are equal
     * @param other 
     * @return whether the receiver of both Emails are equal
     */
    public boolean equalsReceiver(Email other) {
        return (this.receiver.equals(other.getReceiver()));
        	
    }
    /**
     * Method that obtains a String that represents the Email
     */
    @Override
    public String toString() {
    	String st;
    	st="\nFrom: " + sender+"\nTo: " + receiver+"\nSubject: " + subject+"\nMessage: " + text;
    	return st;
    }  
    @Override
    public boolean equals(Object o) {
    	Email e2=(Email)o;
    	return (this.receiver.equals(e2.receiver)&&this.sender.equals(e2.sender)&&
    			this.subject.equals(e2.subject)&&this.text.equals(e2.text));
    	
    }
  
}
