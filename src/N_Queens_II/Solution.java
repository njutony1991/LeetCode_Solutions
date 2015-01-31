package N_Queens_II;
import java.util.*;
public class Solution {

	int sum=0;
	protected void dfs(int row,List<Integer> cols,int n){
		if(row==n){
			sum++;
			return;
		}
		for(int i=0;i<n;i++){
			int flag = 0;
			for(int j=0;j<cols.size();j++)
				if(cols.get(j)==i||Math.abs(row-j)==Math.abs(i-cols.get(j)))
					flag=1;
			if(flag!=1){
				cols.add(i);
				dfs(row+1,cols,n);
				cols.remove(cols.size()-1);
			}
		}
	}
    public int totalNQueens(int n) {
	       sum = 0;
	       List<Integer> cols = new LinkedList<Integer>();
	       dfs(0,cols,n);
	       return sum;
	}
    
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.totalNQueens(1));

	}

}
