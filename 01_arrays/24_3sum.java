// LeetCode (15) - 3Sum
// Difficulty: Medium
// Approach: Sort the array and use 2 pointers to find pairs that sum to the negative of the fixed element. Skip duplicates to avoid repeating triplets in the result.
// Time Complexity: O(n^2) - O(nlogn) for sorting and O(n^2) for 2pt traversal
// Space Complexity: O(1)

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); //sort to use 2pt, duplicate removal, optimization

        for (int i = 0; i < nums.length; i++) {
            //optimize: break if we find positive num bcoz array is sorted and we couldnt find triplet on right then
            if (nums[i] > 0) break;

            //skip duplicate
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1; //start just after fixed element
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum < 0) left++;
                else if (sum > 0) right--;
                else {
                    //creates a list of 3 integers
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
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
        return result;
    }
}