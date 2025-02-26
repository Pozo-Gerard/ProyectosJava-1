/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pt4.socisgimnasdinamic;

//Importem la llibreria ArrayList per poder crear la taula
import java.util.ArrayList;
//Importem la llibreria Collections per ordenar numericament la taula
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author gerard i Eric Serrano
 * 
 *         Aquet programa pregunta al usuari quants socis té el seu gimás,
 *         després l'usuari introdueix l'edat de tots els socis i ho emmagatzema
 *         en un ArrayList, després mostra: La mitjana de les edats, l'edat minima i
 *         maxima, els menors d'edat, els majors d'edat i els socis més grans a
 *         la mitja.
 */
public class PT41SocisGimnasDinamic {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Declarem i inicialitzem les constants
        final int EDAT_MINIMA = 14;
        final int EDAT_MAXIMA = 100;
        final int MAJORIA_EDAT = 18;
        // Declarem les variables que utilitzarem
        int majorsEdat = 0, menorsEdat = 0, edatMinima = 0, edatMaxima, socisMajorsMitja, socis, comptador;
        double sumaEdats = 0, mitjanaEdats;
        boolean introduirEdats = true;

        // Diem al usuari quin rang posar i com finalitzar
        System.out.println("Introdueix les edats dels usuaris entre 14 i 100.");
        System.out.println("Finalitza el programa posant -1.");
        // Declarem i inicialitzem la taula
        ArrayList<Integer> arraySocis = new ArrayList<Integer>();

        comptador = 1;
        while (introduirEdats) {
            // Demanem al usuari introduir l'edat del soci
            System.out.print("Introdueix l'edat del soci " + comptador + ": ");
            // Comprovem que la dada que introdueixi l'usuari sigui tipus int
            if (sc.hasNextInt()) {
                int edatSoci = sc.nextInt();

                // Comprovem que el usuari introdueix una edat entre 14 i 100
                if (edatSoci >= EDAT_MINIMA && edatSoci <= EDAT_MAXIMA) {
                    arraySocis.add(edatSoci);
                    //Sumem tots els nombres que vaigi introduint l'usuari per mes tard calcular la mitjana
                    sumaEdats += arraySocis.get(comptador - 1);

                    //Calculem el menor i el major
                    if (edatSoci < MAJORIA_EDAT) {
                        menorsEdat++;
                    } else {
                        majorsEdat++;
                    }
                    
                    comptador++;

                // Si l'usuari no introdueix -1 i sempre que hi hagi més de 0 edats
                } else if(edatSoci == -1 && arraySocis.size() > 0) {
                    introduirEdats = false;
                } else {
                    System.out.println("Tens que introduir minim una edat entre 14 i 100.");
                }
                // Si l'usuari no introdueix un nombre enter
            } else {
                System.out.println("Tens que introduir un nombre enter.");
                sc.next();
            }
        }

        // Declarem la variable amb la quantitat de posicions del array
        socis = arraySocis.size();

        // Calculem la mitjana i tornem la mitjana de les edat
        mitjanaEdats = sumaEdats / socis;
        // Fem un printf amb aquest format per a que només es mostrin 2 decimals
        System.out.printf("\nLa mitjana de edat es: %.2f%n", mitjanaEdats);

        // Edat maxima i edat minima
        // Utilitzem el metode .sort de la llibreria Collections per ordenar de menor a
        // major la taula
        Collections.sort(arraySocis);
        // Definim la edat minima i maxima i tornem els valors
        edatMinima = arraySocis.get(0);
        edatMaxima = arraySocis.get(socis - 1);
        System.out.println("Edat minma: " + edatMinima + " Edat maxima: " + edatMaxima);

        // Socis majors d'edat
        System.out.println("Hi han " + majorsEdat + " socis majors d'edat.");

        // Socis menors d'edat
        System.out.println("Hi han " + menorsEdat + " socis menors d'edat.");

        // Socis majors a la mitja
        socisMajorsMitja = 0;
        for (int i = 0; i < socis; i++) {
            if (arraySocis.get(i) > mitjanaEdats) {
                socisMajorsMitja++;
            }
        }
        System.out.println("Hi han " + socisMajorsMitja + " que son majors a la mitja.");
    }
}