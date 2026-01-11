// LeetCode 226 - Invert Binary Tree
// Difficulty: Easy
// Approach: DFS Recursion, Traverse the tree using DFS and swap the left and right child of every node to mirror the tree.
// Time Complexity: O(n)
// Space Complexity: O(log n) — due to recursion stack in a balanced BST

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}