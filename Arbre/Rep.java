/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author origon
 */
public class Rep {

    private final String dossier = "/home/origon/Documents/Journaux";
    private String j1, j2, j3;

    Rep() {
        j1 = "/La_Voie_De_L_Ain";
        j2 = "/Le_Progrès";
        j3 = "/N3";

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
            // Declaration et ouverture des flux
            java.io.FileInputStream sourceFile = new java.io.FileInputStream(source);

            try {
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
            } finally {
                sourceFile.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Erreur
        }

        return true; // Résultat OK  
    }

    void Add(int t, String anne, String mois, File file) {
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
        if (!new File(dossier + "/" + nom + "/" + anne + "/").exists()) {
            new File(dossier + "/" + nom + "/" + anne + "/").mkdirs();
        }
        if (!new File(dossier + "/" + nom + "/" + anne + "/" + mois + "/").exists()) {
            new File(dossier + "/" + nom + "/" + anne + "/" + mois + "/").mkdirs();
        }
        copyFile(file,new File(dossier + "/" + nom + "/" + anne + "/" + mois + "/"+file.getName()));
    }
}
