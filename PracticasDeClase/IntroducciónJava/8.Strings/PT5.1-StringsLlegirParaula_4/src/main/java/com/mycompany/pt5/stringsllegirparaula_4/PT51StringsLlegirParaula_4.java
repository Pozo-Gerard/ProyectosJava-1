/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pt5.stringsllegirparaula_4;

import java.util.Scanner;
/**
 *
 * @author Gerard Pozo, Ivan Rodriguez, Eric Serrano
 * 
 * Aquet programa demana una paraula al usuari i la mostra invertida
 */
public class PT51StringsLlegirParaula_4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //En aquesta variable guardarem la paraula invertida
        String paraulaInvertida = "";
        //Demanem una paraula al usuari
        System.out.print("Introdueix una paraula: ");
        String paraula = sc.next();

        //Recorrem la paraula i anem afegint les lletres començant desde la última fins la primera
        for (int i = paraula.length() - 1; i >= 0; i--) {
            //Fiquem les lletres en la variable
            paraulaInvertida += paraula.charAt(i);
        }
        //Imprimim la variable
        System.out.println("La paraula invertida: " + paraulaInvertida);
    }
}
