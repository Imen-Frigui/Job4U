/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author user
 */
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import javax.mail.internet.MimeMessage;

import javax.mail.internet.InternetAddress;

public class MailAPI3 {

    /**
     * Utility method to send simple HTML email
     *
     * @param session
     * @param toEmail
     * @param subject
     * @param body
     */
   
	

    

    public static void sendEmail(Session session, String toEmail, String subject, String body) {
        try {
            MimeMessage msg = new MimeMessage(session);
            //set message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress("benamor.hamza@esprit.tn", "NoReply-JD"));

            msg.setReplyTo(InternetAddress.parse("benahamza279@gmail.com", false));

            msg.setSubject(subject, "UTF-8");

            msg.setText(body, "UTF-8");

            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            System.out.println("Message is ready");
            Transport.send(msg);

            System.out.println("EMail Sent Successfully!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
		
	    System.out.println("SimpleEmail Start");
		final String password = "EspritHamza"; // correct password for gmail id
	    String smtpHostServer = "smtp.gmail.com";
	    String emailID = "benahamza279@gmail.com";
	    
	    Properties props = System.getProperties();

	    props.put("mail.smtp.host", smtpHostServer);
            
          
		
		props.put("mail.smtp.socketFactory.port", "578"); //SSL Port
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
		props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
		props.put("mail.smtp.port", "578"); //SMTP Port
	
            
             //create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("benamor.hamza@esprit.tn", password);
			}
		};
		Session session = Session.getInstance(props, auth);
		
	    
	    MailAPI3.sendEmail(session,emailID ,"SimpleEmail Testing Subject", "SimpleEmail Testing Body");
	}

}

