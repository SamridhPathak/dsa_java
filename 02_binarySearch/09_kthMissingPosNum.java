// LeetCode (1539) - Kth Missing Positive Number
// Difficulty: Easy
// Approach: Binary search for the boundary where the number of missing values reaches k. Calculate missing = arr[mid] - (mid + 1). If missing < k, go right; otherwise go left. After the search, answer = start + k.
// Time Complexity: O(log n)
// Space Complexity: O(1)

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }        
        return start + k;
    }
}