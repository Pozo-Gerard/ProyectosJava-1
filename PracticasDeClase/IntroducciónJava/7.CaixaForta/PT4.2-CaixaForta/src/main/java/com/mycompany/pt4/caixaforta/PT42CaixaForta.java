/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.pt4.caixaforta;

import java.util.Scanner;

/**
 *
 * @author gerard i Ivan Rodriguez
 * 
 *         Aquet programa mostra un menú principal i l'usuari selecciona si
 *         començar el joc o sortir del programa,
 *         un cop que començem el joc demana al usuari quants digits té que
 *         tenir el codi secret i després l'usuari ho té que adivinar,
 *         al finalitzar mostra quants intents a trigar en adivinar-lo.
 */
public class PT42CaixaForta {

    public static void main(String[] args) {
        // Variable del scanner
        Scanner sc = new Scanner(System.in);
        // Variables final
        final int COMENÇAR_JOC = 1;
        final int SORTIR = 2;
        final int VALOR_MAXIM = 9;
        final int VALOR_MINIM = 0;

        // Variables boolean per la execució de bucles
        boolean execuccioPrograma = true;
        boolean execuccioJoc = true;
        boolean nombreEndevinat = false;

        // Variable dels intents per endevinar la combinació
        int intentsEndevinar = 1;
        // Variable que emmagatzema per quina posició del array anem a l'hora de
        // endevinar els nombres
        int posicioEndevinar = 0;
        // La variable codi la utilitzarem per emmagatzemar els nombres correctes i per
        // donar una sortida amb estil
        String codi = "";
        // Comença el cos del programa
        do {
            // Imprimim el menu principal
            System.out.println("\n--------------");
            System.out.println(" Caixa Forta");
            System.out.println("--------------");
            System.out.println("1) Començar joc");
            System.out.println("2) Sortir");
            System.out.print("\nIntrodueix una opció: ");
            // Comprovem que el nombre introduit sigui un nombre enter
            if (sc.hasNextInt()) {
                int eleccioMenuPrincipal = sc.nextInt();
                switch (eleccioMenuPrincipal) {
                    case COMENÇAR_JOC -> {
                        // Si l'usuari vol començar el joc
                        do {
                            // Demanem al usuari quants nombres té que tenir el codi secret
                            System.out.print("Posa el nombre de digits que té que tenir el codi: ");
                            // Comprovem que el nombre introduit sigui un nombre enter
                            if (sc.hasNextInt()) {
                                // Variable que emagatzema la quantitat de digits que té que tenir el codi
                                int digitsCodi = sc.nextInt();

                                // Creem un array amb els espais que el usuari hagi indicat
                                int[] arrayCodiSecret = new int[digitsCodi];

                                // Li donem al arrayCodiSecret el codi secret
                                for (int i = 0; i < arrayCodiSecret.length; i++) {
                                    // Sumem 1 al valor máxim per a que pugui sortir el nombre que té la variable,
                                    // ja que no retorna el nombre que indiquem en el valor maxim
                                    int nombreAleatori = (int) (Math.random() * (VALOR_MAXIM + 1));
                                    arrayCodiSecret[i] = nombreAleatori;
                                }

                                while (!nombreEndevinat) {
                                    // Imprimim els nombres endevinats per l'usuari
                                    System.out.print("\n" + codi);
                                    // Imprimim claudators simulant un espai per ficar un nombre, segons els nombres
                                    // que falten per endevinar
                                    for (int i = posicioEndevinar; i < arrayCodiSecret.length; i++) {
                                        System.out.print("[ ] ");
                                    }
                                    // Demanem al usuari un nombre
                                    System.out.print("\n\nIntrodueix un nombre per endevinar la posicio "
                                            + (posicioEndevinar + 1) + ": ");
                                    // Comprovem que sigue enter
                                    if (sc.hasNextInt()) {
                                        int endivinarCodi = sc.nextInt();
                                        // Comprovem que el nombre estigui entre el valor minim i máxim
                                        if (endivinarCodi >= VALOR_MINIM && endivinarCodi <= VALOR_MAXIM) {
                                            // Si el nombre introduit es el nombre en el que esta en la posicio del
                                            // array
                                            if (endivinarCodi == arrayCodiSecret[posicioEndevinar]) {
                                                System.out.println("Has encertat.");
                                                // Afegim a codi el nombre correcte entre claudators
                                                codi += "[" + arrayCodiSecret[posicioEndevinar] + "] ";
                                                // Pasem a la següent posició
                                                posicioEndevinar++;
                                                // Si el nombre es menor ho indicarem al usuari i sumarem 1 als intents
                                            } else if (endivinarCodi < arrayCodiSecret[posicioEndevinar]) {
                                                System.out.println("El nombre " + endivinarCodi + " es menor.");
                                                intentsEndevinar++;
                                                // Si el nombre es més gran ho indicarem al usuari i sumarem 1 als
                                                // intents
                                            } else {
                                                System.out.println("El nombre " + endivinarCodi + " es més gran.");
                                                intentsEndevinar++;
                                            }

                                            /*
                                             * Quan la posició sigui la mateixa que la longitud del array significara
                                             * que
                                             * ja hem recorregut tots els nombres i com un nombre no pasa a altre fins
                                             * que
                                             * no sigui correcta això funciona bé
                                             */
                                            if (posicioEndevinar == arrayCodiSecret.length) {
                                                System.out.println("El codi ha sigut endevinat en " + intentsEndevinar
                                                        + " intents.");
                                                nombreEndevinat = true;
                                                execuccioJoc = false;
                                            }
                                            // Si l'usuari no introdueix un nombre entre el valor minim i el valor maxim
                                        } else {
                                            System.out.println("Tens que introduir un nombre entre " + VALOR_MINIM
                                                    + " i " + VALOR_MAXIM);
                                        }
                                        // Si l'usuari no introdueix un nombre enter
                                    } else {
                                        System.out.println("Tens que introduir un nombre enter.");
                                        sc.next();
                                    }
                                }
                                // Mostrem per últim cop tots els nombres correctes
                                System.out.println("\n" + codi);
                                // Si l'usuari no introdueix un nombre enter
                            } else {
                                System.out.println("Tens que introduir un nombre enter");
                                sc.next();
                            }
                        } while (execuccioJoc);
                        //Mi tortura y mi condena (Lo entregué sin estas lineas, haciendo que no se pueda volver a adivinar)
                        codi = "";
                        posicioEndevinar = 0;
                        nombreEndevinat = false;
                    }
                    // Si l'usuari vol sortir del programa
                    case SORTIR -> {
                        execuccioPrograma = false;
                        // Si l'usuari no introdueix cap de les opcions
                        System.out.println("Tens que introduïr una de les opcions.");
                    }
                    default -> System.out.println("Tens que introduir una de les opcions.");
                }
                // Si l'ususuari no introdueix un nombre enter
            } else {
                System.out.println("Tens que introduïr una de les opcions.");
                sc.next();
            }
        } while (execuccioPrograma);
    }
}