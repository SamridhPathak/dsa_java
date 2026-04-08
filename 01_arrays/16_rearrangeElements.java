// LeetCode (376) - Rearrange Array Elements by Sign
// Difficulty: Medium
// Approach: create ans array, even idx -> positive, odd idx -> negative, iterate through nums and fill ans accordingly
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int posIdx = 0;
        int negIdx = 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) { //negative 
                ans[negIdx] = nums[i];
                negIdx += 2;
            } else { //positive
                ans[posIdx] = nums[i];
                posIdx += 2;
            }
        }
        return ans;
    }
}