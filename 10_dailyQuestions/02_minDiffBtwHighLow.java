// LeetCode 1984 - Minimum Difference Between Highest and Lowest of K Scores
// Difficulty: Easy
// Approach: sort the array to bring closest elements together, then use sliding window to find minimum difference (size of window = k)
// Time Complexity: O(n log n) due to sorting
// Space Complexity: O(1)

class Solution {
    public int minimumDifference(int[] nums, int k) {
        //edge case
        if (k == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i <= n - k; i++) {
            int lowest = nums[i];
            int highest = nums[i + k - 1];
            int currDiff = highest - lowest;
            minDiff = Math.min(currDiff, minDiff);
        }
        return minDiff;
    }
}