// LeetCode 236 - Lowest Common Ancestor of a Binary Tree
// Difficulty: Medium
// Approach: Recursion DFS
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (root == p || root == q) { //if found in root only, no need to go down
            return root;
        }

        //otherwise go down, 
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {//means 1 item found in left, 1 in right 
            return root;                    //curr node is answer
        }

        return left == null ? right : left;
        //if left is null, means ans in right, otherwise ans in left
    }
}