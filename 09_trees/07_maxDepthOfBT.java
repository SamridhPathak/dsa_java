// LeetCode 104 -  Maximum Depth of Binary Tree
// Difficulty: Easy
// Approach: BFS + Queue
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int maxDepth(TreeNode root) {
        
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
            count++;
        }
        return count;
    }
}


/*ALternate solution using DFS

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

*/