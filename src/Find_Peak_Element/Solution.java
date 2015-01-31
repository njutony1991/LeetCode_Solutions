package Find_Peak_Element;

/**
 * Created by tony on 15-1-28.
 */

public class Solution {
    public int findPeakElement(int[] num) {
        int left = 0;
        int right = num.length-1;
        if(num.length>=2) {
            if (num[0] > num[1])
                return 0;
            if (num[num.length - 1] > num[num.length-2])
                return num.length-1;
        }
        while(left < right){
            int mid = (left+right)/2;
            if((num[mid]>num[mid-1])&&(num[mid+1]>num[mid])) {
                left = mid+1;
            }else if((num[mid]<num[mid-1])&&(num[mid+1]<num[mid])) {
                right = mid;
            }else if((num[mid]<num[mid-1])&&(num[mid+1]>num[mid])){
                left = mid+1;
            }else if((num[mid]>num[mid-1])&&(num[mid+1]<num[mid]))
                  return mid;
        }
        return left;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] num = {3,4,3,2,1};
        System.out.println(sol.findPeakElement(num));
    }
}
