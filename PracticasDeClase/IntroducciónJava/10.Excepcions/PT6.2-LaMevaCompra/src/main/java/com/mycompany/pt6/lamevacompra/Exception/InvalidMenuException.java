/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pt6.lamevacompra.Exception;

/**
 *
 * @author Gerard Pozo i Eric Serrano
 * 
 *         Clase creada per l'excepció personalitzada creada
 */
public class InvalidMenuException extends Exception {
    // Creem el metode
    public InvalidMenuException(String message) {
        // Amb super accedim a la clase pare i guarda el missatge que posem en la clase
        // principal
        super(message);
    }
}
