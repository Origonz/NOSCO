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
import java.awt.FlowLayout;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class Panel extends JFrame {

    private JTree arbre;
    private DefaultMutableTreeNode racine;
    private Rep a;
    private String s;
    private JScrollPane tr;

    private void initTree() {
        File dir = new File("/home/origon/Documents/Journaux");
        this.racine = listFile(dir, new DefaultMutableTreeNode(dir));
        // On crée, avec notre hiérarchie, un arbre
        arbre = new JTree(this.racine);
        // Que nous plaçons sur le ContentPane de notre JFrame à l'aide d'un
        // scroll
        tr=new JScrollPane(arbre);
        this.getContentPane().add(tr);
    }

    public Panel() {
        // initComponents();
        this.setSize(300, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Journaux");
        a = new Rep();
        initTree();
        arbre.addTreeSelectionListener(new TreeSelectionListener() {

            @Override
            public void valueChanged(TreeSelectionEvent event) {
                if (arbre.getLastSelectedPathComponent() != null) {
                    //La méthode getPath retourne un objet TreePath
                    s = getAbsolutePath(event.getPath());
                }
            }
            
            private String getAbsolutePath(TreePath treePath) {
                String str = "";
                int i = 0;
                //On balaie le contenu de l'objet TreePath
                for (Object name : treePath.getPath()) {
                    if (name.toString() != null) {
                        if (i == 1) {
                            str += "/";
                        }
                    }
                    i++;
                    str += name.toString();
                }
                str=str.replace('\\', '/');
                return str;
            }

        });
        this.setLayout(new FlowLayout());

        JButton bouton = new JButton("Cliquez ici !");
        this.add(bouton);
        bouton.addActionListener((java.awt.event.ActionEvent evt) -> {
            System.out.println(s);
        });
        JButton bouton1 = new JButton("Supprimer");
        this.add(bouton1);
        bouton1.addActionListener((java.awt.event.ActionEvent evt) -> {
            a.delete(s);
           // initTree();
        });
        JButton bouton2 = new JButton("Ajouter");
        this.add(bouton2);
        bouton2.addActionListener((java.awt.event.ActionEvent evt) -> {
        a.Add(1,new File("/home/origon/B010536201_LALUNE_1865_11_00_01.jpg"));
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
