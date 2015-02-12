package RemoveElement;

/**
 * Created by tony on 15-2-8.
 */
public class Solution {
    public int removeElement(int[] A, int elem) {
        int shift = 0;
        for(int i=0;i<A.length;i++){
            if(A[i]!=elem)
                A[i-shift] = A[i];
            else
                shift++;
        }
        return A.length-shift;
    }
}
