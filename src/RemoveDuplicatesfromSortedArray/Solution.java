package RemoveDuplicatesfromSortedArray;


public class Solution {
    private int move(int[]A,int from,int shift,int len){
        for(int i=from;i<len;i++){
            A[i-shift] = A[i];
        }
        return len-shift;
    }
    public int removeDuplicates(int[] A) {
        if(A.length==0)
            return 0;
        if(A.length==1)
            return 1;
        int shift=0;
        int c = A[0];
        int len = A.length;
        for(int j=1;j<len;j++){
            if(A[j]==c)
                shift++;
            else {
                len = move(A,j,shift,len);
                j = j-shift;
                shift = 0;
                c = A[j];
            }
        }
        int lastrepeat = 0;
        for(int i=len-1;i>=1&&A[i]==A[i-1];i--){
            lastrepeat++;
        }
       // for(int i=0;i<len-lastrepeat;i++)
       //     System.out.print(A[i]+" ");
       // System.out.println("");
        return len-lastrepeat;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] a = {1,1,1,2,2,2,3,3,3,3,4,4,4,5,5,5};
        System.out.println(sol.removeDuplicates(a));
    }
}
