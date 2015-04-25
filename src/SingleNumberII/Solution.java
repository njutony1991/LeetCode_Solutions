package SingleNumberII;

public class Solution {
    public int singleNumber(int[] A) {
        int[] count = new int[32];
        int result = 0;
        for(int i=0;i < 32;i++) {
            for (int j = 0; j < A.length; j++) {
                if (((A[j] >> i) & 1) != 0) {
                    count[i]++;
                }
            }
            result |= ((count[i]%3)<<i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = {1,1,1,2,2,2,3,4,4,4};
        System.out.println(new Solution().singleNumber(test));
    }
}
