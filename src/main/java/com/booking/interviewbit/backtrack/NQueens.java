package com.booking.interviewbit.backtrack;

import java.util.ArrayList;

public class NQueens {
    public static ArrayList<ArrayList<Integer>> solveNQueens(int a) {
        ArrayList<ArrayList<Integer>> results1 = new ArrayList<ArrayList<Integer>>();
        ArrayList<int[]> results = new ArrayList<int[]>();

        placeQueens(a, 0, new int[a], results);
        printSolution(results, a);
        return results1;
    }

    public static void placeQueens(int a, int row, int[] columns, ArrayList<int[]> results) {
        if (row == a) {
            results.add(columns.clone());
            return;
        } else {
            for (int col = 0; col < a; col++) {
                if (checkValid(columns, row, col)) {
                    columns[row] = col;
                    placeQueens(a, row + 1, columns, results);
                }
            }
        }
    }

    private static boolean canPlace(int row, int col, int[] solution) {
        for (int prevRow = 0; prevRow < row; ++prevRow) {
            if (col == solution[prevRow]) return false;
            if (row - prevRow == Math.abs(col - solution[prevRow])) return false;
        }
        return true;
    }



    static boolean checkValid(int[] columns, int row1, int column1) {
        for (int rowsBelow = 0; rowsBelow < row1; rowsBelow++) {
            int column2 = columns[rowsBelow];
            if (column1 == column2) {
                return false;
            }

            int columnDistance = Math.abs(column2 - column1);
            int rowDistance = row1 - rowsBelow;
            if (columnDistance == rowDistance) {
                return false;
            }
        }
        return true;
    }

    private static void printSolution1(ArrayList<int[]> solutions) {

            for (int[] solution : solutions) {
                for (int i : solution) System.out.print(i + " ");
                System.out.println();
            }

    }

    private static ArrayList<ArrayList<String>> printSolution(ArrayList<int[]> solutions, int a) {
        ArrayList<ArrayList<String>> results = new ArrayList<>();
        for (int[] solution : solutions) {
            ArrayList<String> list = new ArrayList<>();
            for (int i : solution) {
                StringBuilder res = new StringBuilder();
                for (int j = 0; j < a; j++) {
                    if (i != j) {
                        res.append(".");
                    } else {
                        res.append("Q");                    }
                }

                list.add(res.toString());
            }
            results.add(list);
        }
        return results;
    }

    public static void main(String[] args) {
        solveNQueens(4);
    }
}
