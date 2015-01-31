package GasStation;
public class Solution {
	public int canCompleteCircuit(int[] gas,int[] cost){
		int[] residual = new int[gas.length];
		for(int i=0;i<gas.length;i++)
			residual[i] = gas[i]-cost[i];
		
		int ans = -1;
		for(int i=0;i<residual.length;i++){
			int sum =0;
			int index = i;
			boolean flag = true;
			for(int j=0;j<residual.length;j++){
				sum+=residual[index];
				index = (index+1)%residual.length;
				if(sum<0){
					flag = false;
					break;
				}
			}
			if(flag==true)
			{	ans = i;
				break;
			}
		}
		return ans;
	}
}
