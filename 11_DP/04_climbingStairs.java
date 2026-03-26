// LeetCode (70) - Climbing Stairs 
// Difficulty: Easy
// Approach: observe that the problem follows a Fibonacci pattern where the number of ways to reach step n depends on the previous two steps. use space optimization to store only the last two values and iterate to calculate the result.
// Time Complexity: O(n) 
// Space Complexity: O(1)

class Solution {
    public int climbStairs(int n) {

        //space optimization approach

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int prev2 = 1;
        int prev = 2;

        for (int i = 3; i <= n; i++) {
            int curr = prev2 + prev;
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}