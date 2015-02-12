package RemoveDuplicatesfromSortedArray;


public class Solution {

    public int removeDuplicates(int[] A) {
        if(A.length==0) return 0;
        if(A.length==1) return 1;
        int top = 0;
        for(int i=1;i<A.length;i++){
            if(A[i]!=A[top]){
                top++;
                A[top]=A[i];
            }
        }
        return top+1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] a = {1,1,1,2,2,2,3,3,3,3,4,4,4,5,5,5};
        System.out.println(sol.removeDuplicates(a));
    }
}
