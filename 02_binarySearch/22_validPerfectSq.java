// LeetCode (367) - Valid Perfect Square
// Difficulty: Easy
// Approach: Perfect Square can be solved using Binary Search by searching for an integer mid such that mid * mid == num. Start with start = 1 and end = num / 2 for num > 1, with a separate case for num == 1. If mid * mid == num, return true. If mid * mid > num, search left by end = mid - 1. If mid * mid < num, search right by start = mid + 1. Use long for mid and mid * mid to avoid integer overflow because num can be as large as 2³¹ - 1. I initially used Math.sqrt(num), which was wrong because the question explicitly prohibits sqrt. My Binary Search logic was correct, but I had to optimize the search range and handle the long type properly
// Time Complexity: O(log num)
// Space Complexity: O(1)

class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        long start = 1;
        long end = num / 2;

        while (start <= end) {
            long mid = start + (end - start) / 2;

            if (mid * mid == num) {
                return true;
            } else if (mid * mid > num) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}