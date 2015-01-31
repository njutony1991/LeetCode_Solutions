package ValidPalindrome;


public class Solution {
    public boolean isPalindrome(String s) {
        if(s==null||s.length()==0)
            return true;
        String temp =s.toLowerCase();
        StringBuffer buff = new StringBuffer();
        for(int i=0;i<temp.length();i++)
            if((temp.charAt(i)>='a'&&temp.charAt(i)<='z')||
                    (temp.charAt(i)>='0'&&temp.charAt(i)<='9'))
                buff.append(temp.charAt(i));
        String str = buff.toString();
        if(str.length()==0||str.length()==1)
            return true;
        int i=0,j=str.length()-1;
        while(i<j){
            if(str.charAt(i)==str.charAt(j)){
                i++;
                j--;
            }
            else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isPalindrome("2a2"));
    }
}


