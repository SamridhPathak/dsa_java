// LeetCode (18) - 4Sum 
// Difficulty: Medium
// Approach: Sort the array and use two nested loops to fix the first two numbers. Then, use the two pointers approach to find pairs that sum up to the target minus the sum of the fixed numbers. Skip duplicates to avoid repeating quadruplets in the result.
// Time Complexity: O(n^3), three nested loops and two pointers approach for the innermost loop
// Space Complexity: O(1) (excluding the space for the output list)

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        //fix 1st and 2nd
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; //skip duplicate
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; //skip duplicate

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum < target) left++;
                    else if (sum > target) right--;
                    else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;

                        //skip duplicates for left
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        //skip duplicates for right
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                }
            }
        }
        return result;
    }
}