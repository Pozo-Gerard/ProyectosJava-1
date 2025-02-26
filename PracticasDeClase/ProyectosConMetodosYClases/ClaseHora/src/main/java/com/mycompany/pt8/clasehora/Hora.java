/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pt8.clasehora;

/**
 *
 * @author Gerard Pozo i Eric Serrano
 * 
 *         En aquesta Clase esta tots els parametres i lógica del objecte Hora
 * 
 */
public class Hora {
    private int hora;
    private int minut;
    private int segon;

    /**
     *
     * @param hora
     * @param minut
     * @param segon
     */

    // Construim el constructor del objecte
    public Hora(int hora, int minut, int segon) {
        this.hora = hora;
        this.minut = minut;
        this.segon = segon;
    }

    // Setters
    void setHora(int hora) {
        final byte HORA_MINIMA = 0;
        final byte HORA_MAXIMA = 23;
        if (hora >= HORA_MINIMA && hora <= HORA_MAXIMA) {
            this.hora = hora;
        }
    }

    void setMinut(int minut) {
        final byte MINUT_MINIM = 0;
        final byte MINUT_MAXIM = 59;
        if (minut >= MINUT_MINIM && minut <= MINUT_MAXIM) {
            this.minut = minut;
        }
    }

    void setSegon(int segon) {
        final byte SEGON_MINIM = 0;
        final byte SEGON_MAXIM = 59;
        if (segon >= SEGON_MINIM && segon <= SEGON_MAXIM) {
            this.segon = segon;
        }
    }

    // Getters
    int getHora() {
        return hora;
    }
    
    int getMinut() {
        return minut;
    }

    int getSegon() {
        return segon;
    }

    // Incrementa un segon, comprovant que no sigui més gran de 59
    void incrementarSegon() {
        final byte SEGON_MAXIM = 59;
        this.segon++;
        if (this.segon > SEGON_MAXIM) {
            // Si es més gran trucarem al metode per a que sumi 1 i el reiniciem
            incrementarMinut();
            this.segon = 0;
        }
    }

    // Incrementa un minut, comprovant que no sigui més gran de 59
    void incrementarMinut() {
        final byte MINUT_MAXIM = 59;
        this.minut++;
        if (this.minut > MINUT_MAXIM) {
            // Si es més gran trucarem al metode per a que sumi 1 i el reiniciem
            incrementarHora();
            this.minut = 0;
        }
    }

    // Metode sobrecargat, recibeix un parametre que indica cuants minuts vol sumar
    // a l'hora
    void incrementarMinut(int minuts) {
        for (int i = 0; i < minuts; i++) {
            // Trucarem al metode la quantitat de cops que es vulgui
            incrementarMinut();
        }
    }

    // Incrementem una hora, comprovant que no sigui més gran de 23
    void incrementarHora() {
        final byte HORA_MAXIMA = 23;
        this.hora++;
        if (this.hora > HORA_MAXIMA) {
            // Si es més gran el reiniciem
            this.hora = 0;
        }
    }

    // Metode per mostrar l'hora
    void mostrar() {
        System.out.println("L'hora es: " + hora + ":" + minut + ":" + segon);
    }

    // Metode per comprovar si els parametres de dos objectes son iguals
    boolean iguals(Hora altreHores) {
        return this.hora == altreHores.hora && this.minut == altreHores.minut && this.segon == altreHores.segon;
    }

}
