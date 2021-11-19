package com.company;

public class Sudoku {

    private int [][]board;
    private static final int EMPTY = 0;
    private static final int SIZE = 9; //max row and column for the grid

    public Sudoku(int[][] b){
        this.board = new int[SIZE][SIZE];

        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                this.board[i][j] = b[i][j];
            }
        }
    }

    //we check if a possible number is already in a row
    private boolean isInRow(int row, int number){
        for(int i = 0; i < SIZE; i++)
            if(board[row][i] == number)
                return true;


        return false;
    }

    //we check if a possible number is already in a column
    private boolean isInColumn(int column, int number){
        for(int i = 0; i < SIZE; i++)
            if(board[i][column] == number)
                return true;


        return false;
    }

    //check if a number is in a 3x3 square
    private boolean isInBox(int row, int column, int number){
        int r = row - row % 3;
        int c = column - column % 3;

        for(int i = r; i < r + 3; i++)
            for(int j = c; j < c + 3;j++)
                if(board[i][j] == number)
                    return true;



        return false;
    }

    //method to check if a number is a possible for a row, column
    private boolean isOk(int row, int column, int number){
        return !isInRow(row,number) && !isInColumn(column,number) && !isInBox(row,column,number);
    }

    //solve method, using backtracking
    public boolean solve() {
        for(int row = 0; row < SIZE; row++){
            for(int column = 0; column < SIZE; column++){
                //search for an empty cell
                if(board[row][column] == EMPTY){
                    for(int number = 1; number <= SIZE; number++){
                        if(isOk(row, column, number)){
                            board[row][column] = number;

                            //we start backtracking
                            if(solve()){
                                return true;
                            } else {
                                board[row][column] = EMPTY;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void display(){
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                System.out.print(" " + board[i][j]);
            }
            System.out.println();
        }
    }

}
