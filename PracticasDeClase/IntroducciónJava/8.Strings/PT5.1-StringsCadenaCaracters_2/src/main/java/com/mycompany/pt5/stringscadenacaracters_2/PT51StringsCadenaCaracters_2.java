/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pt5.stringscadenacaracters_2;

import java.util.Scanner;
/**
 *
 * @author Gerard Pozo, Ivan Rodriguez, Eric Serranor
 * 
 * Aquet programa demana un text al usuari i separa totes les paraules amb un salt de linea
 */
public class PT51StringsCadenaCaracters_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final char SALT_LINEA = ' ';
        //Demanem un text
        System.out.print("Introdueix un text: ");
        String text = sc.nextLine();

        //Recorrem el text
        for (int i = 0; i < text.length(); i++) {
            //Guardem la lletra en una variable
            char lletra = text.charAt(i);
            //Comprovem que la lletra sigui un espai
            if (lletra == SALT_LINEA) {
                //Si ho es, salt de linea
                System.out.println("");
            } else {
                //Si no, imprimim la lletra juntament amb les altres
                System.out.print(text.charAt(i));
            }
        }
    }
}
