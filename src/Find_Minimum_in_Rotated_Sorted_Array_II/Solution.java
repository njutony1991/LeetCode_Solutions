package Find_Minimum_in_Rotated_Sorted_Array_II;

public class Solution {

	int binarySearch(int[] num){
		int left = 0,right = num.length-1;
		while(left < right){
			int mid = (left + right) / 2;
			if(num[mid]>=num[right]){
				left = mid+1;
			}
			else if(num[mid]<num[right]){
				right = mid;
			}
		}
		return right;
	}
	
	public int findMin(int[] num){
		if(num==null || num.length ==0) 
			return -1;
		if(num[0]<=num[num.length-1])
			return num[0];
		int ans = binarySearch(num);
		return num[ans];
	}
}
