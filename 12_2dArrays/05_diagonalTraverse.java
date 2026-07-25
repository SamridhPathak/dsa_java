// LeetCode (498) - Diagonal Traverse
// Difficulty: Medium
// Approach: 
/*
Run m × n times (visit every element exactly once).
 Direction depends on (row + col) : 
Even → Move Up-Right (↗) → row--, col++
Odd → Move Down-Left (↙) → row++, col—
Up-Right (↗)
•	Right wall (col == n-1) → row++ 
•	Top wall (row == 0) → col++ 
•	Else → row--, col++ 
Order: Right wall → Top wall → Normal
(Handles the top-right corner correctly.)
Down-Left (↙)
•	Bottom wall (row == m-1) → col++ 
•	Left wall (col == 0) → row++ 
•	Else → row++, col-- 
Order: Bottom wall → Left wall → Normal
(Handles the bottom-left corner correctly.)

*/
// Time Complexity: O(m * n)
// Space Complexity: O(1)

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] resultMat = new int[m * n];
        int row = 0, col = 0;

        for (int i = 0; i < m * n; i++) {
            resultMat[i] = mat[row][col];
            if ((row + col) % 2 == 0) {
                if (col == n - 1) { //hit right wall
                    row++; 
                }
                else if (row == 0) { //hit top wall
                    col++; 
                }
                else {
                    row--; 
                    col++;
                }
            } else {
                if (row == m - 1) { //hit bottom wall
                    col++;
                } else if (col == 0) { //hit left wall
                    row++;
                } else {
                    row++;
                    col--;
                }
            }
        } 
        return resultMat;
    }
}