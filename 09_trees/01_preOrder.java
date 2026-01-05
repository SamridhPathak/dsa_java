// LeetCode 144 - Binary Tree Preorder Traversal
// Difficulty: Easy
// Approach: recursive DFS
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        preOrder(root, res);
        return res;
    }
    private void preOrder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        preOrder(node.left, res);
        preOrder(node.right, res);
    }
}