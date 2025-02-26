/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pt5.stringssaludi_1;
import java.util.Scanner;
/**
 *
 * @author Gerard Pozo, Ivan Rodriguez, Eric Serrano
 * 
 * Aquet programa demana al usuari un nom i mostra per pantalla una frase més el nom del usuari
 */
public class PT51StringsSaludi_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Fem una variable amb la frase
        String bonDia = "Bon dia";
        //Demanem al usuari el seu nom
        System.out.print("Introdueix el teu nom: ");
        String nom = sc.nextLine();
        //Concatenem les variables del bon dia i del nom
        String frase = bonDia + " " + nom;
        //Mostrem per pantalla la frase més el nom
        System.out.println(frase);
    }
}
