package org.example;

public class Board {
    private char[][] cells;

    public Board() {
        cells = new char[3][3];
    }

    public boolean isEmptyCell(int x, int y) {
        if (cells.length < x || cells[x].length < y) {
            return false;
        }
        return cells[x][y] == '\u0000';
    }

    public void place(int x, int y, char marker) {
        cells[x][y] = marker;
    }

    public char getCell(int x, int y) {
        return cells[x][y];
    }

    public boolean isFull() {
        for (char[] row : cells) {
            for (char cell : row) {
                if (cell == '\u0000') {
                    return false;
                }
            }
        }
        return true;
    }

    public void clear() {
        for (char[] row : cells) {
            for (char cell : row) {
                cell = '\u0000';
            }
        }
    }

    public void print() {
        System.out.println("▁▁▁▁▁▁");
        for (char []row : cells) {
            for (int i = 0; i < row.length; i++) {
                System.out.print("|");
                if (row[i] == '\u0000')
                    System.out.print(" ");
                else
                    System.out.print(row[i]);
            }
            System.out.println("|");
        }
        System.out.println("▔▔▔▔");
    }

}
