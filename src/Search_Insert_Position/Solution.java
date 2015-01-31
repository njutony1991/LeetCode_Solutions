package Search_Insert_Position;

/**
 * Created by tony on 15-1-28.
 */
public class Solution {

    public int searchInsert(int[] A, int target) {
        int left = 0,right = A.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(A[mid]==target)
                return mid;
            else if(A[mid]<target)
                left = mid+1;
            else if(A[mid]>target)
                right = mid-1;
        }
        return left;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] num = {1,3,5,6};
        System.out.println(sol.searchInsert(num,0));
    }
}
