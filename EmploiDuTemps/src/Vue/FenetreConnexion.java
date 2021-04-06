/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author 931702061
 */
public class FenetreConnexion extends JFrame implements ActionListener {

    private final JPanel panel_co;
    

    public FenetreConnexion(String titre) {

        super("FenetreConnexion");
        
        //proprieteFenetreCon()
        this.setSize(500, 300);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        panel_co = (JPanel) this.getContentPane();

        panel_co.add(northField(), BorderLayout.NORTH);
        panel_co.add(centerField(), BorderLayout.CENTER);
        panel_co.add(verifier_co(), BorderLayout.SOUTH);
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Window Closing");
                System.exit(0);
            }
        }
        );

        /**
         * // Création des labels avec mnémoniques JLabel lblEmail = new
         * JLabel("Email", JLabel.LEFT); lblEmail.setDisplayedMnemonic('E'); //
         * Définir le mnémonique lblEmail.setLabelFor(txtEmail); // Définir le
         * composant qui est labelé
         *
         * JLabel lblMdp = new JLabel("Mot de passe", JLabel.LEFT);
         * lblMdp.setDisplayedMnemonic('M'); lblMdp.setLabelFor(txtMdp);          *
         * //Creation du boutton de validation valider = new JButton("Valider");
         *
         * JPanel p = new JPanel( ); p.setLayout(new GridLayout(3,1,7,7));
         *
         * p.add(lblEmail); p.add(txtEmail);          *
         * p.add(lblMdp); p.add(txtMdp);
         *
         * p.add(valider);
    *
         */
    }

    void proprieteFenetreCon() {
        
    }
    
    void closeFenetreCo(){
        this.hide();
    }

    private JPanel northField() {

        JPanel northField = new JPanel(new FlowLayout(FlowLayout.LEFT));
        northField.setPreferredSize(new Dimension(200,100));
        
        JLabel txtEmail = new JLabel("Mon Email");
        txtEmail.setPreferredSize(new Dimension (100,30));
        northField.add(txtEmail);
        
        JTextArea msgEmail = new JTextArea("Saisir un email");
        txtEmail.setPreferredSize(new Dimension (100,30));
        northField.add(msgEmail);
       
        return northField;
    }
    
    private JPanel centerField() {

        JPanel centerField = new JPanel(new FlowLayout(FlowLayout.LEFT));
        centerField.setPreferredSize(new Dimension(200,100));
        
        JLabel txtMdp = new JLabel("Mon Mdp");
        txtMdp.setPreferredSize(new Dimension (100,30));
        centerField.add(txtMdp);
        
        JTextArea msgMdp = new JTextArea("Saisir mon mdp");
        msgMdp.setPreferredSize(new Dimension (100,30));
        centerField.add(msgMdp);
       
        return centerField;
    }
    
    public JButton verifier_co() {
        
        JButton valider = new JButton("Valider");
        valider.setPreferredSize(new Dimension (100,30));
        
        valider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //FenetreEDT test_fe = new FenetreEDT();
                //FenetreRefPeda frp = new FenetreRefPeda();
                closeFenetreCo();
            }
            });
        return valider;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Boutton pressé"); //To change body of generated methods, choose Tools | Templates.
    } 
}
