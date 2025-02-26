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
public class PT31FactorialDoWhile {

    public static void main(String[] args) {
        //Declarem i inicialitzem les variables i preguntem al usuari que numero volem introduïr
        Scanner sc = new Scanner(System.in);
        System.out.print("Introdueix un numero enter per saber el seu factorial: ");
        final int VALOR_MINIM = 0;
        int numero = sc.nextInt();
        int resultat = 1;

        //Validem que  el numero sigui més petit que 0
        if (numero < VALOR_MINIM) {
            System.out.println("El numero té que ser positiu");
            //En el cas que sigui 0 el resultat sempre es 1
        } else if (numero == VALOR_MINIM) {
            System.out.print(numero + "! = 1");
        } else {
            //Sumem 1 per que quan comença el do resta 1 al comptador
            int comptador = numero + 1;
            //Imprimim el numero del usuari fent que quedi aixì: 5! =
            System.out.print(numero + "! = ");
            do {
                //Fem la formula per calcular el factorial i restem 1 a comptador
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
            } while (comptador > 1);
            //Imprimim el resultat
            System.out.print(resultat);
        }
    }
}
