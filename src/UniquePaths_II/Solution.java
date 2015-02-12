package UniquePaths_II;

import java.util.Arrays;

/**
 * Created by tony on 15-2-3.
 */
public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1)
            return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] map = new int[m][n];
        int flag1 = 1,flag2 = 1;
        for(int i=0;i<m;i++) {
            if(flag1==0)
                map[i][0] = 0 ;
            else{
                if(obstacleGrid[i][0]==1){
                    map[i][0] = 0;
                    flag1 = 0;
                }else
                    map[i][0] = 1;
            }
        }

        for(int i=0;i<n;i++){
            if(flag2==0)
                map[0][i] = 0;
            else{
                if(obstacleGrid[0][i]==1){
                    map[0][i] = 0;
                    flag2 = 0;
                }else
                    map[0][i] = 1;
            }
        }

        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==1)
                    map[i][j] = 0;
                else
                    map[i][j] = map[i-1][j]+map[i][j-1];
            }

        return map[m-1][n-1];
    }
}
