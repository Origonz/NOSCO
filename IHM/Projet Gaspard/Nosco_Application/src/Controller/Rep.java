/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import Model.Journaux;
import Model.Connexion;

/**
 *
 * @author origon
 */
public class Rep {

    private final String dossier = "/home/origon/Documents/Journaux";
    private final String j1, j2, j3;
    private final Journaux a;
    Rep() {
        j1 = "/La_Voie_De_L_Ain";
        j2 = "/Le_Progrès";
        j3 = "/La_Lune";
        a = new Journaux("/home/origon/Nosco.sqlite");
        if (!new File(dossier).exists()) {
            new File(dossier).mkdirs();
        }
        if (!new File(dossier + j1).exists()) {
            new File(dossier + j1).mkdirs();
        }
        if (!new File(dossier + j2).exists()) {
            new File(dossier + j2).mkdirs();
        }
        if (!new File(dossier + j3).exists()) {
            new File(dossier + j3).mkdirs();
        }
    }

    public static boolean copyFile(File source, File dest) {
        try {
            try ( // Declaration et ouverture des flux
                    java.io.FileInputStream sourceFile = new java.io.FileInputStream(source)) {
                java.io.FileOutputStream destinationFile = null;

                try {
                    destinationFile = new FileOutputStream(dest);

                    // Lecture par segment de 0.5Mo 
                    byte buffer[] = new byte[512 * 1024];
                    int nbLecture;

                    while ((nbLecture = sourceFile.read(buffer)) != -1) {
                        destinationFile.write(buffer, 0, nbLecture);
                    }
                } finally {
                    destinationFile.close();
                }
            }
        } catch (IOException e) {
            return false; // Erreur
        }

        return true; // Résultat OK  
    }

    public void AddJ(int t, String page,String jour, String annee, String mois, File file) throws IOException {
        String nom = "";
        if (t == 1) {
            nom = j1;
        }
        if (t == 2) {
            nom = j2;
        }
        if (t > 2) {
            nom = j3;
        }
        if (!new File(dossier + "/" + nom + "/" + annee + "/").exists()) {
            new File(dossier + "/" + nom + "/" + annee + "/").mkdirs();
        }
        if (!new File(dossier + "/" + nom + "/" + annee + "/" + mois + "/").exists()) {
            new File(dossier + "/" + nom + "/" + annee + "/" + mois + "/").mkdirs();
        }
        if (!new File(dossier + "/" + nom + "/" + annee + "/" + mois + "/" + jour + "/").exists()) {
            new File(dossier + "/" + nom + "/" + annee + "/" + mois + "/" + jour + "/").mkdirs();
        }
        if (!new File(dossier + "/" + nom + "/" + annee + "/" + mois + "/" + jour + "/" + "Correction" +"/").exists()) {
            new File(dossier + "/" + nom + "/" + annee + "/" + mois + "/" + jour + "/" + "Correction" +"/").mkdirs();
        }
        if (!new File(dossier + "/" + nom + "/" + annee + "/" + mois + "/" + jour + "/" + "Correction" + "/"+ "Original" + page + ".txt").exists()) {
            new File(dossier + "/" + nom + "/" + annee + "/" + mois + "/" + jour + "/" + "Correction" + "/" + "Original" + page + ".txt").createNewFile();
            copyFile(new File(dossier + "/" + nom + "/" + annee + "/" + mois + "/" + jour + "/" + "Correction" + "/" + "Original" + page + ".txt"),new File(dossier + "/" + nom + "/" + annee + "/" + mois + "/" + jour + "/" + "Correction" +"/" + "Modifier" + page + ".txt"));
        }
        String url=dossier + "/" + nom + "/" + annee + "/" + mois + "/" + jour + "/" + page + ".jpg";
        copyFile(file, new File(url));
        int foo = Integer.parseInt(page);
        String date =jour+"/"+mois+"/"+annee;
        nom = nom.replace("_", " ");
        nom = nom.replace("/", "");
        url = url.replace("//", "/");
        a.addjournal(nom,date, foo,"", url);
    }

    public void delete(String route) {
        File n = new File(route);
        a.deletejournal(route);
        if (n.isDirectory()) {
            if(n.delete())
                System.out.println("Suppression Dossier");
        } else{ if (!n.delete()) {
            System.out.println("Pas marché");
        }else{
            
            System.out.println("Delete Reussi !");
        }
        }
    };
    
    public void Add(int l , File file) throws IOException {
        if (file.isFile()) {
            String b, an, mo, jo,pa;
            b = file.getName();
            an = b.substring(18, 22);
            mo = b.substring(23, 25);
            jo = b.substring(26, 28);
            pa = b.substring(29, 31);
            AddJ(l, pa, jo, an, mo, file);
            System.out.println("Update Reussi !");
        } else {
            System.out.println("Erreur de fichier");
        }
    }
    
    public void setJournauxContenu(String url,String con){
        if(new File(url).isFile()){
        a.setContenu(url, con);
        System.out.println("Modification apporter !");
        }else{
            System.out.println("Ce n'est pas un fichier");
        }
    }
    
    String getJournalContenu(String url){
       return a.getContenu(url);
    }
    
    public void AccepterCorrection(String urlOr){
        String g;
        g=urlOr.replace("Original", "Modifier");
        copyFile(new File(g),new File(urlOr));
    }
    
}
