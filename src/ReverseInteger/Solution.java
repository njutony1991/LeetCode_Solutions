package ReverseInteger;
import java.util.*;
public class Solution {
	public int reverse(int x){
		if(x==0) return 0;
		int flag = 1;
		if(x<0){
			flag = 0;
			x = -x;
		}
		while(x%10==0){
			x = x/10;
		}
		//System.out.println(x);
		List<Integer> list = new LinkedList<Integer>();
		while(x/10!=0){
			int temp = x%10;
			list.add(temp);
			x=x/10;
		}
		list.add(x);
		//System.out.println(list);
		int sum = 0;
		for(int i:list){
			sum = sum*10+i;
		}
		if(flag==0) 
			return -sum;
		else 
			return sum;
	}
//	public static void main(String[] args){
//		System.out.println(new Solution().reverse(9010000));
//	}
}
