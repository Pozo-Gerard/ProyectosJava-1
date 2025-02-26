/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parellimparell;

import java.util.Scanner;

/**
 *
 * @author Jordi
 */
public class ParellImparell {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        Aplicació que solicita un número i indica si és parell
        o imparell
        */
        
        // Declaració de variables
        int numero;
        
        // Entrada de dades
        Scanner sc= new Scanner(System.in);
        System.out.println("Escriu un número");
        numero = sc.nextInt();
        
        // Parell o imparell
        if (numero == 0){
            System.out.println("El zero no és parell ni imparell");
        } else if (numero%2 == 0){
            System.out.println("El número " + numero + " és parell");
        } else {
            System.out.println("El número " + numero + " és imparell");
        }
    }
    
}
