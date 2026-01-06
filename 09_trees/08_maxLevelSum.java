// LeetCode 1161 - Maximum Level Sum of a Binary Tree
// Difficulty: Medium
// Approach: BFS + Queue
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int maxLevelSum(TreeNode root) {
        
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int maxSum = Integer.MIN_VALUE;  //node can be negative, we took least val. possible
        int currLevel = 1;
        int answerLevel = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int levelSum = 0;

            for (int i = 0; i < levelSize; i++) {

                TreeNode currNode = queue.poll();
                levelSum = levelSum + currNode.val;

                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
            if (levelSum > maxSum) {
                maxSum = levelSum;
                answerLevel = currLevel;
            }
            currLevel += 1;
        } 
        return answerLevel;
    }
}