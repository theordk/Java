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
import Modele.*;
import ModeleDAO.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;


public class FenEtuListe extends JFrame implements ActionListener {

    private final JPanel panel;
    
    //private final JTextArea txt1;
    //private final JScrollPane scroll_1;
    JButton bAcceuil, bEnseignants, bPromotions, bGroupes, bEtudiants, bCours, bSalles;
    JButton bSelect;
    private final ContFenEtuListe cont_fen_etuListe;

    public FenEtuListe(int id) {

        super("FenEtuListe");
        proprieteFenetre();
        cont_fen_etuListe = new ContFenEtuListe(this, id);
        
        bAcceuil = new JButton("Acceuil");
        bEnseignants = new JButton("Enseignants");
        bPromotions = new JButton("Promotions");
        bGroupes = new JButton("Groupes");
        bEtudiants = new JButton("Etudiants");
        bCours = new JButton("Cours");
        bSalles = new JButton("Salles");
        bSelect = new JButton("Select");

        panel = (JPanel) this.getContentPane();
        //panel.setBackground(Color.yellow);
        panel.add(createToolBar(this), BorderLayout.NORTH);
        panel.add(createStatusBar(), BorderLayout.SOUTH);
        panel.add(ListEtu(this,id), BorderLayout.CENTER);
         //panel.add(createJtree(), BorderLayout.WEST);
         
         // add menubar to frame 
        setJMenuBar(createMenuBar(id));

        //panel.setLayout(null); //--> Besoin des bounds pour placer les boutons
        //panel.setLayout(new FlowLayout()); //--> Tout en ligne
        // panel.setLayout(new GridLayout(2,2,10,10)); //--> Grille (l,c)
        //Si on ne met rien --> BorderLayout par défaut
        

        //panel.add(createRightPanel(),BorderLayout.EAST);
        //txt1 = new JTextArea("text");
        //scroll_2 = new JScrollPane(txt1);
        //panel.add(scroll_2, BorderLayout.CENTER);
       

        //scroll_1 = new JScrollPane(new Jtree());
        //scroll_1.setPreferredSize(new Dimension(150,0));

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

    void closeFenEtuListe() {
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
        JMenuItem profil = new JMenuItem("Profil: Référent Pedagogique");
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

       private JToolBar createToolBar(FenEtuListe f) {

        JToolBar ToolBar = new JToolBar();

        
        ToolBar.add(f.bAcceuil);
        f.bAcceuil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cont_fen_etuListe.bAcceuilclicked(e); 
                
                closeFenEtuListe();
            }
        });

        
        ToolBar.add(f.bEnseignants);
        f.bEnseignants.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cont_fen_etuListe.bEnsclicked(e); 
                
                closeFenEtuListe();
            }
        });

        
        ToolBar.add(f.bPromotions);
        f.bPromotions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cont_fen_etuListe.bPromoclicked(e); 
                
                closeFenEtuListe();
            }
        });

        
        ToolBar.add(f.bGroupes);
        f.bGroupes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cont_fen_etuListe.bGroupeclicked(e); 
                
                closeFenEtuListe();
            }
        });

        
        ToolBar.add(f.bEtudiants);
        f.bEtudiants.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cont_fen_etuListe.bEtudiantclicked(e); 
                
                closeFenEtuListe();
            }
        });

        
         ToolBar.add(f.bCours);
        f.bCours.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cont_fen_etuListe.bCoursclicked(e);

                closeFenEtuListe();
            }
        });

        ToolBar.add(f.bSalles);
        f.bSalles.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cont_fen_etuListe.bSallesclicked(e);

                closeFenEtuListe();
            }
        });

        return ToolBar;
    }


    private JPanel ListEtu(FenEtuListe f, int id) {
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,2)); //--> Grille (l,c)
        //setSize(800,800);
        
        DAO<Etudiant> etDAO = new EtudiantDAO(Connexion.getInstance());
        DAO<Utilisateur> utilisateurDAO = new UtilisateurDAO(Connexion.getInstance());
        ArrayList<Etudiant> listeEt = new ArrayList<>();
        
        ArrayList<String> items = new ArrayList<String>(); 
        String ens = "";
        
        listeEt = etDAO.findAll();
           
        for(Etudiant e : listeEt){
            
            //afficher cours
            String nom = utilisateurDAO.find(e.getId()).getNom();
            String prenom = utilisateurDAO.find(e.getId()).getPrenom();
            nom = nom + " " + prenom;
            items.add(nom);
            
        }   
        JList<String> jlist = new JList(items.toArray());
        
        f.bSelect.setPreferredSize(new Dimension(100, 20));
        //JLabel txt = new JLabel ("Liste des Enseignants : ");
        f.bSelect.setFont(new Font("Times New Roman", Font.BOLD, 50));
        f.bSelect.setForeground(Color.BLACK);
        
        //panel.add(txt, BorderLayout.NORTH);
        panel.add(jlist, BorderLayout.CENTER);
        panel.add(f.bSelect, BorderLayout.SOUTH);
        
        f.bSelect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int[] indice = jlist.getSelectedIndices();
                for (int i=0; i<indice.length; i++){
                    //System.out.println("selected item :" + indice[i]);
                    //closeFenEtuListe();
                    
                    if (indice[i] == 0) {
                    
                        //System.out.println("okk");
                        closeFenEtuListe();
                        FenEtuEDT fedt_etu = new FenEtuEDT(3,id);
                        
                    }
                    
                    if (indice[i] == 1) {
                    
                        //System.out.println("okk");
                        closeFenEtuListe();
                        FenEtuEDT fedt_etu = new FenEtuEDT(4,id);
                        
                    }
                    if (indice[i] == 2) {
                    
                        //System.out.println("okk");
                        closeFenEtuListe();
                        FenEtuEDT fedt_etu = new FenEtuEDT(5,id);
                        
                    }
                    if (indice[i] == 3) {
                    
                        //System.out.println("okk");
                        closeFenEtuListe();
                        FenEtuEDT fedt_etu = new FenEtuEDT(7,id);
                        
                    }
                    if (indice[i] == 4) {
                    
                        //System.out.println("okk");
                        closeFenEtuListe();
                        FenEtuEDT fedt_etu = new FenEtuEDT(11,id);
                        
                    }
                    if (indice[i] == 5) {
                    
                        //System.out.println("okk");
                        closeFenEtuListe();
                        FenEtuEDT fedt_etu = new FenEtuEDT(12,id);
                        
                    }
                    if (indice[i] == 6) {
                    
                        //System.out.println("okk");
                        closeFenEtuListe();
                        FenEtuEDT fedt_etu = new FenEtuEDT(18,id);
                        
                    }
                    if (indice[i] == 7) {
                    
                        //System.out.println("okk");
                        closeFenEtuListe();
                        FenEtuEDT fedt_etu = new FenEtuEDT(19,id);
                        
                    }
                    if (indice[i] == 8) {
                    
                        //System.out.println("okk");
                        closeFenEtuListe();
                        FenEtuEDT fedt_etu = new FenEtuEDT(20,id);
                        
                    }
                    if (indice[i] == 9) {
                    
                        //System.out.println("okk");
                        closeFenEtuListe();
                        FenEtuEDT fedt_etu = new FenEtuEDT(21,id);
                        
                    }
                    if (indice[i] == 10) {
                    
                        //System.out.println("okk");
                        closeFenEtuListe();
                        FenEtuEDT fedt_etu = new FenEtuEDT(23,id);
                        
                    }
                    if (indice[i] == 11) {
                    
                        //System.out.println("okk");
                        closeFenEtuListe();
                        FenEtuEDT fedt_etu = new FenEtuEDT(25,id);
                        
                    }
                    
                }
                
            }
        });
 
        return panel;
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

