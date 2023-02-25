/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Authenticator;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Service;
import javax.net.ssl.CertPathTrustManagerParameters;
import javax.net.ssl.SSLPermission;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.TrustManagerFactory;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class APImailJdid {

    public static void main(String[] args) {
        String to = "benahamza279@gmail.com";
        String from = "benamor.hamza@esprit.tn";
        String host = "smtp.gmail.com";
        String port = "587";

         String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

        Properties props = System.getProperties();
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
       
         
        try {
            Session session = Session.getInstance(props,
                    new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("benamor.hamza@esprit.tn","EspritHamza");
                }
            });

            Message msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress(from));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            msg.setSubject("Subject Line");
            Transport.send(msg);
            System.out.println("Sent message");

            Transport.send(msg);

        } catch (MessagingException e) {
            System.out.println("Erreur d'envoi, cause: " + e);
        }
    }

}


/*
String to = "Johnssp1201@gmail.com";
	      String from = "Johnssp1201@gmail.com";
	      String host = "localhost";
	      String port = "25";
	  
	      final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	 
	         Properties props = System.getProperties();
	         props.setProperty("mail.smtp.host", "smtp.gmail.com");
	         props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
	         props.setProperty("mail.smtp.socketFactory.fallback", "false");
	         props.setProperty("mail.smtp.port", "465");
	         props.setProperty("mail.smtp.socketFactory.port", "465");
	         props.put("mail.smtp.auth", "true");
	         props.put("mail.debug", "true");
	         props.put("mail.store.protocol", "pop3");
	         props.put("mail.transport.protocol", "smtp");
	         final String username = "Johnssp1201@gmail.com";//
	         final String password = "johnpeter1";
	         try{
	         Session session = Session.getInstance(props, 
	                              new Authenticator(){
	                                 protected PasswordAuthentication getPasswordAuthentication() {
	                                    return new PasswordAuthentication(username, password);
	                                 }});
	     
	         Message msg = new MimeMessage(session);

	   
	       
    msg.setFrom(new InternetAddress(fromEmail));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            msg.setSubject("Subject Line");
            Transport.send(msg);
            System.out.println("Sent message");
	         
	         
	         
	        
	
	         Transport.send(msg);
	       
	      }catch (MessagingException e){ System.out.println("Erreur d'envoi, cause: " + e);}
	   }  */
