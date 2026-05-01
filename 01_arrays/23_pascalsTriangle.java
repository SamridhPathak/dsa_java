// LeetCode (118) - Pascal's Triangle
// Difficulty: Easy
// Approach: Iterate through each row and calculate the value of each element based on the previous row. The first and last element of each row is always 1, and the value of each inner element is the sum of the two elements directly above it in the previous row.
// Time Complexity: O(numRows^2) - We need to iterate through each row and calculate the value of each element, which takes O(numRows) time for each row. Since there are numRows rows, the overall time complexity is O(numRows^2).
// Space Complexity: O(numRows^2) - We are storing the entire Pascal's Triangle in a list of lists, which takes O(numRows^2) space in the worst case when numRows is large.

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        if (numRows == 0) return result;

        //special case : 1st row alwasy has element '1'
        List<Integer> firstRow =  new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);

        if (numRows == 1) return result;

        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow =  result.get(i - 1);

            //start the next row   
            List<Integer> row =  new ArrayList<>();
            row.add(1);
            for (int j = 0; j < i - 1; j++) {
                row.add(prevRow.get(j) + prevRow.get(j + 1));
            }
            row.add(1);

            result.add(row);
        }
        return result;
    }
}