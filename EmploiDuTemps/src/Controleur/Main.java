/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.*;
import ModeleDAO.*;
import Vue.*;
import java.util.ArrayList;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
/**
 *
 * @author 931702061
 */
public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        
     UIManager.setLookAndFeel(new NimbusLookAndFeel());
        
     Authentification a = new Authentification();
          
    }
    
}
