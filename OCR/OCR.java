/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocr;

import com.asprise.ocr.Ocr;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author Arnaud
 */
public class OCR {

    static String base;

    public static String creer(String journal, String fichier) {
        String s="";
        try {
            Ocr.setUp(); // one time setup
            Ocr ocr = new Ocr(); // create a new OCR engine
            ocr.startEngine("fra", Ocr.SPEED_FASTEST); // English
            s = ocr.recognize(new File[]{new File(journal)}, Ocr.RECOGNIZE_TYPE_ALL, Ocr.OUTPUT_FORMAT_PLAINTEXT); // PLAINTEXT | XML | PDF | RTF
            System.out.println("Result: " + s);
            ocr.stopEngine();

            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fichier)));
// normalement si le fichier n'existe pas, il est crée à la racine du projet
            writer.write(s);

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    public static void modifier(String fichier , String chaine, String ecrire) {

       

        //lecture du fichier texte	
        try {

            InputStream ips = new FileInputStream(fichier);
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader br = new BufferedReader(ipsr);
            String ligne;
            while ((ligne = br.readLine()) != null) {
                ecrire += ligne + "\n";
            }
            ecrire += chaine;
            br.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        //création ou ajout dans le fichier texte
        try {
            FileWriter fw = new FileWriter(fichier);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter fichierSortie = new PrintWriter(bw);
            fichierSortie.println(ecrire);
            fichierSortie.close();
            //System.out.println("Le fichier " + fichier + " a été créé!");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void nouveau(String fichier){
        String ecrire = "";
        try {
            FileWriter fw = new FileWriter(fichier);
            BufferedWriter bw = new BufferedWriter(fw);
            try (PrintWriter fichierSortie = new PrintWriter(bw)) {
                fichierSortie.println(ecrire);
                //System.out.println("Le fichier " + fichier + " a été créé!");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    

}
