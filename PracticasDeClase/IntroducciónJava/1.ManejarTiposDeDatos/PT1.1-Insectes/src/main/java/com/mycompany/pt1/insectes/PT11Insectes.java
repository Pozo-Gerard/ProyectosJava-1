package com.mycompany.pt1.insectes;

import java.util.Scanner;

/**
 *
 * @author ivanr && Gerard Pozo
 */

// Considerem que els insectes seràn números enters, ja que no es consideraran parts d'insectes.

public class PT11Insectes {

    public static void main(String[] args) {
    /*Primer de tot, declarem la variable "sc" i inicialitzem amb
      la classe Scanner per poder introduir valors des de la consola.
      */
        Scanner sc = new Scanner(System.in);
        
    /*Declarem les 
      variables amb Int, ja que tant el nombre d'insectes com el de potes
      serà un enter.
    */        
        int formigues, aranyes, cotxinilles, potesTotals; 
        
      //Demanem a l'usuari el nombre d'individus de cada tipus
        
        System.out.println("Quantes formigues has trobat?");
        formigues = sc.nextInt();
           
        System.out.println("Quantes aranyes has trobat?");
        aranyes = sc.nextInt();
        
        System.out.println("Quantes cotxinilles has trobat?");
        cotxinilles = sc.nextInt();
        
        
      /*Calculem el número de potes totals amb la fòrmula següent 
        i mostres a l'usuari els resultats
        */
      
        // Declarem i iniciem les constants per que el nostre codi no admet canvi en el número de potes
        final int formiguesPotes = 6;
        final int aranyesPotes = 8;
        final int cotxinillesPotes = 14;
      
        potesTotals = (formiguesPotes * formigues) + (aranyesPotes * aranyes) + (cotxinillesPotes * cotxinilles);
        
        System.out.println("El número de potes de les formigues es " + formiguesPotes * formigues);
        System.out.println("El número de potes de les aranyes es " + aranyesPotes * aranyes);
        System.out.println("El número de potes de les cotxinilles es " + cotxinillesPotes * cotxinilles);
        System.out.println("El número de potes entre tots els tipus d'insectes és " + potesTotals);
    }
}