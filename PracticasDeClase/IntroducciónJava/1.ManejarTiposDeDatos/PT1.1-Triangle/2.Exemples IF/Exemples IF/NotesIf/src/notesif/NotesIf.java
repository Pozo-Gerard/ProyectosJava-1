/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package notesif;

import java.util.Scanner;

/**
 *
 * @author Jordi
 */
public class NotesIf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        Demana una nota entera de 0 a 10 i mostra-la de la següent forma:
        - Insuficient: de 0 a 4
        - Suficient: 5
        - Bé: 6
        - Notable: 7 o 8
        - Excel·lent: 9 o 10
        */
        
        Scanner sc = new Scanner(System.in);
        
        // Declaració de variables
        int nota;
        
        // Petició de dades
        System.out.println("Introdueix una nota");
        nota = sc.nextInt();
        
        // Sentència IF
        if(nota >= 0 && nota < 5){  // També nota >= 0 && nota <= 4
            System.out.println("Insuficient ");
        } else if (nota == 5){
            System.out.println("Suficient");
        } else if (nota == 6){
            System.out.println("Bé");
        } else if (nota == 7 || nota == 8){
            System.out.println("Notable");
        } else if (nota == 9 || nota == 10){
            System.out.println("Excel·lent");
        } else{
            System.out.println("Error: nota no vàlida");
        }
        
    }
    
}
