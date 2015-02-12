package FourSum;

/**
 * Created by tony on 15-2-8.
 */
import java.util.*;
public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        HashMap<Integer,List<Integer[]>> hm = new HashMap<Integer,List<Integer[]>>();
        List<List<Integer>> mainList = new ArrayList<List<Integer>>();
        int len = num.length;
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                int sum = num[i]+num[j];
                List<Integer[]> l = null;
                Integer[] x = new Integer[4];
                x[0] = num[i]; x[1] = i; x[2] = num[j]; x[3] = j;
                if(hm.containsKey(sum)){
                    l = hm.get(sum);
                    l.add(x);
                }else{
                    l = new ArrayList<Integer[]>();
                    l.add(x);
                    hm.put(sum,l);
                }
            }
        }

        Integer[] s =  hm.keySet().toArray(new Integer[hm.size()]);
        for(int k:s){
            if(hm.containsKey(k)){
                if(hm.containsKey(target-k)){
                    List<Integer[]> l = hm.get(target-k);
                    List<Integer[]> m = hm.get(k);
                    for(int i=0;i<l.size();i++){
                        Integer[] x = l.get(i);
                        for(int j=0;j<m.size();j++){
                            Integer[] y = m.get(j);
                            if(x[1] != y[1] && x[3] != y[3] && x[1] != y[3] && x[3] != y[1]) {
                                List<Integer> p = new ArrayList<Integer>();
                                p.add(x[0]); p.add(x[2]); p.add(y[0]); p.add(y[2]);
                                Collections.sort(p);
                                if(!mainList.contains(p))
                                    mainList.add(p);
                            }
                        }
                    }
                    hm.remove(k);
                    hm.remove(target - k);
                }
            }
        }

        return mainList;
    }
}
