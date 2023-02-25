/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.File;
import java.io.IOException;



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
public class SendMailWithAttachement {
    
    
    public  void Send() throws IOException {
  String to = "hamzaBenz2002@gmail.com"; // to address. It can be any like gmail, hotmail etc.
  final String from = "benahamza279@gmail.com"; // from address. As this is using Gmail SMTP.
  final String password = "HamzaBenAmor2022"; // password for from mail address. 
 
  Properties prop = new Properties();
  prop.put("mail.smtp.host", "smtp.gmail.com");
  prop.put("mail.smtp.port", "465");
  prop.put("mail.smtp.auth", "true");
  prop.put("mail.smtp.socketFactory.port", "465");
  prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
 
  Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
   @Override
   protected PasswordAuthentication getPasswordAuthentication() {
    return new PasswordAuthentication(from, password);
   }
  });
 
  try {
 
   Message message = new MimeMessage(session);
   message.setFrom(new InternetAddress(from));
   message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
   message.setSubject("Message from Java Simplifying Tech");
    
   String msg = "This email sent using JavaMailer API from Java Code!!!";
    
   MimeBodyPart mimeBodyPart = new MimeBodyPart();
   mimeBodyPart.setContent(msg, "text/html");
     
   Multipart multipart = new MimeMultipart();
   multipart.addBodyPart(mimeBodyPart);
    
   MimeBodyPart attachmentBodyPart = new MimeBodyPart();
   attachmentBodyPart.attachFile(new File("C:\\Users\\user\\Documents\\NetBeansProjects\\JavaFXGestionUser\\src\\Images\\userr.jfif"));
   multipart.addBodyPart(attachmentBodyPart);
   message.setContent(multipart);
 
   Transport.send(message);
 
   System.out.println("Mail successfully sent..");
 
  } catch (MessagingException e) {
   e.printStackTrace();
  }
 }
}
    

