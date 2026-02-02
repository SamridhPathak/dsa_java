// LeetCode 1877 - Minimize Maximum Pair Sum in Array
// Difficulty: Medium
// Approach: Two Pointers after Sorting
// Time Complexity: O(n log n)
// Space Complexity: O(1)

class Solution {
    public int minPairSum(int[] nums) {
        //sort array to balance the load to minimize the max pair sum
        //sorting helps us balance the load so that no single pair becomes heavy
        Arrays.sort(nums);
        int start = 0; //two pointers approach
        int end = nums.length - 1;
        int maxPairSum = 0;
        while (start < end) {
            int currentSum = nums[start] + nums[end];
            maxPairSum = Math.max(maxPairSum, currentSum);
            start++;
            end--;
        }
        return maxPairSum;
    }
}