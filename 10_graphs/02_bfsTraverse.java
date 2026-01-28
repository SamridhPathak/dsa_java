// GFG - Breadth First Search or BFS for a Graph
// Difficulty: Medium
// Approach: Use a queue to explore nodes level by level, starting from the source node (0).
// We maintain a visited array to avoid processing the same node multiple times.
// Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges.
// Space Complexity: O(V) for the visited array and the queue.

class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        
        // This list will store the final BFS traversal order
        ArrayList<Integer> bfs = new ArrayList<>();
        
        // Total number of vertices in the graph
        // adj.size() gives the number of nodes
        int V = adj.size();
        
        // Visited array to keep track of visited nodes
        // Initially, all values are false
        boolean[] visit = new boolean[V];
        
        // Queue is used in BFS to process nodes level by level
        Queue<Integer> queue = new LinkedList<>();
        
        // Start BFS from node 0 (as per problem statement)
        queue.add(0);  // Add starting node to queue
        visit[0] = true;  // Mark node 0 as visited
        
         // Continue BFS until the queue becomes empty
        while (!queue.isEmpty()) {
            int node = queue.poll(); // Remove the front element from the queue
            bfs.add(node);  // Add the current node to BFS result
            
            // Traverse all adjacent (neighbor) nodes of current node
            for (int x : adj.get(node)) {
                
                // If the adjacent node is not visited
                if (!visit[x]) {
                    visit[x] = true; // Mark the node as visited
                    queue.add(x); // Add the node to the queue for future processing
                }
            }
        }
        return bfs;  // Return the BFS traversal list
    }
}