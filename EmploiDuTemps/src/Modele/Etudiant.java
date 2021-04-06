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
public class Etudiant extends Utilisateur{
    
    //ID
    private int id = 0;
    //Numero etudiant
    private int numero = 0;
    //ID groupe
    private int id_grp = 0;

    public Etudiant(int id, int numero, int id_grp) {
      this.id = id;
      this.numero = numero;
      this.id_grp = id_grp;
    }
    
    public Etudiant(){};

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public int getNumero() {
      return numero;
    }

    public void setNumero(int numero) {
      this.numero = numero;
    }

    public int getId_grp() {
      return id_grp;
    }

    public void setId_grp(int id_grp) {
      this.id_grp = id_grp;
    }   
    
}
