/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.pt3.distancia;

import java.util.Scanner;

/**
 * Aquet programa va demanant al usuari ciutats i a quina distancia es troben,
 * al final suma la distancia total entre totes les ciutats
 *
 * @author Gerard
 */
public class PT31Distancia {

    public static void main(String[] args) {
        //Declarem i inicialitzem les variables
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;
        int kilometresEntreCiutats;
        int resultat = 0;

        //Primer de tot imprimim un cop el programa abans de comprovar si el usuari vol continuar fent el programa
        do {
            System.out.print("Posa el nom de la primera ciutat: ");
            String primeraCiutat = sc.nextLine();
            System.out.print("Posa el nom de la segona ciutat: ");
            String segonaCiutat = sc.nextLine();
            System.out.print("Posa quants kilometres hi ha entre " + primeraCiutat + " i " + segonaCiutat + ": ");
            kilometresEntreCiutats = sc.nextInt();
            
            //Afegim una linea per quan es torni a executar el programa poder introduïr la primera ciutat
            sc.nextLine();
            
            resultat += kilometresEntreCiutats;
            System.out.print("Vols afegir un altre ciutat?: (S/N) ");
            String afegirAltreCiutat = sc.nextLine();
            
            //Validem si el usuari  vol seguir en el programa
            if (afegirAltreCiutat.equals("S") || afegirAltreCiutat.equals("s")) {
                System.out.println("\nHas continuat en el programa.\n");
            //Validem si el usuari no vol seguir en el programa
            } else if (afegirAltreCiutat.equals("N") || afegirAltreCiutat.equals("n")) {
                continuar = false;
            //Si el usuari no introdueix S o N
            } else {
                System.out.println("Has introduït una dada no valida");
                continuar = false;
            }
        }
        //Després de imprimir un cop el programa validem si el usuari vol continuar
        while (continuar);
        
        //Quan el usuari surt del bucle imprimeix quants quilometres en total hi ha
        System.out.println("Distancia total: " + resultat + "km.");
    }
}
