// LeetCode (81) - Search in Rotated Sorted Array II
// Difficulty: Medium
// Approach: Modified Binary Search. At every step, check mid. If start, mid, and end have the same value, we cannot determine which half is sorted, so shrink both sides (start++, end--) and use continue to recalculate mid. Otherwise, identify the sorted half and check whether the target lies in that range. If found → true, otherwise after the loop → false.
// Time Complexity: O(logN) in average case, O(N) in worst case (when all elements are same)
// Space Complexity: O(1)

class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return true;
            }
            
            //if s,m,e are same (duplicates), we need to shrink
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
                continue;
            }

            if(nums[start] <= nums[mid]) { //left sorted
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else { //right sorted
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}