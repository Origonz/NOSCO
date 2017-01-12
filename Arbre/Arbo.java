/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.File;

/**
 *
 * @author origon
 */
public class Arbo {

    void test() {
        File repertoire = new File("/home/origon/");
        File[] li = repertoire.listFiles(); // liste les fichiers du répertoire
        int i;
        for (i = 0; i < li.length; i++) {
            System.out.println(li[i]);
        }
    }

}
