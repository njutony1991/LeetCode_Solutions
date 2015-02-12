package UniqueBinarySearchTrees;

/**
 * Created by tony on 15-2-3.
 */
public class Solution {
    public int numTrees(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        int[] num = new int[n+1];
        num[0]=1;
        num[1]=1;
        num[2]=2;
        for(int j=3;j<=n;j++){
            for(int i=1;i<=j;i++){
                num[j] += num[i-1]*num[j-i];
            }
        }
        return num[n];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numTrees(3));
    }
}
