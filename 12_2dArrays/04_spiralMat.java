// LeetCode (54) - Spiral Matrix
// Difficulty: Medium
// Approach: 
/* Use 4 boundaries- top, bottom, left, right. 
Traverse in this fixed order: Top → Right → Bottom → Left.
After each traversal, shrink the corresponding boundary.
Before traversing the bottom row and left column, check:
top <= bottom 
left <= right
Stop when top > bottom or left > right.
Outer While Condition - while (top <= bottom && left <= right) means
top <= bottom → At least one row is left. left <= right → At least one column is left. Continue while both are true. Stop when no rows or columns remain. 
•	Bottom row check - if (top <= bottom) - After traversing the top row and right column, top may become greater than bottom. This check avoids printing the bottom row twice (especially in a single-row matrix). 
•	Left Column Check - if (left <= right) - After traversing the right column, left may become greater than right. This check avoids printing the left column twice (especially in a single-column matrix).
*/
// Time Complexity: O(m * n) - every element is visited exactly once
// Space Complexity: O(1)

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        ArrayList<Integer> result = new ArrayList<>();

        while (top <= bottom && left <= right) {
            //top row
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top++;

            //right column
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right--;

            //bottom row
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
                bottom--;
            }

            //left column
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