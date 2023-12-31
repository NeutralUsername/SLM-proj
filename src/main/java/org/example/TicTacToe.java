package org.example;

import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Board getBoard() {
        return board;
    }

    public void start() {
        System.out.println("Welcome to Tic Tac Toe!");
        while(true) {
            System.out.println("current player: " + currentPlayer.getMarker());
            board.print();
            System.out.println("row (0-2): ");
            int row = -1;
            Scanner scanner = new Scanner(System.in);
            while (row < 0 || row > 2) {
                row = scanner.nextInt();
            }
            int col = -1;
            System.out.println("col (0-2): ");
            while (col < 0 || col > 2) {
                col = scanner.nextInt();
            }
            board.place(row, col, currentPlayer.getMarker());

            if (this.hasWinner()) {
                System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                break;
            }
            if (board.isFull()) {
                System.out.println("It's a tie!");
                break;
            }

            switchCurrentPlayer();
        }
    }

    public void switchCurrentPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public boolean hasWinner() {
        char topLeft = '\u0000';
        char topMiddle = '\u0000';
        char topRight = '\u0000';
        char middleLeft = '\u0000';
        char middleMiddle = '\u0000';
        char middleRight = '\u0000';
        char bottomLeft = '\u0000';
        char bottomMiddle = '\u0000';
        char bottomRight = '\u0000';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                switch (i) {
                    case 0:
                        switch (j) {
                            case 0:
                                topLeft = board.getCell(i, j);
                                break;
                            case 1:
                                topMiddle = board.getCell(i, j);
                                break;
                            case 2:
                                topRight = board.getCell(i, j);
                                if (topLeft == topMiddle && topMiddle == topRight && topRight != '\u0000')
                                    return true;
                                break;
                        }
                        break;
                    case 1:
                        switch (j) {
                            case 0:
                                middleLeft = board.getCell(i, j);
                                break;
                            case 1:
                                middleMiddle = board.getCell(i, j);
                                break;
                            case 2:
                                middleRight = board.getCell(i, j);
                                if (middleLeft == middleMiddle && middleMiddle == middleRight && middleRight != '\u0000')
                                    return true;
                                break;
                        }
                        break;
                    case 2:
                        switch(j){
                            case 0:
                                bottomLeft = board.getCell(i, j);
                                if (topLeft == middleLeft && middleLeft == bottomLeft && bottomLeft != '\u0000')
                                    return true;
                                if (topRight == middleMiddle && middleMiddle == bottomLeft && bottomLeft != '\u0000')
                                    return true;
                                break;
                            case 1:
                                bottomMiddle = board.getCell(i, j);
                                if (topMiddle == middleMiddle && middleMiddle == bottomMiddle && bottomMiddle != '\u0000')
                                    return true;
                                break;
                            case 2:
                                bottomRight = board.getCell(i, j);
                                if (topRight == middleRight && middleRight == bottomRight && bottomRight != '\u0000')
                                    return true;
                                if (topLeft == middleMiddle && middleMiddle == bottomRight && bottomRight != '\u0000')
                                    return true;
                                break;
                        }
                        break;
                }
            }
        }
        return false;
    }
}
