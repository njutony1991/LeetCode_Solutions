package MergeSortedArray;

/**
 * Created by tony on 15-1-29.
 */
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int[] copya = new int[m];
        System.arraycopy(A,0,copya,0,m);
        int i=0,j=0;
        int k=0;
        while(i<m&&j<n)
            if(copya[i]<B[j]){
                A[k++] = copya[i++];
            }else
            if(B[j]<copya[i])
                A[k++] = B[j++];
            else{
                A[k++] = copya[i++];
                A[k++] = B[j++];
            }
        while(i<m)
            A[k++] = copya[i++];
        while(j<n)
            A[k++] =  B[j++];
    }
}
