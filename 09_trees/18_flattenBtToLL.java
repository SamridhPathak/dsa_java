// LeetCode 114 - Flatten Binary Tree to Linked List
// Difficulty: Medium
// Approach: iterate through the tree, and whenever a node has a left child, you attach its left subtree in place of the right subtree by linking the rightmost node of the left subtree to the original right child.
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public void flatten(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                TreeNode temp = current.left;
                while(temp.right != null) {
                    temp = temp.right;
                }
                temp.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }
}