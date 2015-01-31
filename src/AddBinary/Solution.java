package AddBinary;

/**
 * Created by tony on 15-1-29.
 */
public class Solution {
    int step = 0;
    char bitsAdd(char a ,char b){
        if(a=='0'&&b=='0'&&step==0) {
            step = 0;
            return '0';
        }
        if(a=='0'&&b=='0'&&step==1) {
            step = 0;
            return '1';
        }
        if(((a=='0'&&b=='1')||(a=='1'&&b=='0'))&&step==0) {
            step = 0;
            return '1';
        }
        if(((a=='0'&&b=='1')||(a=='1'&&b=='0'))&&step==1){
            step = 1;
            return '0';
        }
        if((a=='1'&&b=='1')&&step==1){
            step = 1;
            return '1';
        }
        if((a=='1'&&b=='1')&&step==0){
            step = 1;
            return '0';
        }
        return '0';  // never reach here
    }

    public String addBinary(String a, String b) {
        int i = a.length()-1,j = b.length()-1;
        StringBuffer buff = new StringBuffer();
        step = 0;
        while(i>=0&&j>=0){
            char bit = bitsAdd(a.charAt(i),b.charAt(j));
            buff.append(bit);
            i--;
            j--;
        }
        while(i>=0){
            char bit = bitsAdd(a.charAt(i),'0');
            buff.append(bit);
            i--;
        }
        while(j>=0){
            char bit = bitsAdd('0',b.charAt(j));
            buff.append(bit);
            j--;
        }
        if(step==1)
            buff.append('1');
        return buff.reverse().toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String l1 = "1";
        String l2 = "1";
        System.out.println(sol.addBinary(l1,l2));
    }
}
