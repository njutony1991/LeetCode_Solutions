package CountAndSay;


public class Solution {
    public String nextString(String pre){
        StringBuffer buffer = new StringBuffer();
        char c = pre.charAt(0);
        int num = 1;
        int i = 1;

        while(i<pre.length()) {
            if (c == pre.charAt(i)) {
                num++;
            } else {
                buffer.append(num).append(c);
                num = 1;
                c = pre.charAt(i);
            }
            i++;
        }
        buffer.append(num);
        buffer.append(c);

        return buffer.toString();
    }
    public String countAndSay(int n) {
        String tmp = "1";
        if(n==1)
            return "1";
        for(int i=2;i<=n;i++){
            tmp = nextString(tmp);
        }
        return tmp;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.countAndSay(4));
    }
}
