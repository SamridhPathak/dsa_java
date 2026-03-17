// LeetCode (242) - Valid Anagram
// Difficulty: Easy
// Approach: Array for counting characters. Increment count for characters in string s and decrement for characters in string t. Finally, check if all counts are zero.
// Time Complexity: O(n)
// Space Complexity: O(1) - since the array size is fixed at 26

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            count[idx]++;
        }

        for (char c : t.toCharArray()) {
            int idx = c - 'a';
            count[idx]--;
        }

        for (int val : count) {
            if (val != 0) return false;
        }
        return true;
    }
}