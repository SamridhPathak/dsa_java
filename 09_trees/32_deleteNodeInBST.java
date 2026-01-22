// LeetCode 450- Delete Node in a BST
// Difficulty: Medium
// Approach: We iteratively search for the node to delete in the BST, then restructure the tree using a helper function by attaching the right subtree to the rightmost node of the left subtree.
// Time Complexity: O(h) where h is the height of the tree 
// Space Complexity: O(H)

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            return helper(root);
        }

        TreeNode dummy = root;

        while (root != null) {
            if (root.val > key) {
                if (root.left != null && root.left.val == key) {
                    root.left = helper(root.left);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                if (root.right != null && root.right.val == key) {
                    root.right = helper(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return dummy;
    }

    public TreeNode helper(TreeNode root) {
        if (root.left == null) {
            return root.right;
        } 
        else if (root.right == null) {
            return root.left;
        } 
        else {
            TreeNode rightChild = root.right;
            TreeNode lastRight = findLastRight(root.left);
            lastRight.right = rightChild;
            return root.left;
        }
    }

    public TreeNode findLastRight(TreeNode root) {
        if (root.right == null) {
            return root;
        }
        return findLastRight(root.right);
    }
}