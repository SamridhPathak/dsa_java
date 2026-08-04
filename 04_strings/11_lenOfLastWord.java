// LeetCode (58) - Length of Last Word 
// Difficulty: Easy
// Approach: take pointer ‘i’ and start from end of the string, skip spaces, when char is encountered, count++, then return count
// Time Complexity: O(n) - only one traversal of string
// Space Complexity: O(1) - constant space

class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        while (i >= 0 && s.charAt(i) != ' ') {
            count++;
            i--;
        }
        return count;
    }
}