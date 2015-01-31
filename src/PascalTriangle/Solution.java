package PascalTriangle;

import java.util.*;
public class Solution {
        public List<List<Integer>> generate(int numRows) {
            ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
            if(numRows==0)
                return ans;
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            tmp.add(1);
            ans.add(tmp);
            if(numRows==1)
                return ans;
            for(int i=1;i<numRows;i++){
                ArrayList<Integer> line = new ArrayList<Integer>();
                for(int j=0;j<=i;j++){
                    if(j==0||j==i)
                        line.add(1);
                    else {
                        int temp = ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j);
                        line.add(temp);
                    }
                }
                ans.add(line);
            }
            return ans;
        }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.generate(1));
    }
}
