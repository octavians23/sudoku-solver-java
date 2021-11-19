package com.company;

public class Main {

    //simple grid to be solved, stored in a 2D array
    public static int[][] GRID_TO_SOLVE = {
            {7,0,9,0,8,0,5,0,2},
            {0,0,0,0,0,0,0,0,4},
            {8,0,0,6,0,0,0,0,0},
            {0,0,0,0,0,0,0,7,0},
            {0,1,0,0,0,3,0,0,0},
            {0,0,2,0,6,0,9,0,8},
            {0,0,0,0,5,0,0,4,0},
            {0,0,7,0,0,0,0,6,0},
            {0,2,0,1,0,0,7,0,5},
    };

    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku(GRID_TO_SOLVE);
        if(sudoku.solve()){
            System.out.println("The solved sudoku is: ");
            sudoku.display();
        } else {
            System.out.println("Unsolvable");
        }
    }
}
