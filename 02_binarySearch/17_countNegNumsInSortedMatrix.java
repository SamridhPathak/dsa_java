// LeetCode (1351) - Count Negative Numbers in a Sorted Matrix
// Difficulty: Easy
// Approach: Staircase search approach - Start from the bottom-left corner: r = m - 1, c = 0. If grid[r][c] < 0, then because the row is sorted in decreasing order, all elements to the right are also negative. So, add n - c to count and move up: r--. If grid[r][c] >= 0, then everything to its left is also non-negative, so move right: c++. Continue until r < 0 or c >= n. This avoids checking every element individually.
// Time Complexity: O(m + n)
// Space Complexity: O(1)

class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int r = m - 1;
        int c = 0;
        int count = 0;

        while (r >= 0 && c < n) {
            if (grid[r][c] < 0) {
                count += n - c;
                r--;
            } else {
                c++;
            }
        }
        return count;
    }
}