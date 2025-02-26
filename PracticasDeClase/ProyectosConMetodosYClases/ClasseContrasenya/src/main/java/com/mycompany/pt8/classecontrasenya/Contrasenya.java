/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pt8.classecontrasenya;

/**
 * Clase per crear l'objecte Contrasenya, permet generar contrasenyes
 * aleatoriament podent assignar una longitud o deixarla per defecte.
 * 
 * Disposa d'un metode per comprovar si la contrasenya és o no és forta.
 * 
 * @author Gerard Pozo i Eric Serrano
 */
public class Contrasenya {
    private int longitud = 8;
    private String contrasenya = "";

    /**
     * Constructor:
     * Asigna automaticament una contrasenya aleatoria.
     */
    public Contrasenya() {
        generarContrasenya();
    }

    /**
     * Constructor:
     * Demana la quantitat de caracters que ha de tenir la contrasenya.
     * Asigna automaticament una contrasenya aleatoria.
     * 
     * @param longitud Caracters totals per contrasenya
     */
    public Contrasenya(int longitud) {
        this.longitud = longitud;
        generarContrasenya();
    }

    /**
     * @param longitud
     */
    public void setlongitud(int longitud) {
        this.longitud = longitud;
    }

    /**
     * @return longitud
     */
    public int getLongitud() {
        return longitud;
    }

    /**
     * @param longitud
     */
    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    /**
     * @return contrasenya
     */
    public String getContrasenya() {
        return contrasenya;
    }

    /**
     * Comprova que la contrasenya sigui forta.
     * Condicions: 2 majúscules, 1 minuscula, 3 nombres.
     * 
     * @return
     */
    public boolean esFort() {
        // Minim 2 majúscules, 1 minuscula i 3 nombres -> 2 + 1 + 3 = 6
        final int MINIM_MAYUSCULES = 2;
        final int MINIM_MINUSCULES = 1;
        final int MINIM_NOMBRES = 3;
        final int MINIM_PER_SER_SEGUR = MINIM_MAYUSCULES + MINIM_MINUSCULES + MINIM_NOMBRES;

        final String CARACTERS_NOMBRES = "0123456789";
        final String CARACTERS_MAYUSCULES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String CARACTERS_MINUSCULA = "abcdefghijklmnopqrstuvwxyz";

        int comptadorNombres;
        int comptadorMayuscules;
        int comptadorMinuscules;

        if (longitud < MINIM_PER_SER_SEGUR) {
            // Si d'entrada no compleix amb la quantitat minima de caracter que té que tenir
            // per ser segur no fa falta comprovar rés més, tornem directament false
            return false;
        } else {
            // Comptem cuants caracters hi ha de cada tipus
            comptadorNombres = comptarCaracters(CARACTERS_NOMBRES);
            comptadorMayuscules = comptarCaracters(CARACTERS_MAYUSCULES);
            comptadorMinuscules = comptarCaracters(CARACTERS_MINUSCULA);
        }
        // Tornem si es compleix o no la condició
        return comptadorMayuscules >= MINIM_MAYUSCULES && comptadorMinuscules >= MINIM_MINUSCULES
                && comptadorNombres >= MINIM_NOMBRES;
    }

    // Metode que només utilitzarem dins de la clase per comptar els caracters de la
    // contrasenya
    private int comptarCaracters(String caracters) {
        int comptador = 0;
        for (int i = 0; i < longitud; i++) {
            char lletraContrasenya = contrasenya.charAt(i);
            for (int j = 0; j < caracters.length(); j++) {
                char lletraCaracters = caracters.charAt(j);
                if (lletraContrasenya == lletraCaracters) {
                    comptador++;
                }
            }
        }
        return comptador;
    }

    /**
     * Genera una contrasenya aleatoriament d'entre una cadena donada.
     */
    public void generarContrasenya() {
        // Tots els caracters que pot tenir la contrasenya
        final String CARACTERS_PERMESOS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        // Asignem els caracters a la contrasenya
        for (int i = 0; i < longitud; i++) {
            // Generem un nombre aleatori
            int nombreAleatori = (int) (Math.random() * (CARACTERS_PERMESOS.length()));
            // Asignem un caracter
            char caracter = CARACTERS_PERMESOS.charAt(nombreAleatori);
            // Guardem el caracter en la contrasenya
            contrasenya += caracter;
        }
    }
}
