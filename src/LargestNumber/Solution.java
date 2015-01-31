package LargestNumber;
import java.util.*;
public class Solution {
	 class Number implements Comparable<Number>{
		ArrayList<Integer> digits = new ArrayList<Integer>();
	    long num;
		int shift;
		Number(int num){
			this.num = num;
			this.shift = 1;
			do{
				digits.add(num%10);
				shift = shift*10;
				num = num/10;
			}while(num!=0);
		}
		
		@Override
		public int compareTo(Number o) {
		 	long sum1 = this.num*o.shift+o.num;
		 	long sum2 = o.num*this.shift+this.num;
		 	if(sum1>sum2)
		 		return -1;
		 	if(sum1<sum2)
		 		return 1;
		 	return 0;
		}
		 
		@Override 
		public String toString(){
			return " "+num+" ";
		}
	 }
	 public String largestNumber(int[] num) {
		 Number[] numbers = new Number[num.length];
		 for(int i=0;i<num.length;i++)
			 numbers[i] = new Number(num[i]);
		 Arrays.sort(numbers);
		 StringBuffer buf = new StringBuffer();
		 int flag = 0;
		 for(int i=0;i<numbers.length;i++){
			 ArrayList<Integer> list = numbers[i].digits;
			 for(int j=list.size()-1;j>=0;j--){
				 if(list.get(j)!=0)
					 flag=1;
				 buf.append(list.get(j));
			 }
		 }
		 if(flag==0)
			 return "0";
		 else
			 return buf.toString();
	 }
	 
	 public static void main(String[] args){
		 int[] nums = new int[]{3,30,34,5,9};
		 Solution sol = new Solution();
		 System.out.println(sol.largestNumber(nums));
	 }
}
