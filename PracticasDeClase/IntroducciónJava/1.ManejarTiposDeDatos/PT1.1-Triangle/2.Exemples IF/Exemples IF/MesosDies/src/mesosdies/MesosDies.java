/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mesosdies;

import java.util.Scanner;

/**
 *
 * @author Jordi
 */
public class MesosDies {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       /*
        Realiza un programa que pida un número entero entre uno y doce e 
        imprima el número de días que tiene el mes correspondiente.
        Realitza un programa que demani un número enter entre 1 i 12, i 
        imprimeixi el número de dies que té el més correponent
        */
       
        Scanner lector = new Scanner(System.in);
        
        // Declaració de variables
        int mes;
        
        // Solicitud de dades a l'usuari
        System.out.println("Escriu el número de mes");
        mes = lector.nextInt();
        
        // Realitzem les comparacions i mostrem el resultart
        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12){
            System.out.println("El mes seleccionat té 31 dies");
        } else if (mes == 2){
            System.out.println("Febrer tiene 28 dies");
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11){
            System.out.println("El mes escollit té 30 dies");
        } else {
            System.out.println("Error, el mes ha d'estar entre 1-12.");
        } 
    }
    
}
