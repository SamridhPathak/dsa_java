// LeetCode (796) - Rotate String 
// Difficulty: Easy
// Approach: Concatenate s with itself and check if goal is a substring of the doubled string
// Time Complexity: O(n) - string concatenation and substring search
// Space Complexity: O(n) - for storing the doubled string

class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;

        String doubled = s + s;

        if (doubled.contains(goal)) {
            return true;
        }
        return false; 
    }
}