/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Andrew
 * @param <O>
 */
public interface IServiceOffre<O> {
    
    public void ajouter(O  t) throws SQLException;
    public void ajouter2(O  t) throws SQLException;
    public void supprimer(O t);
    public void modifier(O t);
    public ArrayList<O> afficher();
    
    
}
