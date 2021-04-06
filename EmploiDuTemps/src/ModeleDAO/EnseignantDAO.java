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
import Modele.Etudiant;
import Modele.Seance;
import java.sql.*;
import java.util.ArrayList;


public class EnseignantDAO extends DAO<Enseignant> {
    
  public EnseignantDAO(Connection conn) {
    super(conn);
  }

  public boolean create(Enseignant ens) {
      int mail = ens.getId();
      int password = ens.getId_cours();
      
      Enseignant enseignant = new Enseignant();
        
        try {
            Statement statement = this.connection.createStatement();
            
            String query = "INSERT INTO enseignant (ID_UTILISATEUR, ID_COURS) VALUES ("+mail+","+password+")";
            ResultSet resultSet = statement.executeQuery(query);           
            

        } catch (SQLException e) {
        }
      
    return false;
  }

  public boolean delete(Enseignant obj) {
    return false;
  }

  public boolean update(Enseignant obj) {
    return false;
  }
   
  
   public Enseignant find(int id) {                
        Enseignant enseignant = new Enseignant();
        
        try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM enseignant WHERE ID_UTILISATEUR = " + id;
            ResultSet resultSet = statement.executeQuery(query);           
            
            if(resultSet.first()){                
                enseignant = new Enseignant(id, resultSet.getInt("ID_COURS"));                
            }
        } catch (SQLException e) {
        }
                
        return enseignant;
    }
   
   public ArrayList<Enseignant> findAll(){
       ArrayList<Enseignant> enseignants = new ArrayList<>();
       
       try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM enseignant";
            ResultSet resultSet = statement.executeQuery(query);           
            
            if(resultSet.first()){
                
                    do{
                        enseignants.add(this.find(resultSet.getInt("ID_UTILISATEUR")));
                    }while (resultSet.next());
            }
            
        } catch (SQLException e) {
        }
       
       return enseignants;
   }

   
   
   
   
   
   
   
   
   
   
     public ArrayList<Seance> ListeS(int id_prof){
      //On rentre l'ID d'un groupe, ca donne une liste de toutes ses Seances
       ArrayList<Seance> seances = new ArrayList<>();
       ArrayList<Integer> id_seances = new ArrayList<>();
      
       
       try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM seance_enseignant WHERE ID_UTILISATEUR = " + id_prof;
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
                        seances.add(new Seance(id_seances.get(i), resultSet.getInt("SEMAINE"), resultSet.getString("SATE"), resultSet.getString("HEURE_DEBUT"), resultSet.getString("HEURE_FIN"), resultSet.getInt("ETAT"), resultSet.getInt("ID_COURS"), resultSet.getInt("ID_TYPE")));
                    }
            }
            }
            
            
        } catch (SQLException e) {
        }
      
      return seances;
  }

}