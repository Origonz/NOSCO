/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocrproj;

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
        
    
       /* String cheminDoss="C:\\Users\\Arnaud\\Desktop\\PTUT\\";
        
        String NomImg="test2.jpg";
        String NomFich="out";*/
    
     public static void creerOriginal(String NomImg,String NomFich) {
        //on applique l'OCR sur le fichier passer en parametre et on crée un txt avec son texte dedans
     
        try {
    Runtime.getRuntime().exec("tesseract "+NomImg+" "+NomFich );
} catch (IOException t) { }
        

          
    }

      public static void modifier(String nomFichier, String ajout) {
        //permet de modifier le fichier en parametre en ajoutant le contenu en parametre
        try {
            File fichier = new File(nomFichier);
            PrintWriter out = new PrintWriter(new FileWriter(fichier));
            out.write(ajout); //écris dans le fichier
            out.close(); //Ferme le flux du fichier, sauvegardant ainsi les données.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void nouveau(String nomFichier) {
        //creer un nouveau fichier vide
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(nomFichier)));
// normalement si le fichier n'existe pas, il est crée à la racine du projet
            writer.write("");

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void ecrire_php(String urlImage, String chemin_image) {
        
        //creer un .php et l'edite avec le txt_php
        //ne semble pas fonctionner
        

        String txt_php = "<?php\n" + "\n" + "echo\"<html>\n" + "	<body>\n" + "	\n" + "		<img src=" + "\\" + "\"" + chemin_image + "\\" + "\"" + ">   \n" + "</body>   \n" + "</html>   \n" + "\"" + ";  \n" + "?>";

        urlImage = "C:\\wamp64\\www\\NOSCO\\" + urlImage + ".php";
        
        nouveau(urlImage);
        modifier(urlImage,txt_php);

    }

    public static String lire_txt(String fichier){
        //permet de lire et récuperer le conenu d'un fichier txt ou autre txt,xml...
        String txt="";
        try{
            InputStream ips=new FileInputStream(fichier); 
            InputStreamReader ipsr=new InputStreamReader(ips);
            BufferedReader br=new BufferedReader(ipsr);
            String ligne;
            while ((ligne=br.readLine())!=null){                
		txt+=ligne+"\n";	
            }
            br.close(); 
	}		
	catch (Exception e){
            System.out.println(e.toString());
	}
        return txt;
    }
}
