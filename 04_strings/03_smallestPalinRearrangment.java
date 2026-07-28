// LeetCode (3517) - Smallest Palindromic Rearrangement I 
// Difficulty: Medium
// Approach: create a hashmap to count freq of each character, then create a left half of the palindrome by adding half of the freq of each character in lexicographical order, and if there is any odd freq character, add it to the middle of the palindrome, finally create the right half by reversing the left half and return the concatenation of left + middle + right.
// Time Complexity: O(n) + O(n) + O(n) = O(n)
// Space Complexity: HM stores at most 26 characters, so O(1) space complexity. O(n) bcoz of the StringBuilder left and right.

class Solution {
    public String smallestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) { //O(n)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        StringBuilder left = new StringBuilder();
        String middle = "";

        for (char ch = 'a'; ch <= 'z'; ch++) {  //O(n)
            int freq = map.getOrDefault(ch, 0);
            for (int i = 0; i < freq/2; i++) {  //O(n)
                left.append(ch);
            }
            if (freq % 2 == 1) { //no SB for mid bcoz it will always be atmost 1 character (or nothing)
                middle = String.valueOf(ch);
            }
        }
        StringBuilder right = new StringBuilder(left);
        right.reverse();

        return left + middle + right;
    }
}