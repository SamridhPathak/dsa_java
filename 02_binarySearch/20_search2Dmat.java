// LeetCode (74) - Search a 2D Matrix
// Difficulty: Medium
// Approach: Binary Search (Flattened 2D array) - Since every row is sorted and the first element of each row is greater than the last element of the previous row, the entire matrix can be treated as a sorted 1D array. We perform Binary Search from 0 to m*n-1. To convert the 1D mid index into a 2D position, row = mid / n because division tells us how many complete rows of n elements have been crossed, and col = mid % n because the remainder tells us the position inside the current row. Then compare matrix[row][col] with the target and move start or end like normal Binary Search.
// Time Complexity: O(log(m*n))
// Space Complexity: O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m * n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int row = mid / n;
            int col = mid % n;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m * n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int row = mid / n;
            int col = mid % n;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}