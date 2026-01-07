// LeetCode 107 - Binary Tree Level Order Traversal II
// Difficulty: Medium
// Approach: BFS + Queue
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int levelSize = queue.size();
            List<Integer> currLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {

                TreeNode currNode = queue.poll();
                currLevel.add(currNode.val);

                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
            result.add(0, currLevel);  //0 bcoz we need to add from front ie. 0th index
        }
        return result;
    }
}