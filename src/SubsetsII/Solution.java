package SubsetsII;
import java.util.*;
public class Solution {
	
	void dfs(int[] num,int len,HashSet<List<Integer>> ans,LinkedList<Integer> set){
		if(len==num.length){
		    ans.add(new LinkedList<Integer>(set));
			return;
		}
	    set.add(num[len]);
	    dfs(num,len+1,ans,set);
	    set.removeLast();
	    dfs(num,len+1,ans,set);
	}
	
	public List<List<Integer>> subsetsWithDup(int[] num) {
	    Arrays.sort(num);
	    HashSet<List<Integer>> ans = new HashSet<List<Integer>>();
	    LinkedList<Integer> set = new LinkedList<Integer>();
	    dfs(num,0,ans,set);
	    List<List<Integer>> fans = new LinkedList<List<Integer>>();
	    Iterator<List<Integer>>  iter = ans.iterator();
	    while(iter.hasNext()){
	    	fans.add(iter.next());
	    }
		return fans;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] num = {1,2,2};
	    List<List<Integer>> ans = sol.subsetsWithDup(num);
	    
	    for(List<Integer> l:ans){
	    	System.out.println(l);
	    }
	}
}
