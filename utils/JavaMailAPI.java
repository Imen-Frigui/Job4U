/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;



import java.util.Date;

import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.activation.*; 
import javax.mail.Session;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Address;
import javax.mail.PasswordAuthentication;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



import javax.mail.internet.MimeBodyPart;

import javax.mail.internet.MimeMultipart;

/**
 *
 * @author user
 */
public class JavaMailAPI {
    
    
  public static void main(String[] args) {
    final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
 // Get a Properties object
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
    final String username = "hamzabenz2002@gmail.com";
    final String password = "hamzaBenz22";
    try{
      Session session = Session.getDefaultInstance(props, 
                          new Authenticator(){
                             protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(username, password);
                             }});

   // -- Create a new message --
      Message msg = new MimeMessage(session);

   // -- Set the FROM and TO fields --
      msg.setFrom(new InternetAddress("benahamza279@gmail.com"));
      msg.setRecipients(Message.RecipientType.TO, 
                        InternetAddress.parse("hamzabenz2002@gmail.com",true));
      msg.setSubject("Hello");
      msg.setText("How are you");
      msg.setSentDate(new Date());
      Transport.send(msg);
      System.out.println("Message sent.");
    }catch (MessagingException e){ 
      System.out.println("Erreur d'envoi, cause: " + e);
    }
  }
}
    

