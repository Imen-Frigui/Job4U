/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Date;
import javax.mail.Authenticator;
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
public class JavaMailAPI2 {

    public static void main(String[] args) {
            final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        System.out.println("Preparing to send:");
        
         Properties properties = System.getProperties();
        

        String myAccountEmail ="hamzabenz2002@gmail.com";
        String password ="hamzaBenz22";
        
        
           properties.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
    properties.setProperty("mail.smtp.socketFactory.fallback", "false");
         properties.put("com.hof.email.starttime","20170519094544");
        properties.put("mail.smtp.connectiontimeout","60000");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.trust","*");
        properties.put("mail.smtp.starttls.enable","false");
        properties.put("mail.smtp.timeout","60000");
        properties.put("mail.transport.protocol","smtp");
          properties.put("mail.smtp.auth", "true");
    properties.put("mail.debug", "true");
    properties.put("mail.store.protocol", "pop3");
    properties.put("mail.transport.protocol", "smtp");
        
        Session session = Session.getInstance(properties, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        
         try {
            //msg.setFrom(new InternetAddress("benahamza279@gmail.com"));
     // msg.setRecipients(Message.RecipientType.TO, 
                    //    InternetAddress.parse("hamzabenz2002@gmail.com",true));
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("benahamza279@gmail.com"));
            
            message.setRecipients(Message.RecipientType.TO, 
                        InternetAddress.parse(myAccountEmail,true));
           
              message.setSubject("Hello");
               message.setText("How are you");
               
               Transport.send(message);
      System.out.println("Message sent.");
            
           
        } catch (MessagingException ex) {
            
            Logger.getLogger(JavaMailAPI2.class.getName()).log(Level.SEVERE, null, ex);
            
        }

    }
}