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

import Modele.Type_Cours;
import java.sql.*;
import java.util.ArrayList;

public class Type_CoursDAO extends DAO<Type_Cours> {
    
public Type_CoursDAO(Connection conn) {
    super(conn);
  }

  public boolean create(Type_Cours u) {
      
      int mail = u.getId();
      String password = u.getNom();

      
        
        try {
            Statement statement = this.connection.createStatement();
            
            String query = "INSERT INTO type_cours (ID, NOM) VALUES ("+mail+","+password+")";
            ResultSet resultSet = statement.executeQuery(query);           
            

        } catch (SQLException e) {
        }
      
    return false;
  }

  public boolean delete(Type_Cours obj) {
    return false;
  }
   
  public boolean update(Type_Cours obj) {
    return false;
  }
   

  
  public Type_Cours find(int id) {                
        Type_Cours type_cours = new Type_Cours();
        
        try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM type_cours WHERE ID = " + id;
            ResultSet resultSet = statement.executeQuery(query);           
            
            if(resultSet.first()){                
                type_cours = new Type_Cours(id, resultSet.getString("NOM"));                
            }
        } catch (SQLException e) {
        }
                
        return type_cours;
    }
  
  public ArrayList<Type_Cours> findAll(){
       ArrayList<Type_Cours> type_cours = new ArrayList<>();
       
       try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM type_cours";
            ResultSet resultSet = statement.executeQuery(query);           
            
            if(resultSet.first()){
                
                   do{
                        type_cours.add(this.find(resultSet.getInt("ID")));
                    }while (resultSet.next());
            }
            
        } catch (SQLException e) {
        }
       
       return type_cours;
   }
}
