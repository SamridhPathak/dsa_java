// LeetCode (69) - Sqrt(x)
// Difficulty: Medium
// Approach: Sqrt(x) can be solved using Binary Search by finding the largest integer mid such that mid * mid <= x. Start with start = 1 and end = x / 2 for x > 1, and handle x == 0 and x == 1 separately. If mid * mid == x, return mid because the exact square root is found. If mid * mid < x, store mid in ans because it can be a possible answer, then search right for a larger valid value. If mid * mid > x, search left because mid is too large. After the loop ends, return ans because it stores the largest integer whose square is less than or equal to x. Use long for mid and mid * mid to avoid integer overflow. I initially forgot to maintain the best possible answer when mid * mid < x and also missed the x = 0 edge case. This is similar to Valid Perfect Square, but here we need an ans variable because the exact square root may not exist.
// Time Complexity: O(log x)
// Space Complexity: O(1)

class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        long start = 1;
        long end = x/2;
        long ans = 0;

        while (start <= end) {
            long mid = start + (end - start) / 2;

            if (mid * mid == x) {
                return (int)mid;
            } else if (mid * mid <= x) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return (int)ans;
    }
}