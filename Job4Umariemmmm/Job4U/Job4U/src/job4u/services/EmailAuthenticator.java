/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package job4u.services;

/**
 *
  */
import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;

public class EmailAuthenticator extends Authenticator {
    private final String username;
    private final String password;

    public EmailAuthenticator(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }
}
