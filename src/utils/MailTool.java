
package utils;


import javax.mail.PasswordAuthentication;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Address;
import javax.mail.PasswordAuthentication;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;


import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


/**
 *
 * @author user
 */
public class MailTool {
    
    
    
    
      private static Message prepareMessage(Session session, String myAccountEmail,String recepient,String subject,String messagevalue){
        try {
            
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject(subject);
            
            message.setText(messagevalue);
            return message;
        } catch (MessagingException ex) {
          
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
 
  private static Message prepareMessage(Session session, String myAccountEmail,String recepient,String subject){
        try {
            
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject(subject);
            
            return message;
        } catch (MessagingException ex) {
            Logger.getLogger(MailTool.class.getName()).log(Level.SEVERE, null, ex);
        }
          return null;
      
    } 

     public static void sendMail(String recepient,String subject,String messagevalue) throws Exception{
        System.out.println("Preparing to send:");
        Properties properties = new Properties();
        

        String myAccountEmail ="hamzabenz2002@gmail.com";
        String password ="hamzaBenz22";
        
        properties.put("com.hof.email.starttime","20170519094544");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.connectiontimeout","60065");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        properties.put("mail.smtp.ssl.trust","*");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.timeout","60065");
        properties.put("mail.transport.protocol","smtp");
        
        
        
        Session session;
          session = Session.getInstance(properties, new Authenticator(){
              @Override
              protected PasswordAuthentication getPasswordAuthentication() {
                  return new PasswordAuthentication(myAccountEmail, password);
              }
          });
        
        Message message = prepareMessage(session,myAccountEmail,recepient,subject,messagevalue);
        Transport.send(message);
       
        System.out.println("message send successfully");
    }
     
     
     
        public static void sendMailWithHtmlCode(String recepient,String subject,String messagevalue) throws Exception{
        System.out.println("Preparing to send:");
        Properties properties = new Properties();
        

        
        String myAccountEmail ="hamzabenz2002@gmail.com";
        String password ="hamzaBenz22";
        
        properties.put("com.hof.email.starttime","20170519094544");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.connectiontimeout","60065");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        properties.put("mail.smtp.ssl.trust","*");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.timeout","60065");
        properties.put("mail.transport.protocol","smtp");
        
        
        
        Session session = Session.getInstance(properties, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        
        Message message = prepareMessage(session,myAccountEmail,recepient,subject);
        message.setContent(messagevalue, "text/html; charset=utf-8");

        Transport.send(message);
        System.out.println("message send successfully");
    }
    
}
