class Solution {
    public int maxProfit(int[] prices) {
        int lowest = Integer.MAX_VALUE, highest = 0, maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for(; i < prices.length - 1 && prices[i] > prices[i + 1] || prices.length == i; i++);
            int low = prices[i];
            if (lowest > low) {
                lowest = low;
            }

            for (; i < prices.length - 1 && prices[i] < prices[i + 1] || prices.length == i; i++);
            int high = prices[i];
            if (highest < high) {
                highest = high;
            }

            int profit = high - lowest;
            if (maxProfit < profit) {
                maxProfit = profit;
            }
        }
        
        return maxProfit;
    }
}