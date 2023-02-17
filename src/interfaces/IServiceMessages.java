/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author
 */
public interface IServiceMessages <M>{
    public void Add(M  m) throws SQLException;
    public void Delete(M m);
    public void Edit(M m);
    public ArrayList<M> afficher();
}
