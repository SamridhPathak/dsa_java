// LeetCode (28) - First Index of First Occurrence in String (haystack and needle) 
// Difficulty: Easy
// Approach: For each position, first check whether the starting character matches. If it matches, extract a substring of the same length as needle using substring(i, i + needle.length()) and compare it with needle. If they are equal, return i. If no match is found, return -1
// Time Complexity: O(n*m)  {n = length of haystack, m = length of needle}
// Space Complexity: : O(m) {substring() creates a new string of length m} 

class Solution {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.substring(i, needle.length() + i).equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }
}