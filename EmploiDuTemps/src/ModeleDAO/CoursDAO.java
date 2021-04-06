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


import Modele.Cours;
import java.sql.*;
import java.util.ArrayList;


public class CoursDAO extends DAO<Cours>{
    
public CoursDAO(Connection conn) {
    super(conn);
  }

  public boolean create(Cours u) {
      
          int mail = u.getId();
          String password = u.getNom();

      
        
        try {
            Statement statement = this.connection.createStatement();
            
            String query = "INSERT INTO cours (ID, NOM) VALUES ("+mail+","+password+")";
            ResultSet resultSet = statement.executeQuery(query);           
            

        } catch (SQLException e) {
        }
    return false;
  }

  public boolean delete(Cours obj) {
    return false;
  }
   
  public boolean update(Cours obj) {
    return false;
  }
   

  
  public Cours find(int id) {                
        Cours cours = new Cours();
        
        try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM cours WHERE ID = " + id;
            ResultSet resultSet = statement.executeQuery(query);           
            
            if(resultSet.first()){                
                cours = new Cours(id, resultSet.getString("NOM"));                
            }
        } catch (SQLException e) {
        }
                
        return cours;
    }
  
    public ArrayList<Cours> findAll(){
       ArrayList<Cours> cours = new ArrayList<>();
       
       try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM cours";
            ResultSet resultSet = statement.executeQuery(query);           
            
            if(resultSet.first()){
                
                    do{
                        cours.add(this.find(resultSet.getInt("ID")));
                    }while (resultSet.next());
            }
            
        } catch (SQLException e) {
        }
       
       return cours;
   }
  
}
