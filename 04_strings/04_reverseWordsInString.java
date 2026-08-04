// LeetCode (151) - Reverse Words in a String 
// Difficulty: Medium
// Approach: split -> traverse backwards -> append to SB
// Time Complexity: O(n)+ O(n)+ O(n)= O(n) {split, traverse, append}
// Space Complexity: O(n)+ O(n)= O(n) {split array, SB}

class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder ans = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i] == "") continue;

            if (ans.length() > 0) {
                ans.append(" ");
            }

            ans.append(words[i]);
        }
        return ans.toString();
    }
}