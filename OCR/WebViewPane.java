/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocr;

/**
 *
 * @author Arnaud
 */

    


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import static ocr.OCR.base;
import static ocr.OCR.urlImage;
 
public class WebViewPane extends Application {

    public static String txtmodifier;


    public static void main(String[] args)  {
        
        //String txtmodifier;
        String chemin_image = "/NOSCO/img/" + urlImage;
        
        urlImage="journal";
        
        OCR.ecrire_php(urlImage,chemin_image);
        
        String urlTxtOriginal = "C:\\wamp64\\www\\NOSCO\\img\\"+urlImage+"original.xml";
        
        String urlTxtModifier="C:\\wamp64\\www\\NOSCO\\img\\"+urlImage+"modification.xml";
        
        String Image="C:\\wamp64\\www\\NOSCO\\img\\"+urlImage+".jpg";
        
        base=OCR.creerOriginal(Image, urlTxtOriginal);
        txtmodifier=OCR.lire_txt(urlTxtModifier);
        
             
        OCR.nouveau(urlTxtModifier);
        
        OCR.modifier(urlTxtModifier, base);
       
        
        MaFenetre fen=new MaFenetre(urlTxtModifier,txtmodifier);
        fen.setVisible(true);
        
        
         launch(args);
         
         
        // TODO code application logic here
    }
    
    
    
        @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.load("http://localhost/NOSCO/"+urlImage+".php");
        
        root.getChildren().add(webView);
        Scene scene = new Scene(root);
        primaryStage.setTitle("WebView");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}

