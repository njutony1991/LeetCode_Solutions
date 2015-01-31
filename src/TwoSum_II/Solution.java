package TwoSum_II;

import java.util.Arrays;

public class Solution {
	public int[] twoSum(int[] numbers, int target) {
	        int[] ans = new int[2];
	        for(int i=0;i<numbers.length-1;i++){
	        	int temp = target-numbers[i];
	        	int index = Arrays.binarySearch(numbers, i+1, numbers.length, temp);
	        	if(index>=0){
	        		ans[0] = i+1;
	        		ans[1] = index+1;
	        		break;
	        	}
	        }
	        return ans;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] numbers = {2,3,4};
		int[] ans = sol.twoSum(numbers, 6);
		System.out.println(ans[0]+" "+ans[1]);
	}

}
