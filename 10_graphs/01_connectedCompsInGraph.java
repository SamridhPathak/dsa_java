// GFG - Connected Components in a Graph
// Difficulty: Medium
// Approach: Use DFS to traverse each connected component
// Time Complexity: O(V + E) bcoz we visit each vertex and edge once 
// Space Complexity: O(V + E) bcoz of adjacency list and visited array

class Solution {

    // DFS function to explore all nodes of one connected component
    private void dfs(int node,
                     ArrayList<ArrayList<Integer>> adj,
                     boolean[] visited,
                     ArrayList<Integer> component) {

        // Mark current node as visited so we don't visit it again
        visited[node] = true;

        // Add current node to the current component
        component.add(node);

        // Visit all neighbours of the current node
        for (int neighbour : adj.get(node)) {

            // If neighbour is not visited, continue DFS
            if (!visited[neighbour]) {
                dfs(neighbour, adj, visited, component);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {

        // Step 1: Create adjacency list for the graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list with empty lists for each vertex
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the adjacency list (undirected graph)
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v); // u -> v
            adj.get(v).add(u); // v -> u
        }

        // Step 2: Visited array to track already visited nodes
        boolean[] visited = new boolean[V];

        // Step 3: This will store all connected components
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        // Step 4: Check every vertex
        for (int i = 0; i < V; i++) {

            // If vertex is not visited, it means a new component starts here
            if (!visited[i]) {

                // List to store nodes of the current component
                ArrayList<Integer> component = new ArrayList<>();

                // Perform DFS to collect all connected nodes
                dfs(i, adj, visited, component);

                // Add the completed component to the result
                result.add(component);
            }
        }

        // Step 5: Return all connected components
        return result;
    }
}
