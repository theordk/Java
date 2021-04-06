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
import Modele.Site;
import Modele.Type_Cours;
import Modele.Utilisateur;
import ModeleDAO.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
//import main.java.Connexion;

public class FenEtuEDT extends JFrame implements ActionListener{
    
    private final JPanel panel;
    //private Connexion maconnexion;
    //private final JTextArea txt1;
    //private final JScrollPane scroll_1;
    
    //private final JTextArea txt1;
    //private final JScrollPane scroll_1;
    JButton bAcceuil, bEnseignants, bPromotions, bGroupes, bEtudiants, bCours, bSalles;
    JButton bSelect;
    private final ContFenEtuEDT cont_etu_EDT;

    public FenEtuEDT(int indice, int id) {
        
        super("FenEtuEDT");
       proprieteFenetre();
        proprieteFenetre();
        cont_etu_EDT = new ContFenEtuEDT(this, id);
        
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
        panel.add(createEDT(this, indice), BorderLayout.CENTER);
        panel.add(createStatusBar(), BorderLayout.SOUTH);
       
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
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Window Closing");
                System.exit(0);
            }
        }
        );
    }
    
    
    void proprieteFenetre(){
        this.setSize(1500, 1000);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    
    void closeFenEtuEDT() {
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

    private JToolBar createToolBar(FenEtuEDT f) {

        JToolBar ToolBar = new JToolBar();

        
        ToolBar.add(f.bAcceuil);
        f.bAcceuil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cont_etu_EDT.bAcceuilclicked(e); 
                
                closeFenEtuEDT();
            }
        });

        
        ToolBar.add(f.bEnseignants);
        f.bEnseignants.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cont_etu_EDT.bEnsclicked(e); 
                
                closeFenEtuEDT();
            }
        });

        
        ToolBar.add(f.bPromotions);
        f.bPromotions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cont_etu_EDT.bPromoclicked(e); 
                
                closeFenEtuEDT();
            }
        });

        
        ToolBar.add(f.bGroupes);
        f.bGroupes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cont_etu_EDT.bGroupeclicked(e); 
                
                closeFenEtuEDT();
            }
        });

        
        ToolBar.add(f.bEtudiants);
        f.bEtudiants.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cont_etu_EDT.bEtudiantclicked(e); 
                
                closeFenEtuEDT();
            }
        });

        
         ToolBar.add(f.bCours);
        f.bCours.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cont_etu_EDT.bCoursclicked(e);

                closeFenEtuEDT();
            }
        });

        ToolBar.add(f.bSalles);
        f.bSalles.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cont_etu_EDT.bSallesclicked(e);

                closeFenEtuEDT();
            }
        });
        return ToolBar;
    }
    
    private JPanel createEDT(FenEtuEDT f, int i) {
        
        JPanel mon_edt = new JPanel();
        DefaultTableModel model = new DefaultTableModel();
        
        int id_etudiant = i+1;
        int id_enseignant = 0;
        int id_groupe = 0;
        int id_promotion = 0;
        int id_salle = 0;
        int id_type = 0;
        int id_cours = 0;
        
        model.addColumn("Date");
        model.addColumn("Cours");
        model.addColumn("Type");
        model.addColumn("Heure Début");
        model.addColumn("Heure Fin");
        model.addColumn("Professeur");
        model.addColumn("Salle");
        model.addColumn("Site");
        
        DAO<Utilisateur> utilisateurDAO = new UtilisateurDAO(Connexion.getInstance());
        DAO<Etudiant> etudiantDAO = new EtudiantDAO(Connexion.getInstance());
        DAO<Enseignant> enseignantDAO = new EnseignantDAO(Connexion.getInstance());
        DAO<Seance> seanceDAO = new SeanceDAO(Connexion.getInstance());
        DAO<Groupe> groupeDAO = new GroupeDAO(Connexion.getInstance());
        DAO<Salle> salleDAO = new SalleDAO(Connexion.getInstance());
        DAO<Site> siteDAO = new SiteDAO(Connexion.getInstance());
        DAO<Type_Cours> type_coursDAO = new Type_CoursDAO(Connexion.getInstance());
        DAO<Cours> coursDAO = new CoursDAO(Connexion.getInstance());
        DAO<Seance_Groupe> s_gDAO = new Seance_GroupeDAO(Connexion.getInstance());
        DAO<Seance_Enseignant> s_eDAO = new Seance_EnseignantDAO(Connexion.getInstance());
        DAO<Seance_Salle> s_sDAO = new Seance_SalleDAO(Connexion.getInstance());
        
        
        Etudiant etudiant = new Etudiant();
        Enseignant enseignant = new Enseignant();
        Seance seance = new Seance();
        Groupe groupe = new Groupe();
        /*
    
        Salle salle = new Salle();
        Site site = new Site();
        Type_Cours type_cours = new Type_Cours();
        Cours cours = new Cours();
        Seance_Groupe s_g = new Seance_Groupe();
        Seance_Enseignant s_e = new Seance_Enseignant();
        Seance_Salle s_s = new Seance_Salle();

         */
        
        ArrayList<Seance> seances = new ArrayList<>();
        ArrayList<Seance> seancesDuGroupe = new ArrayList<>();
        
        ArrayList<Groupe> groupes = new ArrayList<>();
        ArrayList<Seance_Enseignant> s_e = new ArrayList<>();
        ArrayList<Seance_Salle> s_s = new ArrayList<>();
        ArrayList<Seance_Groupe> s_g = new ArrayList<>();
        
        
        String salle = "", site = "", cours="", type="", date="", h_d="", h_f="", prof_nom = "", prof_prenom = "";
        int week, etat;
        
        
 
        
        etudiant = etudiantDAO.find(id_etudiant); //l'etudiant       
        groupe = groupeDAO.find(etudiant.getId_grp()); //son groupe
        
        System.out.println("ID Groupe: "+ groupe.getId());
        
        
        groupes = groupeDAO.findAll(); // tous les groupes
        seances = seanceDAO.findAll(); //toute les seances
        s_g = s_gDAO.findAll();
       
       
        
        
        
        
        for(Seance_Groupe sg : s_g){
            
            if(sg.getId_g() == groupe.getId()){  //si l'ID d'un des groupes correspond a l'ID du groupe de cet etudiant
                
                seancesDuGroupe.add(seanceDAO.find(sg.getId_s()));
                
            }
        }
        

            for(Seance s : seancesDuGroupe){ //toutes les seances



                            //On recupere Salle et Site
                                s_s = s_sDAO.findAll();

                                for(Seance_Salle ss : s_s){
                                        //pour chaque Seance_Salle on regarde l'id séance
                                        if(ss.getId_s() == s.getId()){
                                          salle = salleDAO.find(ss.getId_salle()).getNom();

                                          site = siteDAO.find(salleDAO.find(ss.getId_salle()).getId_site()).getNom();
                                        }
                                }
                            //On recupere le nom du prof        
                                s_e = s_eDAO.findAll();

                                for(Seance_Enseignant se : s_e){
                                        //pour chaque Seance_Enseignant on regarde l'id séance
                                        if(se.getId_s() == s.getId()){
                                          prof_nom = utilisateurDAO.find(se.getId_u()).getNom();

                                          prof_prenom = utilisateurDAO.find(se.getId_u()).getPrenom();
                                        }
                                }

                            //On recupere toutes les infos de la seance        
                                cours = coursDAO.find(s.getId_cours()).getNom();
                                type = type_coursDAO.find(s.getId_type()).getNom();
                                week = s.getSemaine();
                                date = s.getDate();
                                h_d = s.getHeureD();
                                h_f = s.getHeureF();
                                etat = s.getEtat();
                                
                                String prof = prof_nom + " " + prof_prenom;
                                 model.addRow(new Object[]{date, cours, type, h_d, h_f, prof, salle, site});

                            System.out.println("ID Seance: "+s.getId());
                            System.out.println("Semaine: "+week);
                            System.out.println("Date: "+date);
                            System.out.println("Cours: "+cours);
                            System.out.println("Type: "+type);
                            System.out.println("Commence à: "+h_d+" et fini à: "+h_f);
                            System.out.println("Prof: "+ prof_nom + " " +prof_prenom);
                            System.out.println("Salle: "+salle+" du le Site: "+site);
                            System.out.println("*************************************************");

                    
                    }
            
        JTable table = new JTable(model);
        //getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
        table.setPreferredScrollableViewportSize(new Dimension(900, 800));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);

        mon_edt.add(scrollPane, BorderLayout.CENTER);

        return mon_edt;
       
    }
    
    private JPanel createStatusBar() {
    
            JPanel StatusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel l1 = new JLabel("Emploie du Temps ECE Paris 2020");
        l1.setPreferredSize(new Dimension(200, 20));
        StatusBar.add(l1);
        return StatusBar;
            
         
    }
    
//    private JScrollPane createJtree(){
//    
//        //JTree jTree = new JTree();
//        JScrollPane scrool = new JScrollPane(new JTree());  
//        scrool.setPreferredSize(new Dimension(150,0));
//        return scrool;
//    }
//    
//    private JPanel createRightPanel() {
//        
//        JPanel RightPanel = new JPanel(new GridLayout(3,1));
//            
//            JButton b1 = new JButton("Button1");
//            b1.setPreferredSize(new Dimension (100,20));
//            b1.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("BOUTON 1 PRESSE");
//            }
//            });
//            RightPanel.add(b1);
//            
//            JButton b2 = new JButton("Button2");
//            b2.setPreferredSize(new Dimension (100,20));
//            RightPanel.add(b2);
//            
//            JButton b3 = new JButton("Button3");
//            b3.setPreferredSize(new Dimension (100,20));
//            RightPanel.add(b3);
//            
//            return RightPanel;
//    }

}
