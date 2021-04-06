package Modele;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bapti
 */
public class Seance_Salle {
    
        //ID
    private int id_salle = 0;
    
    //ID
    private int id_s = 0;
    


    
    public Seance_Salle(int id_s, int id_salle){
        
              this.id_salle = id_salle;
              this.id_s = id_s;
        }

    public Seance_Salle() {
    }

    public int getId_salle() {
        return id_salle;
    }

    public int getId_s() {
        return id_s;
    }

    public void setId_salle(int id_salle) {
        this.id_salle = id_salle;
    }

    public void setId_s(int id_s) {
        this.id_s = id_s;
    }
   

    


    
}
