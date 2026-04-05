// LeetCode (337) - House Robber III 
// Difficulty: Medium
// Approach: dfs (post-order traversal), for each node, we have two options: loot or skip. If we loot, we can't loot its children, but we can loot its grandchildren. If we skip, we can loot its children. We will return an array of two elements for each node: the maximum amount of money we can get if we loot this node and the maximum amount of money we can get if we skip this node. Finally, we will return the maximum of these two values for the root node.
// Time Complexity: O(n)
// Space Complexity: O(h) where h is the height of the tree

class Solution {
    public int rob(TreeNode root) {
        int[] options = travel(root);
        return Math.max(options[0], options[1]);
    }
    private int[] travel(TreeNode root) {
        if (root == null) return new int[2];

        int[] leftNodeChoices = travel(root.left);
        int[] rightNodeChoices = travel(root.right);
        int[] options = new int[2];

        //store value if looted in [0]
        options[0] = root.val + leftNodeChoices[1] + rightNodeChoices[1];

        //store value if skipped in [1]
        options[1] = Math.max(leftNodeChoices[0], leftNodeChoices[1]) + Math.max(rightNodeChoices[0], rightNodeChoices[1]);

        return options;
    }
}