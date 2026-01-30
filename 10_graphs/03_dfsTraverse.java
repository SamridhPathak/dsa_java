// GFG - Depth First Search or DFS for a Graph
// Difficulty: Medium
// Approach: Use recursion to traverse all unvisited neighbors of a node.
// Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges.
// Space Complexity: O(V) for the visited array and recursion stack.

class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        
         // This list will store the final DFS traversal order
        ArrayList<Integer> dfs = new ArrayList<>();
        
        // Total number of vertices in the graph
        int V = adj.size();
        
        // Visited array to track which nodes are already visited
        boolean[] visit = new boolean[V];
        
        // Start DFS from node 0
        dfsHelper(0, adj, visit, dfs);
        return dfs;
    }
    private void dfsHelper(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visit, ArrayList<Integer> dfs) {
        
        // Mark the current node as visited
        visit[node] = true;
        
        // Add the current node to DFS result
        dfs.add(node);
        
        // Visit all adjacent (neighbor) nodes one by one
        for (int x : adj.get(node)) {
            
            // If the adjacent node is not visited
            if(!visit[x]) {
                dfsHelper(x, adj, visit, dfs);
            }
        }
    }
}