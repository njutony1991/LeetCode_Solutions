package LetterCombinationsofaPhoneNumber;

import java.util.*;

/**
 * Created by tony on 15-2-9.
 */
public class Solution {
    private static final Map<Integer,String> map = new HashMap<Integer,String>(){
        {put(2,"abc");put(3,"def");put(4,"ghi");put(5,"jkl");
         put(6,"mno");put(7,"pqrs");put(8,"tuv");put(9,"wxyz");}
    };

    private void dfs(String digits,int index,char[] buffer,LinkedList<String> ans){
        if(index==digits.length()){
            StringBuilder builder = new StringBuilder();
            for(int i=0;i<buffer.length;i++)
                builder.append(buffer[i]);
            ans.add(builder.toString());
            return;
        }
        String line = map.get((digits.charAt(index)-'0'));
        for(int i=0;i<line.length();i++){
            buffer[index] = line.charAt(i);
            dfs(digits,index+1,buffer,ans);
        }
    }
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        char[] buf = new char[digits.length()];
        dfs(digits,0,buf,ans);
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.letterCombinations("23"));
    }
}
