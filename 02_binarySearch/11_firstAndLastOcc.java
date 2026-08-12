// LeetCode (34) - 
// Difficulty: Medium
// Approach: Use two binary searches — one to find the first occurrence by continuing left after finding the target, and one to find the last occurrence by continuing right after finding the target. If target is absent, ans remains -1. First → found target → go LEFT. Last → found target → go RIGHT.
// Time Complexity: O(log n)
// Space Complexity: O(1)

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        result[0] = first;
        result[1] = last;
        return result;
    }
    private int findFirst(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }
    private int findLast(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;
    }
}