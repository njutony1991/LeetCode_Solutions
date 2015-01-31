package ZigZagConversion;

public class Solution {
    public String convert(String s, int nRows) {
    	 if(s.length()==1||nRows==1)
    		 return s;
		 char[] temp = s.toCharArray();
		 char[] ans = new char[s.length()];
		 int index = 0;
		 for(int i = 0;i<nRows;i++){
			 if(i==0||i==nRows-1){
				 int len = 2*nRows-2;
				 for(int j=i;j<s.length();j=j+len){
					 ans[index++] = temp[j];
				 }
			 }else{
				 int len = 2*nRows-2-2*i;
				 int flag = 0;
				 int j = i;
				 while(j<s.length()){
					 ans[index++] = temp[j];
					 j = j+len;
					 if(flag==0){
						 len = 2*i;
						 flag = 1;
					 }else{
						 len = 2*nRows-2-2*i;
						 flag = 0;
					 }
				 }
			 }
		 }
		 
		 return new String(ans);
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.convert("AB", 1));
	}
}
