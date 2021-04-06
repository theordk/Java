/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeleDAO;


import Modele.Etudiant;
import Modele.Groupe;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author bapti
 */

public class EtudiantDAO extends DAO<Etudiant> {
    
  public EtudiantDAO(Connection conn) {
    super(conn);
  }

  public boolean create(Etudiant u) {
      
      int mail = u.getId();
      int password = u.getNumero();
      int id = u.getId_grp();

      
        
        try {
            Statement statement = this.connection.createStatement();
            
            String query = "INSERT INTO etudiant (ID, NUMERO, ID_GROUPE) VALUES ("+mail+","+password+","+id+")";
            ResultSet resultSet = statement.executeQuery(query);           
            

        } catch (SQLException e) {
        }
    return false;
  }

  public boolean delete(Etudiant obj) {
    return false;
  }
   
  public boolean update(Etudiant obj) {
    return false;
  }
   

  
  public Etudiant find(int id) {                
        Etudiant etudiant = new Etudiant();
        
        try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM etudiant WHERE ID_UTILISATEUR = " + id;
            ResultSet resultSet = statement.executeQuery(query);           
            
            if(resultSet.first()){                
                etudiant = new Etudiant(id, resultSet.getInt("NUMERO"), resultSet.getInt("ID_GROUPE"));                
            }
        } catch (SQLException e) {
        }
                
        return etudiant;
    }
  
  public ArrayList<Etudiant> findAll(){
       ArrayList<Etudiant> etudiants = new ArrayList<>();
       
       try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM etudiant";
            ResultSet resultSet = statement.executeQuery(query);           
            
            if(resultSet.first()){
                
                    do{
                        etudiants.add(this.find(resultSet.getInt("ID_UTILISATEUR")));
                    }while (resultSet.next());
            }
            
        } catch (SQLException e) {
        }
       
       return etudiants;
   }
  
  
  
  
  
  
  
  
  
  
  
  
  
  public Groupe getGroupe(int id){
      Groupe groupe = new Groupe();
      int id_grp=0;
        try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT id_groupe FROM etudiant WHERE ID_UTILISATEUR = " + id;
            ResultSet resultSet = statement.executeQuery(query);   
            
        if(resultSet.first()){
                id_grp = resultSet.getInt("ID_GROUPE");
            }
        } catch (SQLException e) {
        }
        
        try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM groupe WHERE ID = " + id_grp;
            ResultSet resultSet = statement.executeQuery(query);   
            
        if(resultSet.first()){
                groupe = new Groupe(id_grp, resultSet.getString("NOM"),resultSet.getInt("ID_PROMOTION"));
            }
        } catch (SQLException e) {
        }
        
      
      
      return groupe;
  }
  
}
