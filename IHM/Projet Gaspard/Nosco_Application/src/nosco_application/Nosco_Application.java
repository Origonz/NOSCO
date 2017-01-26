/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nosco_application;

import View.Home;
import View.Accueil2;
import View.NewsList2;
import View.Recherche;

/**
 *
 * @author Gaspard
 */
public class Nosco_Application {

    /**
     * @param args the command line arguments             
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//        Accueil2 accueil2 = new Accueil2();
//        accueil2.setVisible(true);
        
        Home home = new Home();
        home.setTitle("Nosco - Accueil");
        home.setResizable(false);
        home.setVisible(true);

//          NewsList2 newslist = new NewsList2();
//          newslist.setVisible(true);
        
        
        
//        Recherche recherche = new Recherche();
//        recherche.setVisible(true);

          
        
        
    }
    
}
