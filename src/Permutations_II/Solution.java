package Permutations_II;
import java.util.*;
public class Solution {
	void dfs(int[] num,int len,LinkedList<Integer> list,LinkedList<List<Integer>>ans,int[] used){
		if(len==num.length){
			ans.add(new LinkedList<Integer>(list));
			return;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0;i<num.length;i++){
			if(used[i]==0){
				if(set.contains(num[i]))
					continue;
				set.add(num[i]);
				used[i]=1;
				list.add(num[i]);
				dfs(num,len+1,list,ans,used);
				list.remove(list.size()-1);
				used[i]=0;
			}
		}
	}
    public List<List<Integer>> permuteUnique(int[] num) {
        LinkedList<List<Integer>> ans = new LinkedList<List<Integer>>();
        LinkedList<Integer> list = new LinkedList<Integer>();
        int[] used = new int[num.length];
        dfs(num,0,list,ans,used);
        return ans;
    }
    
    public static void main(String[] args){
    	List<List<Integer>> ans = new Solution().permuteUnique(new int[]{1,2,1});
    	System.out.println(ans);
    }
}