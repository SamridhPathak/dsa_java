// LeetCode (1408) - String Matching In An Array
// Difficulty: Easy
// Approach: run 2 ptrs ‘i’ and ‘j’ in the same arr for each word, if I == j thn cont., check if j consists of I, then add it to the answer.
// Time Complexity: O(n² × k) - k is the cost of contains() (depends on string lengths).
// Space Complexity: O(1) - (excluding the output list).

class Solution {
    public List<String> stringMatching(String[] words) {
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) continue;

                if (words[j].contains(words[i])) {
                    ans.add(words[i]);
                    break;
                }
            }
        }
        return ans;
    }
}