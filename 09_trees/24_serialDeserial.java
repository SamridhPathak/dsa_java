// LeetCode 297 -  Serialize and Deserialize Binary Tree
// Difficulty: Hard 
// Time Complexity: O(N)
// Space Complexity: O(N)
// Approach: 
/* 1. Serialize: 
Check if the tree is empty: If the root is null, return an empty string.
Initialise an empty string to store the serialised binary tree.
Use a queue for level-order traversal: initialise a queue and enqueue the root.
Within the level-order traversal loop:
Dequeue a node from the queue.
If the node is null, append "#" to the string.
If the node is not null, append its data value along with a comma (",") as a delimiter. Enqueue its left and right children.
Return the final string containing the serialised representation of the tree.

2. Deserialize:
Check if the serialised data is empty: If it is, return null.
Tokenize the serialised data using a stringstream with comma as a delimiter.
Read the first token and create the root node with this value.
Use a queue for level-order traversal: initialise a queue and enqueue the root.
Within the level-order traversal loop:
Dequeue a node from the queue.
Read the value for the left child.
If it is "#", set the left child to null. Otherwise, create a new node and set it as the left child.
Read the next value for the right child.
If it is "#", set the right child to null. Otherwise, create a new node and set it as the right child.
Enqueue the left and right children into the queue for further traversal.
Return the reconstructed root of the tree.
*/


public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder s = new StringBuilder(); //to store serialized result
        Queue<TreeNode> q = new LinkedList<>(); //to store nodes during level-order traversal
        q.offer(root);

        while(!q.isEmpty()) {
            TreeNode currNode = q.poll();
            if (currNode == null) {
                s.append("#,");
            } else {
                s.append(currNode.val).append(",");
                q.offer(currNode.left);
                q.offer(currNode.right);
            }
        }
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (!q.isEmpty() && i < values.length) {
            TreeNode node = q.poll();

            // Read the left child value
            if (!values[i].equals("#")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(values[i]));
                node.left = leftNode;
                q.offer(leftNode);
            }
            i++;

            // Read the right child value
            if (!values[i].equals("#")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(values[i]));
                node.right = rightNode;
                q.offer(rightNode);
            }
            i++;
        }
        return root;    
    }
}