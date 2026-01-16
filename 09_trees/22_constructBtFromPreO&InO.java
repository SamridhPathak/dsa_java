// LeetCode 105 - Construct Binary Tree from Preorder and Inorder Traversal
// Difficulty: Medium
// Approach: Use preorder to pick roots sequentially and inorder to divide left and right subtrees recursively.
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    private int preIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int left, int right) {
        if (left > right) return null;

        // Create root from preorder
        TreeNode root = new TreeNode(preorder[preIdx++]);

        // Find root index in inorder
        int inIdx = search(inorder, left, right, root.val);

        // Build left and right subtrees
        root.left = helper(preorder, inorder, left, inIdx - 1);
        root.right = helper(preorder, inorder, inIdx + 1, right);

        return root;
    }

    private int search(int[] inorder, int left, int right, int val) {
        for (int i = left; i <= right; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
