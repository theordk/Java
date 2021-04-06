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

import Modele.Groupe;
import Modele.Etudiant;
import Modele.Seance;
import java.sql.*;
import java.util.*;

public class GroupeDAO extends DAO<Groupe> {
    
public GroupeDAO(Connection conn) {
    super(conn);
  }

  public boolean create(Groupe u) {
          int mail = u.getId();
          String password = u.getNom();
          int idp = u.getId_promo();

      
        
        try {
            Statement statement = this.connection.createStatement();
            
            String query = "INSERT INTO groupe (ID, NOM, ID_PROMOTION) VALUES ("+mail+","+password+","+idp+")";
            ResultSet resultSet = statement.executeQuery(query);           
            

        } catch (SQLException e) {
        }
    return false;
  }

  public boolean delete(Groupe obj) {
    return false;
  }
   
  public boolean update(Groupe obj) {
    return false;
  }
   

  
  public Groupe find(int id) {                
        Groupe groupe = new Groupe();
        
        try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM groupe WHERE ID = " + id;
            ResultSet resultSet = statement.executeQuery(query);           
            
            if(resultSet.first()){                
                groupe = new Groupe(id, resultSet.getString("NOM"), resultSet.getInt("ID_PROMOTION"));                
            }
        } catch (SQLException e) {
        }
                
        return groupe;
       
    }
  
    public ArrayList<Groupe> findAll(){
       ArrayList<Groupe> groupes = new ArrayList<>();
       
       try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM groupe";
            ResultSet resultSet = statement.executeQuery(query);           
            
            if(resultSet.first()){
                
                    do{
                        groupes.add(this.find(resultSet.getInt("ID")));
                    }while (resultSet.next());
            }
            
        } catch (SQLException e) {
        }
       
       return groupes;
   }
  
    
    
    
    
  
  public ArrayList<Etudiant> Liste(int id_grp){
      //On rentre l'ID d'un groupe, ca donne une liste d'Etudiants
       ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
       
       try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM etudiant WHERE ID_GROUPE = " + id_grp;
            ResultSet resultSet = statement.executeQuery(query);           
            
            if(resultSet.first()){
                
                    while (resultSet.next()) {
                etudiants.add(new Etudiant(resultSet.getInt("ID_UTILISATEUR"), resultSet.getInt("NUMERO"), id_grp));
            }
            }
        } catch (SQLException e) {
        }
      
      return etudiants;
  }
  
  
  
  
  
  
  
  
  
  public ArrayList<Seance> ListeS(int id_grp){
      //On rentre l'ID d'un groupe, ca donne une liste de toutes ses Seances
       ArrayList<Seance> seances = new ArrayList<>();
       ArrayList<Integer> id_seances = new ArrayList<>();
      
       
       try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM seance_groupe WHERE ID_GROUPE = " + id_grp;
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



