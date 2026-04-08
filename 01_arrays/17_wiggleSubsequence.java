// LeetCode (2149) - Wiggle Subsequence
// Difficulty: Medium
// Approach: only when up, down, up, down pattern is followed, we can increase the count. that is what wiggle is. so we can keep track of the previous difference and current difference, if they are in opposite direction, we can increase the count.
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;
        int count = 1;
        int prevDiff = 0;
        for (int i = 1; i < nums.length; i++) {
            int currDiff = nums[i] - nums[i - 1];
            if (currDiff > 0 && prevDiff <= 0) {
                count += 1;
                prevDiff = currDiff;
            } else if (currDiff < 0 && prevDiff >= 0){
                count += 1;
                prevDiff = currDiff;
            }
        }
        return count;
    }
}