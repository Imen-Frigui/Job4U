/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package job4u;

import services.ServiceUsers;
import utils.MyDB;

/**
 *
 * @author Imen Frigui
 */
public class Job4U {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                MyDB db=MyDB.getInstance();
     
            ServiceUsers sp = new ServiceUsers();

        System.out.println(sp.afficher());
    }
    
}
