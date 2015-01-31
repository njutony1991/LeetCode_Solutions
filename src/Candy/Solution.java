package Candy;

public class Solution {
	  int descendlength(int init,int[] ratings){
		  int len = 0;
		  for(int i=init;i<ratings.length;i++){
			  if(ratings[i]<ratings[i-1])
				  len++;
			  else
				  break;
		  }
		  return len;
	  }
	  
	  public int candy(int[] ratings) {
		  if(ratings.length==0) return 0;
		  if(ratings.length==1) return 1;
		  
		  int[] candies = new int[ratings.length];
		  candies[0] = 1;
		  for(int i=1;i<ratings.length;){
			  if(ratings[i]>ratings[i-1]){
				  candies[i] = candies[i-1]+1;
				  i++;
			  }
			  else
			  if(ratings[i]==ratings[i-1]){
				  candies[i] = 1;
				  i++;
			  }
			  else
			  if(ratings[i]<ratings[i-1]){
				  int descendlen = descendlength(i,ratings);
				  int index = i;
				  for(;i<index+descendlen;i++){
					  candies[i] = descendlen-(i-index);
				  }
				  if(candies[index]>=candies[index-1])
					  candies[index-1] = candies[index]+1;
			  }
		  }
		  int sum = 0;
		  for(int i=0;i<candies.length;i++)
			  sum+=candies[i];
		  return sum;
	  }
	  
	  public static void main(String[] args){
		  int[] ratings = new int[]{2,2,1};
		 // for(int i=0;i<20000;i++)
		//	  ratings[i]=i+1;
		  Solution sol = new Solution();
		  System.out.println(sol.candy(ratings));
	  }
}
