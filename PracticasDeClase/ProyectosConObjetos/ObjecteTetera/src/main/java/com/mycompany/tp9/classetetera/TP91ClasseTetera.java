/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tp9.classetetera;

/**
 * Prova de la clase tetera.
 * 
 * @author Gerard Pozo i Marc Stalker
 */
public class TP91ClasseTetera {

    public static void main(String[] args) {
        // Creem els objectes
        Tetera t1 = new Tetera();
        Tetera t2 = new Tetera(1500);
        Tetera t3 = new Tetera(3000, 33505);

        // Mostrem tots els objectes
        System.out.println("Mostrem els objectes");
        System.out.println("------------------------");
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println("------------------------");

        // Omplim les teteres
        System.out.println("Omplim les teteres.");
        System.out.println("------------------------");
        t1.omplirTetera();
        t2.omplirTetera();
        t3.omplirTetera();
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println("------------------------");

        // Servim tasses
        System.out.println("Servir tasses");
        System.out.println("------------------------");
        t1.servirTassa(200);
        t2.servirTassa(-2);
        t3.servirTassa(20000);
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println("------------------------");

        // Buidem teteres
        System.out.println("Buidar teteres");
        System.out.println("------------------------");
        t1.buidarTetera();
        t2.buidarTetera();
        t3.buidarTetera();
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println("------------------------");

        // Agregar te
        System.out.println("Afegim te");
        System.out.println("------------------------");
        t1.agregarTe(30000);
        t2.agregarTe(30);
        t3.agregarTe(-2);
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println("------------------------");
    }
}
