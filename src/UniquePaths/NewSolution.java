package UniquePaths;

/**
 * Created by tony on 15-2-3.
 */
public class NewSolution {

    int memorySearch(int m,int n,int[][] map){
        if(map[m][n]!=0)
            return map[m][n];
        if(m==0||n==0) {
            map[m][n] = 1;
        }
        else
            map[m][n] = memorySearch(m-1,n,map)+memorySearch(m,n-1,map);
        return map[m][n];
    }

    public int uniquePaths(int m, int n) {
        int[][] map = new int[m][n];
        return memorySearch(m-1,n-1,map);
    }
}
