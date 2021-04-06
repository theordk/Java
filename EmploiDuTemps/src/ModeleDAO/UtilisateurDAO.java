/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeleDAO;

/**
 *
 * @author bapti
 */


import Modele.Utilisateur;
import java.sql.*;
import java.util.ArrayList;

public class UtilisateurDAO extends DAO<Utilisateur> {
    
public UtilisateurDAO(Connection conn) {
    super(conn);
  }

  public boolean create(Utilisateur u) {
      
      String mail = u.getEmail();
      String password = u.getPassword();
      String nom = u.getNom();
      String prenom = u.getPrenom();
      int droit = u.getDroit();
      
        
        try {
            Statement statement = this.connection.createStatement();
            
            String query = "INSERT INTO utilisateur (EMAIL, PASSWD, NOM, PRENOM, DROIT) VALUES ("+mail+","+password+", "+nom+", "+prenom+", "+droit+")";
            ResultSet resultSet = statement.executeQuery(query);           
            

        } catch (SQLException e) {
        }
      
    return false;
  }

  public boolean delete(Utilisateur obj) {
    return false;
  }
   
  public boolean update(Utilisateur obj) {
    return false;
  }
   

  
  public Utilisateur find(int id) {                
        Utilisateur utilisateur = new Utilisateur();
        
        try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM utilisateur WHERE ID = " + id;
            ResultSet resultSet = statement.executeQuery(query);           
            
            if(resultSet.first()){                
                utilisateur = new Utilisateur(id, resultSet.getString("EMAIL"), resultSet.getString("PASSWD"), resultSet.getString("NOM"), resultSet.getString("PRENOM"), resultSet.getInt("DROIT"));                
            }
        } catch (SQLException e) {
        }
                
        return utilisateur;
    }
  
  public ArrayList<Utilisateur> findAll(){
       ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
       
       try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM utilisateur";
            ResultSet resultSet = statement.executeQuery(query);           
            
            if(resultSet.first()){
                
                    do{
                        utilisateurs.add(this.find(resultSet.getInt("ID")));
                    }while (resultSet.next());
            }
            
        } catch (SQLException e) {
        }
       
       return utilisateurs;
   }
}
