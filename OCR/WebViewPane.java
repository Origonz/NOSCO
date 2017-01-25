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
 
public class WebViewPane extends Application {



    public static void main(String[] args)  {
        
        String urlTxtModifier="C:\\wamp64\\www\\NOSCO\\img\\modification.txt";
        
        String urlImage = "C:\\wamp64\\www\\NOSCO\\img\\test2.jpg";
        String urlTxtOriginal = "C:\\wamp64\\www\\NOSCO\\img\\original.txt";
        
        //String UrlPHP="test2.php";
        
        
        base=OCR.creer(urlImage, urlTxtOriginal);
             
        
       
        
        MaFenetre fen=new MaFenetre(urlTxtModifier);
        fen.setVisible(true);
        
        
         launch(args);
         
        // TODO code application logic here
    }
    
    
        @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.load("http://localhost/NOSCO/test2.php");
        root.getChildren().add(webView);
        Scene scene = new Scene(root);
        primaryStage.setTitle("WebView");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}

