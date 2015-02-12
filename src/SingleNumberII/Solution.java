package SingleNumberII;

public class Solution {
    public int singleNumber(int[] A) {
        int sum1 = 0;
        for(int i=0;i<A.length;i++)
            sum1 = sum1 ^ A[i];
        return 0;
    }
}
