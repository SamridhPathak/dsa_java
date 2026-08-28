// LeetCode 509: Fibonacci Number
// Difficulty: Easy
// Approach: Use Recursion. If n<2, return n because F(0)=0 and F(1)=1. Otherwise return fib(n-1)+fib(n-2). Each function call makes two more recursive calls, so the same values are calculated multiple times.
// Time Complexity: O(2^N) - Exponential
// Space Complexity: O(N) - Due to recursion stack

class Solution {
    public int fib(int n) {
        if (n < 2) return n;
        return fib(n - 1) + fib (n - 2);
    }
}