/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.pt3.cinccentsvegades;

import java.util.Scanner;

/**
 * Aquest programa demana al usuari quants cops vol repetir la frase "Estaré
 * atent a clase"
 *
 * @author Gerard i Eric Serrano
 */
public class PT31CincCentsVegadesDoWhile {

    public static void main(String[] args) {
        //Declarem i inicialitzem les variables i preguntem al usuari el cop de vegades que vol repetir la frase
        Scanner sc = new Scanner(System.in);
        System.out.print("Introdueix el numero de vegades que tens que posar la frase: ");
        final int VALOR_MINIM = 0;
        int comptador = 0;
        int vegades = sc.nextInt();

        //Fem un condicional per asegurar-nos que la quantiat de cops que es repeteix es més gran que 0
        if (vegades > VALOR_MINIM) {
            //Fem el bucle do while que s'executará la quantitat de vegades que el usuari vol que es repeteixi
            do {
                System.out.println("Estaré atent a classe");
                comptador++;
            } while (comptador < vegades);
        }
    }
}
