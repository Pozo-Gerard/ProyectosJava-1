/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pt3.factorial;

import java.util.Scanner;

/**
 * Aquet programa demana un numero al usuari i calcula el factorial del numero
 *
 * @author Gerard
 */
public class PT31FactorialWhile {

    public static void main(String[] args) {
        //Declarem i inicialitzem les variables i preguntem al usuari que numero volem introduïr
        Scanner sc = new Scanner(System.in);
        System.out.print("Introdueix un numero enter per saber el seu factorial: ");
        final int VALOR_MINIM = 0;
        int numero = sc.nextInt();
        int resultat = 1;
        int comptador = numero + 1;
        
        //Validem que el numero sigui més gran que 0
        if (numero > VALOR_MINIM) {
            System.out.print(numero + "! = ");
            
            //Fem el bucle
            while (comptador > 1) {
                comptador--;
                resultat *= comptador;
                
                //Aquet condicional s'encarrega d'imprimir bé la operació
                if (comptador > 1) {
                    //Si no es 1 imprimira aixì: 5 x 4 x 3 x 2...
                    System.out.print(comptador + " x ");
                } else {
                    //Si es 1 imprimeix el final de la operació, posant un = al final: 3 x 2 x 1 =
                    System.out.print(comptador + " = ");
                }
            }
            //Imprimim el resultat
            System.out.println(resultat);
            
        //Si el numero es 0    
        } else if (numero == VALOR_MINIM) {
            System.out.print(numero + "! = 1");
            
        //Si el numero es negatiu    
        } else {
            System.out.print("No es poden introduïr numeros negatius.");
        }
    }
}