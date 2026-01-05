// LeetCode 145 - Binary Tree Postorder Traversal
// Difficulty: Easy
// Approach: recursive DFS
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        postOrder(root, res);
        return res;
    }

    private void postOrder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }

        postOrder(node.left, res);
        postOrder(node.right, res);
        res.add(node.val);
    }
}