// LeetCode (977) - Squares of a Sorted Array
// Difficulty: Easy
// Approach: Two Pointer, take 3 ptrs (i, j, k). i at first and j at last element of nums. k at last of result. if (nums[i]*nums[i] > nums[j]*nums[j]) then result[k] = nums[i]*nums[i] and i++, else result[k] = nums[j]*nums[j] and j--. at each step k--.
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        int k = result.length - 1;

        while (i <= j) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                result[k] = nums[i] * nums[i];
                i++;
                k--;
            } else {
                result[k] = nums[j] * nums[j];
                j--;
                k--;
            }
        }
        return result;
    }
}