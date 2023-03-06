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

/**
 *
 * @author user
 */
public class Mailjdid {

    public static void main(String[] args) {

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", 587);
        props.put("mail.smtp.user", "hamzabenz2002@gmail.com");
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", 587);
        props.put("mail.smtp.debug", true);
        props.put("mail.smtp.socketFactory.port", 587);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", false);

        try {
            Session session = Session.getDefaultInstance(props, null);
            
            String [] emailReceipients = {"hamzabenz2002@gmail.com"}; 
            session.setDebug(true);
            MimeMessage message = new MimeMessage(session);
            
            message.setSubject("OTP For your Neftola Account");
            message.setFrom(new InternetAddress("benahamza279@gmail.com"));
            
            for (String emailReceipient : emailReceipients) {
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailReceipient));
            message.saveChanges();
            }
            try {
                Transport transport = session.getTransport("smtp");
                System.out.println("9aa3ed ya9ra");
                transport.connect("smtp.gmail.com", "hamzabenz2002@gmail.com", "hamzaBenz22");
                System.out.println("9aa3ed ya9ra");
                transport.sendMessage(message, message.getAllRecipients());
                System.out.println("9aa3ed yabaath");
                transport.close();              
            
            } catch (Exception e) {
                	System.out.println("Email successfully sent!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
      
        }

    }
}
