// LeetCode 994 - Rotting Oranges 
// Difficulty: Medium
// Approach: Use multi-source BFS starting from all rotten oranges, where each BFS level represents one minute and we rot adjacent fresh oranges until none are left.  
// Time Complexity: O(n * m) because each cell is processed at most once   
// Space Complexity: O(n * m) for the queue in worst case

class Solution {
    public int orangesRotting(int[][] grid) {

        int n = grid.length;      // number of rows
        int m = grid[0].length;   // number of columns

        int freshCount = 0;       // count of fresh oranges

        // Queue for BFS (stores positions of rotten oranges)
        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Traverse the grid
        // - count fresh oranges
        // - add all initially rotten oranges to the queue
        // Time Complexity: O(n * m)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;               // fresh orange found
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j}); // rotten orange added to queue
                }
            }
        }

        // If there are no fresh oranges, no time is required
        if (freshCount == 0) {
            return 0;
        }

        int time = 0; // tracks minutes passed

        // Step 2: BFS traversal (each level = 1 minute)
        while (!queue.isEmpty()) {

            int size = queue.size(); // number of rotten oranges at current minute

            // Process all rotten oranges of the current minute
            for (int i = 0; i < size; i++) {

                int[] rottenLoc = queue.poll();
                int r = rottenLoc[0];
                int c = rottenLoc[1];

                // All 4-directional neighbors (up, right, down, left)
                int[][] neighbours = {
                    {r - 1, c},
                    {r, c + 1},
                    {r + 1, c},
                    {r, c - 1}
                };

                // Check each neighboring cell
                for (int[] neighbour : neighbours) {

                    int nr = neighbour[0];
                    int nc = neighbour[1];

                    // Skip if:
                    // - out of bounds
                    // - already rotten (2)
                    // - empty cell (0)
                    if (nr < 0 || nr >= n || nc < 0 || nc >= m
                            || grid[nr][nc] == 2 || grid[nr][nc] == 0) {
                        continue;
                    }

                    // Fresh orange becomes rotten
                    grid[nr][nc] = 2;
                    queue.offer(new int[]{nr, nc});
                    freshCount--;

                    // If all fresh oranges are rotten, return time + 1
                    // because this rotting happens in the next minute
                    if (freshCount == 0) {
                        return time + 1;
                    }
                }
            }

            // One minute has passed after processing one BFS level
            time++;
        }

        // If some fresh oranges are still left, it's impossible to rot all
        return -1;
    }
}
