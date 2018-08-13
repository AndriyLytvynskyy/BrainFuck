package com.study.interviewbit;

/**
 * Imagine a robot sitting on the upper left comer of an X by Y grid. The robot can only
 * move in two directions: right and down. How many possible paths are there for the
 * robot to go from (0, 0) to (X, Y) ?
 * FOLLOW UP
 * Imagine certain spots are "off limits," such that the robot cannot step on them.
 * Design an algorithm to find a path for the robot from the top left to the bottom right.
 */

public class RobotSitting {
    class RobotPos{
        int x;
        int y;

        public RobotPos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int possibleWays(int a, int b){
        if(a==0 || b==0) return 0;
        if(a==1 || b==1) return 1;

        int[][] board = new int[a][b];

        //left column
        for(int i=0; i<a; i++){
            board[i][0] = 1;
        }

        //top row
        for(int j=0; j<b; j++){
            board[0][j] = 1;
        }

        //fill up the dp table
        for(int i=1; i<a; i++){
            for(int j=1; j<b; j++){
                board[i][j] = board[i-1][j] + board[i][j-1];
            }
        }

        return board[a-1][b-1];
    }

    public static void main(String[] args) {
            possibleWays(2,2);
    }
}
