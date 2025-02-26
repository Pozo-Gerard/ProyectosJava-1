package com.tresenraya.Objects;

/**
 * Permite crear el objeto Player, que contiene un contador de partidas ganadas
 * 
 * @author Gerard Pozo
 */
public class Player {
    /**
     * El simbolo que tendrá el jugador
     */
    private char simbol;
    /**
     * Las partidas que ha ganado el jugador
     */
    private int wonGames;

    /**
     * Constructor
     * 
     * Construye el objeto jugador
     * 
     * @param simbol simbolo del jugador
     */
    public Player(char simbol) {
        this.simbol = simbol;
    }

    /**
     * Coloca un simbolo al jugador
     * 
     * @param simbol simbolo del jugador
     */
    void setSimbol(char simbol) {
        this.simbol = simbol;
    }

    /**
     * Devuelve el simbolo del jugador
     * 
     * @return simbolo del jugador
     */
    public char getSimbol() {
        return simbol;
    }

    /**
     * Coloca la cantidad de partidas ganadas del jugador
     * 
     * @param wonGames partidas ganadas
     */
    void setWonGames(int wonGames) {
        this.wonGames = wonGames;
    }
    
    /**
     * Devuelve la cantidad de juegos ganados por el jugador
     * 
     * @return partidas ganadas
     */
    public int getWonGames() {
        return wonGames;
    }

    /**
     * Suma 1 a las partidas ganas del jugador
     */
    public void sumWonGames() {
        this.wonGames++;
    }
}
