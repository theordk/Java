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

import Modele.Enseignant;
import Modele.Seance;
import Modele.Seance_Enseignant;
import java.sql.*;
import java.util.ArrayList;

public class Seance_EnseignantDAO extends DAO<Seance_Enseignant>{
    
    public Seance_EnseignantDAO(Connection conn) {
    super(conn);
  }

  public boolean create(Seance_Enseignant obj) {
    return false;
  }

  public boolean delete(Seance_Enseignant obj) {
    return false;
  }
   
  public boolean update(Seance_Enseignant obj) {
    return false;
  }
   

  
  public Seance_Enseignant find(int id_s) {                
        Seance_Enseignant seance_enseignant = new Seance_Enseignant();
        
        try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM seance_enseignants WHERE ID_SEANCE = " + id_s;
            ResultSet resultSet = statement.executeQuery(query);
            
            if(resultSet.first()){                
                seance_enseignant = new Seance_Enseignant(id_s, resultSet.getInt("ID_UTILISATEUR"));                
            }
        } catch (SQLException e) {
        }
                
        return seance_enseignant;
    }
   
  
      public ArrayList<Seance_Enseignant> findAll(){
       ArrayList<Seance_Enseignant> seances_enseignant = new ArrayList<>();
       
       try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM seance_enseignants";
            ResultSet resultSet = statement.executeQuery(query);           
            
            if(resultSet.first()){
                
                   do{
                        seances_enseignant.add(this.find(resultSet.getInt("ID_SEANCE")));
                    }while (resultSet.next());
            }
            
        } catch (SQLException e) {
        }
       
       return seances_enseignant;
   }
  
    
  
  
  
}

  
  
