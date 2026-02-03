// LeetCode 3637 - Trionic Array
// Difficulty: Easy 
// Approach: traverse the array and find breakpoints for increasing, decreasing and again increasing sequences.  
// Time Complexity: O(n) 
// Space Complexity: O(1) 

class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;

        int i = 0;
        //increasing
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }
        if (i == 0) return false; //no increase

        //decreasing
        int decStart = i;
        while (i + 1 < n && nums[i] > nums[i + 1]) {
            i++;
        }
        if (i == decStart) return false; //no decrease

        //again increase
        int incStart = i;
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }
        if (i == incStart) return false;

        return i == n - 1;
    }
}