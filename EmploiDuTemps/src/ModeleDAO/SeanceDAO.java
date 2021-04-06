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
import Modele.Groupe;
import Modele.Salle;
import Modele.Seance;
import java.sql.*;
import Modele.Type_Cours;
import java.util.ArrayList;

public class SeanceDAO extends DAO<Seance> {
    
public SeanceDAO(Connection conn) {
    super(conn);
  }

  public boolean create(Seance u) {
      
      int id = u.getId();
      int sem = u.getSemaine();
      String date = u.getDate();
      String HD = u.getHeureD();
      String HF = u.getHeureF();
      int etat = u.getEtat();
      int idc = u.getId_cours();
      int idt = u.getId_type();
      
        
        try {
            Statement statement = this.connection.createStatement();
            
            String query = "INSERT INTO seance (ID, SEMAINE, DATE, HEURE_DEBUT, HEURE_FIN, ETAT, ID_COURS, ID_TYPE) VALUES ("+id+","+sem+", "+date+", "+HD+", "+HF+", "+etat+", "+idc+", "+idt+")";
            ResultSet resultSet = statement.executeQuery(query);           
            

        } catch (SQLException e) {
        }
    return false;
  }

  public boolean delete(Seance obj) {
    return false;
  }
   
  public boolean update(Seance obj) {
    return false;
  }
   

  
  public Seance find(int id) {                
        Seance seance = new Seance();
        
        try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM seance WHERE ID = " + id;
            ResultSet resultSet = statement.executeQuery(query);           
            
            if(resultSet.first()){                
                seance = new Seance(id, resultSet.getInt("SEMAINE"), resultSet.getString("DATE"), resultSet.getString("HEURE_DEBUT"), resultSet.getString("HEURE_FIN"), resultSet.getInt("ETAT"), resultSet.getInt("ID_COURS"), resultSet.getInt("ID_TYPE"));                
            }
        } catch (SQLException e) {
        }
                
        return seance;
    }
    public ArrayList<Seance> findAll(){
       ArrayList<Seance> seances = new ArrayList<>();
       
       try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM seance";
            ResultSet resultSet = statement.executeQuery(query);           
            
            if(resultSet.first()){
                
                    do{
                        seances.add(this.find(resultSet.getInt("ID")));
                    }while (resultSet.next());
            }
            
        } catch (SQLException e) {
        }
       
       return seances;
   }
  
  
    public Salle GetSalle(int id_seance){
      //On rentre l'ID de la seance, ca donne sa salle
      Salle salle = new Salle();
      int id_salle = 0;
      
       
       try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM seance_salle WHERE ID_SEANCE = " + id_seance;
            ResultSet resultSet = statement.executeQuery(query);           
            
            if(resultSet.first()){
                    
                id_salle = resultSet.getInt("ID_SALLE");            
            }

        } catch (SQLException e) {
        }
       
        try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM salle WHERE ID_SALLE = " + id_salle;
            ResultSet resultSet = statement.executeQuery(query);           
            
            if(resultSet.first()){
                    
                salle = new Salle(id_salle, resultSet.getString("NOM"), resultSet.getInt("CAPACITE"), resultSet.getInt("ID_SITE"));          
            }

        } catch (SQLException e) {
        }
       
       
      
      return salle;
  }
    
     public Enseignant GetEnseignant(int id_seance){
      //On rentre l'ID de la seance, ca donne son enseignant
      Enseignant enseignant = new Enseignant();
      int id_enseignant=0;
      
      
       
       try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM seance_enseignant WHERE ID_SEANCE = " + id_seance;
            ResultSet resultSet = statement.executeQuery(query);           
            
            if(resultSet.first()){
                    
                id_enseignant = resultSet.getInt("ID_UTILISATEUR");            
            }

        } catch (SQLException e) {
        }
       
        try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM enseignant WHERE ID_UTILISATEUR= " + id_enseignant;
            ResultSet resultSet = statement.executeQuery(query);           
            
            if(resultSet.first()){
                    
                enseignant = new Enseignant(id_enseignant, resultSet.getInt("ID_COURS"));          
            }

        } catch (SQLException e) {
        }
       
       
      
      return enseignant;
  }
    
     public ArrayList<Groupe> GetGroupes(int id_seance){
      //On rentre l'ID d'un groupe, ca donne une liste de toutes ses Seances
       ArrayList<Groupe> groupes = new ArrayList<>();
       ArrayList<Integer> id_groupes = new ArrayList<>();
      
       
       try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM seance_groupe WHERE ID_SEANCE = " + id_seance;
            ResultSet resultSet = statement.executeQuery(query);           
            
            if(resultSet.first()){
                
                    while (resultSet.next()) {
                        id_groupes.add(resultSet.getInt("ID_SEANCE"));
                    }
            }
            
            
            
        } catch (SQLException e) {
        }
       
       try {
            for(int i=0; i<id_groupes.size();i++){
                
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM seance WHERE ID_Seance = " + id_groupes.get(i);
            ResultSet resultSet = statement.executeQuery(query);           
            
            if(resultSet.first()){
                
                    while (resultSet.next()) {
                        groupes.add(new Groupe(id_groupes.get(i),resultSet.getString("NOM"), resultSet.getInt("ID_PROMOTION")));
                    }
            }
            }
            
            
        } catch (SQLException e) {
        }
      
      return groupes;
  }
  
}

