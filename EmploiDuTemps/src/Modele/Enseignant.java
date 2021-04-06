/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author bapti
 */
public class Enseignant extends Utilisateur{
    
    //ID
    private int id = 0;

    //ID cours
    private int id_cours = 0;

    public Enseignant(int id, int id_cours) {
      this.id = id;
      this.id_cours = id_cours;
    }
    
    public Enseignant(){};

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public int getId_cours() {
      return id_cours;
    }

    public void setId_cours(int id_cours) {
      this.id_cours = id_cours;
    }   
    
}

