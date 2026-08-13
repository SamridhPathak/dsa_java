// LeetCode (33) - Search in Rotated Sorted Array
// Difficulty: Medium
// Approach: At every iteration, identify which half is sorted. Check whether the target lies within that sorted half; if yes, search there, otherwise search the other half.
// Time Complexity: O(log n)
// Space Complexity: O(1)

class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        // int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[start] <= nums[mid]) { //left sorted
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else { //right sorted
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}