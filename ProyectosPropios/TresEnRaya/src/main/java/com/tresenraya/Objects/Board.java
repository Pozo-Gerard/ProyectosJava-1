package com.tresenraya.Objects;

import java.util.Arrays;

/**
 * Permite crear el objeto Board, un tablero.
 *
 * Permite llenar el tablero, interactuar con él añadiendo simbolos. Cuando el
 * tablero está lleno o hay 3 simbolos consecutivos formando una linea se puede
 * dar un ganador.
 *
 * @author Gerard Pozo
 */
public class Board {

    // Constants
    /**
     * El simbolo por defecto que tendrá cada casilla del tablero
     */
    private static final String DEFAULT_SYMBOL = "|   |";

    // Variables
    /**
     * Tablero
     */
    private String[][] board;

    /**
     * Simbolo para colocar en el tablero
     */
    private String symbol;

    /**
     * Constructor
     *
     * Inicializa el tablero con 3 espacios
     */
    public Board() {
        this.board = new String[3][3];
        fillBoard();
    }

    /**
     * Devuelve el tablero
     *
     * @return board
     */
    public String[][] getBoard() {
        return board;
    }

    /**
     * Devuelve el simbolo
     *
     * @return symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Cambia el valor del simbolo
     *
     * @param symbol Pide el simbolo
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Rellena el tablero de "| |"
     */
    public void fillBoard() {
        for (String[] row : board) {
            Arrays.fill(row, DEFAULT_SYMBOL);
        }
    }

    /**
     * Imprime todo el tablero por terminal
     */
    public void showBoard() {
        for (String[] row : board) {
            System.out.println(String.join("", row));
        }
    }

    /**
     * Se asegura de que en la casilla seleccionada se pueda poner un simbolo,
     * es decir que no esté ocupada por otro simbolo
     *
     * @param movement Pide a que casilla se va a mover
     * @return true,false Si se puede o no se puede marcar la casilla
     */
    public boolean isCanCheckBox(int movement) {
        boolean canCheckBox = false;
        // Se asume que el tablero tiene 3 de ancho y tiene 3 filas
        final byte FIRST_ROW = 3, SECOND_ROW = 6, THIRST_ROW = 9;
        int row;
        // Restamos 1 porque el indice empieza en 0, pero para el usuario el indice
        // empieza
        // en 1
        int square;

        if (movement <= FIRST_ROW) {
            // Si el usuario introduce menos de 3, internamente para el programa se está
            // refiriendo a la primera fila, con indice 0
            row = 0;
            square = movement - 1;
        } else if (movement > FIRST_ROW && movement <= SECOND_ROW) {
            row = 1;
            square = movement - 4;
        } else {
            row = 2;
            square = movement - 7;
        }

        // Si la casilla que el usuari ha seleccionado está vacía se procede a poner el
        // simbolo en la casilla
        if (board[row][square] == DEFAULT_SYMBOL) {
            checkBox(row, square);
            canCheckBox = true;
            return canCheckBox;
        }
        return canCheckBox;
    }

    /**
     * Ponemos en una casilla del tablero un simbolo
     *
     * @param row Pide una fila
     * @param square Pide una columna
     */
    private void checkBox(int row, int square) {
        board[row][square] = symbol;
    }

    /**
     * Devuelve si en el tablero ya no quedan casillas sin llenar
     *
     * @return true o false. Si el tablero está completo
     */
    private boolean isBoardFull() {
        boolean isFull = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == DEFAULT_SYMBOL) {
                    return isFull;
                }
            }
        }
        isFull = true;
        return isFull;
    }

    /**
     * Devuelve si alguna fila, columna o diagonal tienen el mismo simbolo
     *
     * @param symbol
     * @return true o false, si hay un ganador
     */
    private boolean hasWinner() {
        // Verificar columnas y filas
        for (int i = 0; i < board.length; i++) {
            if (board[i][0].equals(symbol) && board[i][1].equals(symbol) && board[i][2].equals(symbol)) {
                return true; // Fila completa
            }
            if (board[0][i].equals(symbol) && board[1][i].equals(symbol) && board[2][i].equals(symbol)) {
                return true; // Columna completa
            }
        }

        // Verifica diagonales
        if (board[0][0].equals(symbol) && board[1][1].equals(symbol) && board[2][2].equals(symbol)) {
            return true; // Diagonal principal
        }
        if (board[0][2].equals(symbol) && board[1][1].equals(symbol) && board[2][0].equals(symbol)) {
            return true; // Diagonal secundaria
        }

        return false; // No hay ganador
    }

    /**
     * Devolverá true o false si tenemos un ganador o si el tablero está
     * completo
     *
     * @return true, false, si el tablero está lleno o hay un ganador
     */
    public boolean hasWinnerOrBoardFull() {
        return hasWinner() || isBoardFull();
    }
}
