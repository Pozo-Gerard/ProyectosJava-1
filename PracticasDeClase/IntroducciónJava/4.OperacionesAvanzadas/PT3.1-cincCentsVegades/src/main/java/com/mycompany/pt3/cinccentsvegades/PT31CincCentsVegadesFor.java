/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.pt3.cinccentsvegades;

import java.util.Scanner;

/**
 * Aquest programa demana al usuari quants cops vol repetir la frase "Estaré
 * atent a clase"
 *
 * @author Gerard
 */
public class PT31CincCentsVegadesFor {

    public static void main(String[] args) {
        //Declarem i inicialitzem les variables i preguntem al usuari el cop de vegades que vol repetir la frase
        Scanner sc = new Scanner(System.in);
        System.out.print("Introdueix el numero de vegades que tens que posar la frase: ");
        int vegades = sc.nextInt();

        //Fem el bucle for que s'executará la quantitat de vegades que el usuari vol que es repeteixi
        for (int comptador = 0; comptador < vegades; comptador++) {
            System.out.println("Estaré atent a classe");
        }
    }
}
