package Subsets;
import java.util.*;
public class Solution {

	public void dfs(int[]S,int len,LinkedList<Integer> set,LinkedList<List<Integer>> ans){
		if(len == S.length){
			ans.add(new LinkedList<Integer>(set));
			return;
		}
		set.add(S[len]);
		dfs(S,len+1,set,ans);
		set.removeLast();
		dfs(S,len+1,set,ans);
	}
    public List<List<Integer>> subsets(int[] S) {
	    Arrays.sort(S);
    	LinkedList<List<Integer>> ans = new LinkedList<List<Integer>>();
    	LinkedList<Integer> set = new LinkedList<Integer>();
    	dfs(S,0,set,ans);
    	return ans;
    }
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] num = {1,2,3};
		List<List<Integer>> ans = sol.subsets(num);
		for(List<Integer> l : ans)
			System.out.println(l);
	}

}
