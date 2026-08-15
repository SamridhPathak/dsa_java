// LeetCode (540) - Single Element in a Sorted Array
// Difficulty: Medium
// Approach: Array is sorted and every element appears twice except one. Before the single element, pairs are at (even, odd) indices. After the single element, this pairing pattern shifts. Use binary search to find where this pattern breaks. Make mid even so mid and mid + 1 form a pair. If nums[mid] == nums[mid + 1] → pair is correct → single is on the right → start = mid + 2. Otherwise → pair is broken → single is on the left or at mid → end = mid. When start == end, nums[start] is the single element.
// Time Complexity: O(log N)
// Space Complexity: O(1)

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start +(end - start) / 2 ;

            if (mid % 2 == 1) {
                mid--;
            }

            if (nums[mid] == nums[mid + 1]) {
                start = mid + 2;
            } else {
                end = mid;
            }
        }
        return nums[start]; 
    }
}