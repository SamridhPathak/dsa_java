// LeetCode 993 - Cousins in Binary Tree
// Difficulty: Easy
// Approach: BFS + Queue 
// Time Complexity: O(n)
// Space Complexity: O(k)

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int childCount = 0; //how many child found at each level
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            //check at same level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();
                int sameParentCount = 0; /*a node is parent to which childs,
                                           initializes to zero for every node on same level */

                if (currNode.left != null) {

                    if (currNode.left.val == x || currNode.left.val == y) {
                        sameParentCount++;
                        childCount++;
                    }
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {

                    if (currNode.right.val == x || currNode.right.val == y) {
                        sameParentCount++;
                        childCount++;
                    }
                    queue.offer(currNode.right);
                }
                if (sameParentCount == 2) { //means 2 child from same parent -> rule break
                    return false;
                }
            }
            if (childCount == 2) { //2 child from 2 diff parent
                return true;
            }
            if (childCount == 1) { //1 child found, another on diff lvl, rule break
                return false;
            }
        }
        return false;
    }
}