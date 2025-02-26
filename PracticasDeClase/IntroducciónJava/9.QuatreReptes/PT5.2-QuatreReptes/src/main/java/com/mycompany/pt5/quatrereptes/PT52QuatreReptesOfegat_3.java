/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.pt5.quatrereptes;

/* Aquest programa és el joc de l'ofegat, amb una sèrie de normes: primer un jugador introdueix
 * la paraula a endevinar, i l'altre anirà provant d'encertar lletra a lletra. El joc acaba 
 * quan s'encerta la paraula o quan s'arriba a 7 intents. Les lletres no conegudes es mostraran 
 * amb un "_", i conforme es vagin encertant, s'aniran mostrant. Si s'encerta la lletra, no es resta l'intent.
 *
 * @author Gerard Pozo, Eric Serrano i Ivan Rodríguez
 */
import java.util.Scanner;

public class PT52QuatreReptesOfegat_3 {

    public static void main(String[] args) {
        //Declarem les variables
        Scanner sc = new Scanner(System.in);
        final int COMENÇAR_JOC = 1;
        final int RESULTAT_PARTIDES = 2;
        final int SORTIR = 3;
        final int INTENTS_MAXIMS = 7;
        int partidesGuanyadesJugadorA = 0;
        int partidesGuanyadesJugadorB = 0;
        int tornJugador = 1;

        boolean execucioPrograma = true;
        char jugadorQueLiToca = 'A';
        do { //Inici del programa
            int intents = INTENTS_MAXIMS;// Declarem i inicialitzem el recompte d'intents en els màxims (Cnt)
            //Presentació del joc i menú principal
            System.out.println("\n-----------------");
            System.out.println("     Ofegat");
            System.out.println("-----------------");
            System.out.println("1) Començar joc");
            System.out.println("2) Resultat partides");
            System.out.println("3) Sortir");
            System.out.print("\nIntrodueix una opció: ");
            if (sc.hasNextInt()) { //Comprovació que s'ha introduït nombre enter
                int eleccioMenuPrincipal = sc.nextInt(); //asignem la tria a una variable.

                switch (eleccioMenuPrincipal) { //avaluem la opció triada
                    case COMENÇAR_JOC -> { //Inici del joc
                        // Informem a quin jugador li toca ara, començarà l'"A".
                        System.out.print("\nJugador " + jugadorQueLiToca + " introdueix una paraula: ");
                        if (tornJugador % 2 == 0) { //Torns parells
                            jugadorQueLiToca = 'A';
                        } else { //Torns senars
                            jugadorQueLiToca = 'B';
                        }
                        // Demanem al jugador que li toca una paraula, i assignem a String
                        String paraula = sc.next();
                        //Declarem un array char amb la longitud de la paraula introduïda.
                        char[] arrParaulaAmagada = new char[paraula.length()];
                        //Recorrem la paraula, per mostrar tants guions com chars tingui.
                        for (int i = 0; i < paraula.length(); i++) { 
                            arrParaulaAmagada[i] = '_';
                        }
                        boolean paraulaEndevinada = false;

                        do {
                            // Demanem al jugador que li toca una lletra.
                            System.out.print("\nJugador " + jugadorQueLiToca + " introdueix una lletra: ");
                            char lletra = sc.next().charAt(0);// Variable per emmagatzemar les lletres entrades per teclat
                            boolean intentComptat = false; //
                            int lletresEncertades = 0;
                            for (int i = 0; i < paraula.length(); i++) { //Bucle per buscar la lletra en la paraula.
                                // Comprovem si la lletra introduïda es troba en la paraula
                                if (lletra == paraula.charAt(i)) {
                                    arrParaulaAmagada[i] = lletra; //Si coincideix, canviem el guió per la lletra a l'array.
                                    lletresEncertades++; //incrementem comptador de lletres encertades   
                                //amb el booleà ens assegurem que només es resti una vegada l'intent a cada bucle
                                } else if (!intentComptat) {                                     
                                    intents--;
                                }
                                intentComptat = true;
                                //Sortida de la paraula després de comprovar la lletra amb el bucle
                                System.out.print(arrParaulaAmagada[i]);
                                System.out.print(" ");
                            }
                            System.out.println("\nTens: " + intents + " intents");

                            if (intents <= 0) {
                                System.out.println("\nEl jugador " + jugadorQueLiToca + " s'ha quedat sense intents.");
                                paraulaEndevinada = true;

                                // Sumem la partida guanyada la jugador que pertoqui
                                if (jugadorQueLiToca == 'A') {
                                    partidesGuanyadesJugadorB++;
                                } else {
                                    partidesGuanyadesJugadorA++;
                                }
                            }
                            if (lletresEncertades >= paraula.length()) { //Si ha encertat la paraula sencera
                                System.out.println("\nEl jugador " + jugadorQueLiToca + " a endevinat la paraula.");
                                paraulaEndevinada = true;

                                // Sumem la partida guanyada a un dels jugadors (al que li toqui)
                                if (jugadorQueLiToca == 'A') {
                                    partidesGuanyadesJugadorA++;
                                } else {
                                    partidesGuanyadesJugadorB++;
                                }
                            }
                        } while (!paraulaEndevinada);
                        tornJugador++; //incrementem el torn per a canviar els rols a la següent partida.
                    }

                    case RESULTAT_PARTIDES -> { //Opció resultats de partides, donem sortida dels comptadors.
                        System.out.println("\nResultat partides");
                        System.out.println("-----------------");
                        System.out.println("Partides guanyades jugador A: " + partidesGuanyadesJugadorA);
                        System.out.println("Partides guanyades jugador B: " + partidesGuanyadesJugadorB);
                    }

                    case SORTIR -> { //Opció sortir, a través del booleà "execucióPrograma"
                        System.out.println("\nHas sortit del programa.");
                        execucioPrograma = false;
                    }

                    default -> { //Opció triada no vàlida
                        System.out.println("Has d'introduïr una de les opcions.");
                    }
                }
            } else { //Si no ha introduït un enter
                System.out.println("Introdueix una de les opcions.");
                sc.next();
            }
        } while (execucioPrograma);
    }
}
