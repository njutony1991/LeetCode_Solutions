package SpiralMatrixII;
import java.util.*;
public class Solution {

    public int[][] generateMatrix(int n) {

    	int[][] ans = new int[n][n];
        if(n==0)
            return ans;
        int leftx = 0,lefty = 0;
        int rightx = n-1,righty = n-1;
        int num = 1;
        while(leftx<=rightx&&lefty<=righty){
            for(int i=lefty;i<=righty;i++) {
                ans[leftx][i]=num;
                num++;
            }
            for(int i=leftx+1;i<=rightx;i++){
                ans[i][righty]=num;
                num++;
            }
            for(int i=righty-1;i>=lefty;i--){
                ans[rightx][i]=num;
                num++;
            }
            for(int i=rightx-1;i>=leftx+1;i--){
                ans[i][lefty]=num;
                num++;
            }
            leftx++;
            lefty++;
            rightx--;
            righty--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] ans = new Solution().generateMatrix(4);
        for (int i=0;i<ans.length;i++)
            System.out.println(Arrays.toString(ans[i]));
    }
}
