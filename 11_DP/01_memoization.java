// Memoization: Top-Down Approach
// Time Complexity: O(n) - Each Fibonacci number is computed once and stored in the dp array.
// Space Complexity: O(n) + O(n) - recursive call stack and dp array.


class Solution {
    public int fib(int n, int[] dp) {
        if (n <= 1) return n;   //if base case return n

        if (dp[n] != -1) return dp[n];  //if already computed, return stored value

        dp[n] = fib(n - 1, dp) + fib(n - 2, dp);  //otherwise compute and store 
        return dp[n];
    }
}