/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pt7.metodes;

/**
 *
 * @author Gerard i Eric Serrano
 * 
 *         En aquet programa creem un metode i calculem la potencia d'un nombre
 *         que ens pasen per el main.
 * 
 */
public class PT71Potencia {

    public static void main(String[] args) {
        // Prova amb l'exponent en 0
        double resultat = potencia(3.4, 0);
        System.out.println(resultat);
        // Prova amb nombres enters
        resultat = potencia(3, 3);
        System.out.println(resultat);
        // Prova amb nombres decimals
        resultat = potencia(3.4, 3);
        System.out.println(resultat);
    }

    // Creem el metode potencia, esperem un double i un int
    public static double potencia(double base, int exponent) {
        double resultat = 1;
        // Comprovem que l'exponent no sigui engatiu
        if (exponent >= 0) {
            // Fem l'operació per calcular la potencia
            for (int i = 0; i < exponent; i++) {
                resultat *= base;
            }
        } else {
            // En cas negatiu
            System.out.println("L'exponent no pot ser negatiu.");
        }
        // Tornem el resultat
        return resultat;
    }
}
