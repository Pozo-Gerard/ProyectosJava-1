/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.pt3.curiositatmatematica;

import java.util.Scanner;

/**
 * Aquet programa mostra un menú d'opcions i demana al usuari que entri una
 * opció, si selecciona la primera opció té que posar un nombre i fara una
 * curiositat matematica que si el nombre es parell es dividira entre dos i si
 * no ho es es multiplicará per tres i sumara un. Si selecciona dos tindrá que
 * ficar un rang de nombres i fara la curiositat matematica fent tots els
 * nombres entre mitj incluint els dos nombres. I si selecciona tres el programa
 * seleccionara un nombre aleatori de entre 1 i 1.000.000 i també fara la
 * curiositat matematica.
 *
 * I hem afegit l'opció de veure el nombre amb més iteraccions que l'usuari a
 * trobat provant nombres.
 *
 * @author Gerard Pozo i Fran Tarriño
 */

public class PT33CuriositatMatematica {
    public static void main(String[] args) {
        //Declarem i inicialitzem les variables que anem a utilitzar
        int nombre = 0, segonNombre = 0, nombreGuardat = 0, iteraccions = 0;
        //Variable Scanner
        Scanner sc = new Scanner(System.in);
        //Variable per mantenir la execució del programa
        boolean execucioDelPrograma = true;

        //Aquestes variables serveixen per emmagatzemar el nombre amb més iteraccions trobada
        int puntuacioMaximaIteraccions = 0;
        int puntuacioMaximaNombre = 0;

        //Variables per al switch
        final byte OPCIO_INTRODUIR_UN_NOMBRE = 1;
        final byte OPCIO_INTRODUIR_UN_RANG = 2;
        final byte OPCIO_NOMBRE_ALEATORI_MILLON = 3;
        final byte OPCIO_VEURE_NOMBRE_AMB_MES_ITERACCIONS = 4;
        final byte OPCIO_SORTIR_DEL_PROGRAMA = 5;

        //Creem un bucle do-while per a que imprimeixi un cop minim el menu principal i que el usuari faigi l'opció que vulgui
        do {
            //Imprimim el menu principal
            System.out.println("\nCURIOSITAT MATEMATICA");
            System.out.println("---------------------------");
            System.out.println("1) Introdueix un nombre");
            System.out.println("2) Introdueix un rang");
            System.out.println("3) Escollir un nombre aleatori entre 1 i 1.000.000");
            System.out.println("4) Veure el nombre amb més iteraccions trobat");
            System.out.println("5) Sortir del programa");
            System.out.println("---------------------------");
            System.out.print("Introdueix una opció: ");
            //El que el usuari introdueixi s'emmagatzema en aquesta variable
            int eleccioUsuari = sc.nextInt();

            //Aquest boolean l'utilitzarem per executar la operació
            boolean dadesCorrectes = false;

            //Comprovem l'eleccio del usuari
            switch (eleccioUsuari) {
                //Si l'usuari a introduït la primera opció
                case OPCIO_INTRODUIR_UN_NOMBRE -> {
                    //Demanem un nombre al usuari
                    System.out.print("\nIntrodueix un nombre: ");
                    nombre = sc.nextInt();
                    //Com la logica demana el primer i el segon nombre fem que el segon nombre sigui el mateix que el primer, així només fa el nombre introduït
                    segonNombre = nombre;
                    //Emmagaztamem el nombre del usuari per que després ho necesitarem per comprovar si es el nombre amb més iteraccions
                    nombreGuardat = nombre;
                    //Variable que emmagatzema la quantitat de iteraccions de x nombre
                    iteraccions = 0;
                    //Si el nombre es menor a 1 demanem al usuari que introdui un nom positiu
                    if (nombre < 1) {
                        System.out.println("\nTens que introduir un nombre enter positiu.");
                    } else {
                        //Declarem el boolean dadesCorrectes com true per executar l'operació desrpés del switch
                        dadesCorrectes = true;
                    }
                }
                //Si l'usuari a introduit la segona opció
                case OPCIO_INTRODUIR_UN_RANG -> {
                    //Demanem l'usuari introduit 2 nombres
                    System.out.print("\nIntrodueix el primer nombre: ");
                    nombre = sc.nextInt();
                    System.out.print("Introdueix el segon nombre: ");
                    segonNombre = sc.nextInt();
                    //Si el primer nombre es menor a 1 o més gran que el segon nombre
                    if (nombre < 1 || nombre > segonNombre) {
                        System.out.println("\nTens que introduir un nombre enter positiu i el primer nombre té que ser major al segon nombre.");
                    } else {
                        //Emmagatzamem el nombre
                        nombreGuardat = nombre;
                        //Declarem el boolean dadesCorrectes com true per executar l'operació desrpés del switch
                        dadesCorrectes = true;
                    }
                }
                //Si l'usuari a introduit la tercera opció
                case OPCIO_NOMBRE_ALEATORI_MILLON -> {
                    // Variable que escull un nombre entre el nombre maxim i el nombre minim aleatoriamente
                    final int NOMBRE_MAXIM = 1000000;
                    final int NOMBRE_MINIM = 1;
                    nombre = (int) (Math.random() * NOMBRE_MAXIM + NOMBRE_MINIM);
                    //Com la logica demana el primer i el segon nombre fem que el segon nombre sigui el mateix que el primer, així només fa el nombre introduït
                    segonNombre = nombre;
                    //Guardem el nombre
                    nombreGuardat = nombre;
                    //Declarem el boolean dadesCorrectes com true per executar l'operació desrpés del switch
                    dadesCorrectes = true;
                }
                //Si l'usuari a introduit la cuarta opció
                case OPCIO_VEURE_NOMBRE_AMB_MES_ITERACCIONS -> {
                    //Mostrem per pantalla el nombre trobat amb més iteraccions i la quantitat de iteraccions
                    System.out.println("\nEl mayor número de iteraciones: " + puntuacioMaximaIteraccions + " amb el nombre: " + puntuacioMaximaNombre);
                }
                //Si l'usuari a introduit la cinquena opció
                case OPCIO_SORTIR_DEL_PROGRAMA -> {
                    //Missatge per indicar que hem sortir del programa
                    System.out.println("\nHas sortir del programa.");
                    //Terminem l'execucció del programa
                    execucioDelPrograma = false;
                }
                //Si l'usuari no ha introduit cap opció valida
                default -> {
                    //Missatge per indicar que no s'ha introduit una opció valida
                    System.out.println("\nTens que introduïr una opcio valida.");
                }
            }

            //Comprovem que el boolean dadesCorrectes sigui true
            if (dadesCorrectes) {
                //Fem el bucle fins que nombre sigui igual o superior a segonNombre
                for (int comptador = 1; nombre <= segonNombre; comptador++) {
                    //Tornem iteraccions a valor 0
                    iteraccions = 0;
                    System.out.print("\nSequencia per " + nombre + ": ");
                    //Fem un bucle while, mentres el nombre sigui més gran a 1
                    while (nombre > 1) {
                        //Sumem 1 a iteraccions
                        iteraccions++;
                        //Imprimim el nombre introduit i li posem un espai per al següent nombre
                        System.out.print(nombre + " ");
                        //Si el nombre entre el modul 2 dona 0 es dividira entre 2
                        if (nombre % 2 == 0) {
                            nombre /= 2;
                        //Si no es multiplicara entre 3 i sumara 1
                        } else {
                            nombre = (nombre * 3) + 1;
                        }
                    }
                    //Imprimim el nombre, que en aquest punt dona 1
                    System.out.println(nombre);
                    //Imprimim la quantitat de iteracions per al nombre
                    System.out.println("Nombre total de iteracions: " + iteraccions);
                    
                    //Veurem si el nombre té més iteraccions que l'últim emmagatzemat
                    if (puntuacioMaximaIteraccions < iteraccions) {
                        puntuacioMaximaNombre = nombreGuardat + (comptador - 1);
                        puntuacioMaximaIteraccions = iteraccions;
                    }
                    //Donem a nombre el seu valor inicial més la quantitat de iteraccions del bucle for
                    nombre = nombreGuardat + comptador;
                }
            }
        } while (execucioDelPrograma);
    }
}