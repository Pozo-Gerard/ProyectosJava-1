/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package majoredatelseif;

import java.util.Scanner;

/**
 *
 * @author Jordi
 */
public class MajorEdatElseIf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Decidir si una persona es major de edat i/o adolescent
        
        // Declaració de variables
        final int MAJOREDAT = 18;
        int edat;
        
        // Entrada de dades
        Scanner lector = new Scanner(System.in);
        System.out.print("Quina edat tens? ");
        edat = lector.nextInt();
        
        // Sèntencia ELSE IF
        if (edat >= MAJOREDAT){
            System.out.println("Ets major d'edat");
        } else if (edat >= 16){
            System.out.println("Ets menor d'edat i adolescent");
        } else if (edat >= 6 && edat <= 12) {
            System.out.println("Ets menor d'edat i vas a primaria");
        } else {
            System.out.println("Ets menor de 16 anys");
        }

    }
}  
    

