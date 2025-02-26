/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pt10.empresesdetransport;

/**
 * Proves per provar el funcionament de les clases Caixa i Caixa Carto.
 * 
 * @author Gerard Pozo i Eric Serrano
 */
public class PT101EmpresesDeTransport {

    public static void main(String[] args) {
        // Proves amb caixa
        // Caixa per defecte
        Caixa c1 = new Caixa();
        System.out.println(c1);
        // Afegim una etiqueta, provem que només agafi els primers 30 caracters
        c1.setEtiqueta("Caixa de llet Caixa de llet Caixa de llet Caixa de llet Caixa de llet");
        System.out.println(c1);

        // Caixa amb alt, fons, i ample
        Caixa c2 = new Caixa(-20, -30, 15);
        System.out.println(c2);

        // Caixa amb alt, fons, ample i etiqueta
        Caixa c3 = new Caixa(34.3, 23, 12, "Caixa amb Auriculars");
        System.out.println(c3);

        // Caixa amb alt, fons, ample, etiqueta i unitat
        Caixa c4 = new Caixa(23.5, 19, 23.4, "Caixa de boligrafs", "m");
        System.out.println(c4);


        // Proves amb caixa de cartro
        // Caixa de cartro per defecte
        CaixaCartro cc1 = new CaixaCartro();
        System.out.println(cc1);

        // Caixa de cartro amb alt, fons i ample
        CaixaCartro cc2 = new CaixaCartro(20, 30, -15);
        System.out.println(cc2);

        // Caixa de cartro amb alt, fons, ample i etiqueta
        CaixaCartro cc3 = new CaixaCartro(12.4, 9, 8, "Caixa de cartro amb sardines Caixa de cartro amb sardines");
        System.out.println(cc3);
    }
}
