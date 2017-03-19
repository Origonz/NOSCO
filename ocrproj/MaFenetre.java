/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocrproj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Arnaud
 */
public class MaFenetre extends JFrame {
    //Les imports habituels
    
 

  private JPanel container = new JPanel();
  
  
  private JTextArea jtf = new JTextArea("texte par défaut",20,5);
  private final JLabel label = new JLabel();
  private final JButton button =new JButton("Modifier");
    
  
  public MaFenetre(String urlTxtModifier,String txtmodifier){
     
    
    this.setTitle("Modification ");
    this.setSize(500, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    container.setBackground(Color.white);
    container.setLayout(new BorderLayout());
    JPanel top = new JPanel();
    Font police = new Font("Arial", Font.BOLD, 14);
    jtf.setFont(police);
    jtf.setPreferredSize(new Dimension(300, 500));
    jtf.setForeground(Color.BLUE);
    top.add(button);
    button.addActionListener(new ActionListener(){
        
        //bouton modifier quand on clique modifie le fichier comportant les modifications
        @Override
        public void actionPerformed(ActionEvent e) {
            //on recupere le texte dans le JTextArea
            String chaine=jtf.getText();  
            //creation du fichier modification si non existant
            OCR.nouveau(urlTxtModifier);
            //on remplace le contenu du fichier modifier par celui recupere dans le JTextArea
            OCR.modifier(urlTxtModifier, chaine);          
           // System.out.println(base);
            System.exit(0);  
            
        }
    });
    top.add(label);
    top.add(jtf);
    container.add(top, BorderLayout.NORTH);
    this.setContentPane(container);
    this.setVisible(true); 
    
    
    
  }
  
 
}