package job4u.utils;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ILYESS LASS
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    private static DataSource instance;
    private final String USER = "root";
    private final String PWD = "";
    private final String URL = "jdbc:mysql://localhost:3306/job4you";
    private Connection cnx;

    private DataSource() {
        try {
            cnx = DriverManager.getConnection(URL, USER, PWD);
            System.out.println("Connected!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

    public Connection getConnection() {
        return cnx;
    }

    public void closeConnection() {
        try {
            cnx.close();
            System.out.println("Connection closed!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
 

}

