package Anagrams;
import java.util.*;
public class Solution {
	class Str{
		char[] string = null;
		Str(String str){
			this.string = str.toCharArray();
			Arrays.sort(string);
		}
		public int hashCode(){
			return Arrays.hashCode(string);
		}
		public boolean equals(Object s1){
				Str temp1 = (Str)s1;
				return Arrays.equals(this.string, temp1.string);
		}
		
		public String toString(){
			return Arrays.toString(this.string);
		}
	}
	
	public List<String> anagrams(String[] strs){
		List<String> list = new LinkedList<String>();
		Map<Str,Integer> hash = new HashMap<Str,Integer>();
		for(int i=0;i<strs.length;i++){
			Str temp = new Str(strs[i]);
			//System.out.println(temp);
			if(hash.containsKey(temp)){
				list.add(strs[i]);
				if(hash.get(temp)!=-1){
					int origin = hash.get(temp);
					list.add(strs[origin]);
					hash.put(temp,-1);
				}
			}else{
				hash.put(temp, i);
			}
		}
		return list;
	}
//	public static void main(String[] args){
//		List<String> ans = new Solution().anagrams(new String[]{"","","bac","ssss"});
//		System.out.println(ans);
//		}
}
