/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pt4.socisgimnas;

import java.util.Scanner;
//Importem la llibreria Arrays per poder utilitzar el metode .sort, que ordenara de menor a major el array.
import java.util.Arrays;

/**
 *
 * @author gerard i Eric Serrano
 * 
 *         Aquet programa pregunta al usuari quants socis té el seu gimás,
 *         després l'usuari introdueix l'edat de tots els socis i ho emmagatzema
 *         en un array, després mostra: La mitjana de les edats, l'edat minima i
 *         maxima, els menors d'edat, els majors d'edat i els socis més grans a
 *         la mitja.
 */
public class PT41SocisGimnas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Declarem i inicialitzem les constants
        final int EDAT_MINIMA = 14;
        final int EDAT_MAXIMA = 100;
        final int MAJORIA_EDAT = 18;
        // Declarem les variables que utilitzarem
        int majorsEdat = 0, menorsEdat = 0, edatMinima, edatMaxima, socisMajorsMitja, comptador;
        double sumaEdats = 0, mitjanaEdats;
        // Demanem al usuari la quantitat de socis que te el gimnás
        System.out.print("Quants socis té el gimnas?: ");
        int socis = sc.nextInt();

        // Declarem el array i ho inicialitzem amb la quantitat de usuaris introduit per
        // el usuari
        int[] arraySocis = new int[socis];

        comptador = 1;
        // Com la longitud de arraySocis és la mateixa que socis, utilitzo socis
        // directament per el bucle
        while (comptador <= socis) {
            // Demanem al usuari introduir l'edat del soci
            System.out.print("Introdueix l'edat del soci " + comptador + ": ");

            // Comprovem que la dada que introdueixi l'usuari sigui tipus int
            if (sc.hasNextInt()) {
                int edatSoci = sc.nextInt();

                // Comprovem que el usuari introdueix una edat entre 14 i 100
                if (edatSoci >= EDAT_MINIMA && edatSoci <= EDAT_MAXIMA) {
                    // Restem 1 al comptador per que asigni desde la posició 0 i arribi al final de
                    // la taula sense pasar-se
                    arraySocis[comptador - 1] = edatSoci;

                    //Sumem tots els nombres que vaigi introduint l'usuari per mes tard calcular la mitjana
                    sumaEdats += arraySocis[comptador - 1];

                    comptador++;

                    //Calculem el menor i el major
                    if (edatSoci < MAJORIA_EDAT) {
                        menorsEdat++;
                    } else {
                        majorsEdat++;
                    }
                    // Si l'usuari no introdueix una edat valida té que tornar a introduirla
                } else {
                    System.out.println("Tens que introduïr una edat entre " + EDAT_MINIMA + " i " + EDAT_MAXIMA);
                }
                // Si l'usuari no introdueix un nombre enter
            } else {
                System.out.println("Tens que introduir un nombre enter.");
                sc.next();
            }
        }

        // Calculem la mitjana i tornem la mitjana de les edats
        mitjanaEdats = sumaEdats / socis;
        // Fem un printf amb aquest format per a que només es mostrin 2 decimals
        System.out.printf("\nLa mitjana de edat es: %.2f%n", mitjanaEdats);

        // Edat maxima i edat minima
        // Utilitzem el metode .sort de la llibreria Arrays per ordenar de menor a major
        // la taula
        Arrays.sort(arraySocis);
        // Definim la edat minima i maxima i tornem els valors
        edatMinima = arraySocis[0];
        edatMaxima = arraySocis[socis - 1];
        System.out.println("Edat minma: " + edatMinima + " Edat maxima: " + edatMaxima);

        // Socis majors d'edat
        System.out.println("Hi han " + majorsEdat + " socis majors d'edat.");

        // Socis menors d'edat
        System.out.println("Hi han " + menorsEdat + " socis menors d'edat.");

        // Socis majors a la mitja
        socisMajorsMitja = 0;
        for (int i = 0; i < socis; i++) {
            if (arraySocis[i] > mitjanaEdats) {
                socisMajorsMitja++;
            }
        }
        System.out.println("Hi han " + socisMajorsMitja + " que son majors a la mitja.");
    }
}