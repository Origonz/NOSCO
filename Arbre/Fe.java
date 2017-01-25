/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.awt.FlowLayout;
import java.io.File;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author origon
 */

public class Fe extends JFrame{
    private String s;
    private JScrollPane tr;
    private String fi;
    private Pan p;
    Fe(){
        this.setSize(300, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Journaux");
        p=new Pan();//-----------------------------------------------Important
        this.getContentPane().add(p.getTree());//-----------------------------------------------Important
        this.setLayout(new FlowLayout());
        JButton bouton = new JButton("Cliquez ici !");
        this.add(bouton);
        bouton.addActionListener((java.awt.event.ActionEvent evt) -> {
            System.out.println(p.getPath());
        });
        JButton bouton1 = new JButton("Supprimer");
        this.add(bouton1);
        bouton1.addActionListener((java.awt.event.ActionEvent evt) -> {
            p.delete();
        //this.getContentPane().remove(tr);
        //initTree();
        //this.getContentPane().add(tr);
        });
        JButton bouton2 = new JButton("Ajouter");
        this.add(bouton2);
        bouton2.addActionListener((java.awt.event.ActionEvent evt) -> {
            System.out.print("Chemin du fichier : ");
            fi = new Scanner(System.in).next();
        p.Add(1,new File(fi));
        //this.getContentPane().
        //initTree();
        //this.getContentPane().add(tr);
        });
        
        this.setVisible(true);
    }
}
