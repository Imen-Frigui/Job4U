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


/**
 *
 * @author user
 */
public class Sender {
    
     public static void main(String[] args) throws IOException {
     
     SendMailWithAttachement objSender =new SendMailWithAttachement();
     objSender.Send();
     
     }
     
    
}
