package SearchforaRange;

/**
 * Created by tony on 15-2-12.
 */
public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] ans = new int[2];
        int left = 0,right = A.length-1;
        int flag = 0;
        while(left<=right){
            int mid = (left+right)/2;
            if(A[mid]==target){
                flag=1;
                int l = mid;
                while(l>=0&&A[l]==target)
                    l--;
                int r = mid;
                while(r<A.length&&A[r]==target)
                    r++;
                ans[0] = l+1;
                ans[1] = r-1;
                break;
            }else if(A[mid]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        if(flag==0){
            ans[0] = -1;
            ans[1] = -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] num = {2,2};
        int target = 3;
        int[] ans = sol.searchRange(num,target);
        System.out.println(ans[0]+" "+ans[1]);
    }
}
