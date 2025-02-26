/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.pt2.calculadora;

import java.util.Scanner;

/**
 * Aquest programa permet operar (sumar, restar, multiplicar i dividir) amb dos números introduïts per l'usuari
 * @author Gerard Pozo i Ivan Rodríguez
 */
public class PT22Calculadora {

    public static void main(String[] args) {
        //Declarem variables del programa. Inicialitzem algunes.
        double num1, num2, resultat;
        int operacio;
        final int OPCIO_SUMA = 1;
        final int OPCIO_RESTA = 2;
        final int OPCIO_MULTIPLICACIO = 3;
        final int OPCIO_DIVISIO = 4;
        boolean error = false;

        //DEmanem a l'usuari que introdueixi els números i inicialitzem les variables corresponents.
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix un número");
        num1 = sc.nextDouble();

        System.out.println("Introdueix un altre número");
        num2 = sc.nextDouble();

        // Demanem opció de la operació que desitja fer i inicialitzem variable operacio
        System.out.println("Què vols fer amb aquests números?");
        System.out.println("   1. Sumar-los");
        System.out.println("   2. Restar-los");
        System.out.println("   3. Multiplicar-los");
        System.out.println("   4. Dividir-los");

        operacio = sc.nextInt();

        //Inicialitzem valor resultat amb "0" 
        resultat = 0;
        // Sentència switch per valorar la variable operacio.
        switch (operacio) {
            case OPCIO_SUMA ->
                resultat = num1 + num2;

            case OPCIO_RESTA ->
                resultat = num1 - num2;

            case OPCIO_MULTIPLICACIO ->
                resultat = num1 * num2;

            case OPCIO_DIVISIO -> {
                //Sentència IF per contemplar la opció que el denominador d'una divisió sigui 0.
                if (num2 == 0) {
                    System.out.println("Math error");
                    error=true;
                   
                } else {
                    resultat = num1 / num2;                    
                }
            }
            default -> {
                System.out.println("Opció incorrecte");
                error=true;
               
            }
        }
        //Donem com a sortida el resultat, si s'ha pogut operar.
        if (!error) {
            System.out.println("el resultat es " + resultat);
        }
    }
}
