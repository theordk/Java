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
import Modele.Seance;
import java.sql.*;
import java.util.ArrayList;

public class SalleDAO extends DAO<Salle> {
    
public SalleDAO(Connection conn) {
    super(conn);
  }

  public boolean create(Salle u) {
      
      int mail = u.getId();
      String password = u.getNom();
      int cap = u.getCapacite();
      int id = u.getId_site();

      
        
        try {
            Statement statement = this.connection.createStatement();
            
            String query = "INSERT INTO salle (ID, NOM, CAPACITE, ID_SITE) VALUES ("+mail+","+password+","+cap+","+id+")";
            ResultSet resultSet = statement.executeQuery(query);           
            

        } catch (SQLException e) {
        }
    return false;
  }

  public boolean delete(Salle obj) {
    return false;
  }
   
  public boolean update(Salle obj) {
    return false;
  }
   

  
  public Salle find(int id) {                
        Salle salle = new Salle();
        
        try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM salle WHERE ID = " + id;
            ResultSet resultSet = statement.executeQuery(query);           
            
            if(resultSet.first()){                
                salle = new Salle(id, resultSet.getString("NOM"),  resultSet.getInt("CAPACITE"), resultSet.getInt("ID_SITE"));                
            }
        } catch (SQLException e) {
        }
                
        return salle;
    }
  
      public ArrayList<Salle> findAll(){
       ArrayList<Salle> salles = new ArrayList<>();
       
       try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM salle";
            ResultSet resultSet = statement.executeQuery(query);           
            
            if(resultSet.first()){
                
                    do{
                        salles.add(this.find(resultSet.getInt("ID")));
                    }while (resultSet.next());
            }
            
        } catch (SQLException e) {
        }
       
       return salles;
   }
  
    
  
  
  
  
  
  
      public ArrayList<Seance> ListeS(int id_salle){
      //On rentre l'ID d'une salle, ca donne une liste de toutes ses Seances
       ArrayList<Seance> seances = new ArrayList<>();
       ArrayList<Integer> id_seances = new ArrayList<>();
      
       
       try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM seance_salle WHERE ID_SALLE = " + id_salle;
            ResultSet resultSet = statement.executeQuery(query);           
            
            if(resultSet.first()){
                
                    while (resultSet.next()) {
                        id_seances.add(resultSet.getInt("ID_SEANCE"));
                    }
            }
            
            
            
        } catch (SQLException e) {
        }
       
       try {
            for(int i=0; i<id_seances.size();i++){
                
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM seance WHERE ID_SEANCE = " + id_seances.get(i);
            ResultSet resultSet = statement.executeQuery(query);           
            
            if(resultSet.first()){
                
                    while (resultSet.next()) {
                        seances.add(new Seance(id_seances.get(i), resultSet.getInt("SEMAINE"), resultSet.getString("DATE"), resultSet.getString("HEURE_DEBUT"), resultSet.getString("HEURE_FIN"), resultSet.getInt("ETAT"), resultSet.getInt("ID_COURS"), resultSet.getInt("ID_TYPE")));
                    }
            }
            }
            
            
        } catch (SQLException e) {
        }
      
      return seances;
  }
}
