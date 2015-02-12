package DecodeWays;

/**
 * Created by tony on 15-2-4.
 */
public class Solution {
    public int numDecodings(String s) {
        if(s.length()==0)
            return 0;

        if(s.charAt(0)=='0')
            return 0;

        int[] ways = new int[s.length()];
        ways[0] = 1;
        if(s.length()==1)
            return 1;

        int tmp = (s.charAt(0)-'0')*10+(s.charAt(1)-'0');
        if(s.charAt(1)=='0')
            ways[1] = (tmp<26)? 1 : 0;
        else
            ways[1] = (tmp<=26)? 2 : 1;

        for(int i=2;i<s.length();i++){
            tmp = (s.charAt(i-1)-'0')*10+(s.charAt(i)-'0');
            if(tmp==0)
                return 0;

            if(s.charAt(i)=='0')
                ways[i] = (tmp<26) ? ways[i-2]:0;
            else
            {
                if(s.charAt(i-1)!='0')
                    ways[i] = (tmp<=26) ? ways[i-2]+ways[i-1] : ways[i-1];
                else
                    ways[i] = ways[i-1];
            }
        }
        return ways[s.length()-1];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numDecodings("111301"));
    }
}
