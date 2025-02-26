/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pt3.pkg2.estructuresdecontrol;

import java.util.Scanner;

//Importem la biblioteca Math, especificament la clase que anem a utilitzar
import static java.lang.Math.pow;

/**
 * Aquet programa demana dos nombres al usuari i després dona una serie
 * d'opcions per escollir que fer amb aquestos nombres, també dona l'opció de
 * tornar a introduïr les dades quan es selecciona l'opció de sortir del
 * programa.
 *
 * @author Gerard i Eloy
 */
public class PT32EstructuresDeControl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Creem la variable Scanner
        Scanner sc = new Scanner(System.in);
        //Aquesta variable manté en funcionament el primer do-while
        boolean operarUnAltreCop = false;

        //Imprimeix mínim un cop el que té i després comprova si la variable "operarUnAltreCop" es true
        do {
            //Demanem al usuari que introdueixi dos nombres i els guardem en dos variables
            System.out.print("Introdueix un nombre: ");
            double primerNombre = sc.nextDouble();
            System.out.print("Introdueix un altre nombre: ");
            double segonNombre = sc.nextDouble();

            //Aquesta variable manté en funcionament el segon do-while
            boolean sortirDelPrograma = false;
            //Imprimeix mínim un cop el que té dins i després comprova si la variable "sortirDelPrograma" es false per no sortir del programa
            do {
                //Imprimim el menu principal i declarem les variables per representar de forma més intuitiva quina opció es cadascuna
                System.out.println("\n-----------------------");
                System.out.println("Selecciona una opció");
                System.out.println("-----------------------");
                System.out.println("1) Calcular la mitjana");
                System.out.println("2) Calcular la potencia");
                System.out.println("3) Entrar un altre numero i es mostrara ordenat");
                System.out.println("4) Sortir");
                final byte CALCULAR_LA_MITJANA = 1;
                final byte CALCULAR_LA_POTENCIA = 2;
                final byte ENTRAR_UN_ALTRE_NOMBRE = 3;
                final byte SORTIR = 4;

                //Comprobar qué vol fer l'usuari
                int eleccioUsuari = sc.nextInt();
                switch (eleccioUsuari) {
                    //Si l'usuari vol calcular la mitjana (Opció 1)
                    case CALCULAR_LA_MITJANA -> {
                        //La formula per treura la mitjana
                        double resultat = (primerNombre / segonNombre) / 2;
                        System.out.println("La mitjana entre " + primerNombre + " i " + segonNombre + " es: " + resultat);
                    }
                    //Si l'usuari vol calcular la potencia (Opció 2)
                    case CALCULAR_LA_POTENCIA -> {
                        //Utilitzem la llibreria Math i la clase pow per elevar a la potencia el primer nombre amb el segon nombre
                        double resultat = Math.pow(primerNombre, segonNombre);
                        System.out.println(primerNombre + " elevat a " + segonNombre + " es: " + resultat);
                    }
                    //Si l'usuari vol ordenar tres nombres (Opció 3)
                    case ENTRAR_UN_ALTRE_NOMBRE -> {
                        //Demanem al usuari un nou nombre
                        System.out.print("Introdueix un tercer nombre: ");
                        double tercerNombre = sc.nextDouble();
                        //Comprobem que numero es més gran i petit que altre o igual
                        if (primerNombre < segonNombre && segonNombre < tercerNombre) {
                            System.out.println(primerNombre + " < " + segonNombre + " < " + tercerNombre);
                        } else if (segonNombre < primerNombre && primerNombre < tercerNombre) {
                            System.out.println(segonNombre + " < " + primerNombre + " < " + tercerNombre);
                        } else if (primerNombre < segonNombre && tercerNombre < primerNombre) {
                            System.out.println(tercerNombre + " < " + primerNombre + " < " + segonNombre);
                        } else if (primerNombre < tercerNombre && tercerNombre < segonNombre) {
                            System.out.println(primerNombre + " < " + tercerNombre + " < " + segonNombre);
                        } else if (segonNombre < tercerNombre && tercerNombre < primerNombre) {
                            System.out.println(segonNombre + " < " + tercerNombre + " < " + primerNombre);
                        } else if (tercerNombre < segonNombre && segonNombre < primerNombre) {
                            System.out.println(tercerNombre + " < " + segonNombre + " < " + primerNombre);
                        } else if (primerNombre == segonNombre && segonNombre < tercerNombre) {
                            System.out.println(primerNombre + " = " + segonNombre + " < " + tercerNombre);
                        } else if (primerNombre == tercerNombre && tercerNombre < segonNombre) {
                            System.out.println(primerNombre + " = " + tercerNombre + " < " + segonNombre);
                        } else if (segonNombre == tercerNombre && tercerNombre < primerNombre) {
                            System.out.println(segonNombre + " = " + tercerNombre + " < " + primerNombre);
                        } else if (segonNombre == tercerNombre && primerNombre < tercerNombre) {
                            System.out.println(primerNombre + " < " + segonNombre + " = " + tercerNombre);
                        } else if (primerNombre == tercerNombre && segonNombre < tercerNombre) {
                            System.out.println(segonNombre + " < " + primerNombre + " = " + tercerNombre);
                        } else if (primerNombre == segonNombre && tercerNombre < segonNombre) {
                            System.out.println(tercerNombre + " < " + primerNombre + " = " + segonNombre);
                        } else {
                            System.out.println(primerNombre + " = " + segonNombre + " = " + tercerNombre);
                        }
                    }
                    //Si el usuari vol sortir del programa o canviar els nombres (Opció 4)
                    case SORTIR -> {
                        //Variable per si l'usuari introdueix un nombre no contemplat, 1 o 2
                        boolean nombreIntroduitIncorrecta = false;
                        //Es repetira si la nombreIntroduitIncorrecta es true
                        do {
                            //Preguntem al usuari quina opció vol escollir
                            System.out.println("Que vols fer?");
                            System.out.println("1) Operar amb altres nombres");
                            System.out.println("2) Sortir definitivament");
                            final byte OPERAR_AMB_ALTRES_NOMBRES = 1;
                            final byte SORTIR_DEFINITIVAMENT = 2;
                            //Guardem l'elecció del usuari en una variable
                            eleccioUsuari = sc.nextInt();

                            switch (eleccioUsuari) {
                                //Si el usuari vol canviar els nombres (Opció 1)
                                case OPERAR_AMB_ALTRES_NOMBRES -> {
                                    nombreIntroduitIncorrecta = false;
                                    operarUnAltreCop = true;
                                    sortirDelPrograma = true;
                                }
                                //Si el usuari vol sortir del programa (Opció 2)
                                case SORTIR_DEFINITIVAMENT -> {
                                    System.out.println("Has sortit del programa.");
                                    nombreIntroduitIncorrecta = false;
                                    sortirDelPrograma = true;
                                    operarUnAltreCop = false;
                                }
                                //Si el usuari no introdueix cap nombre válid
                                default -> {
                                    System.out.println("Has introduit un nombre no valid.\n");
                                    nombreIntroduitIncorrecta = true;
                                }
                            }
                        } while (nombreIntroduitIncorrecta);
                    }
                    //Si el usuari no introdueix cap nombre válid
                    default ->
                        System.out.println("Has introduït una dada incorrecta.");
                }
                //Comprovem que la variable sigui false, si es true sortirà del segon do-while
            } while (!sortirDelPrograma);
            //Comprovem que la variable sigui true, si es false sortirà del primer do-while i acabara el programa
        } while (operarUnAltreCop);
    }
}
