package ExcelSheetColumnNumber;

public class Solution {

	
	public int titleToNumber(String s) {
	  int len = s.length();
	  int sum = 0;
	  for(int i = 0;i<=len-1;i++){
		  sum = sum*26+ (s.charAt(i)-'A'+1);
	  }
	  return sum;
	}
	public static void main(String[] args) {
		System.out.println(new Solution().titleToNumber("AC"));
	}

}
