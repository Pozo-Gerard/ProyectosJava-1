/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pt10.empresesdetransport;

/**
 * Sub clase Caixa Carto, hereda de la clase Caixa.
 * 
 * Conté constructors per construir caixes de carto.
 * Es pot treure la superficie i volum real d'una caixa.
 *
 * @author Gerard Pozo i Eric Serrano
 */
public class CaixaCartro extends Caixa {
    // Constants
    /**
     * El volumen real de la caixa, per evitar que es deformi
     */
    private final double VOLUM_REAL_CAIXA = 0.8;

    /**
     * Constructor Caixa Cartro per defecte
     */
    public CaixaCartro() {
        this(AMPLE_PER_DEFECTE, ALT_PER_DEFECTE, FONS_PER_DEFECTE);
    }

    /**
     * Constructor Caixa Cartro
     * 
     * @param ample Amplitud de la Caixa
     * @param alt Alt de la Caixa
     * @param fons Fons de la Caixa
     */
    public CaixaCartro(double ample, double alt, double fons) {
        this(ample, alt, fons, ETIQUETA_PER_DEFECTE);
    }

    /**
     * Constructor Caixa
     * 
     * @param ample Amplitud de la Caixa
     * @param alt Alt de la Caixa
     * @param fons Fons de la Caixa
     * @param etiqueta Etiqueta descriptiva de la Caixa
     */
    public CaixaCartro(double ample, double alt, double fons, String etiqueta) {
        super(ample, alt, fons, etiqueta, UNITAT_PER_DEFECTE);
    }

    /**
     * Retorna la superficie de la caixa en cm cuadrats
     * 
     * @return 2*fons*ample + 2*fons*alt + 2*ample*alt
     */
    public double getSuperficie() {
        return (2 * this.fons * this.ample) + (2 * this.fons * this.alt) + (2 * this.ample * this.alt);
    }

    /**
     * Retorna el volum real de la caixa
     * 
     * @return (ample * alt * fons) * volumRealCaixa
     */
    @Override
    public double getVolum() {
        // Es multiplica per el volum real de les caixes, per evitar que es deformin
        return (this.ample * this.alt * this.fons) * VOLUM_REAL_CAIXA;
    }

    /**
     * Retorna totes les dades de la caixa
     * 
     * @return Ample, alt, fons, volum, superficie, etiqueta, unitat
     */
    @Override
    public String toString() {
        return "\nCaixa Cartro"
                + "\nAmple: " + ample
                + "\nAlt: " + alt
                + "\nFons: " + fons
                + "\nVolum: " + getVolum() + " cm3"
                + "\nSuperficie: " + getSuperficie() + " cm2"
                + "\nEtiqueta: " + etiqueta
                + "\nUnitat: " + unitat;
    }

}
