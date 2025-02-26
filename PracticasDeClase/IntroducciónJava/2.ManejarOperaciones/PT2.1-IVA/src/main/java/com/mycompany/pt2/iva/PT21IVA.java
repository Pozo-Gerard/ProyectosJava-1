/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pt2.iva;

/**
 * Aquest programa demana un producte que pot ser decimal i calcula el iva i si es superior a 100 fa una rebaixa del 5%.
 * @author Gerard && Ivanr
 */

import java.util.Scanner;

public class PT21IVA {

    public static void main(String[] args) {
        // Declarem i inciem variables i demanem al usuari introduirles
        Scanner sc = new Scanner(System.in);
        System.out.print("Introdueix quant costa el producte que vols comprar sense IVA: ");
        double preuProducteSenseIva = sc.nextDouble();
        int unitats = 0;
        final double IVA = 0.21;
        final double DESCOMPTE = 0.05;
        final int PREU_DESCOMPTE = 100;
        
        // Fem un bucle per a que el usuari introdueixi obligatoriament un número de unitats més gran de 0
        while (unitats == 0) {
            System.out.print("Introdueix quantes unitats vols comprar del producte: ");
            unitats = sc.nextInt();
        
            if (unitats == 0) {
                System.out.println("Tens que introduïr un numero més gran de 0");
            }
        }
        
        // Declarem i inciem les variables per calcular el preu final
        double costTotalCestella = preuProducteSenseIva * unitats;
        double producteAmbIva = costTotalCestella * IVA;
        double preuFinal = costTotalCestella + producteAmbIva;
        
        // Validem si el preu final es superior a 100 i apliquem el descompte si es true i si no es queda amb el mateix preu
        if (preuFinal > PREU_DESCOMPTE) {
            preuFinal = preuFinal * (1 - DESCOMPTE);
            System.out.println("Tot costa: " + preuFinal);
        } else {
            System.out.println("Tot costa: " + preuFinal);
        }
    }
}
