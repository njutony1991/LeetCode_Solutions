package GasStation;
import java.util.*;
/**
 * Created by tony on 15-4-21.
 */
public class NewSolution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length!=cost.length)
            return -1;
        if(gas.length==0)
            return -1;

        int tmax = gas[0] - cost[0],max = gas[0] - cost[0];
        int tmin = gas[0] - cost[0],min = gas[0] - cost[0];
        int diff = 0,total = 0;
        int start = 0,startmax = 0,endmin = 0;
        for(int i=0;i<gas.length;i++){
            diff = gas[i] - cost[i];
            total += diff;

            if(max<0){
                max = diff;
                startmax = i;  //用来存储当前序列的起点
            }else
                max += diff;

            if(max>tmax){
                tmax = max;
                start = startmax;  //start用来存储最大序列的起点
            }

            if(min>0)
                min = diff;
            else
                min += diff;
            if(min < tmin){
                tmin = min;
                endmin = i;   //endmin用来存储最小序列的末尾点
            }
        }
        return total < 0 ? -1:(tmax >= (total-tmin) ? start:(endmin+1)%gas.length);
    }

    public static void main(String[] args) {

    }
}
