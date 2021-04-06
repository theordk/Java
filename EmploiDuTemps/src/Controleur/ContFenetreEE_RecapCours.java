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
public class ContFenetreEE_RecapCours implements ActionListener{
    
   
    private final FenetreEE_RecapCours f_recap;
    private int id;
    //Constructeur du Controle de ma fenetre d'acceuil
    public ContFenetreEE_RecapCours(FenetreEE_RecapCours f, int id){
          this.f_recap = f;
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
      
    public void bEDTclicked(ActionEvent e) {
        // tout ce qu'il faut faire      
      //System.out.println("ok ca marche ");
      FenetreEE_EDT f_EE_edt = new FenetreEE_EDT(id);     
    }
    
    public void bRecapclicked(ActionEvent e) {
        // tout ce qu'il faut faire     
        //System.out.println("ok ca marche ");
        FenetreEE_RecapCours f_EE_recap = new FenetreEE_RecapCours(id);       
    }
}
