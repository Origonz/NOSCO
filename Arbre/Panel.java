/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author origon
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author origon
 */
public class Panel extends JFrame{
        private JTree arbre;
    private DefaultMutableTreeNode racine;
    private  Rep a;
    
    
    private void initTree() {
        File dir = new File("/home/origon/Documents/Journaux");
        this.racine = listFile(dir, new DefaultMutableTreeNode(dir));
        // On crée, avec notre hiérarchie, un arbre
        a.Add(1, "1840", "02", new File("/home/origon/billy"));
        arbre = new JTree(this.racine);
        
        // Que nous plaçons sur le ContentPane de notre JFrame à l'aide d'un
        // scroll
        this.getContentPane().add(new JScrollPane(arbre));
    }

    
    public Panel() {
       // initComponents();
        this.setSize(300, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Journaux");
        a=new Rep();
        // On invoque la méthode de construction de notre arbre
        //listRoot();
        initTree();
        arbre.getSelectionModel().addTreeSelectionListener((TreeSelectionEvent e) -> {
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) arbre.getLastSelectedPathComponent();
            System.out.println(selectedNode.toString());
            // action a effectuer
        });
        this.setLayout(new FlowLayout());
 
		JButton bouton = new JButton("Cliquez ici !");
                this.add(bouton);
		bouton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.out.print("yes !!");
            }
        });
        this.setVisible(true);
    
    }
private DefaultMutableTreeNode listFile(File file, DefaultMutableTreeNode node) {
        int count = 0;
        if (file.isFile()) {
            return new DefaultMutableTreeNode(file.getName());
        } else {
            for (File nom : file.listFiles()) {
                count++;
                // pas plus de 5 enfants par noeud
                if (count < 30) {
                    DefaultMutableTreeNode subNode;
                    if (nom.isDirectory()) {
                        subNode = new DefaultMutableTreeNode(nom.getName() + "\\");
                        node.add(this.listFile(nom, subNode));
                    } else {
                        subNode = new DefaultMutableTreeNode(nom.getName());
                    }
                  node.add(subNode);
                }
            }
            return node;
        }
    }

}