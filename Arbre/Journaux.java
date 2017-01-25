/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author matt
 */
public class Journaux {
    
    private Connexion connexion;
   
    public Journaux(String Bdd){
        connexion = new Connexion(Bdd);
        connexion.connect();
    }
    
    void getNom(){
        ResultSet resultSet = connexion.query("Select * From Journaux");
        try {
            while (resultSet.next()) {
                System.out.println("Nom : " + resultSet.getString("Nom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    void getDate(){
        ResultSet resultSet = connexion.query("Select * From Journaux");
        try {
            while (resultSet.next()) {
                System.out.println("Date : " + resultSet.getString("Date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    void getPage(){
        ResultSet resultSet = connexion.query("Select * From Journaux");
        try {
            while (resultSet.next()) {
                System.out.println("Page : " + resultSet.getString("Page"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    void getContenu(){
        ResultSet resultSet = connexion.query("Select * From Journaux");
        try {
            while (resultSet.next()) {
                System.out.println("Contenu : " + resultSet.getString("Contenu"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    String getContenu(String url){
        ResultSet resultSet = connexion.query("Select * From Journaux where url ='"+url+"'");
        try {
                System.out.println("Select * From Journaux where url ='"+url+"'");
            while (resultSet.next()) {
                return resultSet.getString("contenu");
            }
        } catch (SQLException e) {
           System.out.println("Select * From Journaux where url ='"+url+"'");
        }
        return "Erreur de co";
    }
    
    void getUrl(){
        ResultSet resultSet = connexion.query("Select * From Journaux");
        try {
            while (resultSet.next()) {
                System.out.println("Url : " + resultSet.getString("Url"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    void setNom(String n, int i){
        connexion.modifjournal("Update Journaux set nom = '" + n + "' where id = " + i);
    }
    
    void setNom(String n, String i){
        connexion.modifjournal("Update Journaux set nom = '" + n + "' where url = " + i);
    }
    
    void setDate(String d, int i){
        connexion.modifjournal("Update Journaux set date = '" + d + "' where id = " + i);
    }
    void setDate(String d, String i){
        connexion.modifjournal("Update Journaux set date = '" + d + "' where url = " + i);
    }
    
    void setPage(int p, int i){
        connexion.modifjournal("Update Journaux set page = " + p + " where id = " + i);
    }
    void setPage(int p, String i){
        connexion.modifjournal("Update Journaux set page = " + p + " where url = " + i);
    }
    
    void setContenu(String c, int i){
        connexion.modifjournal("Update Journaux set contenu = '" + c + "' where id = " + i);
    }
    
    void setContenu(String i, String c){
        connexion.modifjournal("Update Journaux set contenu = '" + c + "' where url = '" + i+"'");
    }
    
    void setUrl(String u, int i){
        connexion.modifjournal("Update Journaux set url = '" + u + "' where id = " + i);
    }
    
    void addjournal(String name, String date, int page, String contenu, String url){
        connexion.addjournal(name, date, page, contenu, url);
    }
    
    void deletejournal(String url){
        connexion.deletejournal(url);
    }
}
