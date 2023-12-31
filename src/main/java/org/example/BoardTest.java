package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void getCell() {
        Board board = new Board();
        assertEquals('\u0000', board.getCell(0, 0));
        assertEquals('\u0000', board.getCell(1, 1));
        assertEquals('\u0000', board.getCell(2, 2));
        assertEquals('\u0000', board.getCell(0, 2));
    }

    @Test
    void place() {
        Board board = new Board();
        board.place(0, 0, 'X');
        assertEquals('X', board.getCell(0, 0));

        board.place(1, 1, 'O');
        assertEquals('O', board.getCell(1, 1));

        board.place(2, 2, 'X');
        assertEquals('X', board.getCell(2, 2));

        board.place(0, 2, 'O');
        assertEquals('O', board.getCell(0, 2));
    }

    @Test
    void isFull() {
        Board board = new Board();
        assertFalse(board.isFull());

        board.place(0, 0, 'X');
        assertFalse(board.isFull());

        board.place(1, 1, 'O');
        assertFalse(board.isFull());

        board.place(2, 2, 'X');
        assertFalse(board.isFull());

        board.place(0, 2, 'O');
        assertFalse(board.isFull());

        board.place(0, 1, 'X');
        assertFalse(board.isFull());

        board.place(1, 0, 'O');
        assertFalse(board.isFull());

        board.place(1, 2, 'X');
        assertFalse(board.isFull());

        board.place(2, 0, 'O');
        assertFalse(board.isFull());

        board.place(2, 1, 'X');
        assertTrue(board.isFull());
    }
}