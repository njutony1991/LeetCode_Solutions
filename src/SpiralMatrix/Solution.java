package SpiralMatrix;

import java.util.List;
import java.util.LinkedList;


public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        LinkedList ans = new LinkedList<Integer>();
        if(matrix==null||matrix.length==0)
            return ans;
        int row = matrix.length-1;
        int col = matrix[0].length-1;
        int leftx = 0,lefty = 0;
        int rightx = row,righty = col;
            while ((leftx <= rightx) && (lefty <= righty)) {
                for (int i = lefty; i <= righty; i++)
                    ans.add(matrix[leftx][i]);
                for (int i = leftx + 1; i <= rightx; i++)
                    ans.add(matrix[i][righty]);
                if(rightx!=leftx)
                    for (int i = righty - 1; i >= lefty; i--)
                        ans.add(matrix[rightx][i]);
                if(righty!=lefty)
                for (int i = rightx - 1; i >= leftx + 1; i--)
                    ans.add(matrix[i][lefty]);

                leftx ++;
                lefty ++;
                rightx --;
                righty --;
            }

        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(new Solution().spiralOrder(matrix));
    }
}
