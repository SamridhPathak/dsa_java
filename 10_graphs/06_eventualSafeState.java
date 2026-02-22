// LeetCode 802 - Find Eventual Safe States 
// Difficulty: Medium 
// Approach: DFS with memoization. We use a HashMap to store the result of whether a node is safe or not. We mark a node as unsafe (false) before exploring its neighbors to avoid cycles. If we find any neighbor that is unsafe, we return false. If all neighbors are safe, we mark the current node as safe (true) and return true.
// Time Complexity: O(V + E) where V is number of vertices and E is number of edges
// Space Complexity: O(V) for the map and recursion stack

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        int n = graph.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dfs(i, graph, map)) {
                res.add(i);
            }
        }
        return res;
    }
    public boolean dfs(int node, int[][] graph,  HashMap<Integer, Boolean> map) {
        if (map.containsKey(node)) {
            return map.get(node);
        }
        map.put(node, false);
        for (int neighbour : graph[node]) {
            if (!dfs(neighbour, graph, map)) {
                return false;
            }
        }
        map.put(node, true);
        return true;
    }
}