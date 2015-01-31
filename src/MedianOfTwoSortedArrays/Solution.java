package MedianOfTwoSortedArrays;

public class Solution {
	 double findKth(int[] a,int indexa,int[] b,int indexb,int k){
		 if((a.length-indexa) > (b.length-indexb))
			 return findKth(b,indexb,a,indexa,k);
		 if(a.length <= indexa)
			 return b[indexb+k-1];
		 if(k == 1)
			 return a[indexa] < b[indexb] ? a[indexa]: b[indexb];
		 
	     int pa = (k/2) < (a.length-indexa) ? (k/2):(a.length-indexa);
	     int pb = k - pa;
	     if(a[indexa+pa-1]<b[indexb+pb-1]){
	    	 return findKth(a,indexa+pa,b,indexb,k-pa);
	     }else if(a[indexa+pa-1]>b[indexb+pb-1]){
	    	 return findKth(a,indexa,b,indexb+pb,k-pb);
	     }
	     else
	    	 return a[indexa+pa-1];
	 }
	 
	 public double findMedianSortedArrays(int A[], int B[]) {
		 int total = A.length+B.length;
		 if(total%2==1)
			 return findKth(A,0,B,0,(total/2+1));
		 else
			 return (findKth(A,0,B,0,(total/2))+findKth(A,0,B,0,(total/2+1)))/2;
	 }
	 
	 public static void main(String[] args){
		 Solution sol = new Solution();
		 int[] a = {1,3,5,8};
		 int[] b = {2,4,6,7};
		 
		 System.out.println(sol.findMedianSortedArrays(a, b));
	 }
}
