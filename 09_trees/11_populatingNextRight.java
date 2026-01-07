// LeetCode 116 -  Populating Next Right Pointers in Each Node
// Difficulty: Medium
// Approach: traverse using 'next' pointers, for each node connect its children (left→right and right→next.left)
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node levelStart = root;

        while (levelStart.left != null) {  //ensures to stop when leaf is reached

            Node curr = levelStart;  //'curr' will help to traverse horizontally
            while (curr != null) { //curr.next not used bcoz we will not reach last node at every lvl

                curr.left.next = curr.right; //connect left child to right child

                if (curr.next != null) { //if right node exists in same level, connect siblings- 
                    curr.right.next = curr.next.left; //- from diff prarents
                }

                curr = curr.next;  //move to next node in same level
            }
            levelStart = levelStart.left; //come down to leftmost node in next level

        }
        return root;
    }
}