// LeetCode 108 -  Convert Sorted Array to Binary Search Tree
// Difficulty: Easy
// Approach: Use divide-and-conquer by picking the middle element of the sorted array as the root and recursively building left and right subtrees from the left and right halves to form a height-balanced BST.
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        return buildBST(nums, left, right); 
    }
    public TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left  = buildBST(nums, left, mid - 1);
        node.right = buildBST(nums, mid + 1, right);

        return node;
    }
}