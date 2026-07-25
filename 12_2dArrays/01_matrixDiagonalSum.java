// LeetCode (1572) - Matrix Diagonal Sum
// Difficulty: Easy
// Approach: only 1 loop required, for primaryDiagonal -> just add the element at row==col (mat[i][i]), and for secondaryDiagonal -> as row incr. col decr. (mat[i][n - 1 - i]), put a check for secondaryDiagonal to get the element (i != n - 1 - i)) bcoz middle element will come twice, therefore we need to avoid this
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            // primary diagonal element
            sum += mat[i][i];

            // secondary diagonal element
            if (i != n - 1 - i) {
                sum += mat[i][n - 1 - i];
            }
        }
        return sum;
    }
}