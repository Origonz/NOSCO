/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author origon
 */
public class Rep {

    private final String dossier = "/home/origon/Documents/Journaux";
    private final String j1, j2, j3;
    private final Journaux a;

    Rep() {
        j1 = "/La_Lune";
        j2 = "/La_Voie_De_L_Ain";
        j3 = "/Le_Progrès";
        
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

    public Boolean AddJ(String j, String page, String jour, String anne, String mois, File file) throws IOException {
        String nom = "";
        System.out.println(j);
        if (j.equals("LALUNE")) {
            nom = j1;
        }
        if (j.equals("AUTRE1")) {
            nom = j2;
        }
        if (j.equals("AUTRE2")) {
            nom = j3;
        }
        if(nom==""){
            System.out.println("Erreur de selection");
            return false;
        }
        if (!new File(dossier + "/" + nom + "/" + anne + "/").exists()) {
            new File(dossier + "/" + nom + "/" + anne + "/").mkdirs();
        }
        if (!new File(dossier + "/" + nom + "/" + anne + "/" + mois + "/").exists()) {
            new File(dossier + "/" + nom + "/" + anne + "/" + mois + "/").mkdirs();
        }
        if (!new File(dossier + "/" + nom + "/" + anne + "/" + mois + "/" + jour + "/").exists()) {
            new File(dossier + "/" + nom + "/" + anne + "/" + mois + "/" + jour + "/").mkdirs();
        }

        if (!new File(dossier + "/" + nom + "/" + anne + "/" + mois + "/" + jour + "/"  + page + "/").exists()) {
            new File(dossier + "/" + nom + "/" + anne + "/" + mois + "/" + jour + "/"  + page + "/").mkdirs();
        }
        
        if (!new File(dossier + "/" + nom + "/" + anne + "/" + mois + "/" + jour + "/"  + page + "/xml/").exists()) {
            new File(dossier + "/" + nom + "/" + anne + "/" + mois + "/" + jour + "/"  + page + "/xml/").mkdirs();
        }
        
        String url = dossier + "/" + nom + "/" + anne + "/" + mois + "/" + jour + "/" + page + "/" + page + ".jpg";
        copyFile(file, new File(url));
        int foo = Integer.parseInt(page);
        String date = jour + "/" + mois + "/" + anne;
        nom = nom.replace("_", " ");
        nom = nom.replace("/", "");
        url = url.replace("//", "/");
        a.addjournal(nom, date, foo, "", url);
        return true;
    }

    public void delete(String route) {
        File n = new File(route);
        a.deletejournal(route);
        if (n.isDirectory()) {
            if (n.delete()) {
                System.out.println("Suppression Dossier");
            }
        } else if (!n.delete()) {
            System.out.println("Pas marché");
        } else {

            System.out.println("Delete Reussi !");
        }
    }

    ;
    
    public void Add(File file) throws IOException {
        if (file.isFile()) {
            String b, an, mo, jo, pa, j;
            b = file.getName();
            j = b.substring(11, 17);
            an = b.substring(18, 22);
            mo = b.substring(23, 25);
            jo = b.substring(26, 28);
            pa = b.substring(29, 31);
            if(AddJ(j, pa, jo, an, mo, file))
            System.out.println("Update Reussi !");
        } else {
            System.out.println("Erreur de fichier");
        }
    }

    public void setJournauxContenu(String url, String con) {
        if (new File(url).isFile()) {
            a.setContenu(url, con);
            System.out.println("Modification apporter !");
        } else {
            System.out.println("Ce n'est pas un fichier");
        }
    }

    public String getJournalContenu(String url) {
        return a.getContenu(url);
    }

    public void AccepterCorrection(String urlOr) {
        String g;
        g = urlOr.replace("Original", "Modifier");

        copyFile(new File(g), new File(urlOr));
    }
}
