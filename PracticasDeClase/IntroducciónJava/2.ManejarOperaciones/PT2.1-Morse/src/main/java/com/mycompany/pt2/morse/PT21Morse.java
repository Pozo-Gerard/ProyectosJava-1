/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pt2.morse;

/**
 * Tradueix les vocals a codi morse
 * @author Gerard && Ivanr
 */

import java.util.Scanner;

public class PT21Morse {

    public static void main(String[] args) {
        // Declarem i inciem les variables i demanem al usuari que intrdueixi una vocal
        Scanner sc = new Scanner(System.in);
        System.out.print("Introdueix una vocal: ");
        char vocalUsuari = sc.next().charAt(0); // Demana al usuari i només agafa el primer digit amb charAt.
        char vocalUsuariMayuscula = Character.toUpperCase(vocalUsuari); // Converteix el primer digit en majuscula
        final char A_MAJUSCULA, E_MAJUSCULA, I_MAJUSCULA, O_MAJUSCULA, U_MAJUSCULA;
        A_MAJUSCULA = 'A';
        E_MAJUSCULA = 'E';
        I_MAJUSCULA = 'I';
        O_MAJUSCULA = 'O';
        U_MAJUSCULA = 'U';
        
        // Compara el char introduït i les constants i si es true imprimeix la vocal en morse.
        if (Character.valueOf(vocalUsuariMayuscula).equals(A_MAJUSCULA)) {
            System.out.println(".-");
        } else if (Character.valueOf(vocalUsuariMayuscula).equals(E_MAJUSCULA)) {
            System.out.println(".");
        } else if (Character.valueOf(vocalUsuariMayuscula).equals(I_MAJUSCULA)) {
            System.out.println("..");
        } else if (Character.valueOf(vocalUsuariMayuscula).equals(O_MAJUSCULA)) {
            System.out.println("---");
        } else if (Character.valueOf(vocalUsuariMayuscula).equals(U_MAJUSCULA)) {
            System.out.println("..-");
        } else {
            System.out.println("No has introduït una vocal.");
        }
    }
}
