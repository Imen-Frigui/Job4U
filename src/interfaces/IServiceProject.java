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
 * @param <P>
 */
public interface IServiceProject<P> {
    
    public void ajouter(P  t) throws SQLException;
    public void ajouter2(P  t) throws SQLException;
    public void supprimer(P t);
    public void modifier(P t);
    public ArrayList<P> afficher();
    
    
}
