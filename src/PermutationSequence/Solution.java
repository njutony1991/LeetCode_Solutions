package PermutationSequence;

import java.util.*;
public class Solution {

    void swap(int[] permutation,int i,int j){
        int tmp = permutation[i];
        permutation[i] = permutation[j];
        permutation[j] = tmp;
    }
    void nextpermutation(int[] permutation){
        int length = permutation.length-1;
        for(;length>0;length--)
            if(permutation[length-1]<permutation[length])
                break;

        if(length==0){
            for(int i=0,j=permutation.length-1;i<=j;i++,j--){
                swap(permutation,i,j);
            }
        }else{
            int k = permutation.length-1;
            for(;k>=length;k--)
                if(permutation[k]>permutation[length-1])
                    break;
            swap(permutation,k,length-1);
            Arrays.sort(permutation,length,permutation.length);
        }
    }
    public String getPermutation(int n, int k) {
        int tmp = 1;
        for(int i=1;i<=n;i++)
            tmp*=i;
        k = k%tmp;
        int[] per = new int[n];
        for(int i=0;i<per.length;i++)
            per[i] = i+1;
        for(int i=1;i<k;i++)
            nextpermutation(per);

        StringBuffer ans = new StringBuffer();
        for(int i=0;i<per.length;i++) {
            ans.append(per[i]);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.getPermutation(8,9));
    }
}
