/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.pt2.rotonda;

import java.util.Scanner;

/**
 * Aquet programa començará en la senyal de cediu el pas abans d'una rotona i
 * presenta diverses situacions i et pregunta que vols fer.
 *
 * @author Gerard i Iban
 */
public class PT22Rotonda {

    public static void main(String[] args) {

        //Declarem i inicialitzem les variables que utilitzarem
        Scanner sc = new Scanner(System.in);
        final byte PARAR_COTXE = 1;
        final byte NO_PARAR_EL_COTXE = 2;
        final byte SORTIR_ROTONDA = 1;
        final byte CONTINUAR_EN_LA_ROTONDA = 2;
        final byte ENTRAR_ROTONDA = 1;
        final byte ANARTE_CORRENT = 1;
        final byte FER_EL_PART = 2;
        final byte ESPERAR_EN_LA_ROTONDA = 2;
        boolean estasEnElCeda = true;
        boolean estasEnLaRotonda = false;
        boolean hasXocat = false;

        //Presentem al usuari la situació i li demanem introduïr una opció
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println("Estas conduïnt i has arribat a un cediu el pas abans d'una rotonda i hi ha un cotxe aproant-se.");
        System.out.println("Que vols fer?");
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println("1) Respectar el cedir el pas parant el cotxe.");
        System.out.println("2) Continuar sense parar el cotxe.");
        int eleccioUsuari = sc.nextInt();

        //Valorem la dada introduida per el usuari
        switch (eleccioUsuari) {

            //En el cas que es decideixi parar el cotxe, la primera opció
            case PARAR_COTXE:
                System.out.println("\nHas parat el cotxe.");

                //Mentre estiguis en el ceda et sortira la mateixa pregunta fins que entris en la rotonda
                while (estasEnElCeda) {
                    System.out.println("Ara no s'está apropant cap cotxe.");
                    System.out.println("Que vols fer?");
                    System.out.println("1) Entrar en la rotonda.");
                    System.out.println("2) Esperar");
                    eleccioUsuari = sc.nextInt();

                    //Fem un switch anidat per valorar la decisió del usuari
                    switch (eleccioUsuari) {

                        //En el cas que es decideixi entrar en la rotonda, la primera opció
                        case ENTRAR_ROTONDA:
                            
                            //El boolean de estasEnElCeda es false perque ja no estas en el ceda, estas en la rotonda
                            estasEnElCeda = false;
                            estasEnLaRotonda = true;
                            System.out.println("\nHas entrar en la rotonda.");

                            //Mentre estiguis en la rotonda et sortira la mateixa pregunta, fins que surtis
                            while (estasEnLaRotonda) {
                                System.out.println("Tens una sortida.");
                                System.out.println("Que vols fer?");
                                System.out.println("1) Sortir de la rotonda.");
                                System.out.println("2) Continuar en la rotonda");
                                eleccioUsuari = sc.nextInt();

                                //Anidem un switch per la nova decisió del usuari
                                switch (eleccioUsuari) {

                                    //Quan el usuari decideix sortir de la rotonda
                                    case SORTIR_ROTONDA:
                                        System.out.println("\nHas sortit de la rotonda.");
                                        estasEnLaRotonda = false;
                                        break;

                                    //Quan el usuari decideix continuar en la rotonda
                                    case CONTINUAR_EN_LA_ROTONDA:
                                        System.out.println("\nHas decidit continuar en la rotonda.");
                                        break;

                                    //Si el usuari no introdueix 1 o 2
                                    default:
                                        System.out.println("Has introduït una dada incorrecta, torna a provar.");
                                        break;
                                }
                            }

                            //Per a que no s'executi el case ESPERAR
                            break;

                        //Si el usuari decideix esperar i no entrar en la rotonda
                        case ESPERAR_EN_LA_ROTONDA:
                            System.out.println("\nHas decidit esperar.");
                            break;

                        //Si el usuari no introdueix 1 o 2
                        default:
                            System.out.println("Has introduït una dada incorrecta, torna a provar.");
                            break;
                    }
                }

                //Per a que no s'executi el case NO_PARAR_EL_COTXE
                break;

            //Si el usuari decideix continuar la marxa
            case NO_PARAR_EL_COTXE:
                hasXocat = true;
                System.out.println("\nHas decidit continuar la marxa.");

                //Si has entrar has xocat
                while (hasXocat) {
                    System.out.println("T'has xocat amb el cotxe.");
                    System.out.println("Un senyor calb es baixa del cotxe molt enfadat amb tú i et comença a cridar.");
                    System.out.println("- Pero que fas boig, no has vist la senyal de cedir el pas!?\n");
                    System.out.println("En aquest moment pensas en dos alternatives.");
                    System.out.println("1) Anar-te corrent.");
                    System.out.println("2) Ser bon ciutada i omplir un full de parts.");
                    eleccioUsuari = sc.nextInt();

                    //Valorem la eleccio del usuari
                    switch (eleccioUsuari) {

                        //Si el usuari decideix anar-se corrent, opció 1
                        case ANARTE_CORRENT:
                            System.out.println("Has rebut una denuncia, et veuras amb el calb en el jutjat.");
                            hasXocat = false;
                            break;

                        //Si el usuari decideix omplir el full de parts, opció 2
                        case FER_EL_PART:
                            System.out.println("Has omplert el full de parts i el segur s'ocupará del asumpte.");
                            hasXocat = false;
                            break;

                        //Si el usuari no introdueix 1 o 2
                        default:
                            System.out.println("Has introduït una dada incorrecta, torna a provar.");
                            break;
                    }
                }

                //Per a que no s'executi el default
                break;
            
            //Si el usuari no introdueix una dada valida
            default:
                System.out.println(eleccioUsuari);
                System.out.println("Has introduït un valor no valid.");
                break;
        }
    }
}
