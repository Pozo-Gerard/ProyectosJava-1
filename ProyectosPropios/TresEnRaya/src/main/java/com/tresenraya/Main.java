package com.tresenraya;

import com.tresenraya.Objects.Board;
import com.tresenraya.Objects.Player;
import com.tresenraya.Tools.InputUtils;

/**
 * Juego del tres en raya.
 *
 * El tablero es el clasico 3x3, juegan 2 jugadores y no termina hasta que el
 * tablero se ha llenado por completo o uno de los jugadores ha marcado 3 filas
 * consecutivas con su simbolo.
 *
 * @author Administrator
 */
public class Main {

    public static void main(String[] args) {
        final byte FIRST_OPTION = 1, LAST_OPTION = 4;
        final byte PLAY_GAME = 1, INSTRUCTIONS = 2, RESULT_GAME = 3, EXIT = 4;

        // Crear jugadores
        Player playerOne = new Player('X');
        Player playerTwo = new Player('O');

        boolean isExecute = true;
        do {
            // Menu principal
            System.out.println("\n------------------");
            System.out.println("   Tres en raya");
            System.out.println("------------------");
            System.out.println("1) Empezar partida");
            System.out.println("2) Instrucciones");
            System.out.println("3) Ver el resultado de las partidas");
            System.out.println("4) Salir del programa");
            // El usuario escoge una opción
            System.out.print("\nIntroduce una de las opciones: ");
            int userOption = InputUtils.readRealNumberKeyboard(FIRST_OPTION, LAST_OPTION);

            switch (userOption) {
                case PLAY_GAME -> {
                    final byte FIRST_OPTION_PLAY = 1, LAST_OPTION_PLAY = 2;
                    final byte HUMAN_OPPONENT = 1;
                    /*
                        * El jugador 1 empieza con X, el jugador 2 empieza con O
                     */

                    // Crear tablero
                    Board board = new Board();
                    // Establecemos los turnos de los jugadores
                    int turnPlayer = 1;
                    // Para saber de que simbolo es el turno
                    String turnSymbol;

                    while (!board.hasWinnerOrBoardFull()) {
                        // Definimos la primera y última casilla
                        final byte FIRST_SQUARE = 1, LAST_SQUARE = 9;

                        // Mostramos el tablero
                        board.showBoard();

                        // Sumamos el turno del jugador, para cambiar el simbolo del siguiente turno
                        turnPlayer++;

                        // Establecemos a que simbolo le toca
                        turnSymbol = (turnPlayer % 2 == 0) ? "| X |" : "| O |";
                        board.setSymbol(turnSymbol);

                        // Pedimos una casilla para marcar
                        System.out.print("\nQue lugar quieres marcar?: ");
                        int userMovement = InputUtils.readRealNumberKeyboard(FIRST_SQUARE, LAST_SQUARE);

                        // Marcamos la casilla
                        if (!board.isCanCheckBox(userMovement)) {
                            turnPlayer--;
                        }
                    }
                    // Mostramos por última vez el tablero
                    board.showBoard();

                    // Le damos un punto al jugador que haya ganado, por lógica habrá ganado el que
                    // tenga el último turno
                    if (turnPlayer % 2 == 0) {
                        System.out.println("Ha ganado X");
                        playerOne.sumWonGames();
                    } else {
                        System.out.println("Ha ganado O");
                        playerTwo.sumWonGames();
                    }
                }
                case INSTRUCTIONS -> {
                    System.out.println("\n------------------");
                    System.out.println("  Instrucciones");
                    System.out.println("------------------");
                    System.out.println("El juego consiste en un tablero de 3x3, donde los jugadores se turnan para marcar una casilla.");
                    System.out.println("El jugador que consiga marcar 3 casillas en línea, ya sea horizontal, vertical o diagonal, gana la partida.");
                    System.out.println("Si el tablero se llena y no hay un ganador, la partida se declara empate.");
                }
                case RESULT_GAME -> {
                    System.out.println("Partidas ganas jugador X");
                    System.out.println(playerOne.getWonGames());
                    System.out.println("Partidas ganas jugador O");
                    System.out.println(playerTwo.getWonGames());
                }
                case EXIT -> {
                    isExecute = false;
                }
            }
        } while (isExecute);
    }
}
