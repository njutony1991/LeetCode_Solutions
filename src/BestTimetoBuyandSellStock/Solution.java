package BestTimetoBuyandSellStock;


public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0)
            return 0;
        int low = prices[0];
        int ans = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<low)
                low = prices[i];
            else if(prices[i]-low>ans)
                ans = prices[i]-low;
        }
        return ans;
    }
}
