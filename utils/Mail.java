/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;


import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author user
 */



public class Mail
{

	//SETUP MAIL SERVER PROPERTIES
	//DRAFT AN EMAIL
	//SEND EMAIL
		
	Session newSession = null;
	MimeMessage mimeMessage = null;
	public static void main(String args[]) throws AddressException, MessagingException, IOException
	{
		Mail mail = new Mail();
		mail.setupServerProperties();
		mail.draftEmail();
		mail.sendEmail();
	}

	private void sendEmail() throws MessagingException {
                 System.out.println("trying to send");
		String fromUser = "hamzabenz2002@gmail.com";  //Enter sender email id
                System.out.println("El user 3arfo");
		String fromUserPassword = "hamzaBenz22";  //Enter sender gmail password , this will be authenticated by gmail smtp server
                System.out.println("3aaraf el mot de passe");
		String emailHost = "smtp.gmail.com";
                 System.out.println("3aaraf el serveur");
            try (Transport transport = newSession.getTransport("smtp")) {
                transport.connect(emailHost, fromUser, fromUserPassword);
                System.out.println("3aaraf el connection");
                transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
                System.out.println("3amal send");
            }catch (MessagingException e){
		System.out.println("Email successfully sent!!!");
                }
                
	}

	private MimeMessage draftEmail() throws AddressException, MessagingException, IOException {
		String[] emailReceipients = {"benahamza279@gmail.com"};  //Enter list of email recepients
                System.out.println("El receiver 3arfo");
		String emailSubject = "Test Mail";
		String emailBody = "Test Body of my email";
		mimeMessage = new MimeMessage(newSession);
		
            for (String emailReceipient : emailReceipients) {
                mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailReceipient));
                System.out.println("Zed el recipient");
            }
		mimeMessage.setSubject(emailSubject);
	   
      // CREATE MIMEMESSAGE 
	    // CREATE MESSAGE BODY PARTS 
	    // CREATE MESSAGE MULTIPART 
	    // ADD MESSAGE BODY PARTS ----> MULTIPART 
	    // FINALLY ADD MULTIPART TO MESSAGECONTENT i.e. mimeMessage object 
	    
	    
		 MimeBodyPart bodyPart = new MimeBodyPart();
		 bodyPart.setContent(emailBody,"html/text");
		 MimeMultipart multiPart = new MimeMultipart();
		 multiPart.addBodyPart(bodyPart);
		 mimeMessage.setContent(multiPart);
                 System.out.println("B3ath saye");
		 return mimeMessage;
	}

	private void setupServerProperties() {
		Properties properties = System.getProperties();
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		newSession = Session.getDefaultInstance(properties,null);
	}
	
}	
