// GFG - First 1 in sorted binary array
// Difficulty: Easy
// Approach: Find the first occurrence of 1 using binary search. If arr[mid] == 1, store mid as ans and continue searching left. If arr[mid] == 0, search right. Return ans after the loop.
// TIme Complexity: O(log N)
// Space Complexity: O(1)

class Solution {
    public int firstIndex(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (arr[mid] == 1) {
                ans = mid;
                end = mid - 1;
            } else if (arr[mid] < 1) {
                start = mid + 1;
            }
        }
        return ans;
    }
}