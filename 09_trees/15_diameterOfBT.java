// LeetCode 543 -  Diameter of Binary Tree
// Difficulty: Easy
// Approach: For each node, calculate the height of left and right subtrees. The diameter through that node is the sum of these heights plus one (for the current node). Keep track of the maximum such diameter.
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root); //we will calculate diameter in another func. 
        return diameter - 1; //-1 bcoz we need edges, not nodes to calculate diameter
                             //edge is 1 less wrt. 2 nodes
    }
    public int height (TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        int dia = leftHeight + rightHeight + 1; //+1 bcoz curr node is also counted
        diameter = Math.max(diameter, dia); //update overall diameter

        return Math.max(leftHeight, rightHeight) + 1;
    }
}