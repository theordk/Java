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
import Modele.Salle;
import Modele.Site;
import java.sql.*;
import java.util.ArrayList;

public class SiteDAO extends DAO<Site> {
    
public SiteDAO(Connection conn) {
    super(conn);
  }

  public boolean create(Site u) {
          int mail = u.getId();
            String password = u.getNom();

      
        
        try {
            Statement statement = this.connection.createStatement();
            
            String query = "INSERT INTO site (ID, NOM) VALUES ("+mail+","+password+")";
            ResultSet resultSet = statement.executeQuery(query);           
            

        } catch (SQLException e) {
        }
    return false;
  }

  public boolean delete(Site obj) {
    return false;
  }
   
  public boolean update(Site obj) {
    return false;
  }
   

  
  public Site find(int id) {                
        Site site = new Site();
        
        try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM site WHERE ID = " + id;
            ResultSet resultSet = statement.executeQuery(query);           
            
            if(resultSet.first()){                
                site = new Site(id, resultSet.getString("NOM"));                
            }
        } catch (SQLException e) {
        }
                
        return site;
    }
  
  public ArrayList<Site> findAll(){
       ArrayList<Site> sites = new ArrayList<>();
       
       try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM site";
            ResultSet resultSet = statement.executeQuery(query);           
            
            if(resultSet.first()){
                
                    do{
                        sites.add(this.find(resultSet.getInt("ID")));
                    }while (resultSet.next());
            }
            
        } catch (SQLException e) {
        }
       
       return sites;
   }
  
  
  
  
   public ArrayList<Salle> Liste(int id_site){
      //On rentre l'ID d'une promo, ca donne une liste de groupes
       ArrayList<Salle> salles = new ArrayList<>();
       
       try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM Salle WHERE ID_SITE = " + id_site;
            ResultSet resultSet = statement.executeQuery(query);           
            
            if(resultSet.first()){
                
                    while (resultSet.next()) {
                salles.add(new Salle(resultSet.getInt("ID"), resultSet.getString("NOM"), resultSet.getInt("CAPACITE"), id_site));
            }
            }
        } catch (SQLException e) {
        }
      
      return salles;
  }
}