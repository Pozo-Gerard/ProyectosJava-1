package com.mycompany.pt1.iva;

import java.util.Scanner;

/**
 *
 * @author ivanr && Gerard Pozo
 */
public class PT11IVA {

    public static void main(String[] args) {
        /*Primer de tot, declarem la variable "sc" i inicialitzem amb
        la classe Scanner per poder introduir valors des de la consola.
        */
        Scanner sc = new Scanner(System.in);
        double base, iva, pvp, importIva; //Declarem les variables
        
      /*Demanem a l'usuari la base imposable, i inicialitzem la variable "base"
        amb el valor introduït
        */
        System.out.println("Quina és la base imposable?");
        base = sc.nextDouble();
        
        /*Demanem a l'usuari quin IVA vol aplicar, i inicialitzem la variable 
        "iva amb el valor introduït
        */
        System.out.println("Quin IVA vols aplicar?");
        iva = sc.nextDouble();
        
        /*Calculem l'import del IVA i el PVP amb les següents fòrmules i donem
        de sortida els dos valors corresponents        
        */
        importIva = base*(iva/100);
        pvp = base + importIva;
        
        System.out.println("L'import afegit corresponent a l'IVA és " + importIva + "€");
        System.out.println("L'import total amb IVA (PVP) és " + pvp + "€");
    }
}
