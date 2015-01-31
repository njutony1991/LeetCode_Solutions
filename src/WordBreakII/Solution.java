package WordBreakII;
import java.util.*;
public class Solution {
	  class Sentences{
		  HashSet<String> words;
		  Sentences(HashSet<String> words){
			  this.words = words;
		  }
	  }
	  
	  int[][] exist = null;
	  Sentences[][] sen = null;
	  
	  public List<String> wordBreak(String s, Set<String> dict) {
		  	exist = new int[s.length()][s.length()];
		  	sen = new Sentences[s.length()][s.length()];
		 	LinkedList<String> ans = new LinkedList<String>();
		  	for(int i=0;i<s.length();i++)
		  		for(int j=i+1;j<=s.length();j++){
		  			String temp = s.substring(i,j);
		  			if(dict.contains(temp)){
		  				exist[i][j-1] = 1;
		  				HashSet<String> set = new HashSet<String>();
		  				set.add(temp);
		  				sen[i][j-1] = new Sentences(set);
		  			}else{
		  				exist[i][j-1] = 0;
		  			}
		  	}
		  	int flag1 = 0,flag2 = 0;
		  	for(int i=0;i<s.length();i++){
		  		if(exist[0][i]==1)
		  			flag1 = 1;
		  	}
		  	for(int i=0;i<s.length();i++){
		  		if(exist[i][s.length()-1]==1)
		  			flag2 = 1;
		  	}
		  	
		  	if(flag1==0||flag2==0)
		  		return ans;
		  	
		  	for(int l=2;l<=s.length();l++)
		  		for(int i=0;i<=s.length()-l;i++){
		  				for(int j=i;j<i+l-1;j++)
		  					if(exist[i][j]==1&&exist[j+1][i+l-1]==1){
		  						exist[i][i+l-1] = 1;
		  						HashSet<String> f1 = sen[i][j].words;
		  						HashSet<String> f2 = sen[j+1][i+l-1].words;
		  						HashSet<String> tempset = sen[i][i+l-1]==null ? 
		  											  new HashSet<String>(): sen[i][i+l-1].words;
		  						Iterator<String> it1 = f1.iterator();
		  						while(it1.hasNext()){
		  							String temp1 = it1.next();
		  							Iterator<String> it2 = f2.iterator();
		  							while(it2.hasNext()){
		  								String temp2 = it2.next();
		  								String temp3 = temp1+" "+temp2;
		  								tempset.add(temp3);
		  							}
		  						}
		  						if(sen[i][i+l-1]==null)
		  							sen[i][i+l-1] = new Sentences(tempset);
		  					}
		  	}
		  	
		 
		  	if(exist[0][s.length()-1]==1){
		  		Iterator<String> finalset= sen[0][s.length()-1].words.iterator();
		  		while(finalset.hasNext()){
		  			ans.add(finalset.next());
		  		}
		  	}
	        return ans;
	  }
	  
	  public static void main(String[] args){
		  HashSet<String> set = new HashSet<String>();
		  set.add("a");
		  set.add("aa");
		  set.add("aaa");
		  
		  System.out.println(new Solution().wordBreak("aaaaaaaaaa", set));
	  }
}
