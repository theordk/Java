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
public class Salle {
    

    
    //ID
    private int id = 0;
    
    //nom
    private String nom = "";
    
    //capacité
    private int capacite = 0;
    
    //site
    private int id_site = 0;


    
    
    public Salle(int id, String nom, int capacite, int id_site){
        
      this.id = id;
      this.nom = nom;
      this.capacite = capacite;
      this.id_site = id_site;

    }
    
    public Salle(){};
    
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
    
    public int getCapacite() {
      return capacite;
    }

    public void setCapacite(int capacite) {
      this.capacite = capacite;
    }
    
    public int getId_site() {
      return id;
    }

    public void setId_site(int id_site) {
      this.id_site = id_site;
    }

    
}
