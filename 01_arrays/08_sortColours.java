// LeetCode (75) - Sort Colors 
// Difficulty: Medium 
// Approach: partition the array into three regions using low, mid, and high pointers and place 0s at the beginning, 2s at the end, and let 1s stay in the middle.
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}