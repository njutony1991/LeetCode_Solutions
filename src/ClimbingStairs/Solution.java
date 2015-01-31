package ClimbingStairs;

/**
 * Created by tony on 15-1-29.
 */
public class Solution {
    public int climbStairs(int n) {
        long a = 1;
        long b = 2;
        if(n<=0)
            return 0;
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        for(int i=3;i<=n;i++)
        {
            long temp = a+b;
            a = b;
            b = temp;
        }
        return (int)b;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.climbStairs(100));
    }
}
