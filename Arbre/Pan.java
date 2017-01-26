/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.File;
import java.io.IOException;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * @author origon
 */
public class Pan {
      private JTree arbre;
    private DefaultMutableTreeNode racine;
    private Rep a;
    private String s;
    private JScrollPane tr;
    private String fi;

    private void initTree() {
        File dir = new File("/home/origon/Documents/Journaux");
        this.racine = listFile(dir, new DefaultMutableTreeNode(dir));
        // On crée, avec notre hiérarchie, un arbre
        arbre = new JTree(this.racine);
        // Que nous plaçons sur le ContentPane de notre JFrame à l'aide d'un
        // scroll
        tr=new JScrollPane(arbre);
        //this.getContentPane().add(tr);
    }

    public Pan() {
        a = new Rep();
        initTree();
        //this.getContentPane().add(tr);////////////////////////////////////////////////////////////
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
        //this.setLayout(new FlowLayout());/////////////////////////////////////////////////////

    }
    public JScrollPane getTree(){
        return tr;
    }
    
    public void Add(int i,File f) throws IOException{
        a.Add(i, f);
    }
    public void delete(){
        a.delete(s);
    }
    public String getPath(){
        return s;
    }
    public void setContenu(String c){
        a.setJournauxContenu(s, c);
    }
    
    public String getJournauxContenu(){
        return a.getJournalContenu(s);
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
