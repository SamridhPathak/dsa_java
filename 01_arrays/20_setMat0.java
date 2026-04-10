// LeetCode (73) - Set Matrix Zeroes
// Difficulty: Medium
// Approach: Use the first row and column as markers to indicate which rows and columns should be set to zero. Then inner matrix from (1,1) and if row and col marked as zero, set to zero. Finally check the first row and column and set to zero using firstRow and firstCol boolean variables.
// Time Complexity: O(m*n)
// Space Complexity: O(1)

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRow = false;
        boolean firstCol = false;

        //set markers in first row and col
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) firstRow = true;
                    if (j == 0) firstCol = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        //replace inner matrix
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        //last remaining checks
        if (firstRow) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if (firstCol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}