// LeetCode (867) - Transpose of a Matrix
// Difficulty: Easy
// Approach: swap row & column indices (res[j][i] = mat[i][j]), 
// Time Complexity: O(n^2)
// Space Complexity: O(n^2)

class Solution {
    public int[][] transpose(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] res = new int[c][r];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }
}