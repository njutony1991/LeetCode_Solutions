package Sudoku_Solver;
import java.util.*;
public class Solution {
	class Node{
		int i=-1;
		int j=-1;
		Node(int i,int j){
			this.i = i;
			this.j = j;
		}
	}
	
	boolean flag = false;
	private boolean isOk(Node node,int num,char[][] board){
		int flag1 = 0,flag2=0,flag3=0;
		for(int j=0;j<9;j++){
			if(board[node.i][j]==(char)('0'+num))
				flag1 = 1;
		}
		for(int j=0;j<9;j++){
			if(board[j][node.j]==(char)('0'+num))
				flag2 = 1;
		}
		
		int line = node.i/3;
		int col = node.j/3;
		for(int j=3*line;j<3*line+3;j++)
			for(int k=3*col;k<3*col+3;k++){
				if(board[j][k]==(char)('0'+num))
					flag3 = 1;
			}
		
		return flag1==0&&flag2==0&&flag3==0;
	}
	
	private void dfs(int index,LinkedList<Node> empty,char[][] board){
		if(index==empty.size()){
			flag = true;
			return;
		}
		
		for(int k=1;k<=9;k++){
			Node slot = empty.get(index);
			if(isOk(slot,k,board)){
				board[slot.i][slot.j]=(char)('0'+k);
				index++;
				dfs(index,empty,board);
				if(flag==true)
					return;
				index--;
				board[slot.i][slot.j]='.';
				
			}
		}
	}
	
    public void solveSudoku(char[][] board) {
    	LinkedList<Node> empty = new LinkedList<Node>();
        for(int i=0;i<board.length;i++)
        	for(int j=0;j<board[0].length;j++){
        		if(board[i][j]=='.')
        			empty.add(new Node(i,j));
        }
        flag = false;
        dfs(0,empty,board);
    }
    
	public static void main(String[] args) {
		char[][] puzzle = new char[][]{{'5','3','.','.','7','.','.','.','.'},
									   {'6','.','.','1','9','5','.','.','.'},
									   {'.','9','8','.','.','.','.','6','.'},
									   {'8','.','.','.','6','.','.','.','3'},
									   {'4','.','.','8','.','3','.','.','1'},
									   {'7','.','.','.','2','.','.','.','6'},
									   {'.','6','.','.','.','.','2','8','.'},
									   {'.','.','.','4','1','9','.','.','5'},
									   {'.','.','.','.','8','.','.','7','9'}};
		
		Solution sol = new Solution();
		sol.solveSudoku(puzzle);
		for(int i=0;i<puzzle.length;i++){
			for(int j=0;j<puzzle[0].length;j++)
				System.out.print(puzzle[i][j]+" ");
			System.out.println("");
		}
	}
}
