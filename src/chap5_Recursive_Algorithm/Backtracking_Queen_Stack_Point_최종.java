package chap5_Recursive_Algorithm;

import java.util.Scanner;

public class Backtracking_Queen_Stack_Point_최종 {
    static final int numberQueens = 8;
    static Scanner sc = new Scanner(System.in);

    public static void SolveQueen(int[][] d, int row) {
        if (row == numberQueens) {
            printSolution(d);
            return;
        }

        for (int col = 0; col < numberQueens; col++) {
            if (checkMove(d, row, col)) {
                d[row][col] = 1;
                SolveQueen(d, row + 1);
                d[row][col] = 0;
            }
        }
    }

    public static boolean checkRow(int[][] d, int crow) {
        for (int j = 0; j < numberQueens; j++) {
            if (d[crow][j] == 1)
                return false;
        }
        return true;
    }

    public static boolean checkCol(int[][] d, int ccol) {
        for (int j = 0; j < numberQueens; j++) {
            if (d[j][ccol] == 1)
                return false;
        }
        return true;
    }

    public static boolean checkDiagSW(int[][] d, int x, int y) {
        int cx = x, cy = y;
        while (cx >= 0 && cx < numberQueens && cy >= 0 && cy < numberQueens) {
            if (d[cx][cy] == 1)
                return false;
            cx++;
            cy--;
        }

        cx = x;
        cy = y;
        while (cx >= 0 && cx < numberQueens && cy >= 0 && cy < numberQueens) {
            if (d[cx][cy] == 1)
                return false;
            cx--;
            cy++;
        }
        return true;
    }

    public static boolean checkDiagSE(int[][] d, int x, int y) {
        int cx = x, cy = y;
        while (cx >= 0 && cx < numberQueens && cy >= 0 && cy < numberQueens) {
            if (d[cx][cy] == 1)
                return false;
            cx++;
            cy++;
        }

        cx = x;
        cy = y;
        while (cx >= 0 && cx < numberQueens && cy >= 0 && cy < numberQueens) {
            if (d[cx][cy] == 1)
                return false;
            cx--;
            cy--;
        }
        return true;
    }

    public static boolean checkMove(int[][] d, int x, int y) {
        return checkRow(d, x) && checkCol(d, y) && checkDiagSW(d, x, y) && checkDiagSE(d, x, y);
    }

    public static void printSolution(int[][] d) {
        for (int i = 0; i < numberQueens; i++) {
            for (int j = 0; j < numberQueens; j++) {
                System.out.print((d[i][j] == 1 ? "Q" : "-") + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] data = new int[numberQueens][numberQueens];
        for (int i = 0; i < numberQueens; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] = 0;
            }
        }

        SolveQueen(data, 0);
    }
}