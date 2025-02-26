/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pt10.empresesdetransport;

/**
 * Clase Caixa.
 * 
 * Conté constructors per fer una caixa i per aconseguir el volum de la caixa.
 * Les caixes poden contenir etiquetes descriptives i tenen que tenir una unitat
 * de mesura.
 * 
 * Si no entren dades es posarán totes per defecte.
 * Si no entra una etiqueta es posará una etiqueta per defecte.
 * Si les dades que entren estàn en valor negatiu es posarán els valors per
 * defectes.
 * Si l'unitat que entra no està controlada o no es posa una unitat es posará
 * una unitat per defecte.
 *
 * @author Gerard Pozo i Eric Serrano
 */
public class Caixa {
    // Constants
    /**
     * Unitat de mesura per defecte de les caixes
     */
    protected final static String UNITAT_PER_DEFECTE = "cm";
    /**
     * Ample que tindrà una caixa per defecte
     */
    protected static final int AMPLE_PER_DEFECTE = 10;
    /**
     * Altura que tindrà una caixa per defecte
     */
    protected static final int ALT_PER_DEFECTE = 10;
    /**
     * Fons que tindrà una caixa per defecte
     */
    protected static final int FONS_PER_DEFECTE = 10;
    /**
     * L'etiqueta per defecte que tindràn les caixes
     */
    protected static final String ETIQUETA_PER_DEFECTE = "";
    /**
     * El máxim de caracters permesos de les etiquetes
     */
    private final int MAXIM_CARACTERS_ETIQUETA = 30;
    /**
     * Unitats de mesura permeses per les caixes
     */
    private final String[] UNITATS_PERMESES = { "cm", "m" };

    // Parametres
    /**
     * Amplitud de la caixa
     */
    protected double ample;
    /**
     * Alt de la caixa
     */
    protected double alt;
    /**
     * Fons de la caixa
     */
    protected double fons;
    /**
     * Etiqueta de la caixa
     */
    protected String etiqueta;
    /**
     * Unitat de mesura de la caixa
     */
    protected String unitat;

    /**
     * Constructor Caixa per defecte
     */
    public Caixa() {
        this(AMPLE_PER_DEFECTE, ALT_PER_DEFECTE, FONS_PER_DEFECTE, ETIQUETA_PER_DEFECTE, UNITAT_PER_DEFECTE);
    }

    /**
     * Constructor Caixa
     * 
     * @param ample Amplitud de la Caixa
     * @param alt Alt de la Caixa
     * @param fons Fons de la Caixa
     */
    public Caixa(double ample, double alt, double fons) {
        this(ample, alt, fons, ETIQUETA_PER_DEFECTE, UNITAT_PER_DEFECTE);
    }

    /**
     * Constructor Caixa
     * 
     * @param ample Amplitud de la Caixa
     * @param alt Alt de la Caixa
     * @param fons Fons de la Caixa
     * @param etiqueta Etiqueta descriptiva de la Caixa
     */
    public Caixa(double ample, double alt, double fons, String etiqueta) {
        this(ample, alt, fons, etiqueta, UNITAT_PER_DEFECTE);
    }

    /**
     * Constructor caixa, si insereix un valor negatiu es posará en el valor per
     * defecte.
     * 
     * Si es introdueix una etiqueta més gran del permés només s'agafaran els
     * primers valors permesos.
     * 
     * @param ample Amplitud de la Caixa
     * @param alt Alt de la Caixa
     * @param fons Fons de la Caixa
     * @param etiqueta Etiqueta descriptiva de la Caixa
     * @param unitat Unitat de mesura de la Caixa
     */
    public Caixa(double ample, double alt, double fons, String etiqueta, String unitat) {
        this.ample = (ample >= 0) ? ample : AMPLE_PER_DEFECTE;
        this.alt = (alt >= 0) ? alt : ALT_PER_DEFECTE;
        this.fons = (fons >= 0) ? fons : FONS_PER_DEFECTE;
        this.setEtiqueta(etiqueta);

        // Comprovem que l'unitat introduïda sigui una de les unitats permeses,
        // qualsevol dada diferent assignara l'unitat per defecte
        for (String unitats : UNITATS_PERMESES) {
            if (unitat.equals(unitats)) {
                this.unitat = unitats;
                // Sortim del bucle
                break;
            } else {
                this.unitat = UNITAT_PER_DEFECTE;
            }
        }
    }

    /**
     * Retorna el volumen de la caixa
     * 
     * @return ample * alt * fons
     */
    public double getVolum() {
        double volum = (unitat.equalsIgnoreCase("m")) ? (this.ample * this.alt * this.fons) * 1000
                : this.ample * this.alt * this.fons;
        return volum;
    }

    /**
     * Dona una etiqueta a la caixa
     * Si la longitud de la etiqueta pasa del maxim només agafa els caracters fins
     * el limit
     * 
     * @param etiqueta Donem una etiqueta a la Caixa
     */
    public void setEtiqueta(String etiqueta) {
        // Comprovem que l'etiqueta estigui dins dels limits permesos, si no, només
        // agafem la quantitat máxima permesa
        this.etiqueta = (etiqueta.length() <= MAXIM_CARACTERS_ETIQUETA) ? etiqueta
                : etiqueta.substring(0, MAXIM_CARACTERS_ETIQUETA);
    }

    /**
     * Retorna l'ample de la caixa
     * 
     * @return ample
     */
    public double getAmple() {
        return ample;
    }

    /**
     * Retorna l'alt de la caixa
     * 
     * @return alt
     */
    public double getAlt() {
        return alt;
    }

    /**
     * Retorna el fons de la caixa
     * 
     * @return fons
     */
    public double getFons() {
        return fons;
    }

    /**
     * Retorna l'etiqueta de la caixa
     * 
     * @return etiqueta
     */
    public String getEtiqueta() {
        return etiqueta;
    }

    /**
     * Retorna l'unitat de la caixa
     * 
     * @return unitat
     */
    public String getUnitat() {
        return unitat;
    }

    /**
     * Retorna totes les dades de la caixa
     * 
     * @return Ample, alt, fons, volum, etiqueta, unitat
     */
    @Override
    public String toString() {
        return "\nCaixa"
                + "\nAmple: " + ample
                + "\nAlt: " + alt
                + "\nFons: " + fons
                + "\nVolum: " + getVolum() + " cm3"
                + "\nEtiqueta: " + etiqueta
                + "\nUnitat: " + unitat;
    }
}
