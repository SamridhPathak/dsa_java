// LeetCode 733 -Flood Fill
// Difficulty: Easy
// Approach: Depth-First Search (DFS) Recursion
// Time Complexity: O(m * n), where m is the number of rows and n is the number of columns
// Space Complexity: O(m * n), due to recursion stack in worst case

class Solution {

    // Number of rows and columns in the image
    int rows, cols;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        // Store total rows and columns
        rows = image.length;
        cols = image[0].length;

        // Original color of the starting pixel
        int curColor = image[sr][sc];

        // If the starting pixel already has the new color,
        // no need to do anything (prevents infinite recursion)
        if (curColor == color) {
            return image;
        }

        // Start DFS from the given starting cell
        dfs(sr, sc, curColor, color, image);

        // Return the updated image
        return image;
    }

    void dfs(int row, int col, int curColor, int newColor, int[][] image) {

        // Base case 1: If the cell is outside the grid, stop recursion
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return;
        }

        // Base case 2: If the current cell color is not the original color,
        // we should not fill it
        if (image[row][col] != curColor) {
            return;
        }

        // Change the current cell's color to the new color
        image[row][col] = newColor;

        // Recursively apply flood fill in all 4 directions       
        dfs(row - 1, col, curColor, newColor, image); // Up
        dfs(row + 1, col, curColor, newColor, image); // Down
        dfs(row, col - 1, curColor, newColor, image); // Left
        dfs(row, col + 1, curColor, newColor, image); // Right
    }
}


