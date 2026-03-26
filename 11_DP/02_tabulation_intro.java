// Tabulation: Bottom-Up Approach
// Time Complexity: O(n)
// Space Complexity: O(n) (dp array)


class Solution {
    public int fib(int n) {
        if (n <= 1) return n;  //if n is 0 or 1, return n

        int[] dp = new int[n + 1];  //reate dp array

        dp[0] = 0;  //base cases
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {  //fill dp array iteratively
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];  //return the final answer
    }
}