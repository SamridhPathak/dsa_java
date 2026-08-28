// GFG: Print 1 to N
// Difficulty: Easy
// Approach: Tail Recursion, Use Recursion. First call the function with n-1, then print n. Keep doing this until n becomes 0. When n becomes 0, the function starts returning and prints the numbers from 1 to n.
// Time Complexity: O(N)
// Space Complexity: O(N) - Due to recursion stack

class Solution {
    public void printTillN(int n) {
        if (n == 0) return;
        printTillN(n - 1);
        System.out.print(n + " ");
    }
}