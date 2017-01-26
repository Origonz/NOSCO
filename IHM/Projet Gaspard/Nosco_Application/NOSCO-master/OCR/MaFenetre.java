/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocr;

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
import static ocr.OCR.base;
import static ocr.OCR.modifier;
/**
 *
 * @author Arnaud
 */
public class MaFenetre extends JFrame {
    //Les imports habituels
    
 

  private final JPanel container = new JPanel();
  private JTextArea jtf = new JTextArea(OCR.base,20,5);
  private final JLabel label = new JLabel();
  private final JButton button =new JButton("Modifier");

  public MaFenetre(String urlTxtModifier){
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
        @Override
        public void actionPerformed(ActionEvent e) {
            
            
            
            String chaine=jtf.getText();
            
            OCR.nouveau(urlTxtModifier);
            modifier(urlTxtModifier, chaine, "");
            
            
            
           System.out.println(base);
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