package WordBreak;
import java.util.*;
public class Solution {
	
	  int[][] exist = null;
	  int[][] ans =  null;
	  
	  public boolean wordBreak(String s, Set<String> dict) {
		  exist = new int[s.length()][s.length()];
		  ans = new int[s.length()][s.length()];
		  for(int i=0;i<s.length();i++)
			  for(int j=i+1;j<=s.length();j++){
				  String temp =  s.substring(i,j);
				  exist[i][j-1] =dict.contains(temp) ? 1 : 0;
			  }
		  
		  for(int i = 0;i<s.length();i++)
			  ans[i][i] = exist[i][i];
		  for(int i=2;i<=s.length();i++)
			  for(int j=0;j<=s.length()-i;j++){
				  if(exist[j][j+i-1]==1) 
					 ans[j][j+i-1] = 1;
				  else
					  for(int k=j;k<j+i-1;k++){
						  if(ans[j][k]==1&&ans[k+1][j+i-1]==1)
							  ans[j][j+i-1] = 1;
					  }
			  }
		  
		  return ans[0][s.length()-1]==1 ? true : false;
	  }
	  
	  public static void main(String[] args){
		  HashSet<String> set = new HashSet<String>();
		  set.add("a");
		  set.add("aa");
		  set.add("aaa");
		  set.add("aaaa");
		  set.add("aaaaa");
		  set.add("aaaaaa");
		  set.add("aaaaaaa");
		  set.add("aaaaaaaa");
		  set.add("aaaaaaaaa");
		  set.add("aaaaaaaaaa");
		  System.out.println(new Solution().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", set));
	  }
}
