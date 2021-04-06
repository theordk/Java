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
public class Seance_Enseignant {
    
    //ID
    private int id_u = 0;
    
    //ID
    private int id_s = 0;
    
    

    
    public Seance_Enseignant(int id_s, int id_u){
              this.id_u = id_u;
              this.id_s = id_s;
        }

    public Seance_Enseignant() {
    }

    
    
    public int getId_u() {
        return id_u;
    }

    public int getId_s() {
        return id_s;
    }

    public void setId_u(int id_u) {
        this.id_u = id_u;
    }

    public void setId_s(int id_s) {
        this.id_s = id_s;
    }
    
    

}