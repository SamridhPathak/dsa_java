// LeetCode 235 - Lowest Common Ancestor of a Binary Search Tree
// Difficulty: Medium
// Approach: Iterative traversal of the BST to find the correct position for the new value.
// Time Complexity: O(h), h is the height of the tree
// Space Complexity: O(H), H is the height of the tree due to recursion stack

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);

        if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);

        return root; //split point (also if p==root || q==root) 
        //The first split point encountered while moving down the BST is the Lowest Common Ancestor, no matter how deep we could go further.
    }
}