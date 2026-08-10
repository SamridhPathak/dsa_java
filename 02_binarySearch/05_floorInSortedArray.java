// GFG - Floor in sorted array
// Difficulty: Easy
// Approach: Binary Search, Floor → last index where arr[i] <= x, Use binary search. If arr[mid] <= x, it is a possible answer, so store mid and move right to find a larger valid element. If arr[mid] > x, move left. If no valid element exists, return -1.
// Time Complexity: O(log n)
// Space Complexity: O(1)

class Solution {
    static int findFloor(int[] arr, int x) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (arr[mid] <= x) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
