// LeetCode (283) - Move Zeroes 
// Difficulty: Easy
// Approach: move all no-zeroes to the left and then fill the rest of the array with zeroes.
// Time Complexity:  O(n)
// Space Complexity: O(1)

class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            } else {
                nums[j] = nums[i];
                j++;
            }
        }
        while (j < nums.length) {
            nums[j] = 0;
            j++;
        }
    }
}