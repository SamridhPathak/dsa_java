// LeetCode (153) - Find Minimum in Rotated Sorted Array
// Difficulty: Medium
// Approach: Use binary search to find the rotation point (minimum). Compare nums[mid] with nums[end]:- nums[mid] > nums[end] → minimum is on the right → start = mid + 1. Otherwise → minimum is at mid or on the left → end = mid. When start == end, nums[start] is the minimum.
// Time Complexity: O(log n)
// Space Complexity: O(1)

class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }
}