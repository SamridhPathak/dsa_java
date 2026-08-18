// LeetCode (2529) - 
// Difficulty: Easy
// Approach: Since the array is sorted, use 2 Binary Searches to find the boundaries of negative and positive numbers. The first Binary Search finds the first index where nums[i] >= 0, so that index directly gives the negative count. The second Binary Search finds the first index where nums[i] > 0, so nums.length - index gives the positive count. Return the maximum of both counts. In the negative search, if nums[mid] < 0 move right, otherwise move left. In the positive search, if nums[mid] <= 0 move right, otherwise move left. Even though we are counting elements, Binary Search works because all negative numbers are together at the beginning and all positive numbers are together at the end due to the sorted array
// Time Complexity: O(log N)
// Space Complexity: O(1)

class Solution {
    public int maximumCount(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int negativeCount = searchNegative(nums, start, end);
        int positiveCount = searchPositive(nums, start, end);
        return Math.max(negativeCount, positiveCount);
    }
    private int searchNegative(int[] nums, int start, int end) {

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < 0) {
                start = mid + 1;
            } else if (nums[mid] >= 0) {
                end = mid - 1;
            }
        }
        return start;
    }
    private int searchPositive(int[] nums, int start, int end) {

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] <= 0) {
                start = mid + 1;
            } else if (nums[mid] > 0) {
                end = mid - 1;
            }
        }
        return nums.length - start;
    }
}