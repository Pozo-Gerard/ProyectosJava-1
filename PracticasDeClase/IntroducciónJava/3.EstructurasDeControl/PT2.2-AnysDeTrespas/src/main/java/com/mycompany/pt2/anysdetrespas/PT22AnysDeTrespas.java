/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pt2.anysdetrespas;

import java.util.Scanner;
/**
 * Aquest programa diu si un any introduit per el usuari és un any de traspas
 * 
 * @author Gerard i Iban
 */
public class PT22AnysDeTrespas {

    public static void main(String[] args) {
        
        //Declarem i inicialitzem les variables i demanem al usuari un any
        Scanner sc = new Scanner(System.in);
        System.out.print("Introdueix un any per veure si es un any de traspás: ");
        int any = sc.nextInt();
        
        //Validem si el any introduit per el usuari es un any de traspas
        if (any % 4 == 0 && any % 100 != 0 || any % 400 == 0) {
            System.out.println("L'any " + any + " es un any de traspás.");
        } else {
            System.out.println("L'any " + any + " no es un any de traspás.");
        }
    }
}
