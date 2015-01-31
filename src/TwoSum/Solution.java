package TwoSum;

import java.util.Arrays;
public class Solution {
	class Number implements Comparable<Number>{
		int pos;
		int num;
		Number(int num,int pos){
			this.num = num;
			this.pos = pos;
		}
		@Override
		public int compareTo(Number arg0) {
			if(this.num<arg0.num) return -1;
			else 
			if(this.num>arg0.num) return 1;
			return 0;
		}
		
	}
	public int[] twoSum(int[] numbers,int target){
		Number[] num_pos = new Number[numbers.length];
		for(int i=0;i<numbers.length;i++)
			num_pos[i] = new Number(numbers[i],i);
		Arrays.sort(num_pos);
		int[] ans = new int[2];
		for(int i=0;i<num_pos.length;i++){
			int temp = target - num_pos[i].num;
			Number tar = new Number(temp,-1);
			int index = Arrays.binarySearch(num_pos,i+1,num_pos.length,tar);
			if(index>=0){
				ans[0] = num_pos[i].pos+1;
				ans[1] = num_pos[index].pos+1;
				if(ans[0]>ans[1]){
					int t = ans[0];
					ans[0] = ans[1];
					ans[1] = t;
				}
			}
		}
		return ans;
	}
}
