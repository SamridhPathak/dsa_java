// LeetCode (1283) - 
// Difficulty: 
// Approach: We need to find the smallest divisor such that the sum of ceil(nums[i] / divisor) for all elements is <= threshold. Divisor range is from 1 to max(nums). Use Binary Search on the answer because as divisor increases, the sum either decreases or stays the same. For every mid, calculate the sum of all ceil(nums[i] / mid). If sum <= threshold, mid is a valid answer, so search for a smaller divisor. Else, mid is too small, so search for a larger divisor. Ceiling division can be done using Math.ceil((double) nums[i] / mid) or (nums[i] + mid - 1) / mid. At the end, start will be the smallest valid divisor. Binary Search: start = 1, end = max(nums). While start <= end, calculate mid = start + (end - start) / 2. Calculate the sum using ceil(nums[i] / mid). If sum <= threshold, set end = mid - 1. Else, set start = mid + 1. Return start.
// Time Complexity: O(log(max(nums)) * n)
// Space Complexity: O(1)

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = 0;
        for (int x : nums) {
            end = Math.max(end, x);
        } 

        while (start < end) {
            int mid = start + (end - start) / 2;
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += Math.ceil((double)nums[i]/mid);
            }
            if (sum <= threshold) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}