package Maximum_Product_Subarray;

public class Solution {
   public int maxProduct(int[] a) {
	 assert a.length > 0 ;
	 if(a.length == 1)
		 return a[0];
	  int[] max = new int[a.length];
	  int[] min = new int[a.length];
	  max[0] = a[0];
	  min[0] = a[0];
	  int ans = max[0];
	  for(int i=1;i<a.length;i++){
		  if(a[i]>=0){
			  max[i] = (a[i]>=a[i]*max[i-1])? a[i]:a[i]*max[i-1];
			  min[i] = (a[i]<=a[i]*min[i-1])? a[i]:a[i]*min[i-1];
		  }
		  else if(a[i]<0){
			  max[i] = (a[i]>=a[i]*min[i-1])? a[i]:a[i]*min[i-1];
			  min[i] = (a[i]<=a[i]*max[i-1])? a[i]:a[i]*max[i-1];
		  }
		  if(max[i]>ans)
			 ans = max[i];
	  }
	   return ans;
   }
   
   public static void main(String[] args){
  	   int[] test = new int[]{-2,-4,0};
    System.out.println(new Solution().maxProduct(test));
   }
}
