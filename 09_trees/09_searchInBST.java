// LeetCode 700 - Search in a Binary Search Tree
// Difficulty: Easy
// Approach: Traverse the BST from the root, moving left or right based on value comparison, and return the node when the target value is found.
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        
        while (root != null) {
            if (root.val == val) {
                return root;
            } else if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }
}