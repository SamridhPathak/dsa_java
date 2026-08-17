// LeetCode (1351) - Count Negative Numbers in a Sorted Matrix
// Difficulty: Easy
// Approach: BS approach - Since every row is sorted in non-increasing order, use Binary Search on each row to find the first negative number. If grid[i][mid] < 0, it can be the first negative, but there may be another negative on the left, so move end = mid - 1. If grid[i][mid] >= 0, the first negative must be on the right, so move start = mid + 1. When the loop ends, start points to the first negative number. Number of negative elements in that row = n - start. Add this to count for every row.
// Time Complexity: O(m log n)
// Space Complexity: O(1)

class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            int start = 0;
            int end = n - 1;

            while (start <= end) {
                int mid = start + (end - start) / 2;

                if (grid[i][mid] < 0) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            count += n - start;
        }

        return count;
    }
}