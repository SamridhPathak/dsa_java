// LeetCode (213) - House Robber II 
// Difficulty: Medium 
// Approach: tabulation, we basically splitted the prob into 2 sub problems individually and solved it like prev prob
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n < 2) return nums[0];

        //create 2 new arrays
        int[] skippingFirstHouse =  new int[n - 1];
        int[] skippingLastHouse =  new int[n - 1];

        for (int i = 0; i < n - 1; i++) {
            skippingFirstHouse[i] = nums[i];
            skippingLastHouse[i] = nums[i + 1];
        }

        //get loot from both cases (we basically splitted the prob into 2 sub problems individually and solved it like prev prob)
        int lootSkipFirst = robHelper(skippingFirstHouse);
        int lootSkipLast = robHelper(skippingLastHouse);

        //return max of 2 loots
        return Math.max(lootSkipFirst, lootSkipLast);
    }

    private int robHelper(int[] nums) {
        if (nums.length < 2) return nums[0];

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }
}

/*

optimized space complexity solution:

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        // Case 1: skip last house
        int case1 = robHelper(nums, 0, n - 2);

        // Case 2: skip first house
        int case2 = robHelper(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    private int robHelper(int[] nums, int start, int end) {
        int prev2 = 0; // dp[i-2]
        int prev = 0;  // dp[i-1]

        for (int i = start; i <= end; i++) {
            int curr = Math.max(prev2 + nums[i], prev);
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}

*/