// LeetCode 701 - Insert into a Binary Search Tree
// Difficulty: Medium
// Approach: Iterative traversal of the BST to find the correct position for the new value.
// Time Complexity: O(h), h is the height of the tree.
// Space Complexity: O(1) 

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) { //if empty tree, return val as root node
            return new TreeNode(val);
        }
        TreeNode curr = root;
        while (true) { // bcoz we will definitely find a place to insert (keep looping until insertion is done, then stop)
            if (curr.val <= val) {
                if (curr.right != null) {
                    curr = curr.right;
                } else{
                    curr.right = new TreeNode(val);
                    break;
                }
            } else {
                if (curr.left != null) {
                    curr = curr.left;
                } else {
                    curr.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
}