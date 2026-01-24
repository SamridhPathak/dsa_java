// GFG - Boundary Traversal of Binary Tree 
// Difficulty: Medium
// Approach: Three separate functions to add left boundary, leaves and right boundary 
// Time Complexity: O(n)
// Space Complexity: O(h) where h is the height of the tree for recursion stack

class Solution {
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ArrayList<Integer> boundary = new ArrayList<>();
        
        if (root == null) return boundary;
        
        //add root only once at very first

        //not 'if (root.left == null && root.right == null)' bcoz we check if doesnt of both childs, but it may have only one child and we still need to add root, (add node if it is not leaf)
        if (!(root.left == null && root.right == null)) {
            boundary.add(root.data);
        }
        
        //add left boundary
        addLeftBoundary(root.left, boundary);
        
        //add leaves
        addLeaves(root, boundary);
        
        //add right boundary
        addRightBoundary(root.right, boundary);
        
        return boundary;
    }
    
    void addLeftBoundary(Node node, ArrayList<Integer> boundary) {
        Node curr = node;
        
        while (curr != null) {
            //add root/node only once at very first
            //same as above, add node if it is not leaf
            if (!(curr.left == null && curr.right == null)) {
                boundary.add(curr.data);
            }
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }
    
    void addLeaves(Node node, ArrayList<Integer> boundary) {
        if (node == null) return;
        
        if (node.left == null && node.right == null) {
            boundary.add(node.data);
        }
        
        addLeaves(node.left, boundary);
        addLeaves(node.right, boundary);
    }
    
    void addRightBoundary(Node node, ArrayList<Integer> boundary) {
        ArrayList<Integer> temp = new ArrayList<>();
        Node curr = node;
        
        while (curr != null) {
            //add root/node only once at very first
            //same as above, add node if it is not leaf
            if (!(curr.left == null && curr.right == null)) {
                temp.add(curr.data);
            }
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        //add in main list in reverse order
        for (int i = temp.size() - 1; i >= 0; i--) {
            boundary.add(temp.get(i));
        }
    }
}
