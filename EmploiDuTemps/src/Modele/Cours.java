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
public class Cours {
   
    //ID
    private int id = 0;
    
    //nom
    private String nom = "";


    
    
    public Cours(int id, String nom){
        
      this.id = id;
      this.nom = nom;

    }
    
    public Cours(){};
    
    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getNom() {
      return nom;
    }

    public void setNom(String nom) {
      this.nom = nom;
    } 

}
