package com.oscarmoreno.sinkthefleet;

import java.util.Random;

public class Board {
    public static final int BOARD_SIZE = 10;
    char sea = '·';
    char water = '-';
    char ship = 'O';
    String unknown = "   ";
    char hit = 'X';
    String[] targetCoordinates = new String[2];
    int targetXCoordinates;
    int targetYCoordinates;
    String shootXCoordinates;
    String shootYCoordinates;
    int maxScoreBoard = 20;


    char [][] shipsBoard = new char [BOARD_SIZE][BOARD_SIZE];
    String [][] sideBoard = {
            {"1","2","3","4","5","6","7","8","9","10"},
            {"A","B","C","D","E","F","G","H","I","J","K"}
    };

    Random r = new Random();

    void initializeBoard() {
        for (int i = 0; i < maxScoreBoard; i++) {
            int x = r.nextInt(10);
            int y = r.nextInt(10);
            shipsBoard[x][y] = ship;
        }
        for (int x = 0; x < BOARD_SIZE ; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                if (shipsBoard[x][y] != ship ) {
                    shipsBoard[x][y] = sea;
                }
            }
        }
    }

    public void drawBoardHeader() {
        System.out.print("   ");
        for (int x = 0; x < BOARD_SIZE ; x++) {
            System.out.print(sideBoard[0][x] + "  ");
        }
        System.out.println();
    }

    void drawBoard() {
        drawBoardHeader();
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print(sideBoard[1][i] + "  ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(shipsBoard[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    void drawUnknownBoard() {
        char [][]unknownShipsBoard = shipsBoard;
        drawBoardHeader();
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print(sideBoard[1][i] + "  ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (unknownShipsBoard[i][j] == hit || unknownShipsBoard[i][j] == water) {
                    System.out.print(unknownShipsBoard[i][j] + "  ");
                } else {
                    System.out.print(unknown);
                }
            }
            System.out.println();
        }
        System.out.println("\n");

    }

    void checkShoot(String targetShoot) {
        targetCoordinates = targetShoot.split("-");
        shootXCoordinates = targetCoordinates[0];
        shootYCoordinates = targetCoordinates[1];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (shootXCoordinates.equals(sideBoard[i][j])) {
                    targetXCoordinates = j;
                }
                if (shootYCoordinates.equals(sideBoard[i][j])) {
                    targetYCoordinates = j;
                }
            }
        }
        if (this.shipsBoard[targetXCoordinates][targetYCoordinates] == '·') {
            System.out.println("Water!");
            this.shipsBoard[targetXCoordinates][targetYCoordinates] = water;
        }
        if (this.shipsBoard[targetXCoordinates][targetYCoordinates] == 'O') {
            System.out.println("Hit!");
            this.shipsBoard[targetXCoordinates][targetYCoordinates] = hit;
            this.setScoreBoard();
        }
    }

    public int getScoreBoard() {
        return maxScoreBoard;
    }

    public void setScoreBoard() {
        this.maxScoreBoard = maxScoreBoard - 1;
    }
}
