/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import java.sql.*;

/**
 *
 * @author bapti
 */
public class Connexion {
    

  //URL de connexion
  private String url = "jdbc:mysql://localhost:3306/edt?autoReconnect=true&useSSL=false";
  //Nom du user
  private String user = "root";
  //Mot de passe de l'utilisateur
  private String passwd = "";
  //Objet Connection
  private static Connection connect;
   
  //Constructeur privé
  private Connexion(){
    try {
      connect = DriverManager.getConnection(url, user, passwd);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
   
  //Méthode qui va nous retourner notre instance et la créer si elle n'existe pas
   public static Connection getInstance(){
    if(connect == null){
      new Connexion();
    }
    return connect;
  }   
}

