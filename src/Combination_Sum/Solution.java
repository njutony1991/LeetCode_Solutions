package Combination_Sum;

/**
 * Created by tony on 15-2-8.
 */
import java.util.*;
public class Solution {
    void dfs(int[] candidates,int target,int index,LinkedList<Integer> line, LinkedList<List<Integer>> ans){
        if(target==0){
            ans.add(new LinkedList<Integer>(line));
            return;
        }
        if(target<candidates[index])
            return;
        for(int i=index;i<candidates.length;i++){
            line.addLast(candidates[i]);
            dfs(candidates,target-candidates[i],i,line,ans);
            line.removeLast();
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedList<List<Integer>> ans = new LinkedList<List<Integer>>();
        LinkedList<Integer> line = new LinkedList<Integer>();
        dfs(candidates,target,0,line,ans);
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] num = {1,1};
        List<List<Integer>> ans = sol.combinationSum(num,3);
        for(List<Integer> list : ans)
            System.out.println(list);
    }
}
