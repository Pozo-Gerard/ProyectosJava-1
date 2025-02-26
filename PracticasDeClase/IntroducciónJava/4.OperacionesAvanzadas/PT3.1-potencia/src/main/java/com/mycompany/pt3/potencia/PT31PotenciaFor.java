/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.pt3.potencia;

import java.util.Scanner;

/**
 * Aquet programa demana un numero al usuari i demana un exponent per calcular
 * la potencia
 *
 * @author Gerard
 */
public class PT31PotenciaFor {

    public static void main(String[] args) {
        //Declarem i inicialitzem les variables i demanem al usuari el numero i el exponent
        Scanner sc = new Scanner(System.in);
        final int VALOR_MINIM = 0;
        System.out.print("Introdueix un numero: ");
        double numero = sc.nextDouble();
        System.out.print("Introdueix l'exponent, no pot ser negatiu: ");
        double exponent = sc.nextDouble();
        double resultat = 1;

        //Validem que el exponent no sigui negatiu
        if (exponent < VALOR_MINIM) {
            System.out.println("No pots introduïr l'exponent amb número negatiu");
        } else {
            //Fem el bucle per calcular la potencia
            for (int comptador = 0; comptador < exponent; comptador++) {
                resultat *= numero;
            }
            //Imprimim el resultat de la potencia
            System.out.println("El resultat es: " + resultat);
        }
    }
}
