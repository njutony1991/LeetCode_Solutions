package TwoSum;
import java.util.*;
public class NewSolution {
    public int[] twoSum(int[] numbers, int target) {
    	HashMap<Integer,Integer> hash = new LinkedHashMap<Integer,Integer>();
        
        for(int i=0;i<numbers.length;i++)
        {   
        	if(hash.containsKey(target-numbers[i]))
        		return new int[]{hash.get(target-numbers[i])+1,i+1};
            hash.put(numbers[i], i);
        }
        throw new IllegalArgumentException("no solution");
    }
	public static void main(String[] args) {

	}

}
