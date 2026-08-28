// GFG: Print N to 1
// Difficulty: Easy
// Approach: Use Recursion. First print n, then call the function with n-1. Keep doing this until n becomes 0. Since we print before the recursive call, numbers are printed from n to 1.
// Time Complexity: O(N)
// Space Complexity: O(N) - Due to recursion stack

class Solution {
    public void printNos(int n) {
        if (n == 0) return;
        System.out.print(n + " ");
        printTillN(n - 1);
    }
}