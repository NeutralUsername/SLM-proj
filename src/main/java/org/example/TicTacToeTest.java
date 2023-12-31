package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    @Test
    void switchCurrentPlayer() {
        TicTacToe game = new TicTacToe();
        Player player1 = game.getCurrentPlayer();
        game.switchCurrentPlayer();
        Player player2 = game.getCurrentPlayer();
        assertNotEquals(player1, player2);
    }

    @Test
    void hasWinner() {
        TicTacToe game = new TicTacToe();
        assertFalse(game.hasWinner());
        game.getBoard().place(0, 0, 'X');
        assertFalse(game.hasWinner());
        game.getBoard().place(1, 1, 'X');
        assertFalse(game.hasWinner());
        game.getBoard().place(2, 2, 'X');
        assertTrue(game.hasWinner());
    }
}