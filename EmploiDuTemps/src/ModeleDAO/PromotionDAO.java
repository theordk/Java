/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeleDAO;

/*
 *
 * @author bapti
 */
import Modele.Groupe;
import Modele.Promotion;
import java.sql.*;
import java.util.ArrayList;

public class PromotionDAO extends DAO<Promotion> {
    
public PromotionDAO(Connection conn) {
    super(conn);
  }

  public boolean create(Promotion u) {
      
          int mail = u.getId();
      String password = u.getNom();

      
        
        try {
            Statement statement = this.connection.createStatement();
            
            String query = "INSERT INTO promotion (ID, NOM) VALUES ("+mail+","+password+")";
            ResultSet resultSet = statement.executeQuery(query);           
            

        } catch (SQLException e) {
        }
    return false;
  }

  public boolean delete(Promotion obj) {
    return false;
  }
   
  public boolean update(Promotion obj) {
    return false;
  }
   

  
  public Promotion find(int id) {                
        Promotion promotion = new Promotion();
        
        try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM promotion WHERE ID = " + id;
            ResultSet resultSet = statement.executeQuery(query);           
            
            if(resultSet.first()){                
                promotion = new Promotion(id, resultSet.getString("NOM"));                
            }
        } catch (SQLException e) {
        }
                
        return promotion;
    }
  
      public ArrayList<Promotion> findAll(){
       ArrayList<Promotion> promotions = new ArrayList<>();
       
       try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM promotion";
            ResultSet resultSet = statement.executeQuery(query);           
            
            if(resultSet.first()){
                
                    do{
                        promotions.add(this.find(resultSet.getInt("ID")));
                    }while (resultSet.next());
            }
            
        } catch (SQLException e) {
        }
       
       return promotions;
   }
  
    
  
  
  
  
  
  
   public ArrayList<Groupe> Liste(int id_promo){
      //On rentre l'ID d'une promo, ca donne une liste de groupes
       ArrayList<Groupe> groupes = new ArrayList<>();
       
       try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM groupe WHERE ID_PROMOTION = " + id_promo;
            ResultSet resultSet = statement.executeQuery(query);           
            
            if(resultSet.first()){
                
                    while (resultSet.next()) {
                groupes.add(new Groupe(resultSet.getInt("ID_UTILISATEUR"), resultSet.getString("NOM"), id_promo));
            }
            }
        } catch (SQLException e) {
        }
      
      return groupes;
  }
}