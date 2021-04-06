/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Vue.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author 931702061
 */
public class ContFenetre_Admin {

    private final Fenetre_Admin f_admin;
    private int id;

    //Constructeur du Controle de ma fenetre d'acceuil
    public ContFenetre_Admin(Fenetre_Admin f, int id) {
        this.f_admin = f;
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
        Fenetre_Admin f_admin = new Fenetre_Admin(id);
    }

    public void bAcceuilToolclicked(ActionEvent e) {
        // tout ce qu'il faut faire      
        //System.out.println("ok ca marche ");
        Fenetre_Admin f_admin = new Fenetre_Admin(id);
    }

    public void bEnsclicked(ActionEvent e) {
        // tout ce qu'il faut faire      
        //System.out.println("ok ca marche ");
        FenEnsListe f_liste_ens = new FenEnsListe(id);
    }

    public void bVoirEDTclicked(ActionEvent e) {
        // tout ce qu'il faut faire     
        //System.out.println("ok ca marche ");
        FenetreRefPeda f_refpeda = new FenetreRefPeda(id);   
    }

    public void bVoirEDTToolclicked(ActionEvent e) {
        // tout ce qu'il faut faire     
        //System.out.println("ok ca marche ");
        //FenPromoListe f_liste_promo = new FenPromoListe(id);
        FenetreRefPeda f_refpeda = new FenetreRefPeda(id);
    }
    
    public void bGererEDTclicked(ActionEvent e) {
        // tout ce qu'il faut faire     
        //System.out.println("ok ca marche ");
        //FenPromoListe f_liste_promo = new FenPromoListe(id);      
    }

    public void bGererEDTToolclicked(ActionEvent e) {
        // tout ce qu'il faut faire     
        //System.out.println("ok ca marche ");
        //FenPromoListe f_liste_promo = new FenPromoListe(id);      
    }
    
    

    public void bPromoclicked(ActionEvent e) {
        // tout ce qu'il faut faire     
        //System.out.println("ok ca marche ");
        FenPromoListe f_liste_promo = new FenPromoListe(id);
    }

    public void bGroupeclicked(ActionEvent e) {
        // tout ce qu'il faut faire     
        //System.out.println("ok ca marche ");
        FenGroupeListe f_liste_groupe = new FenGroupeListe(id);
    }

    public void bEtudiantclicked(ActionEvent e) {
        // tout ce qu'il faut faire     
        //System.out.println("ok ca marche ");
        FenEtuListe f_liste_etu = new FenEtuListe(id);
    }

    public void bCoursclicked(ActionEvent e) {
        // tout ce qu'il faut faire     
        //System.out.println("ok ca marche ");
        FenCoursListe f_liste_cours = new FenCoursListe(id);
    }

    public void bSallesclicked(ActionEvent e) {
        // tout ce qu'il faut faire     
        //System.out.println("ok ca marche ");
        FenSallesListe f_liste_salles = new FenSallesListe(id);
    }

}
