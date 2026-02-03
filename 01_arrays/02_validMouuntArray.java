// LeetCode 941 - Valid Mountain Array
// Difficulty: Easy 
// Approach: check increasing and decreasing sequences, find peak 
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        int i = 0;

        //increasing
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }
        if (i == 0) return false;

        //decreasing
        int decStart = i;
        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }
        if (decStart == i) return false;
        return i == n - 1;
    }
}