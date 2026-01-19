// LeetCode 662 - Maximum Width of Binary Tree
// Difficulty: Medium
// Approach: Level Order Traversal with Indexing (normalization to avoid overflow)
// Time Complexity: O(N) where N is the number of nodes in the binary tree 
// Space Complexity: O(N) where N is the number of nodes in the binary tree 

class Solution {

    static class Pair {
        TreeNode node;
        long idx;

        Pair(TreeNode node, long idx) {
            this.node = node;
            this.idx = idx;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        int maxWidth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            long minIdx = queue.peek().idx;   // leftmost index

            long first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair curr = queue.poll();
                long idx = curr.idx - minIdx; // normalize - subtract the leftmost index of a level from all indices of that level
                                              // so that every lvl start from 0 to avoid overflow
                if (i == 0) {
                    first = idx;
                }
                if (i == size - 1) {
                    last = idx;
                }

                if (curr.node.left != null) {
                    queue.offer(new Pair(curr.node.left, 2 * idx + 1));
                }
                if (curr.node.right != null) {
                    queue.offer(new Pair(curr.node.right, 2 * idx + 2));
                }
            }

            maxWidth = Math.max(maxWidth, (int)(last - first + 1));
        }

        return maxWidth;
    }
}
