// LeetCode (240) - 
// Difficulty: Medium
// Approach: Start from top-right corner, Since every row and every column is sorted, start from the top-right corner. If matrix[row][col] == target, return true. If matrix[row][col] > target, move left using col-- because everything below the current element is even greater and the entire current column can be eliminated. If matrix[row][col] < target, move down using row++ because everything to the left of the current element is even smaller and the entire current row can be eliminated. Continue while row < m && col >= 0
// Time Complexity: O(m+n) - because at every step we eliminate one complete row or column
// Space Complexity: O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n - 1;
        //start at top right
        
        while (row < m && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}