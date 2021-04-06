package Modele;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bapti
 */
public class Utilisateur {
    
    //ID
    private int id = 0;
    //email
    private String email = "";
    //passwd
    private String password = "";
    //nom
    private String nom = "";
    //prenom
    private String prenom = "";
    //droit
    private int droit = 0;
    /*
    0 = aucun droit
    1 = admin
    2 = referant pedagogique
    3 = enseignant
    4 = etudiant
    */

    public Utilisateur(int id, String email, String password, String nom, String prenom, int droit) {
      this.id = id;
      this.email= email;
      this.password = password;
      this.nom = nom;
      this.prenom = prenom;
      this.droit = droit;
    }
    
    public Utilisateur(){};

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }
    
    public String getPassword() {
      return password;
    }

    public void setPassword(String password) {
      this.password = password;
    }
    
    public String getNom() {
      return nom;
    }

    public void setNom(String nom) {
      this.nom = nom;
    }
    
    public String getPrenom() {
      return prenom;
    }

    public void setPrenom(String prenom) {
      this.prenom = prenom;
    }

    public int getDroit() {
      return droit;
    }

    public void setDroit(int droit) {
      this.droit = droit;
    }   
    
    
}
