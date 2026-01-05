// LeetCode 94 - Binary Tree Inorder Traversal
// Difficulty: Easy
// Approach: recursive DFS
// Time Complexity: O(n)
// Space Complexity: O(n)


class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        inorder(root, res);
        return res;        
    }

    private void inorder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }    
}