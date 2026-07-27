// LeetCode (1464) - Maximum Product of Two Elements in an Array
// Difficulty: Easy
// Approach: traverse the array, calculte the largest and second largest number, then return the product of (largest - 1) * (second largest - 1)
// Time Complexity: o(n) 
// Space Complexity: O(1)

class Solution {
    public int maxProduct(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int secLargest = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= largest) {
                secLargest = largest;
                largest = nums[i];
            } else if (nums[i] >= secLargest) {
                secLargest = nums[i];
            }
        }
        return (largest - 1) * (secLargest - 1);
    }
}