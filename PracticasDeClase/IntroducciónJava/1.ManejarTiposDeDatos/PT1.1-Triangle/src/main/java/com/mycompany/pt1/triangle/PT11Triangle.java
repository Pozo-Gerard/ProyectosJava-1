package com.mycompany.pt1.triangle;

import java.util.Scanner;

/**
 *
 * @author ivanr && Gerard Pozo
 */
public class PT11Triangle {

    public static void main(String[] args) {
      /*Declarem la variable "sc" i inicialitzem amb la classe Scanner per 
      poder introduir valors des de la consola.
        */
        Scanner sc = new Scanner(System.in);
        double base, altura, area; //Declarem les variables
        
      /*Demanem a l'usuari la base i l'altura, i inicialitzem ambdues variables
        amb els valors corresponents
        */
        System.out.println("Quina és la base del triangle?");
        base = sc.nextDouble();
           
        System.out.println("Quina és la seva alçada?");
        altura = sc.nextDouble();
        
      /*Calculem l'àrea amb la següent fòrmula i donem el resultat 
        de sortida a l'usuari  
        */
      
        area = base*altura/2;        
        System.out.println("L'àrea del triangle " + area);
    }
}