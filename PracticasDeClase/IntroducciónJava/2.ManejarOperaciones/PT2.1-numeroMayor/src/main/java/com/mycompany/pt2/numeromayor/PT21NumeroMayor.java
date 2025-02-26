/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pt2.numeromayor;

/**
 * Compara dos numeros que poden ser decimals i diu quin és més gran
 * @author Gerard && Ivanr
 */

import java.util.Scanner;

public class PT21NumeroMayor {

    public static void main(String[] args) {
        
        // Declarem i iniciem les variables i demanem al usuari introduïr dos numeros
        Scanner sc = new Scanner(System.in);
        System.out.print("Introdueix un número: ");
        double primerNumero = sc.nextDouble();
        System.out.print("Introdueix un altre número per comparar-los: ");
        double segonNumero = sc.nextDouble();
        
        // Validem si el primer numero és més gran que el segon i ho mostrem si es true, si es false mostrem que el segón número és mayor, i si no mostrem que són iguals
        if (primerNumero > segonNumero) {
            System.out.println(primerNumero + " Es més gran que " + segonNumero);
        } else if (segonNumero > primerNumero) {
            System.out.println(segonNumero + " Es més gran que " + primerNumero);
        } else {
            System.out.println(primerNumero + " es igual a " + segonNumero);
        }
    }
}