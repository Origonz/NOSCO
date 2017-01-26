/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Gaspard
 */
public class Recherche extends JFrame {

    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JCheckBox checkDate;
    JTextField motscles;
    JButton bRechercher;
    JTextField date1;
    JTextField date2;


    public Recherche() {

        this.setTitle("NOSCO - Formulaire de recherche");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        init();

    }

    private void init() {

        label1 = new JLabel("Remplissez les champs souhaités : ");
        label2 = new JLabel("Mots clés (séparés par \";\" ) : ");
        label3 = new JLabel("Date minimum : ");
        label4 = new JLabel("Date maximum : ");
        bRechercher = new JButton("Rechercher");
        checkDate = new JCheckBox("Cochez cette case si vous utilisez la recherche par date");
        motscles = new JTextField();

        date1 = new JTextField();
        date2 = new JTextField();
        


        JPanel pano = new JPanel();

        pano.setLayout(new GridBagLayout());

        GridBagConstraints cont = new GridBagConstraints();

        cont.fill = GridBagConstraints.BOTH;


        cont.gridx = 1;
        cont.gridy = 0;
        pano.add(label1, cont);

        cont.gridx = 0;
        cont.gridy = 1;
        pano.add(label2, cont);

        cont.gridx = 0;
        cont.gridy = 2;
        pano.add(label3, cont);

        cont.gridx = 0;
        cont.gridy = 3;
        pano.add(label4, cont);
        

        cont.gridx = 1;
        cont.gridy = 1;
        pano.add(motscles, cont);
        
        cont.gridx = 1;
        cont.gridy = 2;
        pano.add(checkDate, cont);
        
        cont.gridx = 1;
        cont.gridy = 3;
        pano.add(date1, cont);

        cont.gridx = 1;
        cont.gridy = 4;
        pano.add(date2, cont);
        
        cont.gridx = 1;
        cont.gridy = 5;
        pano.add(bRechercher, cont);

        this.setContentPane(pano);
        this.pack();

    }

}
