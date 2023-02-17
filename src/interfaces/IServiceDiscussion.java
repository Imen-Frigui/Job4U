/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author GO BRO
 * @param <D>
 */
public interface IServiceDiscussion <D> {
    public void Add(D  d) throws SQLException;
    public void Delete(D d);
    public ArrayList<D> afficher();
}
