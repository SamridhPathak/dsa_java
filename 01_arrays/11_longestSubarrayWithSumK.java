// GFG  - Longest Subarray with Sum K
// Difficulty: Medium
// Approach: Two Pointer/Sliding Window - increase right pointer and add to sum, if sum > k, then increase left pointer and subtract from sum, if sum == k, then update max length.
// Time Complexity: O(N)
// Space Complexity: O(1)

//NOTE: This solution assumes that all elements in the array are non-negative. If there are negative numbers, then we will use prefix sum + HashMap approach.

class Solution {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 0;
        int sum = nums[0];
        int left = 0;
        int right = 0;
        
        while (right < n) {
            while (left <= right && sum > k) {
                sum = sum - nums[left];
                left++;
            }
            
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            
            right++;
            if (right < n) {
                sum = sum + nums[right];
            }
        }
        return maxLen;
    }
}