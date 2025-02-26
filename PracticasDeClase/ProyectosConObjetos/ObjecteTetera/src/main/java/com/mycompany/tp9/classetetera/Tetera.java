/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp9.classetetera;

/**
 * Clase Tetera, amb métodes per omplir, buidar i servir te.
 * 
 * @author Gerard Pozo i Mark Stalker
 */
public class Tetera {
    // Constants
    /**
     * La quantitat de ml que té per defecte la tetera
     */
    private final static int CAPACITAT_MAXIMA_PREDETERMINADA = 1000;

    /**
     * La tetera vuida té 0ml
     */
    private final static int TETERA_BUIDA = 0;

    // Atributs
    /**
     * La capacitat máxima de ml la tetera
     */
    private int capacitatMaxima;

    /**
     * La quantitat de ml que tenim en la tetera
     */
    private int liquidTotal;

    /**
     * Constructor sense parametres
     */
    public Tetera() {
        this(CAPACITAT_MAXIMA_PREDETERMINADA, TETERA_BUIDA);
    }

    /**
     * Constructor amb la capacitat máxima de la tetera
     * 
     * @param capacitatMaxima tetera
     */
    public Tetera(int capacitatMaxima) {
        this(capacitatMaxima, capacitatMaxima);
    }

    /**
     * Constructor amb la capacitat máxima i la quantitat actual de te
     * 
     * @param capacitatMaxima
     * @param liquidTotal
     */
    public Tetera(int capacitatMaxima, int liquidTotal) {
        /*
         * Comprovem que la capacitat maxima de la tetera ni sigui menor a la capacitat
         * que té la tetera quan està buida.
         * 
         * Si es compleix, la capacitat de la tetera és la predeterminada, si no,
         * es queda amb l'introduida per l'usuari.
         */
        this.capacitatMaxima = (capacitatMaxima < TETERA_BUIDA) ? CAPACITAT_MAXIMA_PREDETERMINADA : capacitatMaxima;

        /*
         * Comprova que el liquid introduit per l'usuari no pasa dels limits del que té
         * que tenir la tetera o que sigui més petit que la tetera quan esà buida.
         * 
         * Si es compleix, el liquid que hi ha en la tetera serà la capacitat máxima de la tetera, si no, es queda amb el que ha introduit l'usuari.
         */
        this.liquidTotal = (liquidTotal > capacitatMaxima || liquidTotal < TETERA_BUIDA) ? this.capacitatMaxima
                : liquidTotal;
    }

    /**
     * Torna la capacitat maxima de la tetera
     * 
     * @return capacitatMaxima
     */
    public int getCapacitatMaxima() {
        return capacitatMaxima;
    }

    /**
     * Modifica la capacitat maxima de la tetera
     * 
     * @param capacitatMaxima
     */
    public void setCapacitatMaxima(int capacitatMaxima) {
        this.capacitatMaxima = capacitatMaxima;
    }

    /**
     * Torna la quantitat de ml de te que tenim en la tetera
     * 
     * @return capacitatActual
     */
    public int getLiquidTotal() {
        return liquidTotal;
    }

    /**
     * Modifica la quantitat de liquid que hi ha a la tetera
     * 
     * @param liquidTotal
     */
    public void setLiquidTotal(int liquidTotal) {
        this.liquidTotal = liquidTotal;
    }

    /**
     * Ompla la tetera al máxim que pot
     */
    public void omplirTetera() {
        this.liquidTotal = capacitatMaxima;
    }

    /**
     * Resta la quantitat de liquid que es vol servir de la tetera
     * 
     * @param quantitatServir
     */
    public void servirTassa(int quantitatServir) {
        // Comprovem que la quantitat que es vol servir sigui més gran o igual al valor
        // de si la tetera està vuida
        if (quantitatServir >= TETERA_BUIDA) {
            if (liquidTotal < quantitatServir) {
                this.liquidTotal -= liquidTotal;
                if (liquidTotal < quantitatServir) {
                    this.liquidTotal -= liquidTotal;
                } else {
                    this.liquidTotal -= quantitatServir;
                    this.liquidTotal -= quantitatServir;
                }
            }
        }
    }

    /**
     * Torna la capacitatActual en 0
     */
    public void buidarTetera() {
        this.liquidTotal = TETERA_BUIDA;
    }

    /**
     * Afegeix una quantitat de te, sense passarse de la capacitat
     * maxima
     * 
     * @param quantitatAfegir
     */
    public void agregarTe(int quantitatAfegir) {
        // Comprovem que la quantitat que es vol servir sigui més gran o igual al valor
        // de si la tetera està vuida
        if (quantitatAfegir >= TETERA_BUIDA) {
            if ((liquidTotal + quantitatAfegir) > capacitatMaxima) {
                this.liquidTotal = capacitatMaxima;
                if ((liquidTotal + quantitatAfegir) > capacitatMaxima) {
                    this.liquidTotal = capacitatMaxima;
                } else {
                    this.liquidTotal += quantitatAfegir;
                    this.liquidTotal += quantitatAfegir;
                }
            }
        }

    }

    /**
     * Torna l'informació del objecte directament
     * 
     * @return tota l'informació del objecte
     */
    @Override
    public String toString() {
        return "Capacitat máxima: " + capacitatMaxima + "ml\n" +
                "Liquid en la tetera: " + liquidTotal + "ml\n";
    }
}
