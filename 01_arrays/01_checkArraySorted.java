// LeetCode 1752 - Check if Array Is Sorted and Rotated
// Difficulty: Easy
// Approach: Count the number of breaks in the sorted order
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public boolean check(int[] nums) {
        int countBreak = 0;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            // Compare current element with next element
            // (i + 1) % n is used to compare last with first
            if (nums[i] > nums[(i + 1) % n]) {
                countBreak++;
            }
        }
        if (countBreak > 1) return false;
        return true;
    }
}