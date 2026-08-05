// LeetCode (2486) - Append Characters to String to Make Subsequence
// Difficulty: Medium
// Approach: Two Pointer - run ‘i’ and ‘j’ from 0 for s and t resp. if char. matches, then i++ j++, if nom match then only i++, return the remaining length of ‘t’
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int appendCharacters(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++; j++;
            } else {
                i++;
            }
        }
        return t.length() - j;
    }
}