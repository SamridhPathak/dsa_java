// LeetCode (198) - House Robber 
// Difficulty: Medium
// Approach: tabulation, rob this house and add to loot of house n-2, or skip this house and take loot of n-1, take max of both, return last bcoz Because dp[i] stores max loot till index i.
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int rob(int[] nums) {
        //if only 1 element, return
        if (nums.length < 2) return nums[0];

        int[] dp = new int[nums.length];

        //memoize max. loot at first 2 indexes
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        //core logic : totalLoot at house(n)=MAX(totalLoot[n-2]+totalLoot[n], totalLoot[n-1])

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        //return last index as it would contain max loot
        return dp[nums.length - 1];
    }
}

/*
optimal solution with O(1) space complexity

int prev2 = nums[0];
int prev = Math.max(nums[0], nums[1]);

for (int i = 2; i < nums.length; i++) {
    int curr = Math.max(prev2 + nums[i], prev);
    prev2 = prev;
    prev = curr;
}

return prev;

*/