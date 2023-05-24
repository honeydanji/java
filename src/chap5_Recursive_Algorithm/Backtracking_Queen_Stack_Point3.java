package chap5_Recursive_Algorithm;

import java.awt.Point;
import java.util.Arrays;
import java.util.Stack;

public class Backtracking_Queen_Stack_Point3 {
    static final int numberQueens = 8;

    public static void solveQueen(int[][] data) {
        Stack<Point> stack = new Stack<>();
        int count = 0;

        int col = 0;
        while (count < numberQueens) {
            int row = 0;
            while (row < numberQueens) {
                if (check(data, row, col)) {
                    data[row][col] = 1;
                    stack.push(new Point(row, col));
                    System.out.println("push : " + stack.push(new Point(row, col)));
                    count++;
                    col++;
                    break;
                }
                row++;

                if (row == numberQueens) {
                    if (!stack.isEmpty()) {
                        Point point = stack.pop();
                        System.out.println(point);
                        row = point.x;
                        col = point.y;
                        data[row][col] = 0;
                        count--;
                        col++;
                    } else {
                        return;
                    }
                }
            }

            if (col == numberQueens) {
                for (int i = 0; i < numberQueens; i++) {
                    for (int j = 0; j < numberQueens; j++) {
                        System.out.print(" " + data[i][j]);
                    }
                    System.out.println();
                }
                return;
            }
        }
    }

    public static boolean check(int[][] data, int row, int col) {
        for (int i = 0; i < numberQueens; i++) {
            if (data[row][i] == 1 || data[i][col] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (data[i][j] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i < numberQueens && j >= 0; i++, j--) {
            if (data[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] data = new int[numberQueens][numberQueens];
        for (int i = 0; i < numberQueens; i++) {
            Arrays.fill(data[i], 0);
        }

        solveQueen(data);
    }
}