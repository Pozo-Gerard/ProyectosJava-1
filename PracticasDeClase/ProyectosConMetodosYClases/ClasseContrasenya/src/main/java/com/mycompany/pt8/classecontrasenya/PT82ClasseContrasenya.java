/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pt8.classecontrasenya;

import java.util.Scanner;

/**
 * En aquet programa utiltizem el paradigma de programació orientat a objectes,
 * creant un array de tipus Contrasenya per emmagatzemar objectes de tipus
 * Contrasenya dins.
 * 
 * @author Gerard Pozo i Eric Serrano
 */
public class PT82ClasseContrasenya {

    public static void main(String[] args) {
        // Demanem la quantitat de contrasenyes i caracters que tenen que tenir aquestes
        // contrasenyes
        System.out.print("Quantes contrasenyes vols emmagatzemar: ");
        int quantitatContrasenyes = llegirEnterTeclat();
        System.out.print("De quants caracters vols les contrasenyes: ");
        int longitud = llegirEnterTeclat();

        // Creem un array de tipus Contrasenya per emmagatzemar totes les contrasenyes
        Contrasenya[] contrasenyes = new Contrasenya[quantitatContrasenyes];
        // Creem un array de tipus boolean per emmagatzemar si les constrasenyes son o
        // no son fortes
        boolean[] esContrasenyaForta = new boolean[quantitatContrasenyes];

        // Creem totes les contrasenyes demanades per l'usuari
        for (int i = 0; i < quantitatContrasenyes; i++) {
            // Emmagatzamem la contrasenya al array de contrasenyes
            contrasenyes[i] = new Contrasenya(longitud);
            // Emmagatzamem si la contrasenya es forta o no
            esContrasenyaForta[i] = contrasenyes[i].esFort();
            // Mostrem les constrasenyes i si son fortes
            String contrasenyaForta = (esContrasenyaForta[i] == true) ? "Es forta" : "No es forta";

            System.out.println("Contrasenya: " + contrasenyes[i].getContrasenya() + " | " + contrasenyaForta);
        }
    }

    public static int llegirEnterTeclat() {
        Scanner sc = new Scanner(System.in);
        boolean nombreCorrecte = false;
        int nombre = 0;
        // Fem un bucle per demanar un nombre permés
        while (!nombreCorrecte) {
            // Comprovem que sigui un nombre enter
            if (sc.hasNextInt()) {
                // Demanem el nombre
                nombre = sc.nextInt();
                // Sortim del bucle
                nombreCorrecte = true;
            } else {
                // Netejem el buffer i tornem a demanar un nombre
                sc.next();
                System.out.print("Tens que introduïr un nombre enter: ");
            }
        }
        // Tornem el nombre introduit
        return nombre;
    }
}
