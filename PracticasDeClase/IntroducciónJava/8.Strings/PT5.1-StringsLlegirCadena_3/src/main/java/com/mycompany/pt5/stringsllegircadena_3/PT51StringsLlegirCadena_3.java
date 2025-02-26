/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pt5.stringsllegircadena_3;

import java.util.Scanner;
/**
 *
 * @author Gerard Pozo, Ivan Rodriguez, Eric Serrano
 * 
 * Aquet programa demana un text al usuari i li diem quantes vocals té el text
 */
public class PT51StringsLlegirCadena_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final char VOCAL_MIN_A = 'a';
        final char VOCAL_MIN_E = 'e';
        final char VOCAL_MIN_I = 'i';
        final char VOCAL_MIN_O = 'o';
        final char VOCAL_MIN_U = 'u';
        //Inicialitzem els comptadors
        int quantitatA = 0;
        int quantitatE = 0;
        int quantitatI = 0;
        int quantitatO = 0;
        int quantitatU = 0;
        //Demanem el text
        System.out.print("Introdueix un text: ");
        String text = sc.nextLine();
        //Convertim el text en minuscula per comptar les a i les e 
        String textMinuscula = text.toLowerCase();

        //Recorrem el text
        for (int i = 0; i < text.length(); i++) {
            //Agafem la lletra
            char lletra = textMinuscula.charAt(i);

            //Comparem que sigui a o e
            switch (lletra) {
                case VOCAL_MIN_A -> quantitatA++;
                case VOCAL_MIN_E -> quantitatE++;
                case VOCAL_MIN_I -> quantitatI++;
                case VOCAL_MIN_O -> quantitatO++;
                case VOCAL_MIN_U -> quantitatU++;
            }
        }
        //Imprimim la quantitat de vocals trobades
        System.out.println("La quantiat de " + VOCAL_MIN_A + " és: " + quantitatA);
        System.out.println("La quantiat de " + VOCAL_MIN_E + " és: " + quantitatE);
        System.out.println("La quantiat de " + VOCAL_MIN_I + " és: " + quantitatI);
        System.out.println("La quantiat de " + VOCAL_MIN_O + " és: " + quantitatO);
        System.out.println("La quantiat de " + VOCAL_MIN_U + " és: " + quantitatU);
    }
}
