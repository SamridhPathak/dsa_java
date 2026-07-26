// LeetCode (628) - Maximum Product of Three Numbers 
// Difficulty: Easy
// Approach: calculate the maximum product of three numbers in an array by finding the three largest numbers and the two smallest numbers. The maximum product can be obtained either by multiplying the three largest numbers or by multiplying the largest number with the two smallest numbers (in case of negative values). bcoz two negative numbers multiplied together give a positive product.
// Time Complexity: O(d) where d is the number of digits in the input array 
// Space Complexity: O(1)

class Solution {
    public int maximumProduct(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int secLargest = Integer.MIN_VALUE;
        int thirdLargest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        int secSmallest = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {

            //3 largest
            if (nums[i] >= largest) {
                thirdLargest = secLargest;
                secLargest = largest;
                largest = nums[i];
            } else if (nums[i] >= secLargest) {
                thirdLargest = secLargest;
                secLargest = nums[i];
            } else if (nums[i] >= thirdLargest) {
                thirdLargest = nums[i];
            }

            //2 smallest
            if (nums[i] <= smallest) {
                secSmallest = smallest;
                smallest = nums[i];
            } else if (nums[i] <= secSmallest) {
                secSmallest = nums[i];
            }
        } 
        return Math.max(largest * secSmallest * smallest, largest * secLargest * thirdLargest);
    }
}