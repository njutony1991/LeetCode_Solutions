package GasStation;

/**
 * Created by tony on 15-4-21.
 */
public class NewSolutionII {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length==0||cost.length==0)
            return -1;
        int total = 0,sum = 0,start = 0;
        for(int i =0;i<gas.length;i++){
            total += (gas[i]-cost[i]);
            if(sum<0){
                sum = gas[i]-cost[i];
                start = i;
            }else
                sum += gas[i]-cost[i];
        }
        return total < 0? -1:start;
    }
}
