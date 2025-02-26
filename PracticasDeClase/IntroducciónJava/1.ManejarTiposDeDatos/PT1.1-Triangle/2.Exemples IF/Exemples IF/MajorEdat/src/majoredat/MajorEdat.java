package majoredat;

import java.util.Scanner;
public class MajorEdat {
 public static void main(String[] args) {
    //Decidir si una persona es major de edat.
    
    // Declaració de variables
    final int MAJOREDAT = 18;
    final int PENSIONISTA = 65;
    int edat;
    
    // Entrada de dades
    Scanner lector = new Scanner(System.in);
    System.out.print("Quina edat tens? ");
    edat = lector.nextInt();
    
    // Sentència IF
    if (edat >= PENSIONISTA) {
        System.out.println("Ets pensionista");
    }
    if (edat >= MAJOREDAT){
        System.out.println("Ets major d'edat");
    }
    if (edat < MAJOREDAT){
        System.out.println("Ets menor d'edat");
    }
 }
}

