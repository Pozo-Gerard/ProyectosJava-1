/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pt7.sobrecarrega;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Gerard Pozo i Eric Serrano
 * 
 *         Aquet programa té un metode que demana un nombre enter i un altre
 *         metode que truca al primer metode però es té que introduir un nombre
 *         entre un rang no definit, i fa el mateix per a dades double
 * 
 */
public class PT72Sobrecarrega {

    public static void main(String[] args) {
        // Demanem al usuari que introdueixi dos nombres
        System.out.print("Entra un nombre enter: ");
        int nombre1 = llegirEnterTeclat();
        System.out.print("Entra un nombre enter: ");
        int nombre2 = llegirEnterTeclat();
        // Demanem al usuari un nombre entre els 2 introduits
        System.out.print("Entra un nombre entre els 2 introduits: ");
        // Fem més proves per el metode de enters
        int prova1 = llegirEnterTeclat(nombre1, nombre2);
        System.out.println("Nombre entre 2 i 3");
        int prova2 = llegirEnterTeclat(3, 2);
        System.out.println("Nombre entre 100 i 100");
        int prova3 = llegirEnterTeclat(100, 100);
        // Mostrem el resultat de totes les proves
        System.out.println("Prova1: " + prova1 + "\nProva2: " + prova2 + "\nProva3: " + prova3);

        // Fem proves dels metodes double
        System.out.println("\nNombre entre 3.2 i 3.4");
        double prova4 = llegirRealTeclat(3.4, 3.2);
        System.out.println("Nombre entre 2 i 2");
        double prova5 = llegirRealTeclat(2, 2);
        System.out.println("Nombre entre 3.6 i 9");
        double prova6 = llegirRealTeclat(9, 3.6);
        // Mostrem el resultat de les proves
        System.out.println("Prova4: " + prova4 + "\nProva5: " + prova5 + "\nProva6: " + prova6);
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
                System.out.println("Tens que introduïr un nombre enter.");
            }
        }
        // Tornem el nombre introduit
        return nombre;
    }

    public static int llegirEnterTeclat(int min, int max) {
        // Guardem el min i el max correctament, comprovant quin es el major i menor
        int nombreMin = (min <= max) ? min : max;
        int nombreMax = (max >= min) ? max : min;
        boolean nombreCorrecte = false;
        int nombre = 0;
        // Repetim fins que l'usuari posi un nombre entre el rang
        while (!nombreCorrecte) {
            // Truquem al metode per a que l'usuari introdueixi un nombre
            nombre = llegirEnterTeclat();
            // Comprovem que el nombre introduit estigui dins del rang
            if (nombre >= nombreMin && nombre <= nombreMax) {
                // Sortim del bucle si el nombre esta dins del rang
                nombreCorrecte = true;
            } else {
                // Si no esta dins del rang tornem a demanar un nombre
                System.out.println("Tens que introduir un nombre entre els dos que has posat.");
            }
        }
        // Tornem el nombre introduit per l'usuari
        return nombre;
    }

    public static double llegirRealTeclat() {
        Scanner sc = new Scanner(System.in);
        boolean nombreCorrecte = false;
        double nombre = 0;
        // Fem un bucle per demanar un nombre permés
        while (!nombreCorrecte) {
            // Comprovem que sigui Double
            if (sc.hasNextDouble()) {
                nombre = sc.nextDouble();
                // Surtim del bucle
                nombreCorrecte = true;
            } else {
                // Si no es double netejem buffer i tornem a demanar un nombre
                sc.next();
                System.out.println("Tens que introdir un nombre.");
            }
        }
        // Tornem el nombre introduit
        return nombre;
    }

    public static double llegirRealTeclat(double min, double max) {
        // Guardem el min i el max correctament, comprovant quin es el major i menor
        double nombreMin = (min <= max) ? min : max;
        double nombreMax = (max >= min) ? max : min;
        boolean nombreCorrecte = false;
        double nombre = 0;
        // Repetim fins que l'usuari posi un nombre entre el rang
        while (!nombreCorrecte) {
            // Truquem al metode per a que l'usuari introdueixi un nombre
            nombre = llegirRealTeclat();
            // Comprovem que el nombre introduit estigui dins del rang
            if (nombre >= nombreMin && nombre <= nombreMax) {
                // Sortim del bucle
                nombreCorrecte = true;
            } else {
                // Si el nombre no esta dins del rang tornem a demanar un altre nombre
                System.out.println("Tens que introduir un nombre entre els dos que has posat.");
            }
        }
        // Tornem el nombre introduit
        return nombre;
    }
}
