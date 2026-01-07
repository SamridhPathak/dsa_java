// LeetCode 199 - Binary Tree Right Side View
// Difficulty: Medium
// Approach: BFS, Queue, add last node of each level to result list
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();

                if (i == levelSize - 1) {
                    result.add(currNode.val); //add the last value when loop runs for last time
                }

                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
        }
        return result;
    }
}