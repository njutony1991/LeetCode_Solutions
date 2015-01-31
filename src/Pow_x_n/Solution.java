package Pow_x_n;


public class Solution {
	   public double pow(double x, int n) {
		   if(x==0) return 0;
		   if(x==1) return 1;
		   if(n==0) return 1;
		   if(n==1) return x;
		   if(x==-1) return (n%2)==0 ? 1:-1;
		   if(n<0) return pow(1/x,-n);
		   if(n==2) return x*x;
		   
		   if(n%2==0){
			   double temp = pow(x,n/2);
			   return temp*temp;
		   }else{
			   double temp = pow(x,(n-1)/2);
			   return temp*temp*x;
		   }
	   }
	   
	   public static void main(String[] args){
		   Solution sol = new Solution();
		   System.out.println(sol.pow(2, 3));
	   }
}
