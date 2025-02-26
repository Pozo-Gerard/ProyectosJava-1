/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.pt3.cinccentsvegades;

import java.util.Scanner;

public class PT31CinCentsVegadesWhile {

    public static void main(String[] args) {
        //Declarem i inicialitzem les variables i preguntem al usuari el cop de vegades que vol repetir la frase
        Scanner sc = new Scanner(System.in);
        System.out.print("Introdueix el numero de vegades que tens que posar la frase: ");
        int vegades = sc.nextInt();
        int comptador = 0;

        //Fem el bucle while que s'executará la quantitat de vegades que el usuari vol que es repeteixi
        while (comptador < vegades) {
            System.out.println("Estaré atent a classe");
            comptador++;
        }
    }
}
