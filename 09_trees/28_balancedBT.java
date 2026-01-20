// LeetCode 110 - Balanced Binary Tree
// Difficulty: Easy
// Approach: Recursion DFS
// Time Complexity: O(N) where N is the number of nodes in the binary tree 
// Space Complexity: O(H) where H is the height of the binary tree due to recursion stack

class Solution {
    public boolean isBalanced(TreeNode root) {
        int height = getHeight(root);
        if (height == -1) return false;
        return true;
    }
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //post order traversal
        int leftSubTreeHeight = getHeight(root.left);
        int rightSubTreeHeight = getHeight(root.right);

        if (leftSubTreeHeight == -1 || rightSubTreeHeight == -1) {
            return -1;
        }
        if (Math.abs(leftSubTreeHeight - rightSubTreeHeight) > 1) {
            return -1;
        }
        return 1 + Math.max(leftSubTreeHeight, rightSubTreeHeight);
    }
}