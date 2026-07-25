// LeetCode (3536) - Maximum Product of 2 Digits 
// Difficulty: Easy 
// Approach: traverse the arr and find rem (using %10) and keep reducing the number (using /10), use 2 var. largest and secLargest, find both using the rem and keep updating them, then return largest * secLargest at the end.
// Time Complexity: O(d) - where d is num of Digits 
// Space Complexity: O(1)

class Solution {
    public int maxProduct(int n) {
        int largest = -1;
        int secLargest = -1;
        while (n != 0) {
            int rem = n % 10;
            if (rem >= largest) {
                secLargest = largest;
                largest = rem;
            } else if (rem >= secLargest && rem < largest) {
                secLargest = rem;
            }
            n /= 10;
        }
        return largest * secLargest;
    }
}

/*
BF Approach - convert the num into arr of digits, then sort, then multiply last 2 elements
*/