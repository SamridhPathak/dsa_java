// GFG - Most Frequent Character
// Difficulty: Easy
// Approach: frequency array
// Time Complexity: O(n) {for loop to update array}
// Space Complexity: O(1) {fixed size array}

class Solution {
    public static char getMaxOccuringChar(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++; //idx is calculated using ASCII val of each char
        }                     // converting char to idx
        
        int max = 0;
        char ans = 'a';
        
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > max) {
                max = freq[i];
                ans = (char)(i + 'a'); // converting idx to char
            }
        }
        return ans;
    }
}