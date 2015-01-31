package PascalTriangle_II;

import java.util.*;
public class Solution {

    public List<Integer> getRow(int rowIndex) {
        LinkedList<Integer> row = new LinkedList<Integer>();
        row.add(1);
        double val = 1;
        for(int i=1;i<=rowIndex;i++){
            double tmp= (val*(rowIndex-i+1))/i*1.0;
            int next = (int)(tmp);
            val = tmp;
            row.add(next);
        }
        return row;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.getRow(32));
    }
}
