// LeetCode 129 -  Sum Root to Leaf Numbers
// Difficulty: Medium
// Approach: Recursion DFS
// Time Complexity: O(N)
// Space Complexity: O(H) where H is the height of the tree.

class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    public int helper(TreeNode node, int sum) {
        if (node == null) return 0;

        sum = sum * 10 + node.val;

        if (node.left == null && node.right == null) {
            return sum;
        }

        return helper(node.left, sum) + helper(node.right, sum);
    }
}