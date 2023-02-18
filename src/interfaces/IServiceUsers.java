/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Imen Frigui
 */
public interface IServiceUsers <U> {
    public void ajouter(U  u) throws SQLException;
    public void ajouter2(U  u) throws SQLException;
    public void supprimer(U u);
    public void modifier(U u);
    public ArrayList<U> afficher();
}
