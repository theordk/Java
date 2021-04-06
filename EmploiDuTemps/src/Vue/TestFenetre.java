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
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestFenetre extends JFrame implements ActionListener{

    
    /**
    //Menu bar
    private final JMenuBar barre;
    // JMenu 
    private final JMenu menu, edt, recap;
    // Menu items 
    private final JMenuItem profil, nom, prenom;
    **/
    
    //private final JTextArea editeur = new JTextArea();
    
    private final JPanel panel;
    
    //private final JButton b1, b2; 
    //private final JCheckBox c1,c2; 
    private final JTextArea txt1;
    private final JScrollPane scroll_1, scroll_2;

    public TestFenetre() {
        
        super("Ma Fenetre");
        proprieteFenetre();
 
        panel = (JPanel) this.getContentPane();
        //panel.setBackground(Color.yellow);
        
        //panel.setLayout(null); //--> Besoin des bounds pour placer les boutons
        //panel.setLayout(new FlowLayout()); //--> Tout en ligne
        // panel.setLayout(new GridLayout(2,2,10,10)); //--> Grille (l,c)
        
        //Si on ne met rien --> BorderLayout par défaut
        
        /**        
        b1 = new JButton("Button 1");
        b1.setBounds(200,50,150,30);
        panel.add(b1, BorderLayout.NORTH);
        
        b2 = new JButton("Button 2");
        b2.setBounds(200,100,150,30);
        panel.add(b2, BorderLayout.SOUTH);
        **/
        
        /**
        c1 = new JCheckBox("check 1");
        c1.setPreferredSize(new Dimension(200,0));
        panel.add(c1, BorderLayout.WEST);
         
        c2 = new JCheckBox("check 2");
        panel.add(c2, BorderLayout.EAST);
        **/
        
        
        panel.add(createToolBar(),BorderLayout.NORTH);
        panel.add(createStatusBar(),BorderLayout.SOUTH);
        
        panel.add(createRightPanel(),BorderLayout.EAST);
        
        txt1 = new JTextArea("text");
        scroll_2 = new JScrollPane(txt1);
        panel.add(scroll_2, BorderLayout.CENTER);
        
        scroll_1 = new JScrollPane(new JTree());
        scroll_1.setPreferredSize(new Dimension(150,0));
        panel.add(scroll_1, BorderLayout.WEST);
        
        // add menubar to frame 
        setJMenuBar(createMenuBar());

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
        this.setSize(600, 600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Boutton pressé"); //To change body of generated methods, choose Tools | Templates.
    }
    
    private JMenuBar createMenuBar(){
        
        JMenuBar MenuBar = new JMenuBar();
        
        // create a menu 
        JMenu menu = new JMenu("Menu");
        menu.setMnemonic('M');
        
        JMenu edt = new JMenu("Mon Emploi Du Temps");
        JMenu recap = new JMenu("Récapitialtif de mes cours");
        
        // create menuitems 
        JMenuItem profil = new JMenuItem("Mon Profil Enseignant: ");
        profil.addActionListener(this::menuActionListener);
        
        JMenuItem nom = new JMenuItem("Nom : ");
        JMenuItem prenom = new JMenuItem("Prenom : ");
        
        // add menu items to menu 
        menu.add(profil);
        menu.addSeparator();
        menu.add(nom);
        menu.add(prenom);
        
        // add menu to menu bar 
        MenuBar.add(menu);
        MenuBar.add(edt);
        MenuBar.add(recap);
        
        return MenuBar;
    }
    
    private void menuActionListener(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "new doc required");
    }
    
    private JToolBar createToolBar() {
        
        JToolBar ToolBar = new JToolBar();
        
        JButton b1 = new JButton("hola");
        ToolBar.add(b1);
        JButton b2 = new JButton("hola");
        ToolBar.add(b2);
        JButton b3 = new JButton("hola");
        ToolBar.add(b3);
        JButton b4 = new JButton("hola");
        ToolBar.add(b4);
    
    return ToolBar;
    }
    
    private JPanel createStatusBar() {
    
            JPanel StatusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
            
            JLabel l1 = new JLabel("Message1");
            l1.setPreferredSize(new Dimension (100,20));
            StatusBar.add(l1);
            
            JLabel l2 = new JLabel("Message2");
            l2.setPreferredSize(new Dimension (100,20));
            StatusBar.add(l2);
            
            JLabel l3 = new JLabel("Message3");
            l3.setPreferredSize(new Dimension (100,20));
            StatusBar.add(l3);
            
            return StatusBar;
    }
    
    private JPanel createRightPanel() {
        
        JPanel RightPanel = new JPanel(new GridLayout(3,1));
            
            JButton b1 = new JButton("Button1");
            b1.setPreferredSize(new Dimension (100,20));
            b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("BOUTON 1 PRESSE");
            }
            });
            RightPanel.add(b1);
            
            JButton b2 = new JButton("Button2");
            b2.setPreferredSize(new Dimension (100,20));
            RightPanel.add(b2);
            
            JButton b3 = new JButton("Button3");
            b3.setPreferredSize(new Dimension (100,20));
            RightPanel.add(b3);
            
            return RightPanel;
    }

    

}
