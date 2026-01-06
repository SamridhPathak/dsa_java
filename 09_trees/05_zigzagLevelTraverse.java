// LeetCode 103 -  Binary Tree Zigzag Level Order Traversal
// Difficulty: Medium
// Approach: BFS + Queue
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);

        boolean reverse = false;

        while (!deque.isEmpty()) {
            int levelSize = deque.size();
            List<Integer> currLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {

                if (!reverse) {

                    TreeNode currNode = deque.pollFirst();
                    currLevel.add(currNode.val);
                    if (currNode.left != null) {
                        deque.addLast(currNode.left);
                    }
                    if (currNode.right != null) {
                        deque.addLast(currNode.right);
                    }

                } else {

                    TreeNode currNode = deque.pollLast();
                    currLevel.add(currNode.val);
                
                    if (currNode.right != null) {
                        deque.addFirst(currNode.right);
                    }
                    if (currNode.left != null) {
                        deque.addFirst(currNode.left);
                    }

                }
            }
            reverse = !reverse;
            result.add(currLevel);
        }
        return result;
    }
}