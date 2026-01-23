// LeetCode 653 - Two Sum IV - Input is a BST
// Difficulty: Easy
// Approach: inorder traversal + two pointer
// Time Complexity: O(N) for inorder traversal + O(N) for two pointer approach = O(N)
// Space Complexity: O(N) for the inorder list + O(H) for the recursion stack, where H is the height of the tree

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> inorder = new ArrayList<>();
        inOrderTraversal(root, inorder);
        //2 sum approach 
        int start = 0;
        int end = inorder.size() - 1;
        while (start < end) {
            int sum = inorder.get(start) + inorder.get(end);
            if (sum == k) {
                return true;
            }
            if (sum < k) {
                start++; //left shift forward
            } else {
                end--; //right shift backward
            }
        }
        return false;
    }
    public void inOrderTraversal(TreeNode root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }

        //inorder of bst is always sorted in ascending order
        inOrderTraversal(root.left, inorder);
        inorder.add(root.val);
        inOrderTraversal(root.right, inorder);
    }
}