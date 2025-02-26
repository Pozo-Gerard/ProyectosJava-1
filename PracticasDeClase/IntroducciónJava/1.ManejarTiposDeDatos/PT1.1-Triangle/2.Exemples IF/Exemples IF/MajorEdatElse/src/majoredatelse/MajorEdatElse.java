package majoredatelse;

import java.util.Scanner;
public class MajorEdatElse {
 public static void main(String[] args) {
    //Decidir si una persona es major de edat.
    
    // Declaració de variables
    final int MAJOREDAT = 18;
    int edat;
    
    // Entrada de daddes
    Scanner lector = new Scanner(System.in);
    System.out.print("Quina edat tens? ");
    edat = lector.nextInt();
    
    //Sentència IF ELSE
    if (edat >= MAJOREDAT){
        System.out.println("Ets major d'edat");
    } else{
        System.out.println("Ets menor d'edat");
    }
 }
}
