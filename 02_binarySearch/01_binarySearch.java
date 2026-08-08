// LeetCode (704) - Binary Search
// Difficulty: Easy
// Approach: recursive approach
// Time Complexity: O(log n)
// Space Complexity: O(1)

class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }
    private int binarySearch(int[] nums, int target, int start, int end) {
        if (start > end) return -1;

        int mid = start + (end - start) / 2;

        if (nums[mid] == target) {
            return mid;
        }

        if (target > nums[mid]) {
            return binarySearch(nums, target, mid + 1, end);
        } else {
            return binarySearch(nums, target, start, mid - 1);
        }
    }
}