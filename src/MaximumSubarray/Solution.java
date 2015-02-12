package MaximumSubarray;

/**
 * Created by tony on 15-2-4.
 */
public class Solution {
    public int maxSubArray(int[] A) {
        if(A.length==1)
            return A[0];
        int b = A[0];
        int max = A[0];
        for(int i=1;i<A.length;i++)
        {
            if(b<0)
                b = A[i];
            else
                b += A[i];
            if(b>max)
                max = b;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] num = {-2,-1};
        System.out.println(sol.maxSubArray(num));
    }
}
