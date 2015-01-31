package ValidNumber;

public class Solution {
    static int INVALID = 0;
    static int SPACE = 1;
    static int SIGN = 2;
    static int DIGIT = 3;
    static int DOT = 4;
    static int EXPONENT = 5;
    
    int[][] transitionTable = {
    		{-1,0,3,1,2,-1},   //next state for state 0
    		{-1,8,-1,1,4,5},   //next state for state 1
    		{-1,-1,-1,4,-1,-1},//next state for state 2
    		{-1,-1,-1,1,2,-1}, //next state for state 3
    		{-1,8,-1,4,-1,5},  //next state for state 4
    		{-1,-1,6,7,-1,-1}, //next state for state 5
    		{-1,-1,-1,7,-1,-1},//next state for state 6
    		{-1,8,-1,7,-1,-1}, //next state for state 7
    		{-1,8,-1,-1,-1,-1} //next state for state 8
    };
    
    public boolean isNumber(String s) {
	    char[] string = s.trim().toCharArray();
	    int state = 0;
	    int inputType = -1;
	    for(int i =0;i<string.length;i++){
	    	inputType = INVALID;
	    	if(string[i]==' ')
	    		inputType = SPACE;
	    	else if(string[i]=='+'||string[i]=='-')
	    		inputType = SIGN;
	    	else if(Character.isDigit(string[i]))
	    		inputType = DIGIT;
	    	else if(string[i]=='.')
	    		inputType = DOT;
	    	else if(string[i]=='e'||string[i]=='E')
	    		inputType = EXPONENT;
	    	
	        state = transitionTable[state][inputType];
	   	    
	   	    if(state == -1)
	   	    	return false;
	    }
	    return state==1 || state==4 || state==7 || state==8;
	}
    
	public static void main(String[] args) {
		System.out.println(new Solution().isNumber(".e"));
	}

}
