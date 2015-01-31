package N_Queens;
import java.util.*;
public class Solution {
	
	protected void dfs(int row,List<Integer> cols,List<List<Integer>> ans,int n){
		if(row==n){
			ans.add(new LinkedList<Integer>(cols));
			return;
		}
		for(int i=0;i<n;i++){
			int flag = 0;
			for(int j=0;j<cols.size();j++)
				if(cols.get(j)==i||Math.abs(row-j)==Math.abs(i-cols.get(j)))
					flag=1;
			if(flag!=1){
				cols.add(i);
				dfs(row+1,cols,ans,n);
				cols.remove(cols.size()-1);
			}
		}
	}
	
	public List<String[]> solveNQueens(int n) {
		List<Integer> cols = new LinkedList<Integer>();
		List<List<Integer>> ans = new LinkedList<List<Integer>>();
		List<String[]> maps = new LinkedList<String[]>();
		dfs(0,cols,ans,n);
		for(List<Integer> list :ans){
			String[] map = new String[list.size()];
			for(int i=0;i<list.size();i++){
				int temp = list.get(i);
				StringBuffer tempans = new StringBuffer();
				for(int j=0;j<temp;j++)
					tempans.append(".");
				tempans.append("Q");
				for(int j=temp+1;j<n;j++)
					tempans.append(".");
				map[i] = tempans.toString();
			}
			maps.add(map);
		}
		return maps; 
    }
	
	public static void main(String[] args){
		Solution sol = new Solution();
		List<String[]> ans = sol.solveNQueens(4);
		for(String[] str:ans){
			for(String line: str)
				System.out.println(line);
			System.out.println("-----------");
		}
	}
}
