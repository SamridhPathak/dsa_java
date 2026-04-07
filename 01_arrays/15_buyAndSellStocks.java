// LeetCode (121) - Best Time to Buy and Sell Stock
// Difficulty: Easy
// Approach: Track minimum so far, calculate profit at each step, keep maximum profit. 
// Time Complexity: O(n) 
// Space Complexity: O(1)

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        //edge case - no elements, 1 element
        if (n < 2) return 0; // more edge cases like dec. elems. or same elems.

        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            int profit = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
}