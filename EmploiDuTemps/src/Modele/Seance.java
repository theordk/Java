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
public class Seance {
    
    private Cours cours;
    
    //ID
    private int id = 0;
    
    //semaine
    private int semaine = 0;
    
    //date
    private String date = "";
    
    //heure_debut 
    private String heure_d = "";
    
    //heure_fin
    private String heure_f = "";
    
    //etat
    private int etat = 0;
        
    //id_cours
    private int id_cours = 0;
    
    //id_type
    private int id_type = 0;
    
    public Seance(int id, int semaine, String date, String heure_d, String heure_f, int etat, int id_cours, int id_type){
        this.id = id;
        this.semaine = semaine;
        this.date = date;
        this.heure_d = heure_d;
        this.heure_f = heure_f;
        this.etat = etat;
        this.id_cours = id_cours;
        this.id_type = id_type;
    }
    
    public Seance(){};
    
    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }
    
    public int getSemaine() {
      return semaine;
    }

    public void setSemaine(int semaine) {
      this.semaine = semaine;
    }
    
    public String getDate() {
      return date;
    }

    public void setDate(String date) {
      this.date = date;
    } 
    
    public String getHeureD() {
      return heure_d;
    }

    public void setHeureD(String heure_d) {
      this.date = heure_d;
    } 
    
    public String getHeureF() {
      return heure_f;
    }

    public void setHeureF(String heure_f) {
      this.date = heure_f;
    } 
    
    public int getEtat() {
      return etat;
    }

    public void setEtat(int etat) {
      this.etat = etat;
    }
    
    public int getId_cours(){
      return id_cours;
    }

    public void setId_cours(int id_cours){
      this.id_cours = id_cours;
    }
    
    public int getId_type() {
      return id_type;
    }

    public void setId_type(int id_type){
      this.id_type = id_type;
    }
}
