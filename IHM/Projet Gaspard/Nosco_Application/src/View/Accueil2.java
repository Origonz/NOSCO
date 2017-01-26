/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Gaspard
 */
public class Accueil2 extends JFrame {

    JLabel label1;
    JLabel label2;
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton bConnexion;

    public Accueil2() {

        this.setTitle("NOSCO - Accueil");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        init();

    }

    private void init() {

        label1 = new JLabel("Bienvenue sur NOSCO !");
        label2 = new JLabel("Veuillez choisir le journal que vous souhaitez consulter");
        b1 = new JButton("Le Progrès");
        b2 = new JButton("La Voix de l'Ain");
        b3 = new JButton("The Guardian");
        b4 = new JButton("Tous les journaux");
        bConnexion = new JButton("Se connecter");

        JPanel pano = new JPanel();

        pano.setLayout(new GridBagLayout());

        GridBagConstraints cont = new GridBagConstraints();

        cont.fill = GridBagConstraints.BOTH;
        
        cont.gridx = 1;
        cont.gridy = 0;
        pano.add(label1, cont);

        cont.gridx = 1;
        cont.gridy = 1;
        pano.add(label2, cont);

        cont.gridx = 0;
        cont.gridy = 2;
        pano.add(b1, cont);

        cont.gridx = 1;
        cont.gridy = 2;
        pano.add(b2, cont);

        cont.gridx = 2;
        cont.gridy = 2;
        pano.add(b3, cont);

        cont.gridx = 1;
        cont.gridy = 3;
        pano.add(b4, cont);

        cont.gridx = 2;
        cont.gridy = 0;
        pano.add(bConnexion, cont);
        
        this.setContentPane(pano);
        this.pack();

    }
}
