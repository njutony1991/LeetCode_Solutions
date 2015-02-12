package Three_Sum;
import java.util.*;
public class Solution{
	class Triplets{
		int a,b,c;
		Triplets(int a,int b,int c){
			this.a = a;
			this.b = b;
			this.c = c;
		}
		public int hashCode(){
			return this.a*100+this.b*10+this.c;
		}
		public boolean equals(Object o){
			Triplets tri = (Triplets)o;
			return (tri.a==this.a && tri.b==this.b && tri.c==this.c);
		}
	}
	
	
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        LinkedList<List<Integer>> ans = new LinkedList<List<Integer>>();
        HashSet<Triplets> set = new HashSet<Triplets>();
        for(int i = 0;i<num.length;i++){
        	for(int j=i+1;j<num.length;j++){
        		int index=Arrays.binarySearch(num, j+1, num.length, -num[i]-num[j]);
        		if(index>=0){
        			Triplets tri = new Triplets(num[i],num[j],num[index]);
        			if(!set.contains(tri)){
        				set.add(tri);
        				List<Integer> temp = new LinkedList<Integer>();
        				temp.add(num[i]);
        				temp.add(num[j]);
        				temp.add(num[index]);
        				ans.add(temp);
        			}
        		}
        	}
        }
    	return ans;
    }
	public static void main(String[] args) {
		int[] num = new int[]{-1,0,1,2,-1,-4};
		List<List<Integer>> ans = new Solution().threeSum(num);
		for(List<Integer> list:ans){
			for(Integer i:list)
				System.out.print(i+" ");
			System.out.println("");
		}
	}
	
}
