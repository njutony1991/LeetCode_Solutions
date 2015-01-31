package TwoSum_III;
import java.util.*;
public class TwoSum {
	HashMap<Integer,Integer> map = new LinkedHashMap<Integer,Integer>();
	
	public void add(int number) {
		int count = map.containsKey(number)? map.get(number):0;
		map.put(number,count+1);
	}

	public boolean find(int value) {
		for(Map.Entry<Integer, Integer> entry: map.entrySet()){
			int num = entry.getKey();
			int temp = value-num;
			if(temp==num){
				if(entry.getValue()>=2) 
					return true;
			}
			else 
			if(map.containsKey(temp))
				    return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		TwoSum  sol = new TwoSum();
		sol.add(1);
		sol.add(5);
		sol.add(3);
		System.out.println(sol.find(4));
		System.out.println(sol.find(7));
		
	}

}
