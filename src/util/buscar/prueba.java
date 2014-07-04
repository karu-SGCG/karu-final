/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util.buscar;

import util.NumeroToLetras;

/**
 *
 * @author carlitox
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       NumeroToLetras let = new NumeroToLetras();
        System.out.println("Valor > " + let.Convertir("123534", true, 2));
    }
    
}
