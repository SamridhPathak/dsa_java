// LeetCode (189) - Rotate Array 
// Difficulty: Medium
// Approach: Reverse the entire array, then reverse the first 'k' elements and then reverse the remaining 'n-k' elements. This will effectively rotate the array to the right by 'k' steps. Use 'Reverse Technique' whenever you see 'rotate array', 'in-place', 'O(1) space' in the problem statement.
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        //normalize 'k'
        k = k % n; //handle edge case, what if k > n
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}