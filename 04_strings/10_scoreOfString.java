// LeetCode (3110) - Score of a String 
// Difficulty: Easy
// Approach: take a var. sum = 0, find abs. diff. of two adj pair and store in sum, then return sum
// Time Complexity: O(n) - only one traversal of string
// Space Complexity: O(1) - constant space

class Solution {
    public int scoreOfString(String s) {
        int sum = 0;
        for (int i = 1; i < s.length(); i++) {
            sum += Math.abs(s.charAt(i - 1) - s.charAt(i));
        }
        return sum;
    }
}