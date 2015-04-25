package ThreeSum_Closest;

import java.util.*;

public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int ans = num[0]+num[1]+num[num.length-1];
        for(int i=0;i<num.length-2;i++){
            int start = i+1,end = num.length-1;
            while(start<end){
                int sum = num[i]+num[start]+num[end];
                if(sum>target)
                    end--;
                else
                    start++;

                if(Math.abs(sum-target)<Math.abs(ans-target))
                    ans = sum;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] num = {-1,2,1,-4};
        System.out.println(sol.threeSumClosest(num,1));
    }
}
