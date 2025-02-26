/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pt7.metodes;

import java.util.Scanner;

/**
 *
 * @author Gerard i Eric Serrano
 * 
 *         Aquet programa crida una quantitat de cops al metode
 *         escriureTaulaMultiplicar i imprimeix totes les taules de multiplicar
 *         del 0 fins ón l'usuari vol.
 * 
 */
public class PT71TaulaMultiplicar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Truquem a la funció una quantitat de cops, canviant el nombre esperat en cada
        // iteracció
        System.out.print("Introdueix la quantitat de taules de multiplicar que vols mostrar: ");
        int taules = sc.nextInt();
        // Comprovem que no sigui negatiu
        if (taules >= 0) {
            for (int i = 0; i <= taules; i++) {
                // Truquem al métode canviant el nombre en cada trucada
                escriureTaulaMultiplicar(i);
            }
        } else {
            System.out.println("El nombre té que ser positiu o 0.");
        }

    }

    public static void escriureTaulaMultiplicar(int numero) {
        // Volem que ho faixi de 0 fins el nombre máxim
        final int NOMBRE_MAXIM = 10;
        System.out.println("------------");
        System.out.println("Taula del " + numero);
        System.out.println("------------");
        // Recorrem tota la taula de multiplicar del nombre
        for (int i = 0; i <= NOMBRE_MAXIM; i++) {
            // Calculem el resultat de l'operació
            int resultat = numero * i;
            // Imprimim l'operació feta amb el resultat
            System.out.println(numero + " x " + i + " = " + resultat);
        }
    }
}
