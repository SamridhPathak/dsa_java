// GFG - Frog Jump
// Difficulty: Medium
// Approach: Memoization 
// Time Complexity: O(N)
// Space Complexity: O(N) + O(N) = O(N) {for recursion stack and dp array}

class Solution {
    int minCost(int[] height) {
        // empty array
        if (height == null || height.length == 0) return 0;
        
        int n = height.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);  // -1 indicates the uncomputed states
        
        //start from last index
        return solve(n - 1, height, dp);
    }
    
    private int solve(int idx, int[] height, int[] dp) {
        // if at first stone, cost is 0
        if (idx == 0) return 0;
        
        if (dp[idx] != -1) return dp[idx]; // return computed solution (if computed)
        
        //cost when jumping from previous stone
        int jumpOne = solve(idx - 1, height, dp) + Math.abs(height[idx] - height[idx - 1]);
        
        
        //initialize jumpTwo with large value bcoz not always going to happen
        int jumpTwo = Integer.MAX_VALUE;
        
        
        //cost when jumping from two stones back (ind - 2) (if possible)
        if (idx > 1) {
            jumpTwo = solve(idx - 2, height, dp) + Math.abs(height[idx] - height[idx - 2]);
            
        }
        
        // memoize and return the minimum of the two choices
        dp[idx] = Math.min(jumpOne, jumpTwo);
        
        return dp[idx];
    }
}