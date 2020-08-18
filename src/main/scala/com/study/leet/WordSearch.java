package com.study.leet;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * <p>
 * https://www.youtube.com/watch?v=vYYNp0Jrdv0
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (exist(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param board board
     * @param i     row
     * @param j     column
     * @param count count of chars that we've found
     * @param word  word we are searching
     * @return
     */
    public boolean dfs(char[][] board, int i, int j, int count, String word) {
        if (count == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(count)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = ' ';

        boolean found = dfs(board, i + 1, j, count + 1, word)
                     || dfs(board, i - 1, j, count + 1, word)
                     || dfs(board, i, j + 1, count + 1, word)
                     || dfs(board, i, j - 1, count + 1, word);
        board[i][j] = temp;
        return found;
    }

    private boolean exist(char[][] board, int i, int j, String word, int ind){
        if(ind == word.length()) return true;
        if(i > board.length-1 || i <0 || j<0 || j >board[0].length-1 || board[i][j]!=word.charAt(ind))
            return false;
        board[i][j]='*';
        boolean result =    exist(board, i-1, j, word, ind+1) ||
                exist(board, i, j-1, word, ind+1) ||
                exist(board, i, j+1, word, ind+1) ||
                exist(board, i+1, j, word, ind+1);
        board[i][j] = word.charAt(ind);
        return result;
    }

    public static void main(String[] args) {

    }

}
