package Triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tony on 15-2-4.
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null&&triangle.size()==0)
            return 0;
        int m = triangle.size();
        int[] cost = new int[m];
        cost[0] = triangle.get(0).get(0);
        for(int i=1;i<m;i++){
            for(int j=i;j>=0;j--){
                if(j==0)
                    cost[0] = cost[0]+triangle.get(i).get(0);
                else if(j==i)
                    cost[j] = cost[j-1]+triangle.get(i).get(j);
                else
                    cost[j] = (cost[j-1]<cost[j]? cost[j-1]:cost[j])
                              +triangle.get(i).get(j);
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<m;i++)
            ans = ans<cost[i]? ans:cost[i];
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<List<Integer>> map = new ArrayList<List<Integer>>();
        ArrayList<Integer> n1 = new ArrayList<Integer>();
        n1.add(2);
        ArrayList<Integer> n2 = new ArrayList<Integer>();
        n2.add(3);
        n2.add(4);
        ArrayList<Integer> n3 = new ArrayList<Integer>();
        n3.add(6);
        n3.add(5);
        n3.add(7);
        ArrayList<Integer> n4 = new ArrayList<Integer>();
        n4.add(4);
        n4.add(1);
        n4.add(8);
        n4.add(3);
        map.add(n1);
        map.add(n2);
        map.add(n3);
        map.add(n4);

        Solution sol = new Solution();
        System.out.println(sol.minimumTotal(map));
    }
}
