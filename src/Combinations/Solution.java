package Combinations;

import java.util.*;

/**
 * Created by tony on 15-2-9.
 */
public class Solution {
    void dfs(int[] flags,int begin,int index,int k,LinkedList<Integer> line,LinkedList<List<Integer>> ans){
        if(index==k){
            ans.add(new LinkedList(line));
            return;
        }
        for(int i=begin;i<flags.length;i++){
            if(flags[i]==0){
                line.addLast(i);
                flags[i] = 1;
                dfs(flags,i,index+1,k,line,ans);
                flags[i] = 0;
                line.removeLast();
            }
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        int[] flags = new int[n+1];
        Arrays.fill(flags,0);
        LinkedList<List<Integer>> ans = new LinkedList<List<Integer>>();
        LinkedList<Integer> line = new LinkedList<Integer>();
        dfs(flags,1,0,k,line,ans);
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.combine(4,2));
    }
}
