package MinimumPathSum;

/**
 * Created by tony on 15-2-4.
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        int[][] cost = new int[grid.length][grid[0].length];
        cost[0][0] = grid[0][0];
        for(int i=1;i<grid[0].length;i++)
            cost[0][i] = grid[0][i]+cost[0][i-1];
        for(int i=1;i<grid.length;i++)
            cost[i][0] = grid[i][0]+cost[i-1][0];

        for(int i=1;i<grid.length;i++)
            for(int j=1;j<grid[0].length;j++){
                cost[i][j] = (cost[i-1][j]<cost[i][j-1]? cost[i-1][j]:cost[i][j-1])
                             + grid[i][j];
            }
        return cost[grid.length-1][grid[0].length-1];
    }
}
