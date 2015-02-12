package Container_With_Most_Water;

/**
 * Created by tony on 15-2-7.
 */
public class Solution {
    public int maxArea(int[] height) {
        if(height.length<=1)
            return 0;
        int max = Integer.MIN_VALUE;
        int i = 0,j = height.length-1;
        int h = -1;
        int index = -1;
        while(i<j){
            index = (height[i]<=height[j]) ? i : j;
            h = Math.min(height[i],height[j]);
            max = Math.max((j-i)*h,max);
            if(index==i){
                i++;
            }else{
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] height = {1,2,4,3};
        System.out.println(sol.maxArea(height));
    }
}
