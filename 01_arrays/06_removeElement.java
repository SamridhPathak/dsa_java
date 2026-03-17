// LeetCode (27) - Remove Element 
// Difficulty: Easy 
// Approach: Two Pointers, If nums[i] ≠ val then we place it at k and increment k. If nums[i] == val then Skip it (do nothing)
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}