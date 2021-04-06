/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Vue.FenetreEE_Acceuil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.*;
import Vue.FenetreEE_EDT;
import Vue.FenetreEE_RecapCours;

/**
 *
 * @author 931702061
 */
public class ContFenetreEE_Acceuil implements ActionListener{
    
   
    private final FenetreEE_Acceuil f_accueil;
    private int id;
    
    //Constructeur du Controle de ma fenetre d'acceuil
    public ContFenetreEE_Acceuil(FenetreEE_Acceuil f, int id){
          this.f_accueil = f;
          this.id = id;
    }
    
    //gestion des evenements sur la fenetre
    public void actionPerformed(ActionEvent e) {
          
    }
    
//    void closeFenetreEE_Acceuil(FenetreEE_Acceuil fe) {
//        fe.hide();
//    }
    
    public void bAcceuilclicked(ActionEvent e) {
        // tout ce qu'il faut faire      
      //System.out.println("ok ca marche ");
      FenetreEE_Acceuil f_EE_acc = new FenetreEE_Acceuil(id);     
    }
    
     public void bAcceuilToolclicked(ActionEvent e) {
        // tout ce qu'il faut faire     
        //System.out.println("ok ca marche ");
        FenetreEE_Acceuil f_EE_acc = new FenetreEE_Acceuil(id);      
    }
      
    public void bEDTclicked(ActionEvent e) {
          
      //AFFICHER EDT
      FenetreEE_EDT f_EE_edt = new FenetreEE_EDT(id);
        
    }
    
    public void bEDTToolclicked(ActionEvent e) {
          
      //AFFICHER EDT
      FenetreEE_EDT f_EE_edt = new FenetreEE_EDT(id);
        
    }
    
    public void bRecapclicked(ActionEvent e) {
        // tout ce qu'il faut faire     
        //System.out.println("ok ca marche ");
        FenetreEE_RecapCours f_EE_recap = new FenetreEE_RecapCours(id);       
    }
    
    public void bRecapToolclicked(ActionEvent e) {
        // tout ce qu'il faut faire     
        //System.out.println("ok ca marche ");
        FenetreEE_RecapCours f_EE_recap = new FenetreEE_RecapCours(id);       
    }
    
   
    
    
    
}
