package NextPermutation;

import java.util.Arrays;

/**
 * Created by tony on 15-2-9.
 */
public class Solution{
        public void swap(int[] num,int i,int j){
                int tmp = num[i];
                num[i] = num[j];
                num[j] = tmp;
        }
        public void nextPermutation(int[] num){
                int length = num.length-1;
                for(;length>0;length--)
                        if(num[length-1]<num[length])
                                break;
                if(length==0){
                        for(int i=0,j=num.length-1;i<j;i++,j--)
                                swap(num,i,j);
                }else {
                        int k = num.length - 1;
                        for (; k >= length; k--)
                                if (num[k] > num[length - 1])
                                        break;
                        swap(num, k, length - 1);
                        Arrays.sort(num, length, num.length);
                }
        }

        public static void main(String[] args) {
                Solution sol = new Solution();
                int[] num = {5,4,3,2,1};
                sol.nextPermutation(num);
                System.out.println(Arrays.toString(num));
        }
}
