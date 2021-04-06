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
import Modele.Seance_Groupe;
import Modele.Seance;
import Modele.Groupe;
import java.sql.*;
import java.util.ArrayList;

public class Seance_GroupeDAO extends DAO<Seance_Groupe>{
    
    public Seance_GroupeDAO(Connection conn) {
    super(conn);
  }

  public boolean create(Seance_Groupe obj) {
    return false;
  }

  public boolean delete(Seance_Groupe obj) {
    return false;
  }
   
  public boolean update(Seance_Groupe obj) {
    return false;
  }
   

  
  public Seance_Groupe find(int id) {                
        Seance_Groupe seance_groupe = new Seance_Groupe();
        
        try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM seance_groupes WHERE ID_SEANCE = " + id;
            ResultSet resultSet = statement.executeQuery(query);
            
            if(resultSet.first()){                
                seance_groupe = new Seance_Groupe(id, resultSet.getInt("ID_GROUPE"));     
            }
        } catch (SQLException e) {
        }
                
        return seance_groupe;
    }
  
      public ArrayList<Seance_Groupe> findAll(){
       ArrayList<Seance_Groupe> seances_groupes = new ArrayList<>();
       
       try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM seance_groupes";
            ResultSet resultSet = statement.executeQuery(query);           
            
            if(resultSet.first()){
                
                    do{
                        seances_groupes.add(this.find(resultSet.getInt("ID_SEANCE")));
                    }while (resultSet.next());
            }
            
        } catch (SQLException e) {
        }
       
       return seances_groupes;
   }
  
    
  
    
}
