package PalindromePartitioning;

import java.util.*;
public class Solution {
	boolean isPalindrome(String s){
		if(s.length() == 1)
			return true;
		else
		{
			int i = 0,j = s.length()-1;
			for(;s.charAt(i)==s.charAt(j)&&i<=j;i++,j--);
			if(i>j) return true;
			else return false;
		}
	}
	void dfs(String s,int start,List<String> ans,List<List<String>> res)
	{
		if(start==s.length()){
			res.add(new LinkedList<String>(ans));
			return;
		}
		for(int i=start+1;i<=s.length();i++){
			String temp = s.substring(start, i);
			if(isPalindrome(temp)==true){
				ans.add(temp);
				dfs(s,i,ans,res);
				ans.remove(ans.size()-1);
			}
		}
	}
    public List<List<String>> partition(String s) {
    	List<List<String>> res = new LinkedList<List<String>>();
    	List<String> ans = new LinkedList<String>();
    	dfs(s,0,ans,res);
        return res;
    }
    
    //for test
    public static void main(String[] args){
    	List<List<String>> ans = new Solution().partition("aabaa");
    	for(List<String> l :ans)
    	{
    		for(String str:l)
    			System.out.print(str+" ");
    		System.out.println("");
    	}
    }
}
