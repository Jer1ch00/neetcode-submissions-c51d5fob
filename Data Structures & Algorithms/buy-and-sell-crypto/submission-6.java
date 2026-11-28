class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;
        int minPrice = prices[0];
        int profit = Integer.MIN_VALUE;
        
       while(i<prices.length) {
            minPrice = Math.min(minPrice, prices[i]);
            profit = Math.max(profit, prices[i] - minPrice);
            i++;
       }

       return profit;
    }
}
