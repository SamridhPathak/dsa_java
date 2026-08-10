// GFG - Ceil in sorted array
// Difficulty: Easy
// Approach: Binary Search, Ceil → first index where arr[i] >= x, Find the smallest element ≥ x. Use binary search. If arr[mid] >= x, it is a possible answer, so store mid and move left to find an earlier valid element. If arr[mid] < x, move right. If no valid element exists, return -1.
// Time Complexity: O(log n)
// Space Complexity: O(1)

class Solution {
    public int findCeil(int[] arr, int x) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (arr[mid] >= x) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
