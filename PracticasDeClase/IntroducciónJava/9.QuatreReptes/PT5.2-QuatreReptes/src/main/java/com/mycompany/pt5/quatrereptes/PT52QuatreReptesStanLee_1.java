/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pt5.quatrereptes;

import java.util.Scanner;

/*
 * Aquest programa té una frase ("Stan Lee"), que es la que es buscara en el text que
 * l'usuari introdueixi. Al finalitzar mostrarà quants cops s'ha trobat
 * la frase. Fins que no hagi finalitzat la primera frase sencera, no passarà a buscar
 * la segona. Si no es modifica la frase sempre será "stanlee". Es verifica que el text 
 * introduït no tingui més de 10000 caràcters.
 *
 * @author Gerard Pozo, Eric Serrano i Ivan Rodríguez
 */
public class PT52QuatreReptesStanLee_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean execuccioPrograma = true;
        // L'utilitzarem per tenir un comptador per les lletres que anem trobant per
        // formar la frase
        int comptadorLletra = 0;
        // Emmagatzarem la quantitat de cops que es troba la frase en el text donat
        int frasesTrobades = 0;
        // La frase que estem buscant
        final String FRASE = "stanlee";
        final int TEXT_MAXIM = 10000;
        do {
            // Demanem la quantitat de textos a comprovar
            System.out.print("Introdueix la quantitat de textos que es vol comprovar: ");
            // Comprovem que la dada introduïda sigui un int
            if (sc.hasNextInt()) {
                int quantitatTextos = sc.nextInt();
                // Buidem el buffer per ara introduir un text
                sc.nextLine();
                for (int i = 1; i <= quantitatTextos; i++) {
                    // Demanem els textos segons la quantitat que hi hagin
                    System.out.print("\nIntrodueix el text: " + i+ "\n");
                    String text = sc.nextLine();
                    // Comprovem que la longitud del text no sigui més gran al máxim
                    if (text.length() <= TEXT_MAXIM) {
                        // Pasem tot el text a minuscula
                        String textMinuscula = text.toLowerCase();

                        for (int j = 0; j < textMinuscula.length(); j++) {
                            // Agafem una lletra
                            char lletra = textMinuscula.charAt(j);

                            // Comparem si la lletra coincideix amb la frase segons la posició que estem
                            // buscant ara
                            if (lletra == FRASE.charAt(comptadorLletra)) {
                                // Sumem el comptadorLletra per anar a buscar a la següent lletra
                                comptadorLletra++;
                                // Comprovem que la variable sigui mayor o igual a la longitud de la frase
                                if (comptadorLletra >= FRASE.length()) {
                                    // Tornem el comptadorLletra a 0 per tornar a començar a cercar la frase
                                    comptadorLletra = 0;
                                    // Com hem trobat una frase sencera la sumem
                                    frasesTrobades++;
                                }
                            }
                        }
                        // Posem la quantitat de cops que s'ha trobat la frase
                        System.out.println("Quantitat de " + FRASE + " trobats en el text " + i + ": " + frasesTrobades);
                        // Tornem les variables a su posició original
                        frasesTrobades = 0;
                        comptadorLletra = 0;
                        // Si posa un text més gran al máxim li donem una advertencia
                    } else {
                        System.out.println("No pots introduir un text més gran de 10000 caràcters.");
                        // Restem 1 a i per seguir en el mateix text
                        i--;
                    }
                }
                // Un cop totes els textos han sigut analitzats finalitzem el programa
                execuccioPrograma = false;
                // En cas contrari tornem a demanar el nombre i vuidem el bufer
            } else {
                System.out.println("Introdueix un nombre enter.");
                sc.nextLine();
            }
        } while (execuccioPrograma);
    }
}
