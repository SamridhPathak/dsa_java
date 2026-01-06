// Q: Find level order successor of a node
// Difficulty: Medium
// Approach: BFS + Deque
// Time Complexity: O(n)
// Space Complexity: O(n)


class Solution {
    public TreeNode findSuccessor(TreeNode root, int key) {

        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        while (!queue.isEmpty()) {
            
            TreeNode currentNode = queue.poll();

            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
            if (currentNode.val == key) {
                break;
            }
        }
        return queue.peek();
    }
}