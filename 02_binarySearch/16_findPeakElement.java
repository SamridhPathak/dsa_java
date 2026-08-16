// LeetCode (162) - Find Peak Element
// Difficulty: Medium
// Approach: Even though the array is unsorted, Binary Search can be applied because we can use the slope between nums[mid] and nums[mid + 1] to eliminate half of the search space. If nums[mid] < nums[mid + 1], we are going uphill, so a peak must exist on the right side and move start = mid + 1. Otherwise, we are going downhill, so a peak exists at mid or on the left side and move end = mid. When start == end, that index is a peak element, so return start.
// Time Complexity: O(log n)
// Space Complexity: O(1)

class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}