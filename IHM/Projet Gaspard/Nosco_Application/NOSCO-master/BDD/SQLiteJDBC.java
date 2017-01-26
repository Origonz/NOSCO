/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlitejdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author matt
 */
public class SQLiteJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Journaux j = new Journaux("Nosco.sqlite");
        j.deletejournal(5);
    }
}
