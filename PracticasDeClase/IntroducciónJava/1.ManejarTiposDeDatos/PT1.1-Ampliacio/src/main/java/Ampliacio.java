/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/

/**
 *
 * @author ivanr && Gerard Pozo
 */

// El programa mostrara la quantitat de taules de multiplicar que el usuari vulgui fent que si posa 5 es mostri les 5 primeres i amb un máxim de 10.

// Importem la clase Scanner
import java.util.Scanner;

public class Ampliacio {
       
    public static void main(String[] args) {
        // Creem la variable amb el objecte scanner
        Scanner sc = new Scanner(System.in);
        
        // La interfau que veu el usuari
        System.out.println("TAULES DE MULTIPLICAR");
        System.out.println("-----------------------");
        System.out.println("Introdueix quantes taules de multiplicar del 0 al 10 vols sapiguer");
        
        // Declarem i iniciem la variable i li pasem la variable sc, de scanner
        int scannerUsuari = sc.nextInt();
        
        // Valida si la dada introduida del usuari està dins del rang 0 - 10, si no ho cumpleix finalitza el programa
        if (scannerUsuari <= 10 && scannerUsuari >= 0) {
            
            // Declarem i iniciem la varaible i diu el nombre de la taula que estem fent i també ho utilitzarem per el primer valor de la multipliació
            int numeroTaula = 0;
            
            // Declarem i iniciem la variable, ho utilitzarem per el segon valor de la multiplicació
            int increment = 0;
            
            // Declarem la variable, la utilitzarem per sapiguer quant val numeroTaul * increment
            int resultat;
            
            /*
            * Creem el primer bucle, si el valor de numeroTaula es menor o igual al valor introduit al usuari s'activa.
            * Això ho fem per imprimir el número de la taula per al que anem, exemple: Taula 0, Taula 1, Taula 2...
            */
            while (numeroTaula <= scannerUsuari) {
                
                //Imprimim per pantalla per quina taula anem.
                System.out.println("Taula: " + numeroTaula);
                
                /*
                * Creem el segon bucle, sempre que increment sigui menor a 10 es cumplira.
                * El 10 simbolitza quantes operaciones de cada taula volem fer, així mostrara només 10, pero si posesim un máxim de 15, mostraria 15...
                */
                while (increment <= 10) {
                    
                    // Iniciem la variable resultat y multipliquem el valor de numeroTaula per increment, això da com a resultat el valor de la variable resultat
                    resultat = numeroTaula * increment;
                    
                    // Imprimim la operacio
                    System.out.println(numeroTaula + " * " + increment + " = " + resultat);
                    
                    // Increment suma 1 per a que a la següent operació en comptes de 0 sigui 1, si increment es 1, a la següent será 2...
                    increment++;
                }
                
                // Quan el segon bucle termina sumem 1 a numeroTaula per fer la següent taula, si ara hem fet la taula del 0, al sumar 1 farem a la següent volta la taula del 1
                numeroTaula++;
                
                // I tornem a donarli a la variable increment el valor de 0, per a que torni a fer el segon bucle
                increment = 0;
            }
            
            // Si la condició no es cumpleix
        } else {
            
            // Imprimim per qué ha fallat, i el programa finalitza.
            System.out.println("Introdueix un nou número no superior a 10 o inferior a 0.");
        }
    }
}