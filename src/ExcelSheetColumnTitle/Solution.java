package ExcelSheetColumnTitle;

public class Solution {
	   public String convertToTitle(int n) {
		   StringBuffer buf = new StringBuffer();
		   do
		   {
			 int c = n%26;
			 if(c==0)
				buf.append("Z");
			 else{
				int a = 'A'+(c-1);
				char chara = (char)a;
				buf.append(chara);
			 }
			 n = n/26;
			 if(c==0)
				 n--;
		   } while(n!=0);
		   
		   return buf.reverse().toString();
	   }
	   public static void main(String[] args){
		  System.out.println(new Solution().convertToTitle(53));
	   }
}
