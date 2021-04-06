/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

/**
 *
 * @author 931702061
 */
import Controleur.*;
import Modele.Utilisateur;
import ModeleDAO.DAO;
import ModeleDAO.UtilisateurDAO;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class FenetreRefPeda extends JFrame implements ActionListener {

    private final JPanel panel;
    
    //private final JTextArea txt1;
    //private final JScrollPane scroll_1;
    JButton bAcceuil, bEnseignants, bPromotions, bGroupes, bEtudiants, bCours, bSalles;
    JButton bAcceuilBis, bEnseignantsBis, bPromotionsBis, bGroupesBis, bEtudiantsBis, bCoursBis, bSallesBis;
    private final ContFenetreRefPeda cont_fen_refPEda;

    public FenetreRefPeda(int id) {

        super("FenetreRefPeda");
        proprieteFenetre();
        cont_fen_refPEda = new ContFenetreRefPeda(this, id);
        
        Font fontEntered = new Font(Font.DIALOG, Font.ITALIC, 40);
        bAcceuil = new JButton("Acceuil");
        bAcceuil.setFont(fontEntered);
        bEnseignants = new JButton("Enseignants");
        bEnseignants.setFont(fontEntered);
        bPromotions = new JButton("Promotions");
        bPromotions.setFont(fontEntered);
        bGroupes = new JButton("Groupes");
        bGroupes.setFont(fontEntered);
        bEtudiants = new JButton("Etudiants");
        bEtudiants.setFont(fontEntered);
        bCours = new JButton("Cours");
        bCours.setFont(fontEntered);
        bSalles = new JButton("Salles");
        bSalles.setFont(fontEntered);

        bAcceuilBis = new JButton("Acceuil");
        bEnseignantsBis = new JButton("Enseignants");
        bPromotionsBis = new JButton("Promotions");
        bGroupesBis = new JButton("Groupes");
        bEtudiantsBis = new JButton("Etudiants");
        bCoursBis = new JButton("Cours");
        bSallesBis = new JButton("Salles");
        
        panel = (JPanel) this.getContentPane();
        //panel.setBackground(Color.yellow);

        //panel.setLayout(null); //--> Besoin des bounds pour placer les boutons
        //panel.setLayout(new FlowLayout()); //--> Tout en ligne
        // panel.setLayout(new GridLayout(2,2,10,10)); //--> Grille (l,c)
        //Si on ne met rien --> BorderLayout par défaut
        panel.add(createToolBar(this), BorderLayout.NORTH);
        panel.add(createStatusBar(), BorderLayout.SOUTH);

        //panel.add(createRightPanel(),BorderLayout.EAST);
        //txt1 = new JTextArea("text");
        //scroll_2 = new JScrollPane(txt1);
        //panel.add(scroll_2, BorderLayout.CENTER);
        panel.add(menuRefPeda(this), BorderLayout.CENTER);

        //scroll_1 = new JScrollPane(new Jtree());
        //scroll_1.setPreferredSize(new Dimension(150,0));
        //panel.add(createJtree(), BorderLayout.WEST);

        // add menubar to frame 
        setJMenuBar(createMenuBar(id));

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Window Closing");
                System.exit(0);
            }
        }
        );
    }

    void proprieteFenetre() {
        this.setSize(1500, 1000);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    void closeFenetreRefPeda() {
        this.hide();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Boutton pressé"); //To change body of generated methods, choose Tools | Templates.
    }

    private void menuActionListener(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "new doc required");
    }

    private JMenuBar createMenuBar(int id) {

        JMenuBar MenuBar = new JMenuBar();
        DAO<Utilisateur> utilisateurDAO = new UtilisateurDAO(Connexion.getInstance());
        String nom = utilisateurDAO.find(id).getNom();
        String prenom = utilisateurDAO.find(id).getPrenom();
        // create a menu 
        JMenu menu = new JMenu("Menu");
        menu.setMnemonic('M');

        //JMenu edt = new JMenu("Mon Emploi Du Temps");
        //JMenu recap = new JMenu("Récapitialtif de mes cours");
        // create menuitems 
        JMenuItem profil = new JMenuItem("Mon Profil");
        profil.addActionListener(this::menuActionListener);

        JMenuItem mon_nom = new JMenuItem(nom);
        JMenuItem mon_prenom = new JMenuItem(prenom);

        // add menu items to menu 
        menu.add(profil);
        menu.addSeparator();
        menu.add(nom);
        menu.add(prenom);

        // add menu to menu bar 
        MenuBar.add(menu);
        //MenuBar.add(edt);
        //MenuBar.add(recap);

        return MenuBar;
    }

    private JToolBar createToolBar(FenetreRefPeda f) {

        JToolBar ToolBar = new JToolBar();
        ToolBar.add(f.bAcceuilBis);
        ToolBar.add(f.bEnseignantsBis);     
        ToolBar.add(f.bPromotionsBis);
        ToolBar.add(f.bGroupesBis);
        ToolBar.add(f.bEtudiantsBis);
        ToolBar.add(f.bCoursBis);
        ToolBar.add(f.bSallesBis);
        
      

        f.bAcceuilBis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cont_fen_refPEda.bAcceuilclicked(e);

                closeFenetreRefPeda();
            }
        });
      
        f.bEnseignantsBis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cont_fen_refPEda.bEnsclicked(e);

                closeFenetreRefPeda();
            }
        });

       
        f.bPromotionsBis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cont_fen_refPEda.bPromoclicked(e);

                closeFenetreRefPeda();
            }
        });

       
        f.bGroupesBis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cont_fen_refPEda.bGroupeclicked(e);

                closeFenetreRefPeda();
            }
        });

       
        f.bEtudiantsBis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cont_fen_refPEda.bEtudiantclicked(e);

                closeFenetreRefPeda();
            }
        });

      
        f.bCoursBis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //cont_fen_refPEda.bCoursclicked(e);

                closeFenetreRefPeda();
            }
        });

       
        f.bSallesBis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cont_fen_refPEda.bSallesclicked(e);

                closeFenetreRefPeda();
            }
        });

        return ToolBar;
    }

    private JPanel menuRefPeda(FenetreRefPeda f) {

        JPanel jpanel = new JPanel();
        jpanel.setLayout(new GridLayout(3, 2)); //--> Grille (l,c)
        
        
        jpanel.add(f.bEnseignants);     
        jpanel.add(f.bPromotions);
        jpanel.add(f.bGroupes);
        jpanel.add(f.bEtudiants);
        jpanel.add(f.bCours);
        jpanel.add(f.bSalles);

        
      
        f.bEnseignants.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cont_fen_refPEda.bEnsclicked(e);

                closeFenetreRefPeda();
            }
        });

       
        f.bPromotions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cont_fen_refPEda.bPromoclicked(e);

                closeFenetreRefPeda();
            }
        });

       
        f.bGroupes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cont_fen_refPEda.bGroupeclicked(e);

                closeFenetreRefPeda();
            }
        });

       
        f.bEtudiants.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cont_fen_refPEda.bEtudiantclicked(e);

                closeFenetreRefPeda();
            }
        });

      
        f.bCours.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cont_fen_refPEda.bCoursclicked(e);

                closeFenetreRefPeda();
            }
        });

       
        f.bSalles.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cont_fen_refPEda.bSallesclicked(e);

                closeFenetreRefPeda();
            }
        });
        
        return jpanel;
    }

    private JPanel createStatusBar() {

        JPanel StatusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel l1 = new JLabel("Emploie du Temps ECE Paris 2020");
        l1.setPreferredSize(new Dimension(200, 20));
        StatusBar.add(l1);
        return StatusBar;
    }

//    private JScrollPane createJtree() {
//
//        //JTree jTree = new JTree();
//        JScrollPane scrool = new JScrollPane(new JTree());
//        scrool.setPreferredSize(new Dimension(150, 0));
//        return scrool;
//    }

    /**
     * private JPanel createRightPanel() {
     *
     * JPanel RightPanel = new JPanel(new GridLayout(3,1));
     *
     * JButton b1 = new JButton("Button1"); b1.setPreferredSize(new Dimension
     * (100,20)); b1.addActionListener(new ActionListener() { public void
     * actionPerformed(ActionEvent e) { System.out.println("BOUTON 1 PRESSE"); }
     * }); RightPanel.add(b1);
     *
     * JButton b2 = new JButton("Button2"); b2.setPreferredSize(new Dimension
     * (100,20)); RightPanel.add(b2);
     *
     * JButton b3 = new JButton("Button3"); b3.setPreferredSize(new Dimension
     * (100,20)); RightPanel.add(b3);
     *
     * return RightPanel;
    }*
     */
}
