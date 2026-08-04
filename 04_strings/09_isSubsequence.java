// LeetCode (392) - Is Subsequence 
// Difficulty: Easy
// Approach: Two pointers
// Time Complexity: O(n) - only one traversal of string
// Space Complexity: O(1) - constant space

class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++; j++;
            } else {
                j++;
            }
        }
        return i == s.length();
    }
}