package Combination_Sum_II;

/**
 * Created by tony on 15-2-8.
 */
import java.util.*;
public class Solution {

    void dfs(int[] num,int target,int index,LinkedList<Integer> line,LinkedList<List<Integer>> ans){
        if(target==0){
            ans.add(new LinkedList<Integer>(line));
            return;
        }

        for(int i=index;i<num.length;i++){
                if(target<num[i])
                    return;
                if(i!=0&&num[i]==num[i-1]&&index<i)
                    continue;
                line.addLast(num[i]);
                dfs(num, target - num[i], i+1, line, ans);
                line.removeLast();
        }
    }

    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        LinkedList<List<Integer>> ans = new LinkedList<List<Integer>>();
        LinkedList<Integer> line = new LinkedList<Integer>();
        dfs(num,target,0,line,ans);
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] num = {1,1};
        System.out.println(sol.combinationSum2(num,2));
    }
}
