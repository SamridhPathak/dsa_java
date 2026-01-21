// LeetCode 100 - Same Tree
// Difficulty: Easy
// Approach: Recursion (compare nodes of both trees)
// Time Complexity: O(N)
// Space Complexity: O(H) where H is the height of the tree due to recursion stack

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true; //both null, then true
        }
        if (p == null || q == null) {
            return false; //any1 null, then false
        }
        if (p.val != q.val) {
            return false;
        }
        boolean leftSubtree = isSameTree(p.left, q.left);
        boolean rightSubtree = isSameTree(p.right, q.right);

        //return leftSubtree && rightSubtree; *OR*
        if (leftSubtree == true && rightSubtree == true) {
            return true;
        }
        return false;
    }
}