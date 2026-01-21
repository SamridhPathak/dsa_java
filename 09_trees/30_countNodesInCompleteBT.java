// LeetCode 222 - Count Complete Tree Nodes
// Difficulty: Medium
// Approach: Recursive Height Comparison
// Time Complexity: O(log N)^2
// Space Complexity: O(log N)

class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = findLeftHeight(root);
        int rightHeight = findRightHeight(root);

        if (leftHeight == rightHeight) {
            return (int) Math.pow(2, leftHeight) - 1;
            //"2^h - 1" is formula to find nodes in complete BT
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
        //1 bcoz height of curr node
    }
    private int findLeftHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            node = node.left;
            height++;
        }
        return height;
    }
    private int findRightHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            node = node.right;
            height++;
        }
        return height;
    }
}