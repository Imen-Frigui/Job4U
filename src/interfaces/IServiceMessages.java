<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Imen Frigui
 */
public interface IServiceMessages <M>{
    public void Add(M  m) throws SQLException;
    public void Delete(M m);
    public void Edit(int id, String msg);
    public List<M> afficher();
}
||||||| empty tree
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

/**
 *
 * @author GO BRO
 */
public class IServiceMessages {
    
}
>>>>>>> db76b1cfab8c254c1337a5b8d57bcc2461641d3a
