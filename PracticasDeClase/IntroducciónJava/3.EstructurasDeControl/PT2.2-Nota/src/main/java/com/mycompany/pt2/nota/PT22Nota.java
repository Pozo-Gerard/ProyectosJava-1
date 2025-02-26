/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.pt2.nota;

import java.util.Scanner;

/**
 * Aquest programa demana a l'usuari tres notes, fa la mitjana ponderada i li
 * diu si has suspès, aprovat, notable, excel·lent o matrícula d'honor
 *
 * @author Gerard Pozo i Ivan Rodríguez
 */
public class PT22Nota {

    public static void main(String[] args) {
        //Declarem variables de notes, i les incialitzem amb valor introduït per usuari
        double notaTeoria, notaSeminari, notaPractiques, notaFinal;

        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix la teva nota de teoria");
        notaTeoria = sc.nextDouble();
        System.out.println("Introdueix la teva nota de pràctiques");
        notaPractiques = sc.nextDouble();
        System.out.println("Introdueix la teva nota de seminari");
        notaSeminari = sc.nextDouble();

        // Declarem i inicialitzem les constants
        final double PERCENTATGE_TEORIA = 0.4;
        final double PERCENTATGE_PRACTIQUES = 0.3;
        final double PERCENTATGE_SEMINARI = 0.3;

        final double MIN_APROVAT = 5;
        final double MIN_NOTABLE = 7;
        final double MIN_EXCELENT = 8.5;
        final double MH = 10;

        //Inicialitzem la variable notaFinal
        notaFinal = notaTeoria * PERCENTATGE_TEORIA + notaPractiques * PERCENTATGE_PRACTIQUES + notaSeminari * PERCENTATGE_SEMINARI;

        // Validem la nota final de l'alumne i segons la nota li atribueix una calificació final, i li dona la sortida.
        if (notaFinal < MIN_APROVAT) {
            System.out.println("La teva nota final és " + notaFinal + " - Insuficient");
        } else if (notaFinal >= MIN_APROVAT && notaFinal < MIN_NOTABLE) {
            System.out.println("La teva nota final és " + notaFinal + " - Aprovat");
        } else if (notaFinal >= MIN_NOTABLE && notaFinal < MIN_EXCELENT) {
            System.out.println("La teva nota final és " + notaFinal + " - Notable");
        } else if (notaFinal >= MIN_EXCELENT && notaFinal < MH) {
            System.out.println("La teva nota final és " + notaFinal + " - Excel.lent");
        } else if (notaFinal == MH) {
            System.out.println("La teva nota final és " + notaFinal + " - Matricula d'honor");
        }

    }
}
