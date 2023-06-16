/* The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other. 
For example, following is a solution for 4 Queen problem. 
The expected output is a true which has 1s for the blocks where queens are placed. 
For example, following is the matrix for above 4 queen solution
      { 0,  1,  0,  0}
      { 0,  0,  0,  1}
      { 1,  0,  0,  0}
      { 0,  0,  1,  0}
*/

import java.util.*;
public class Main{
	public static void main(String[] args){
		Solution obj = new Solution();
		System.out.println(obj.nQueen(4));
	}
}

class Solution{
	private int N;
	public boolean nQueen(int n){
		N=n;
		int[][] board = new int[N][N];
		return arrangeNQueens(board,0);
	}
	
	public boolean arrangeNQueens(int board[][],int row){
		if(row==N) return true;
		for(int i=0;i<N;i++){
			if(isSafe(board,row,i)){
				board[row][i] = 1;
				if(arrangeNQueens(board,row+1)){
					return true;
				}
				board[row][i] = 0;
			}
		}
		return false;
	}

	private boolean isSafe(int board[][],int row,int col){
		int i, j;
        for (i = 0; i < col; i++) if (board[row][i] == 1) return false;
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) if (board[i][j] == 1) return false;
        for (i = row, j = col; j >= 0 && i < N; i++, j--) if (board[i][j] == 1) return false;
        return true;
	}
}
