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
import Controleur.Connexion;
import Controleur.ContFenetreEE_Acceuil;
import Modele.Utilisateur;
import ModeleDAO.DAO;
import ModeleDAO.UtilisateurDAO;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;


public class FenetreEE_Acceuil extends JFrame implements ActionListener {

    private final JPanel panel;
   

    private final ContFenetreEE_Acceuil cont_acceuil;
    private final JButton bEDT,bRecapCours;
    private final JButton bAcceuil, bEDTTool, bRecapCoursTool;

    //private final JTextArea txt1;
    //private final JScrollPane scroll_1;
    
    
    public FenetreEE_Acceuil(int id) {

        cont_acceuil = new ContFenetreEE_Acceuil(this,id);
        //b0 = new JButton("Accueil"); 
        bEDT = new JButton("Acceder à mon Emploi du Temps");
        bRecapCours = new JButton("Recapitulatif de mes cours");
        bAcceuil = new JButton ("Acceuil");
        bEDTTool  = new JButton("Mon Emploi Du Temps");
        bRecapCoursTool = new JButton("Récapitialtif de mes cours");   
             
        //super("FenetreEE_Acceuil");
        proprieteFenetre();

        panel = (JPanel) this.getContentPane();
        //panel.setBackground(Color.yellow);
        
        panel.add(createToolBar(this), BorderLayout.NORTH);
        panel.add(createStatusBar(), BorderLayout.SOUTH);
        //panel.add(createRightPanel(), BorderLayout.EAST); //Mes bouttons
        panel.add(panelAcceuil(this), BorderLayout.CENTER);
        
        // add menubar to frame 
        setJMenuBar(createMenuBar(id));
        
        

        //panel.setLayout(null); //--> Besoin des bounds pour placer les boutons
        //panel.setLayout(new FlowLayout()); //--> Tout en ligne
        // panel.setLayout(new GridLayout(2,2,10,10)); //--> Grille (l,c)
        //Si on ne met rien --> BorderLayout par défaut

        
        //txt1 = new JTextArea("text");
        //scroll_2 = new JScrollPane(txt1);
        //panel.add(scroll_2, BorderLayout.CENTER);
        

        //scroll_1 = new JScrollPane(new Jtree());
        //scroll_1.setPreferredSize(new Dimension(150,0));
        
        //panel.add(createJtree(), BorderLayout.WEST); //Le JTree

 
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
        //this.setFont(new Font("Times New Roman",Font.BOLD,30));
    }

    void closeFenetreEE_Acceuil() {
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

    private JToolBar createToolBar(FenetreEE_Acceuil f) {

        JToolBar ToolBar = new JToolBar();
        
        ToolBar.add(f.bAcceuil);
        ToolBar.add(f.bEDTTool);
        ToolBar.add(f.bRecapCoursTool);

        f.bAcceuil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cont_acceuil.bAcceuilToolclicked(e);              
                closeFenetreEE_Acceuil();
            }
        });
        
        f.bEDTTool.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cont_acceuil.bEDTToolclicked(e);              
                closeFenetreEE_Acceuil();
            }
        });
        
        f.bRecapCoursTool.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cont_acceuil.bRecapToolclicked(e);              
                closeFenetreEE_Acceuil();
            }
        });
         
        return ToolBar;
    }

    private JPanel panelAcceuil(FenetreEE_Acceuil f) {

        JPanel jpanel = new JPanel();
        jpanel.setLayout(new GridLayout(3, 1)); //--> Grille (l,c)

        JLabel txt = new JLabel("Bienvenue sur votre page d'acceuil");
        txt.setFont(new Font("Times New Roman", Font.BOLD, 50));
        txt.setForeground(Color.BLACK);
        txt.setHorizontalAlignment(SwingConstants.CENTER);

        //Font fontDefaut = b1.getFont();
        Font fontEntered = new Font(Font.DIALOG, Font.ITALIC, 40);
        f.bEDT.setFont(fontEntered);
        f.bRecapCours.setFont(fontEntered);
    
        f.bEDT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cont_acceuil.bEDTclicked(e);              
                closeFenetreEE_Acceuil();
            }
        });
        
        bRecapCours.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cont_acceuil.bRecapclicked(e);
                closeFenetreEE_Acceuil();
            }
        });

        jpanel.add(txt);
        jpanel.add(f.bEDT);
        jpanel.add(bRecapCours);

        return jpanel;
    }

    private JPanel createStatusBar() {

        JPanel StatusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel l1 = new JLabel("Projet Java");
        l1.setPreferredSize(new Dimension(200, 20));
        StatusBar.add(l1);

//        JLabel l2 = new JLabel("Message2");
//        l2.setPreferredSize(new Dimension(100, 20));
//        StatusBar.add(l2);
//
//        JLabel l3 = new JLabel("Message3");
//        l3.setPreferredSize(new Dimension(100, 20));
//        StatusBar.add(l3);

        return StatusBar;
    }

//    private JScrollPane createJtree() {
//
//        //JTree jTree = new JTree();
//        JScrollPane scrool = new JScrollPane(new JTree());
//        scrool.setPreferredSize(new Dimension(150, 0));
//        return scrool;
//    }
//
//    private JPanel createRightPanel() {
//
//        JPanel RightPanel = new JPanel(new GridLayout(3, 1));
//
//        JButton b1 = new JButton("Button1");
//        b1.setPreferredSize(new Dimension(100, 20));
//        b1.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("BOUTON 1 PRESSE");
//            }
//        });
//        RightPanel.add(b1);
//
//        JButton b2 = new JButton("Button2");
//        b2.setPreferredSize(new Dimension(100, 20));
//        RightPanel.add(b2);
//
//        JButton b3 = new JButton("Button3");
//        b3.setPreferredSize(new Dimension(100, 20));
//        RightPanel.add(b3);
//
//        return RightPanel;
//    }

}
