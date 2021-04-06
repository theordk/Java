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
public class Seance_Groupe {
    
        //ID
    private int id_s = 0;
    
    //ID
    private int id_g = 0;
    


    
    public Seance_Groupe(int id_s, int id_g){
              this.id_s = id_s;
              this.id_g = id_g;
        }

    public Seance_Groupe() {
    }

    
    
    public int getId_s() {
        return id_s;
    }

    public int getId_g() {
        return id_g;
    }

    public void setId_u(int id_s) {
        this.id_s = id_s;
    }

    public void setId_g(int id_g) {
        this.id_g = id_g;
    }

    

    
}
