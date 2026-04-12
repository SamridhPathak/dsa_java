// LeetCode (54) - Spiral Matrix 
// Difficulty: Medium
// Approach: We can use four pointers to keep track of the boundaries of the matrix: top, bottom, left, and right. We will traverse the matrix in a spiral manner by moving right, down, left, and up while updating the pointers accordingly. We will continue this process until we have traversed all elements in the matrix.
// Time Complexity: O(m*n) where m is the number of rows and n is the number of columns in the matrix
// Space Complexity: O(1) (ignoring the output list)  

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            //traverse top row (left -> right)
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top++;

            //traverse right col (top -> bottom)
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right--;

            //traverse bottom row (right -> left)
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
                bottom--;
            }

            //traverse left col (bottom -> top)
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    result.add(matrix[row][left]);
                }
                left++;
            }
        }
        return result;
    }
}