// LeetCode 101 -  Symmetric Tree
// Difficulty: Easy
// Approach: BFS with a queue to compare nodes pairwise in mirror order (left subtree vs right subtree) at every level.
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList <>();
        //we can neglect root node, no need
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            //check for false possibilities 
            if (left == null && right == null) {  //if null occurs in btw. at both subtrees
                continue;  //skip it
            }
            if (left == null || right == null) {  //if null occurs at one subtree
                return false; 
            }
            if (left.val != right.val) { //if values don't match
                return false; 
            }

            //traverse further now
            queue.add(left.left);  //
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }
}