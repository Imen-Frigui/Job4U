/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.InformationsSupplementaires;
import utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class InformationsSupplementairesService {

    Connection connection;

    public InformationsSupplementairesService() {
        connection = (Connection) MyConnection.getInstance().getCnx();

    }

    public void AjouterInformation(InformationsSupplementaires s) {
// String requete = " INSERT INTO categorie_aide ( `titre`, `lien_icon`)  VALUES(?,?)";
        try {
            PreparedStatement pre = connection.prepareStatement("INSERT INTO informations_supplementaires  VALUES (?,?,?,?,?)");

            pre.setInt(1, s.getId());

            pre.setString(2, s.getNom());
            pre.setString(3, s.getPrenom());
            pre.setString(4, s.getTell());
             pre.setString(5, s.getLien_icon());

            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
    }

    public InformationsSupplementaires chercherparid(int id) {

        try {
            PreparedStatement pre = connection.prepareStatement("SELECT * FROM informations_supplementaires WHERE id = ?");
            List<InformationsSupplementaires> Information_list = new ArrayList();

            pre.setInt(1, id);
            ResultSet result = pre.executeQuery();
            while (result.next()) {
                Information_list.add(new InformationsSupplementaires(result.getInt(1), result.getString(2), result.getString(3), result.getString(4),result.getString(5)));
                //int id, int user_id, String nom, String prenom, String tell, String image 
            }
            if (Information_list.size() > 0) {
                return Information_list.get(0);

            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
            return null;
        }

    }

    public void update(InformationsSupplementaires s) {
        
        try {
           PreparedStatement pre = connection.prepareStatement("Update informations_supplementaires set nom=?,prenom=?,tell=?,image=? where id = ?");  
            
            pre.setString(1, s.getNom());
            pre.setString(2, s.getPrenom());
            pre.setString(3, s.getTell());
            pre.setString(4, s.getLien_icon());
            pre.setInt(5, s.getId());
            

            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
    }
/*
    public void updateImage(InformationsSupplementaires s) {
        String sql = "Update informations_supplementaires set image=? where user_id = ?";
        try {
            ste = cnx.prepareStatement(sql);
            ste.setString(1, s.getImage());
            ste.setInt(2, s.getUser_id());

            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
    }
*/
}
