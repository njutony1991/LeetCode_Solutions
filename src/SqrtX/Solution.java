package SqrtX;

public class Solution {

    public int sqrt(int x) {
    	if(x==0)
    		return 0;
    	double i=1;
    	while(Math.abs(i*i-x)>0.001)
    	{
    		i=(i+(x/i))/2;
    	}
    	return (int)i;
    }
    
    public static void main(String[] args){
    	Solution sol = new Solution();
    	System.out.println(sol.sqrt(6));
    }
}
