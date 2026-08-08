// LeetCode (35) - Search Insert Position
// Difficulty: Easy
// Approach: Binary Search, Similar to lower bound, return mid if found, else search left or right. if target found then return the index, if not found then return the start index bcoz when the loop ends, start will be pointing to the index where the element should be inserted.
// Time Complexity: O(log n)
// Space Complexity: O(1)

class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}