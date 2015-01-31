package LengthofLastWord;

/**
 * Created by tony on 15-1-29.
 */
public class Solution {
    public int lengthOfLastWord(String s) {

        String tmp = s.trim();
        if(tmp.length()==0)
            return 0;
        String[] strs = tmp.split("\\s+");
        return strs[strs.length-1].length();
    }

    public static void main(String[] args) {
        Solution  sol = new Solution();
        System.out.println(sol.lengthOfLastWord("Hello World   "));
    }
}
