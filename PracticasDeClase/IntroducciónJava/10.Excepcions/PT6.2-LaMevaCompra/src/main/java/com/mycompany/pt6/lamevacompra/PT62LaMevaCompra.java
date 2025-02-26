/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pt6.lamevacompra;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

// Importem les clases que hem creat per poder utilitzarles
// Hem fet això per tenir una estructura més ordenada en l'estructura del projecte
import com.mycompany.pt6.lamevacompra.Exception.*;

/**
 * 
 * @author Gerard Pozo i Eric Serrano
 * 
 *         Aquet programa permet afegir productes a una cestella i calcular el
 *         cost total d'ells, controlant les excepcions.
 */
public class PT62LaMevaCompra {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Opcions del menu principal
        final byte AFEGIR_PRODUCTES_MENU = 1;
        final byte CALCULAR_COST_MENU = 2;
        final byte SORTIR_MENU = 3;
        // El minim preu i la minima quantitat dels productes
        final int PREU_MINIM = 0;
        final int QUANTITAT_MINIMA = 0;
        // Els productes minims que té que tenir la cestella per calcular el preu
        final int PRODUCTES_MINIM_EN_CESTELLA = 1;
        // Variable per indicar quan finalitzar o terminar l'execució del programa
        boolean compilacioPrograma = true;
        // Emmagatzemarem tots els productes en la cestella, amb un multidimensional
        // ArrayList
        ArrayList<ArrayList<String>> arrCestella = new ArrayList<ArrayList<String>>();
        do {
            // Farem un try-catch que englobi tot el programa.
            try {
                // Menu principal
                System.out.println("\n------------------");
                System.out.println("  La meva compra");
                System.out.println("------------------");
                System.out.println("1) Afegir producte");
                System.out.println("2) Calcular cost total");
                System.out.println("3) Sortir");
                System.out.print("\nIntrodueix una opció: ");
                // Validem que l'usuari introdueixi un int
                if (sc.hasNextInt()) {
                    // Eleccio del usuari
                    int eleccioUsuari = sc.nextInt();
                    // Validem que l'usuari hagi introduït una de les opcions del menu
                    if (eleccioUsuari >= AFEGIR_PRODUCTES_MENU && eleccioUsuari <= SORTIR_MENU) {
                        switch (eleccioUsuari) {
                            // Si l'usuari vol afegir productes (Opció 1)
                            case AFEGIR_PRODUCTES_MENU -> {
                                // Tota l'informació d'un mateix producte en un ArrayList
                                ArrayList<String> arrProducte = new ArrayList<>();
                                // Preparem el buffer per la següent entrada
                                sc.nextLine();
                                // Introduir nom del producte
                                System.out.print("\nIntrodueix el nom del producte: ");
                                String nomProducte = sc.nextLine();
                                // Afegim el nom al array producte
                                arrProducte.add(nomProducte);

                                // Introduir preu del producte
                                System.out.print("Introdueix el preu: ");
                                float preu = sc.nextFloat();
                                // Validem que el preu sigui negatiu
                                if (preu < PREU_MINIM) {
                                    // Si es negatiu saltem a l'excepció
                                    throw new InvalidInputException("El valor no pot ser negatiu.");
                                } else {
                                    // Si no ho es, afegim el preu al array producte
                                    arrProducte.add(Float.toString(preu));
                                }

                                // Introduir la quantitat del producte
                                System.out.print("Introdueix la quantitat: ");
                                int quantitat = sc.nextInt();
                                // Validem que la quantitat sigui menor o igual a 0
                                if (quantitat <= QUANTITAT_MINIMA) {
                                    // Si es compleix saltem a l'excepció
                                    throw new InvalidInputException("El valor no pot ser negatiu.");
                                } else {
                                    // Si no ho es, afegim la quantitat al array producte
                                    arrProducte.add(Integer.toString(quantitat));
                                }

                                // Afegim el producte a la cestella
                                arrCestella.add(arrProducte);
                            }
                            // Si l'usuari vol calcular el cost (Opció 2)
                            case CALCULAR_COST_MENU -> {
                                // Cost total de la cestella
                                float preuTotal = 0;
                                // Quantitat de productes en la cestella
                                int nombreDeProductes = arrCestella.size();
                                // Si no hi han productes
                                if (nombreDeProductes < PRODUCTES_MINIM_EN_CESTELLA) {
                                    // Saltem a l'excepció
                                    throw new EmptyCartException("No hi han productes en la cestella.");
                                }
                                // Imprimim la quantitat de productes que hi han a la cestella
                                System.out.println("\nQuantitat de productes: " + nombreDeProductes);
                                System.out.println("Productes");
                                System.out.println("----------");
                                // Recorrem tots els productes
                                for (int i = 0; i < arrCestella.size(); i++) {
                                    // Agafem el nom, preu i quantitat del producte actual
                                    String nomProducte = arrCestella.get(i).get(0);
                                    float preuProducte = Float.parseFloat(arrCestella.get(i).get(1));
                                    int quantitatProducte = Integer.parseInt(arrCestella.get(i).get(2));
                                    // Calculem el preu del producte i el sumem al preu actual
                                    preuTotal += preuProducte * quantitatProducte;
                                    // Imprimim els productes de la cestella
                                    System.out.println(i + 1 + ") " + nomProducte + " | " + preuProducte + "€ | "
                                            + quantitatProducte);
                                }
                                // Imprimim el preu total de tots els productes redonint a 2 xifres.
                                System.out.printf("\nPreu total: %.2f€\n", preuTotal);
                            }
                            // Si l'usuari vol sortir (Opció 3)
                            case SORTIR_MENU -> {
                                // Es surt del programa
                                System.out.println("Has sortit.");
                                compilacioPrograma = false;
                            }
                        }
                        // Si l'usuari introdueix una opció fora del menú
                    } else {
                        // Saltem a l'excepció
                        throw new InvalidMenuException("Opció del menu incorrecte.");
                    }
                    // Si l'usuari no introdueix un nombre enter
                } else {
                    // Netejem el buffer
                    sc.next();
                    // Saltem a l'excepció
                    throw new InputMismatchException();
                }
                // Totes les excepcions que contemplem en el programa
            } catch (InvalidInputException e) {
                System.out.println("ERROR: No es pot introduïr un valor negatiu en el preu o la quantitat.");
            } catch (EmptyCartException e) {
                System.out.println("ERROR: No hi han productes en la cestella.");
            } catch (InvalidMenuException e) {
                System.out.println("ERROR: No es pot introduïr una opció que no estigui en el menú.");
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Es té que introduïr un nombre enter.");
            } catch (Exception e) {
                System.out.println("A ocorregut un error inesperat.");
            }
        } while (compilacioPrograma);
    }
}