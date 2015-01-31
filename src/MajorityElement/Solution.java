package MajorityElement;
import java.util.*;
public class Solution {
	  
	  public int majorityElement(int[] num) {
		  HashMap<Integer,Integer> element_num = new HashMap<Integer,Integer>();
		  for(int i=0;i<num.length;i++)
			  if(element_num.containsKey(num[i]))
				  element_num.put(num[i], element_num.get(num[i])+1);
			  else
				  element_num.put(num[i], 0);
		  
		 int ans = -1;
		 Iterator<Map.Entry<Integer, Integer>> iter = element_num.entrySet().iterator();
		 while(iter.hasNext()){
			 Map.Entry<Integer, Integer> entry = iter.next();
			 if(entry.getValue()>=num.length/2){
				 ans=entry.getKey();
				 break;
			 }
		 }

		  return ans;
	  }
}
