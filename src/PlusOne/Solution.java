package PlusOne;

import java.util.*;
public class Solution {
    public int[] plusOne(int[] digits) {
        LinkedList<Integer> numbers = new LinkedList<Integer>();
        int step = 0;
        digits[digits.length-1]++;
        for(int i=digits.length-1;i>=0;i--){
            if(step==1)
                digits[i]++;
            step = digits[i]/10;
            digits[i] = digits[i]%10;
            numbers.addFirst(digits[i]);
        }
        if(step==1)
            numbers.addFirst(1);
        int[] ans = new int[numbers.size()];
        for(int i=0;i<numbers.size();i++){
            ans[i] = numbers.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] num = {1,9,9,9};
        System.out.println(Arrays.toString(sol.plusOne(num)));
    }
}
