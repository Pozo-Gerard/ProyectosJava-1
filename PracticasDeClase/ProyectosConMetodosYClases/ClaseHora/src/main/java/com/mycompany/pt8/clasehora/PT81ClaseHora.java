/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pt8.clasehora;

import java.util.Scanner;

/**
 *
 * @author Gerard Pozo i Eric Serrano
 * 
 *         En aquet programa creem un objecte anemat Hora, amb distintes opcions
 *         per operar amb ell.
 * 
 */
public class PT81ClaseHora {

    // Variables estatiques per modificarles en tot el programa
    private static int hora;
    private static int minut;
    private static int segon;

    public static void main(String[] args) {
        // Opcions menu principal
        final byte SUMAR_UNA_HORA = 1;
        final byte SUMAR_VARIS_MINUTS = 2;
        final byte SUMAR_UN_MINUT = 3;
        final byte SUMAR_UN_SEGON = 4;
        final byte COMPROVAR_HORES_IGUALS = 5;
        final byte MOSTRAR_HORA = 6;
        final byte INTRODUIR_NOVA_HORA = 7;
        final byte SORTIR = 8;

        boolean execuccioPrograma = true;
        // Demanem un hora al usuari
        llegirHora();
        // Creem l'objecte
        Hora horaUsuari = new Hora(hora, minut, segon);
        do {
            // Menu principal
            System.out.println("-------");
            System.out.println("Hores");
            System.out.println("-------");
            System.out.println("1) Sumar una hora");
            System.out.println("2) Sumar varis minuts");
            System.out.println("3) Sumar un minut");
            System.out.println("4) Sumar un segon");
            System.out.println("5) Comprovar si dos hores son iguals");
            System.out.println("6) Mostrar hora");
            System.out.println("7) Introduir nova hora");
            System.out.println("8) Sortir");
            // Demanem una opció al usuari
            System.out.print("Introdueix una opció: ");
            int opcioUsuari = llegirEnterTeclat();

            // Comprovem quina opció ha escollit
            switch (opcioUsuari) {
                case SUMAR_UNA_HORA -> {
                    // Incrementem una hora
                    horaUsuari.incrementarHora();
                }
                case SUMAR_VARIS_MINUTS -> {
                    // L'usuari diu quants minuts vol incrementar l'hora
                    System.out.print("\nIntrodueix la quantitat de minuts que vols incrementar: ");
                    int minuts = llegirEnterTeclat();
                    horaUsuari.incrementarMinut(minuts);
                }
                case SUMAR_UN_MINUT -> {
                    // Incrementem un minut
                    horaUsuari.incrementarMinut();
                }
                case SUMAR_UN_SEGON -> {
                    // Incrementem un segon
                    horaUsuari.incrementarSegon();
                }
                case COMPROVAR_HORES_IGUALS -> {
                    // Sobreescribim les variables hora, minut, segon
                    llegirHora();
                    // Creem un nou objecte i li pasem l'hora, el minut i el segon
                    Hora segonaHora = new Hora(hora, minut, segon);
                    // Comprovem que retorna el métode i tornem una resposta i l'imprimim
                    String lesHoresSonIguals = (horaUsuari.iguals(segonaHora)) ? "Les hores son iguals"
                            : "Les hores no son iguals";
                    System.out.println(lesHoresSonIguals);
                }
                case INTRODUIR_NOVA_HORA -> {
                    // Sobreescribim les variables hora, minut, segon
                    llegirHora();
                    // Asignem les noves dades introduides a l'objecte
                    horaUsuari.setHora(hora);
                    horaUsuari.setMinut(minut);
                    horaUsuari.setSegon(segon);
                }
                case SORTIR -> {
                    // Sortim del programa
                    System.out.println("\nHas sortit.");
                    execuccioPrograma = false;
                }
            }
            // Després de cada opció mostrem l'hora
            horaUsuari.mostrar();
        } while (execuccioPrograma);
    }

    // Metode per llegir entrades per teclat de nombres enters
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

    // Metode per sobreescriure les variables estatiques
    static void llegirHora() {
        hora = llegirHora("hora", 0, 23);
        minut = llegirHora("minut", 0, 59);
        segon = llegirHora("segon", 0, 59);
    }

    // El temps representa l'hora, minut o segon, i el minim o máxim de cada temps
    static int llegirHora(String temps, int horaMinima, int horaMaxima) {
        // Per comprovar si el valor introduir es correcta
        boolean horaCorrecta = false;

        int hora = 0;
        while (!horaCorrecta) {
            // Demanem un hora al usuari
            if (!horaCorrecta) {
                // L'usuari introdueix una hora
                System.out.print("\nIntrodueix un " + temps + ": ");
                hora = llegirEnterTeclat();
                // Comprovem que l'hora estigui dins el rang
                horaCorrecta = validarEntrada(hora, horaMinima, horaMaxima);
            }
        }
        return hora;
    }

    // Comprovem que els nombres que introdueix el usuari compleixin amb el minim i
    // máxim que tenen que tenir segons sigui hora, minut o segon
    static boolean validarEntrada(int valor, int horaMinima, int horaMaxima) {
        if (valor < horaMinima || valor > horaMaxima) {
            System.out.println("Tens que introduir un nombre entre " + horaMinima + " i " + horaMaxima);
            return false;
        }
        return true;
    }

}
