package RotateImage;

/**
 * Created by tony on 15-2-9.
 */
public class Solution {
    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<i;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for(int i=0,j=matrix.length-1;i<=j;i++,j--){
            for(int k=0;k<matrix.length;k++){
              int tmp = matrix[k][i];
                matrix[k][i] = matrix[k][j];
                matrix[k][j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = {{1,2,3,4}
                         ,{5,4,7,8}
                         ,{9,10,11,12}
                         ,{13,14,15,16}};
        sol.rotate(matrix);
        for(int i=0;i<matrix.length;i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
