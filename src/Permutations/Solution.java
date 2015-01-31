package Permutations;
import java.util.*;
public class Solution {
	void dfs(int[] num,int len,LinkedList<Integer> list,LinkedList<List<Integer>> ans,int[] used){
		if(len==num.length){
			ans.add(new LinkedList<Integer>(list));
			return;
		}
		for(int i=0;i<num.length;i++){
			if(used[i]==0){
				list.add(num[i]);
				used[i]=1;
				dfs(num,len+1,list,ans,used);
				used[i]=0;
				list.remove(list.size()-1);
			}
		}
	}
    public List<List<Integer>> permute(int[] num) {
        LinkedList<List<Integer>> ans = new LinkedList<List<Integer>>();
        LinkedList<Integer> list = new LinkedList<Integer>();
        int[] used = new int[num.length];
        dfs(num,0,list,ans,used);
        return ans;
    }
    
 //   public static void main(String[] args){
 //  	List<List<Integer>> ans = new Solution().permute(new int[]{1,2,3});
 //   	System.out.println(ans);
  //  }
}