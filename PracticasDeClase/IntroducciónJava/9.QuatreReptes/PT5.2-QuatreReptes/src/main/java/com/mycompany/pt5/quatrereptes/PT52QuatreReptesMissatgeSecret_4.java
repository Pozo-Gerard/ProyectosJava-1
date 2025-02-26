/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pt5.quatrereptes;

import java.util.Scanner;
/* Aquest programa descodifica un missatge numèric, introduït per l'usuari, en les 
 * corresponents lletres, segons els codi ASCII. Es poden introduir majúscules i minúscules.
 * Dona de sortida un String.
 *
 * @author Gerard Pozo, Eric Serrano i Ivan Rodríguez
 */
public class PT52QuatreReptesMissatgeSecret_4 {
    public static void main(String[] args) {
        //Declaració de variables
        Scanner sc = new Scanner(System.in);
        final int CODI_ASCII_A_MAY = 65;
        final int CODI_ASCII_Z_MAY = 90;
        final int CODI_ASCII_ESPAI = 32;
        final int CODI_ASCII_A_MIN = 97;
        final int CODI_ASCII_Z_MIN = 122;
        boolean volsIntroduirElCodi = true;
        
        do {
            //Demanem a l'usuari que introdueixi el codi, i si és un enter, li assignem a una variable String.
            String paraulaDesxifrada = "";
            System.out.print("Introdueix el codi: ");
            if (sc.hasNext()) {
                String codiSecret = sc.next();
                //Bucle for per recórrer el codi introduït de 2 caràcteres en 2
                int i = 0;
                while (i < codiSecret.length()) {         
                    int longitudSubstring = 2; //Variable per controlar la longitud dels talls
                    if (codiSecret.charAt(i) == '1') { //Si és 1 el primer número següent, li afegim 1 a la variable
                        longitudSubstring+=1;               
                    }   
                    String codi = codiSecret.substring(i, i + longitudSubstring); //Fem el substring
                    i += longitudSubstring;
                    int nombre = Integer.valueOf(codi); //Convertim a enter 
                    //Si és un número dels desitjats, el convertirem a la lletra corresponent.
                    if (nombre >= CODI_ASCII_A_MAY && nombre <= CODI_ASCII_Z_MAY || 
                        nombre == CODI_ASCII_ESPAI || nombre >= CODI_ASCII_A_MIN && nombre <= CODI_ASCII_Z_MIN) {
                        char lletra = (char) nombre;
                        paraulaDesxifrada += lletra; //Afegirem el char a la variable String resultat.
                        //Si no, li direm a l'usuari, i canviarem el valor de la "i" per sortir del bucle i que torni a demanar un altre codi.
                    } else {
                        System.out.println("El codi no té lletres minuscules ni majuscules");
                        i = codiSecret.length(); //Li donem el valor length perquè surti del bucle.
                    }          
                }
                System.out.println(paraulaDesxifrada); //Donem de sortida la cadena resultat
                System.out.print("\nVols introduïr un altre codi? (Y|N): "); // Preguntem si es vol introduir un altre codi
                char tornarAComençar = sc.next().charAt(0); //I assignem  el valor a una variable
                if (tornarAComençar != 'y' && tornarAComençar != 'Y') { //Avaluem la variable
                    System.out.println("\nHas sortit.");
                    volsIntroduirElCodi = false; //si no volen un altre codi, donem "false" per sortir del programa.
                }
            } else { //Si el codi introduït no és un nombre enter.
                System.out.println("Has d'introduir un nombre enter.");
                sc.next();
            }
        } while (volsIntroduirElCodi);
    }
}
