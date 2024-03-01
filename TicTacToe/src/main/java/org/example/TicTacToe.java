package org.example;

import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    public static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("-----");
            }
        }
    }

    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    public static int minimax(char player) {
        if (checkWin('O')) {
            return 1;
        } else if (checkWin('X')) {
            return -1;
        } else if (isBoardFull()) {
            return 0;
        }

        if (player == 'O') {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = 'O';
                        int score = minimax('X');
                        board[i][j] = ' ';
                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = 'X';
                        int score = minimax('O');
                        board[i][j] = ' ';
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
    }

    public static void makeMove(char player) {
        int bestScore = Integer.MIN_VALUE;
        int bestMoveX = -1;
        int bestMoveY = -1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = 'O';
                    int score = minimax('X');
                    if (score > bestScore) {
                        bestScore = score;
                        bestMoveX = i;
                        bestMoveY = j;
                    }
                    board[i][j] = ' ';
                }
            }
        }

        board[bestMoveX][bestMoveY] = 'O';
        System.out.println("Computer's move: ");
        printBoard();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char currentPlayer = 'X';
        printBoard();

        while (true) {
            if (currentPlayer == 'X') {
                System.out.println("Player's move (row,column): ");
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                if (board[row][col] == ' ') {
                    board[row][col] = 'X';
                    printBoard();
                    if (checkWin('X')) {
                        System.out.println("Player wins!");
                        break;
                    }
                    if (isBoardFull()) {
                        System.out.println("It's a draw!");
                        break;
                    }
                    currentPlayer = 'O';
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            } else {
                makeMove(currentPlayer);
                if (checkWin('O')) {
                    System.out.println("Computer wins!");
                    break;
                }
                if (isBoardFull()) {
                    System.out.println("It's a draw!");
                    break;
                }
                currentPlayer = 'X';
            }
        }

        scanner.close();
    }
}