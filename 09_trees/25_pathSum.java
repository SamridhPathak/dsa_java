// LeetCode 112 -  Path Sum
// Difficulty: Easy
// Approach: Recursion DFS
// Time Complexity: O(N)
// Space Complexity: O(H) where H is the height of the tree

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        //if this is a leaf node
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}