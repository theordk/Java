/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

/**
 *
 * @author diego
 */
import Modele.*;
import ModeleDAO.*;
import Vue.FenetreEE_Acceuil;
import Vue.FenetreRefPeda;
import Vue.Fenetre_Admin;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

public class Authentification extends JFrame {

    JLabel login, mdp;
    JTextField login1;
    JPasswordField mdp1;
    JButton valider, annuler;

    public Authentification() {
        
        super();

        this.setTitle(" INTERFACE CONNEXION ");
        this.setSize(new Dimension(400, 200));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

        login = new JLabel("Login");
        login1 = new JTextField();
        mdp = new JLabel("Mot de Passe");
        mdp1 = new JPasswordField();
        valider = new JButton("Valider ");
        annuler = new JButton(" Annuler");

        Container contenu = this.getContentPane();
        contenu.setLayout(null);
        contenu.add(login);
        login.setBounds(20, 20, 100, 20);
        contenu.add(login1);
        login1.setBounds(150, 20, 150, 20);
        contenu.add(mdp);
        mdp.setBounds(22, 55, 100, 20);
        contenu.add(mdp1);
        mdp1.setBounds(150, 55, 150, 20);
        contenu.add(valider);
        valider.setBounds(125, 100, 77, 20);
        contenu.add(annuler);
        annuler.setBounds(225, 100, 82, 20);

        annuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                System.exit(0);
            }
        });
        valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                //authentification(login1 ,mdp1);

                String login = login1.getText();
                System.out.println("log = " + login);
                String password = mdp1.getText();
                System.out.println("log = " + password);

                //login = "baptiste.boyer@gmail.com" ;
                //password = "123456";
                DAO<Utilisateur> utilisateurDAO = new UtilisateurDAO(Controleur.Connexion.getInstance());
                ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
                utilisateurs = utilisateurDAO.findAll();

                for (Utilisateur u : utilisateurs) {
                    if (u.getEmail().equals(login) && u.getPassword().equals(password)) {
                        
      
                        int droit = u.getDroit();
                        int id = u.getId();
                        
                        if (droit == 3 || droit == 4) { //Enseignant ou eleve 
                            closeFenetreCo();
                            FenetreEE_Acceuil fee_a = new FenetreEE_Acceuil(id);
                        
                        } else if (droit == 2) { //Ref peda
                            closeFenetreCo();
                            FenetreRefPeda f_refPeda = new FenetreRefPeda(id);
                            
                        } else if (droit == 1) { //Admin
                            closeFenetreCo();
                            Fenetre_Admin f_admin = new Fenetre_Admin(id);
                            
                        }

                        //System.out.println("Connexion Réussie!");
                        System.out.println("ID = " + id);
                        System.out.println("Droit = " + droit);
                        JFrame newFrame = new JFrame();
                    } else {
                        //System.out.println("Mauvais login ou password!");
                    }

                }
            }

        });
    }
    
    void closeFenetreCo() {
        this.hide();
    }
}
