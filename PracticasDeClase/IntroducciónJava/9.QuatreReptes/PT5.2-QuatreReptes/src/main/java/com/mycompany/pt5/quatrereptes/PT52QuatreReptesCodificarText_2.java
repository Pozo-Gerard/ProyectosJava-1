/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pt5.quatrereptes;

import java.util.Scanner;

/*
 * Aquest programa demana un text i el codifica amb una correspondència entre lletres,
 * seguint dos conjunts (String) de caràcters. Les lletres no especificades no canviaran. 
 * La codificació no diferència majúscules i minúscules, i sempre donarà la sortida en minúscules.
 *
 * @author Gerard Pozo, Eric Serrano i Ivan Rodríguez
 */
public class PT52QuatreReptesCodificarText_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Declarem i inicialitzem els conjunts
        final String PRIMER_CONJUNT = "eikmpqrstuv";
        final String SEGON_CONJUNT = "pviumterkqs";
        // Variable per l'execució del programa
        boolean volsIntroduirText = true;

        do {
            // Demanem un text a l'usuari
            System.out.print("Introdueix el text: ");
            String text = sc.nextLine();
            // Convertim el text a minuscula
            String textMinuscula = text.toLowerCase();

            for (int i = 0; i < textMinuscula.length(); i++) {
                // Agafem una lletra
                char lletra = textMinuscula.charAt(i);
                // Guardem la posició ón es troba la lletra en el primer conjunt
                int lletraCoincident = PRIMER_CONJUNT.indexOf(lletra);
                // Si indexOf no troba la lletra torna -1, per això comparem el que retorna el
                // indexOf si es més gran o igual a 0
                if (lletraCoincident >= 0) {
                    // Imprimim la lletra del segon conjunt que té la misma posició que ha trobat el
                    // indexOf
                    System.out.print(SEGON_CONJUNT.charAt(lletraCoincident));
                } else {
                    // Imprimim la lletra
                    System.out.print(lletra);
                }
            }            
            // Preguntem a l'usuari si vol introduir un altre codi
            System.out.print("\nVols introduir un altre text? (Y|N): ");
            // Emmagatzamem la primera lletra de la respota
            char tornarAComençar = sc.next().charAt(0);
            // Comprovem que no sigui y o Y per tal de sortir, o si ho és, continuem al bucle.
            if (tornarAComençar != 'y' && tornarAComençar != 'Y') {
                System.out.println("Has sortit.");
                volsIntroduirText = false; //Si hi havia 'y' o 'Y', canviem el booleà per sortir.
            }
            sc.nextLine(); //Netegem el buffer
        } while (volsIntroduirText);
    }
}
