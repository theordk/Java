package Modele;
import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bapti
 */
public class Groupe {
    
    //Etudiant
    protected ArrayList<Etudiant> etudiants = new ArrayList<>();

    //ID
    private int id = 0;
    
    //nom
    private String nom = "";

    //ID promotion
    private int id_promo = 0;
    
    
    public Groupe(int id, String nom, int id_promo){
        
      this.id = id;
      this.nom = nom;
      this.id_promo = id_promo;
    }
    
    public Groupe(){};
    
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
    
    public int getId_promo() {
      return id_promo;
    }

    public void setId_promo(int id_promo) {
      this.id_promo = id_promo;
    }
    
    
}

