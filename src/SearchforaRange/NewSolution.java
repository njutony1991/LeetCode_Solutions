package SearchforaRange;

/**
 * Created by tony on 15-2-12.
 */
public class NewSolution {

    int searchStart(int[] A,int start,int end,int target){
        while(start<=end){
            int mid = (start+end)/2;
            if(A[mid]==target)
                end = mid-1;
            else
                start = mid+1;
        }
        return start;
    }
    int searchEnd(int[] A,int start,int end,int target){
        while(start<=end){
            int mid = (start+end)/2;
            if(A[mid]==target)
                start = mid+1;
            else
                end = mid-1;
        }
        return end;
    }

    public int[] searchRange(int[] A,int target){
        int[] ans = new int[2];
        int start = 0;
        int end = A.length-1;
        while(start <= end){
            int mid = (start+end)/2;
            if(A[mid]<target){
                start = mid+1;
            }else if(A[mid]>target){
                end = mid-1;
            }else{
                int startindex = searchStart(A,start,mid,target);
                int endindex = searchEnd(A,mid,end,target);
                ans[0] = startindex;
                ans[1] = endindex;
                return ans;
            }
        }
        ans[0] = -1;
        ans[1] = -1;
        return ans;
    }

    public static void main(String[] args) {
        NewSolution sol = new NewSolution();
        int[] num = {2,2};
        int target = 2;
        int[] ans = sol.searchRange(num,target);
        System.out.println(ans[0]+" "+ans[1]);
    }
}
