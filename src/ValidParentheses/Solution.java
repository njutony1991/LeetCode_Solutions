package ValidParentheses;

import java.util.*;
public class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<Character>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{')
                stack.addLast(s.charAt(i));
            else if(s.charAt(i)==')'){
                if(stack.isEmpty())
                    return false;
                char tmp = stack.pollLast();
                if(tmp!='(')
                    return false;
            }
            else if(s.charAt(i)==']'){
                if(stack.isEmpty())
                    return false;
                char tmp = stack.pollLast();
                if(tmp!='[')
                    return false;
            }
            else if(s.charAt(i)=='}'){
                if(stack.isEmpty())
                    return false;
                char tmp = stack.pollLast();
                if(tmp!='{')
                    return false;
            }
            else
                return false;
        }
        if(stack.isEmpty())
            return true;
        return false;
    }
}
