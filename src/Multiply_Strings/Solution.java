package Multiply_Strings;

/**
 * Created by tony on 15-2-8.
 */
public class Solution {
    public StringBuffer charMulString(char digit,String number){
        if(digit=='0')
            return new StringBuffer("0");
        if(digit=='1')
            return new StringBuffer(number);

        StringBuffer ans = new StringBuffer();
        int step = 0,val;
        int cdigit = digit-'0';
        for(int i=number.length()-1;i>=0;i--){
            int tmp = (number.charAt(i)-'0')*cdigit+step;
                val = tmp%10;
                step = tmp/10;
            ans.append((char)('0'+val));
        }
        if(step != 0)
            ans.append((char)('0'+step));
        return ans.reverse();
    }

    public StringBuffer add(String number1,String number2){
        if("0".equals(number1))
            return new StringBuffer(number2);
        if("0".equals(number2))
            return new StringBuffer(number1);

        int step = 0,val = -1;
        StringBuffer ans = new StringBuffer();
        int i = number1.length()-1;
        int j = number2.length()-1;
        while(i>=0&&j>=0){
            int tmp = (number1.charAt(i)-'0')+(number2.charAt(j)-'0')+step;
            val = tmp % 10;
            step = tmp / 10;
            ans.append((char)('0'+val));
            i--;
            j--;
        }
        while(i>=0){
            int tmp = (number1.charAt(i)-'0')+step;
            val = tmp % 10;
            step = tmp / 10;
            ans.append((char)('0'+val));
            i--;
        }
        while(j>=0){
            int tmp = (number2.charAt(j)-'0')+step;
            val = tmp % 10;
            step = tmp / 10;
            ans.append((char)('0'+val));
            j--;
        }
        if(step == 1)
            ans.append('1');
        return ans.reverse();
    }


    public String multiply(String num1, String num2) {
        if("0".equals(num1)||"0".equals(num2))
            return "0";
        if("1".equals(num1))
            return num2;
        if("1".equals(num2))
            return num1;
        StringBuffer val = charMulString(num2.charAt(num2.length()-1),num1);

        for(int i=num2.length()-2;i>=0;i--){
            StringBuffer tmp = charMulString(num2.charAt(i),num1);
            for(int k=0;k<num2.length()-1-i;k++)
                tmp.append('0');
            val = add(val.toString(), tmp.toString());
        }
        return val.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.multiply("5","4"));
    }
}
