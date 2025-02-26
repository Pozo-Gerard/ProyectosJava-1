/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pt2.multiple;

/**
 * Aquest programa demana un nombre enter i diu si es multiple de 7 o de 3 o dels dos o de cap
 * @author Gerard && Ivanr
 */

// Importem la libreria Scanner.
import java.util.Scanner;

public class PT21Multiple {

    public static void main(String[] args) {
        
        // Declarem variables i incialitzem
        Scanner sc = new Scanner(System.in);
        System.out.print("Introdueix un número per comprovar si es multiple de 7 o de 3 o les dos.");
        int numero = sc.nextInt();
        
        // Validem si es múltiple de 7 o de 3 o de cap
        if (numero % 7 == 0 && numero % 3 == 0) {
            System.out.println("El número " + numero + " es múltiple de 7 i de 3.");
        } else if (numero % 7 == 0) {
            System.out.println("El número " + numero + " es múltiple de 7.");
        } else if (numero % 3 == 0) {
            System.out.println("El número " + numero + " es múltiple de 3.");
        } else {
            System.out.println("El número " + numero + " no es múltiple de 7 ni de 3.");
        }
    }
}
