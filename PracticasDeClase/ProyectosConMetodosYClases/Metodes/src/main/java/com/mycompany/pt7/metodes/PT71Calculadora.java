/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pt7.metodes;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Gerard i Eric Serrano
 * 
 *         Aquet programa crida a un métode per calcular una operació entre dos
 *         nombres, pasant dos nombres enters i l'operació que es vol fer.
 * 
 */
public class PT71Calculadora {
    public static void main(String[] args) {
        boolean execuccioPrograma = true;
        // La primera i última opció del menu principal
        final byte PRIMERA_OPCIO = 1;
        final byte ULTIMA_OPCIO = 4;
        do {
            Scanner sc = new Scanner(System.in);
            try {
                // Menú principal
                System.out.println("------------");
                System.out.println("CALCULADORA");
                System.out.println("------------");
                System.out.println("1) Sumar");
                System.out.println("2) Restar");
                System.out.println("3) Multiplicar");
                System.out.println("4) Dividir");
                System.out.print("\nIntrodueix una opció: ");
                // Guardem el que vol fer l'usuari
                int opcióUsuari = sc.nextInt();
                // Comprovem que hagi introduït una de les opcions del menú principal
                if (opcióUsuari >= PRIMERA_OPCIO && opcióUsuari <= ULTIMA_OPCIO) {
                    // Demanem els dos nombres
                    System.out.print("\nIntrodueix el primer nombre: ");
                    int primerNombre = sc.nextInt();
                    System.out.print("\nIntrodueix el segon nombre: ");
                    int segonNombre = sc.nextInt();
                    // Truquem al métode i guardem el que retorni en la variable resultat
                    int resultat = calcular(opcióUsuari, primerNombre, segonNombre);
                    // Mostrem el resultat
                    System.out.println("El resultat es " + resultat);
                    // Si es surt del rang es surt del programa
                } else {
                    System.out.println("Has sortit del programa.");
                    execuccioPrograma = false;
                }
                // Si es troben excepcions
            } catch (InputMismatchException e) {
                // Netejem el buffer
                sc.next();
                System.out.println("Tens que introduïr un nombre enter.");
            } catch (Exception e) {
                // Netejem el buffer
                sc.next();
                System.out.println("Ha ocorregut un error inesperat.");
            }
        } while (execuccioPrograma);
    }

    // Creem el métode per calcular l'operació entre els dos nombres
    public static int calcular(int operador, int primerNombre, int segonNombre) {
        // Les opcions posibles del menú principal
        final byte SUMAR = 1;
        final byte RESTAR = 2;
        final byte MULTIPLICAR = 3;
        final byte DIVIDIR = 4;
        // Comprovem quina operació vol fer l'usuari amb l'operador
        switch (operador) {
            case SUMAR -> {
                // Tornem la suma
                return primerNombre + segonNombre;
            }
            case RESTAR -> {
                // Tornem la resta
                return primerNombre - segonNombre;
            }
            case MULTIPLICAR -> {
                // Tornem la multiplicació
                return primerNombre - segonNombre;
            }
            case DIVIDIR -> {
                // No volem que el divisor sigui 0 o negatiu
                if (segonNombre > 0) {
                    // Tornem la divisió
                    return primerNombre / segonNombre;
                } else {
                    System.out.println("No es pot dividir per 0 o un nombre negatiu.");
                }

            }
            // Si no es cap de les opcions
            default -> System.out.println("Escull una de les opcions permeses");
        }
        // Si el codi arriba aquí tornem -1
        return -1;
    }
}
