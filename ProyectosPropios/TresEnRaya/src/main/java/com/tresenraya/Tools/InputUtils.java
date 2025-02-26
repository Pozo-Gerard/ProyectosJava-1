package com.tresenraya.Tools;

import java.util.Scanner;

/**
 * Metodos para controlar las entradas del usuario por el teclado
 * 
 * @author Gerard Pozo
 */
public class InputUtils {
    /**
     * Metodo para leer un número entero por el teclado
     * 
     * @return número entero introducido
     */
    public static int readRealNumberKeyboard() {
        Scanner sc = new Scanner(System.in);
        boolean correctNumber = false;
        int number = 0;
        // Bucle para pedir número correcte
        while (!correctNumber) {
            // Comprovar que sea correcto
            if (sc.hasNextInt()) {
                // Pedir número
                number = sc.nextInt();
                // Salir del bucle
                correctNumber = true;
            } else {
                // Limpiar buffer y voler a repetir
                sc.next();
                System.out.print("\nIntroduce un número: ");
            }
        }
        // Devolver numero introducido
        return number;
    }

    /**
     * Metodo para leer un número entero por el teclado y con un rango
     * 
     * @param min número minimo que debe de introducir el usuario
     * @param max número máximo que debe de introducir el usuario
     * @return número entero introducido
     */
    public static int readRealNumberKeyboard(byte min, byte max) {
        // Guardem el min i el max correctament, comprovant quin es el major i menor
        int minNumber = (min <= max) ? min : max;
        int maxNumber = (max >= min) ? max : min;
        int number = 0;
        boolean isCorrectNumber = false;
        // Repetim fins que l'usuari posi un nombre entre el rang
        while (!isCorrectNumber) {
            // Llamamos al método para que el usuario introduzca un número
            number = readRealNumberKeyboard();
            // Comprovem que el nombre introduit estigui dins del rang
            if (number < minNumber || number > maxNumber) {
                // Si no está dentro del rango salimos
                System.out.println("El número tiene que estar entre " + minNumber + " y " + maxNumber + ".");
                System.out.print("Vuelve a intentarlo: ");
            } else {
                // Salimos del bucle y devolvemos el número
                isCorrectNumber = true;
            }
            
        }
        // Devolvemos el número
        return number;
    }


}
