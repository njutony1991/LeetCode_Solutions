package LongestSubstringWithoutRepeatingCharacters;

import  java.util.*;
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)
            return 0;
        HashMap<Character,Integer> hash = new HashMap<Character,Integer>();
        int i = 0,j=1;
        int maxlength = 1;
        hash.put(s.charAt(i),i);
        while(j<s.length()){
            if(hash.containsKey(s.charAt(j))){
                i = Math.max(i,hash.get(s.charAt(j))+1);
            }
            hash.put(s.charAt(j),j);
            maxlength = Math.max(maxlength,j-i+1);
            j++;
        }

        return maxlength;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.lengthOfLongestSubstring("aabc"));
    }
}
