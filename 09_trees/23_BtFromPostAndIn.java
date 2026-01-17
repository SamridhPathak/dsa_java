// LeetCode 106 -  Construct Binary Tree from Inorder and Postorder Traversal
// Difficulty: Medium
// Approach: Recursive approach with postorder traversal
// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {
    private int postIdx; 
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIdx = postorder.length - 1;
        return helper(inorder, postorder, 0, inorder.length - 1);
    }
    private TreeNode helper(int[] inorder, int[] postorder, int inLeft, int inRight) {
        if (inLeft > inRight) return null;

        TreeNode root = new TreeNode(postorder[postIdx--]);

        int rootIdx = findIdx(inorder, inLeft, inRight, root.val);

        root.right = helper(inorder, postorder, rootIdx + 1, inRight);
        root.left  = helper(inorder, postorder, inLeft, rootIdx - 1);

        return root;
    }
    private int findIdx(int[] inorder, int inLeft, int inRight, int val) {
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
}