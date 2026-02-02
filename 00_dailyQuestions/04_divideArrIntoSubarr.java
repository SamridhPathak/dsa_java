// LeetCode 3010 - Divide an Array Into Subarrays With Minimum Cost I
// Difficulty: Easy
// Approach: Find the two smallest elements in the array (excluding the first element) and add them to the first element.
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int minimumCost(int[] nums) {
        int firstCost = nums[0];

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++) {
            //agar current element ab tak ka sabse chhota mil gaya
            if (nums[i] < smallest) {
                //purana smallest ab secondSmallest ban jaayega
                secondSmallest = smallest;
                //current element naya smallest ban jaata hai
                smallest = nums[i];
            } else if (nums[i] < secondSmallest) {
                //agar current element smallest nahi hai
                //par secondSmallest se chhota hai
                secondSmallest = nums[i];
            }
        }

        int totalCost = firstCost + smallest + secondSmallest;
        return totalCost;
    }
}                       