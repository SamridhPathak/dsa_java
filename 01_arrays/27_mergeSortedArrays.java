// LeetCode (88) - Merge Sorted Array
// Difficulty: Easy
// Approach: take 3 pointers, one for each array and one for the end of nums1. Compare the elements at the pointers and place the larger one at the end of nums1. Move the pointers accordingly until we have traversed both arrays. If there are leftovers in nums2, copy them to nums1.
// Time Complexity: O(m + n), we traverse both arrays at most once
// Space Complexity: O(1)

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; //last valid idx in nums1
        int j = n - 1; //last valid idx in nums2
        int k = m + n - 1; //last valid idx in nums1 including extra 0s

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        //if nums2 has leftovers, copy them to nums1
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}