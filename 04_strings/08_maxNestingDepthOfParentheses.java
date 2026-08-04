// LeetCode (1614) - Maximum Nesting Depth of the Parentheses 
// Difficulty: Easy
// Approach: Stack 
// Time Complexity: O(n) - only one traversal of string
// Space Complexity: O(n) - for storing the stack

class Solution {
    public int maxDepth(String s) {
        Stack<Integer> stack = new Stack<>();
        int currDepth = 0;
        int maxDepth = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                currDepth++;
                maxDepth = Math.max(currDepth, maxDepth);
            }
            if (ch == ')') {
                currDepth--;
            }
        }
        return maxDepth;
    }
}