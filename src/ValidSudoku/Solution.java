package ValidSudoku;

import java.util.Arrays;

/**
 * Created by tony on 15-1-29.
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] tables = new int[10];
        for(int i=0;i<9;i++) {
            Arrays.fill(tables,0);
            for(int j=0;j<9;j++) {
                if(board[i][j]!='.')
                    if(tables[board[i][j]-'0']==1)
                        return false;
                    else
                        tables[board[i][j]-'0']=1;
            }
        }

        for(int i=0;i<9;i++){
            Arrays.fill(tables,0);
            for(int j=0;j<9;j++){
                if(board[j][i]!='.')
                    if(tables[board[j][i]-'0']==1)
                        return false;
                    else
                        tables[board[j][i]-'0']=1;
            }
        }

        for(int i=0;i<9;i=i+3){
            for(int j=0;j<9;j=j+3){
                Arrays.fill(tables,0);
                for(int m=0;m<3;m++)
                    for(int n=0;n<3;n++){
                        if(board[i+m][j+n]!='.')
                            if(tables[board[i+m][j+n]-'0']==1)
                                return false;
                            else
                                tables[board[i+m][j+n]-'0']=1;
                    }
            }
        }
        return true;
    }
}
