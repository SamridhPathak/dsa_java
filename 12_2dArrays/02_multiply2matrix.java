// GFG - Multiply two matrices
// Difficulty: Easy
// Approach: 3 loops, ‘i’ for row, ‘j’ for col, ‘k’ to manage both element at row of MatA and element col of MatB together, add ‘sum’ of each idx into row after completion of ‘k’, add ‘row’ into ‘ans’ after completion of ‘j’, then at the end return ‘ans’ AL
// Time Complexity: O(n^3)
// Space Complexity: O(n^2) ‘ans’ arraylist stores the answer matrix, ans contains n*n

class Solution {
    public ArrayList<ArrayList<Integer>> multiplyMatrices(int[][] a, int[][] b) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < a[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < a.length; k++) {
                    sum += a[i][k] * b[k][j];   
                }
                row.add(sum);
            }
            ans.add(row);
        }
        return ans;
    }
}