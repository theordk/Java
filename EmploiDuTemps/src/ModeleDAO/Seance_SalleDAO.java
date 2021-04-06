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

import Modele.Seance_Salle;
import java.util.ArrayList;
import Modele.Seance;
import Modele.Salle;
import java.sql.*;

public class Seance_SalleDAO extends DAO<Seance_Salle>{
    
    public Seance_SalleDAO(Connection conn) {
    super(conn);
  }

  public boolean create(Seance_Salle obj) {
    return false;
  }

  public boolean delete(Seance_Salle obj) {
    return false;
  }
   
  public boolean update(Seance_Salle obj) {
    return false;
  }
   

  
  public Seance_Salle find(int id_s) {                
        Seance_Salle seance_salle = new Seance_Salle();
        
        try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM seance_salles WHERE ID_SEANCE = " + id_s;
            ResultSet resultSet = statement.executeQuery(query);
            
            if(resultSet.first()){                
                seance_salle = new Seance_Salle(id_s, resultSet.getInt("ID_SALLE"));                
            }
        } catch (SQLException e) {
        }
                
        return seance_salle;
    }
  
      public ArrayList<Seance_Salle> findAll(){
       ArrayList<Seance_Salle> seances_salles = new ArrayList<>();
       
       try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM seance_salles";
            ResultSet resultSet = statement.executeQuery(query);           
            
            if(resultSet.first()){
                
                    do{
                        seances_salles.add(this.find(resultSet.getInt("ID_SEANCE")));
                    }while (resultSet.next());
            }
            
        } catch (SQLException e) {
        }
       
       return seances_salles;
   }
  
    
    

}